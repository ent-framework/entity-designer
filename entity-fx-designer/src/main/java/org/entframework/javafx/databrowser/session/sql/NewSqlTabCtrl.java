/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql;

import javafx.event.Event;
import javafx.scene.layout.BorderPane;
import org.entframework.javafx.databrowser.AppState;
import org.entframework.javafx.databrowser.session.*;
import org.entframework.javafx.databrowser.session.action.ActionScope;
import org.entframework.javafx.databrowser.session.action.ActionUtil;
import org.entframework.javafx.databrowser.session.action.StdActionCfg;

public class NewSqlTabCtrl {
    private final SessionManagerListener _sessionManagerListener;
    private final SqlPaneCtrl _sqlPaneCtrl;
    private final FileManager _fileManager;
    private SessionTabAdmin _sessionTabAdmin;
    private SessionTabContext _newSqlTabContext;

    public NewSqlTabCtrl(SessionTabContext newSqlTabContext) {
        _newSqlTabContext = newSqlTabContext;
        _sessionManagerListener = new SessionManagerListener() {
            @Override
            public void contextActiveOrActivating(SessionTabContext sessionTabContext) {
            }

            @Override
            public void contextClosing(SessionTabContext sessionTabContext) {
                close(sessionTabContext);
            }
        };

        ActionUtil.setActionScope(ActionScope.SQL_EDITOR);


        AppState.get().getSessionManager().addSessionManagerListener(_sessionManagerListener);


        _sqlPaneCtrl = new SqlPaneCtrl(newSqlTabContext);
        _sqlPaneCtrl.requestFocus();

        BorderPane bp = new BorderPane();
        bp.setTop(ActionUtil.createStdActionToolbar());
        bp.setCenter(_sqlPaneCtrl.getSqlPane());

        _sessionTabAdmin = new SessionTabAdmin(_newSqlTabContext, bp, SessionTabType.SQL_TAB);
        SessionTabHeaderCtrl sessionTabHeaderCtrl = new SessionTabHeaderCtrl(newSqlTabContext, StdActionCfg.NEW_SQL_TAB.getActionCfg().getIcon());

        initStandardActions();

        _fileManager = new FileManager(_sqlPaneCtrl.getSQLTextAreaServices(), sessionTabHeaderCtrl);


        _sessionTabAdmin.addOnSelectionChanged(this::onSelectionChanged);
        _sessionTabAdmin.addOnCloseRequest(_fileManager::closeRequest);
        _sessionTabAdmin.addOnClosed(e -> close(_newSqlTabContext));
    }

    private void initStandardActions() {
        StdActionCfg.NEW_SQL_TAB.setAction(() -> AppState.get().getSessionManager().createSqlTab(_newSqlTabContext));
    }

    private void onSelectionChanged(Event e) {
        if (_sessionTabAdmin.isSelected()) {
            AppState.get().getSessionManager().setCurrentlyActiveOrActivatingContext(_newSqlTabContext);
        }
    }


    private void close(SessionTabContext sessionTabContext) {
        if (!_newSqlTabContext.equalsSession(sessionTabContext)) {
            return;
        }


        _sqlPaneCtrl.close();
        AppState.get().getSessionManager().removeSessionManagerListener(_sessionManagerListener);

        _sessionTabAdmin.removeFromTabPane();
    }

    public SessionTabAdmin getSessionTabAdmin() {
        return _sessionTabAdmin;
    }
}
