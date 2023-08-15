/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session;

import javafx.beans.value.ChangeListener;
import javafx.event.Event;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import org.entframework.javafx.databrowser.AppState;
import org.entframework.javafx.databrowser.ApplicationCloseListener;
import org.entframework.javafx.databrowser.aliases.dbconnector.DbConnectorResult;
import org.entframework.javafx.databrowser.services.*;
import org.entframework.javafx.databrowser.services.progress.ProgressTask;
import org.entframework.javafx.databrowser.services.progress.Progressable;
import org.entframework.javafx.databrowser.services.progress.SimpleProgressCtrl;
import org.entframework.javafx.databrowser.session.action.ActionScope;
import org.entframework.javafx.databrowser.session.action.ActionUtil;
import org.entframework.javafx.databrowser.session.action.StdActionCfg;
import org.entframework.javafx.databrowser.session.graph.GraphAccess;
import org.entframework.javafx.databrowser.session.objecttree.ObjectTreeNode;
import org.entframework.javafx.databrowser.session.objecttree.ObjectTreeTabCtrl;
import org.entframework.javafx.databrowser.session.schemainfo.SchemaCache;
import org.entframework.javafx.databrowser.session.schemainfo.SchemaCacheConfig;
import org.entframework.javafx.databrowser.session.schemainfo.SchemaCacheFactory;
import org.entframework.javafx.databrowser.session.sql.SqlTabCtrl;
import org.entframework.javafx.databrowser.session.sql.ViewInObjectTreeCommand;
import org.entframework.javafx.databrowser.session.sql.bookmark.BookmarkEditCtrl;
import org.entframework.javafx.databrowser.workaround.SessionTabSelectionRepaintWA;


public class SessionCtrl {
    private static final String PREF_PRE_SELECT_SQL_TAB = "preselect.sql";
    private final BorderPane _sessionPane;
    private final SessionTabAdmin _sessionTabAdmin;
    private final TabPane _objectTreeAndSqlTabPane;
    private final ApplicationCloseListener _applicationCloseListener;
    private final TransactionManager _transactionManager;
    private final FileManager _fileManager;
    private I18n _i18n = new I18n(getClass());
    private Pref _pref = new Pref(getClass());
    private SqlTabCtrl _sqlTabCtrl;
    private SessionTabContext _sessionTabContext;
    private ObjectTreeTabCtrl _objectTreeTabCtrl;
    private ChangeListener<Tab> _tabChangeListener;


    public SessionCtrl(SessionTabContext sessionTabContext) {
        _sessionTabContext = sessionTabContext;

        _sessionPane = new BorderPane();

        _sessionPane.setTop(ActionUtil.createStdActionToolbar());

        _objectTreeAndSqlTabPane = createObjectTreeAndSqlTabPane();

        _sessionPane.setCenter(_objectTreeAndSqlTabPane);

        _sessionTabAdmin = new SessionTabAdmin(_sessionTabContext, _sessionPane, SessionTabType.SESSION_MAIN_TAB);

        initStandardActions(sessionTabContext);

        _transactionManager = new TransactionManager(sessionTabContext.getSession());

        _fileManager = new FileManager(_sqlTabCtrl.getSQLTextAreaServices(), _sessionTabAdmin.getSessionTabHeaderCtrl());

        _applicationCloseListener = this::onClose;
        AppState.get().addApplicationCloseListener(_applicationCloseListener, ApplicationCloseListener.FireTime.WITHIN_SESSION_FIRE_TIME);

        _sessionTabAdmin.addOnCloseRequest(_fileManager::closeRequest);
        _sessionTabAdmin.addOnClosed(e -> onClose());
        _sessionTabAdmin.addOnSelectionChanged(this::onSelectionChanged);
    }

    private void initStandardActions(SessionTabContext sessionTabContext) {
        StdActionCfg.NEW_SQL_TAB.setAction(() -> AppState.get().getSessionManager().createSqlTab(sessionTabContext));
        StdActionCfg.EDIT_BOOKMARK.setAction(() -> new BookmarkEditCtrl(sessionTabContext));
        StdActionCfg.RELOAD_DB_META_DATA.setAction(() -> reloadSchemaCache());
        StdActionCfg.VIEW_IN_OBJECT_TREE.setAction(() -> new ViewInObjectTreeCommand(_sqlTabCtrl.getSQLTextAreaServices(), _objectTreeTabCtrl));


        DbConnectorResult dbConnectorResult = _sessionTabContext.getSession().getDbConnectorResult();
        Session session = sessionTabContext.getSession();

        StdActionCfg.RECONNECT.setAction(() -> session.getSQLConnection().reconnect(dbConnectorResult, _transactionManager.isAutoCommit()));

        GraphAccess graphAccess = new GraphAccess(_sessionTabContext, (tab, selectTab) -> onAddTab(tab, selectTab));
        StdActionCfg.GRAPH_NEW_QUERY_BUILDER.setAction(() -> graphAccess.onNewGraph());
    }

