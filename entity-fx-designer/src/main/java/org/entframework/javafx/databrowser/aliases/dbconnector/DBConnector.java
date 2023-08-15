/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.aliases.dbconnector;

import javafx.stage.Window;
import org.entframework.javafx.databrowser.AppState;
import org.entframework.javafx.databrowser.aliases.AliasDecorator;
import org.entframework.javafx.databrowser.aliases.AliasUtil;
import org.entframework.javafx.databrowser.services.CancelableProgressTask;
import org.entframework.javafx.databrowser.services.I18n;
import org.entframework.javafx.databrowser.services.JDBCUtil;
import org.entframework.javafx.databrowser.services.progress.Progressable;
import org.entframework.javafx.databrowser.services.progress.SimpleProgressCtrl;
import org.entframework.javafx.databrowser.services.sqlwrap.SQLConnection;
import org.entframework.javafx.databrowser.session.schemainfo.SchemaCache;
import org.entframework.javafx.databrowser.session.schemainfo.SchemaCacheConfig;
import org.entframework.javafx.databrowser.session.schemainfo.SchemaCacheFactory;

public class DBConnector {
    private AliasDecorator _alias;
    private Window _owner;
    private SchemaCacheConfig _schemaCacheConfig;

    public DBConnector(AliasDecorator alias, Window owner, SchemaCacheConfig schemaCacheConfig) {
        _alias = alias;

        _owner = owner;
        _schemaCacheConfig = schemaCacheConfig;
        if (null == _owner) {
            _owner = AppState.get().getPrimaryStage();
        }
    }


    public void tryConnect(DbConnectorListener dbConnectorListener) {
        _tryConnect(dbConnectorListener, false);
    }

    private void _tryConnect(final DbConnectorListener dbConnectorListener, boolean forceLogin) {

        final String user[] = new String[1];
        final String password[] = new String[1];


        if (false == _alias.getAlias().isAutoLogon() || forceLogin) {
            LoginCtrl loginCtrl = new LoginCtrl(_alias.getAlias(), _owner);

            if (false == loginCtrl.isOk()) {
                DbConnectorResult dbConnectorResult = new DbConnectorResult(_alias, null, null);
                dbConnectorResult.setLoginCanceled(true);
                dbConnectorListener.finished(dbConnectorResult);
                return;
            }

            user[0] = loginCtrl.getUserName();
            password[0] = loginCtrl.getPassword();
        } else {
            user[0] = AliasUtil.getUserNameRespectAliasConfig(_alias.getAlias());
            password[0] = AliasUtil.getPasswordRespectAliasConfig(_alias.getAlias());
        }


        String title = new I18n(getClass(), "org.entframework.javafx.databrowser.aliases.dbconnector.i18n").t("connectingctrl.alias.display", _alias.getAlias().getName(), _alias.getAlias().getUrl(), _alias.getAlias().getUserName());

        SimpleProgressCtrl simpleProgressCtrl = new SimpleProgressCtrl(true, true, title);


        CancelableProgressTask<DbConnectorResult> pt = new CancelableProgressTask<DbConnectorResult>() {
            @Override
            public DbConnectorResult call() {
                return doTryConnect(user[0], password[0], simpleProgressCtrl.getProgressable());
            }

            @Override
            public void goOn(DbConnectorResult dbConnectorResult) {
                onGoOn(dbConnectorResult, dbConnectorListener, simpleProgressCtrl);
            }

            @Override
            public void cancel() {
                onCanceled(dbConnectorListener, user[0], simpleProgressCtrl);
            }
        };

        new SessionLoadingTimeHintCtrl(simpleProgressCtrl.getAvailableArea(), _alias);

        simpleProgressCtrl.start(pt);

    }

    private void onCanceled(DbConnectorListener dbConnectorListener, String user, SimpleProgressCtrl simpleProgressCtrl) {
        DbConnectorResult dbConnectorResult = new DbConnectorResult(_alias, user, null);
        dbConnectorResult.setCanceled(true);
        onGoOn(dbConnectorResult, dbConnectorListener, simpleProgressCtrl);
    }

    private DbConnectorResult doTryConnect(String user, String password, Progressable progressable) {
        DbConnectorResult dbConnectorResult = new DbConnectorResult(_alias, user, password);

        try {
            ConnectionWithDriverData jdbcConn = JDBCUtil.createJDBCConnection(_alias.getAlias(), user, password);

            SQLConnection sqlConnection = new SQLConnection(jdbcConn);
            dbConnectorResult.setSQLConnection(sqlConnection);

            SchemaCache schemaCache = SchemaCacheFactory.createSchemaCache(dbConnectorResult, sqlConnection, _schemaCacheConfig);
            schemaCache.load(progressable);
            dbConnectorResult.setSchemaCache(schemaCache);

            return dbConnectorResult;
        } catch (Throwable e) {
            dbConnectorResult.setConnectException(e);
            return dbConnectorResult;
        }
    }

    private void onGoOn(DbConnectorResult dbConnectorResult, DbConnectorListener dbConnectorListener, SimpleProgressCtrl simpleProgressCtrl) {
        simpleProgressCtrl.close();
        if (dbConnectorResult.isCanceled()) {
            dbConnectorListener.finished(dbConnectorResult);
        } else if (false == dbConnectorResult.isConnected() || null != dbConnectorResult.getConnectException()) {
            new ConnectFailedCtrl(_alias.getAlias(), dbConnectorResult, d -> onConnectFailureDecision(d, dbConnectorResult, dbConnectorListener), _owner);
        } else {
            dbConnectorListener.finished(dbConnectorResult);
        }
    }

    private void onConnectFailureDecision(ConnectFailureDecisionListener.Decision decision, DbConnectorResult dbConnectorResult, DbConnectorListener dbConnectorListener) {
        if (ConnectFailureDecisionListener.Decision.RELOGIN_REQUESTED == decision) {
            _tryConnect(dbConnectorListener, true);
        } else {
            dbConnectorResult.setEditAliasRequested(true);
            dbConnectorListener.finished(dbConnectorResult);
        }
    }
}