    private void onAddTab(Tab tab, boolean selectTab) {
        _objectTreeAndSqlTabPane.getTabs().add(tab);

        if (selectTab) {
            _objectTreeAndSqlTabPane.getSelectionModel().select(tab);
        }
    }

    private void reloadSchemaCache() {
        SimpleProgressCtrl simpleProgressCtrl = new SimpleProgressCtrl(false, true);

        simpleProgressCtrl.start(new ProgressTask<SchemaCache>() {
            @Override
            public SchemaCache call() {
                return doReload(simpleProgressCtrl.getProgressable());
            }

            @Override
            public void goOn(SchemaCache schemaCache) {
                onGoOnReload(schemaCache);
            }
        });

    }

    private void onGoOnReload(SchemaCache schemaCache) {
        _sessionTabContext.getSession().getDbConnectorResult().setSchemaCache(schemaCache);
        _sessionTabContext.getSession().getDbConnectorResult().getSchemaCacheProperty().fireChanged();
    }

    private SchemaCache doReload(Progressable progressable) {
        DbConnectorResult dbConnectorResult = _sessionTabContext.getSession().getDbConnectorResult();

        if (Dao.deleteSerializedSchemaCache(dbConnectorResult.getAliasDecorator().getAlias())) {
            new MessageHandler(getClass(), MessageHandlerDestination.MESSAGE_PANEL).info(_i18n.t("schema.cache.file.deleted", dbConnectorResult.getAliasDecorator().getName()));
        }

        SchemaCacheConfig schemaCacheConfig = new SchemaCacheConfig(dbConnectorResult.getAliasDecorator().getAliasPropertiesDecorator());

        SchemaCache schemaCache = SchemaCacheFactory.createSchemaCache(dbConnectorResult, dbConnectorResult.getSQLConnection(), schemaCacheConfig);

        schemaCache.load(progressable);

        return schemaCache;
    }

    private void onSelectionChanged(Event e) {
        if (_sessionTabAdmin.isSelected()) {
            AppState.get().getSessionManager().setCurrentlyActiveOrActivatingContext(_sessionTabContext);
            onTabChanged(_objectTreeAndSqlTabPane.getSelectionModel().getSelectedItem());
        }
    }

    private TabPane createObjectTreeAndSqlTabPane() {
        _objectTreeTabCtrl = new ObjectTreeTabCtrl(_sessionTabContext);

        TabPane ret = new TabPane();

        ret.getTabs().add(_objectTreeTabCtrl.getObjectsTab());
        ActionUtil.setActionScope(ActionScope.OBJECT_TREE);


        _sqlTabCtrl = new SqlTabCtrl(_sessionTabContext);

        Tab sqlTab = _sqlTabCtrl.getSqlTab();
        ret.getTabs().add(sqlTab);

        if (_pref.getBoolean(PREF_PRE_SELECT_SQL_TAB, false)) {
            ret.getSelectionModel().select(sqlTab);
            onSwitchedToSqlTab();
        }


        SessionTabSelectionRepaintWA.forceTabContentRepaintOnSelection(ret);

        _tabChangeListener = (observable, oldValue, newValue) -> onTabChanged(newValue);
        ret.getSelectionModel().selectedItemProperty().addListener(_tabChangeListener);

        return ret;
    }

    private void onSwitchedToSqlTab() {
        _sqlTabCtrl.requestFocus();
        ActionUtil.setActionScope(ActionScope.SQL_EDITOR);
    }

    private void onTabChanged(Tab newSelectedTab) {
        if (_sqlTabCtrl.getSqlTab() == newSelectedTab) {
            onSwitchedToSqlTab();
        } else {
            ActionUtil.setActionScope(ActionScope.OBJECT_TREE);
        }
    }


    private void onClose() {
        _objectTreeTabCtrl.close();

        _pref.set(PREF_PRE_SELECT_SQL_TAB, _objectTreeAndSqlTabPane.getSelectionModel().getSelectedItem() == _sqlTabCtrl.getSqlTab());

        _sqlTabCtrl.close();
        _sessionTabContext.getSession().close();

        _objectTreeAndSqlTabPane.getSelectionModel().selectedItemProperty().removeListener(_tabChangeListener);

        AppState.get().getSessionManager().sessionClose(_sessionTabContext);

        AppState.get().removeApplicationCloseListener(_applicationCloseListener);
    }

    public TreeView<ObjectTreeNode> getObjectTree() {
        return _objectTreeTabCtrl.getObjectTree();
    }

    public SessionTabAdmin getSessionTabAdmin() {
        return _sessionTabAdmin;
    }
}
