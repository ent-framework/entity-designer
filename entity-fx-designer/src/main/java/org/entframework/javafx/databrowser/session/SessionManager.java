/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session;

import org.entframework.javafx.databrowser.aliases.dbconnector.DbConnectorResult;
import org.entframework.javafx.databrowser.session.action.ActionUtil;
import org.entframework.javafx.databrowser.session.sql.NewSqlTabCtrl;

import java.util.ArrayList;
import java.util.List;

public class SessionManager {
    private SessionTabbedPaneCtrl _sessionTabbedPaneController = new SessionTabbedPaneCtrl();

    private SessionTabContext _currentlyActiveOrActivatingContext;

    private volatile int _sessionIdSequence;
    private List<SessionManagerListener> _sessionManagerListeners = new ArrayList<>();

    public int getNextSessionContextId() {
        return ++_sessionIdSequence;
    }


    public void createSession(DbConnectorResult dbConnectorResult) {
        Session session = new Session(dbConnectorResult);
        SessionTabContext sessionTabContext = new SessionTabContext(session, true);
        session.setMainTabContext(sessionTabContext);

        setCurrentlyActiveOrActivatingContext(sessionTabContext);

        SessionCtrl sessionCtrl = new SessionCtrl(_currentlyActiveOrActivatingContext);
        session.setSessionCtrl(sessionCtrl);

        sessionTabContext.setTabAdmin(_sessionTabbedPaneController.addSessionTab(sessionCtrl));
        ActionUtil.updateActionUIs();
    }

    public void createSqlTab(SessionTabContext sessionTabContext) {
        SessionTabContext newSqlTabContext = new SessionTabContext(sessionTabContext.getSession(), false);
        setCurrentlyActiveOrActivatingContext(newSqlTabContext);


        NewSqlTabCtrl newSqlTabCtrl = new NewSqlTabCtrl(newSqlTabContext);
        newSqlTabContext.setTabAdmin(_sessionTabbedPaneController.addSqlTab(newSqlTabCtrl));
        ActionUtil.updateActionUIs();
    }


    public SessionTabbedPaneCtrl getSessionTabbedPaneCtrl() {
        return _sessionTabbedPaneController;
    }

    public void addSessionManagerListener(SessionManagerListener sessionManagerListener) {
        _sessionManagerListeners.remove(sessionManagerListener);
        _sessionManagerListeners.add(sessionManagerListener);
    }

    public void removeSessionManagerListener(SessionManagerListener sessionManagerListener) {
        _sessionManagerListeners.remove(sessionManagerListener);
    }

    public SessionTabContext getCurrentlyActiveOrActivatingContext() {
        return _currentlyActiveOrActivatingContext;
    }

    public void setCurrentlyActiveOrActivatingContext(SessionTabContext currentlyActiveOrActivatingContext) {
        _currentlyActiveOrActivatingContext = currentlyActiveOrActivatingContext;
        fireContextActiveOrActivating(currentlyActiveOrActivatingContext);
    }

    private void fireContextActiveOrActivating(SessionTabContext currentlyActiveOrActivatingContext) {
        for (SessionManagerListener sessionManagerListener : _sessionManagerListeners.toArray(new SessionManagerListener[0])) {
            sessionManagerListener.contextActiveOrActivating(currentlyActiveOrActivatingContext);
        }
    }


    public void sessionClose(SessionTabContext sessionTabContext) {

        // This codes contract is: Closing is always followed by a call to contextActiveOrActivating()

        fireContextClosing(sessionTabContext);

        if (sessionTabContext.equalsSession(_currentlyActiveOrActivatingContext)) {
            _currentlyActiveOrActivatingContext = null;
        }

        fireContextActiveOrActivating(_currentlyActiveOrActivatingContext);
    }

    private void fireContextClosing(SessionTabContext sessionTabContext) {
        for (SessionManagerListener sessionManagerListener : _sessionManagerListeners.toArray(new SessionManagerListener[0])) {
            sessionManagerListener.contextClosing(sessionTabContext);
        }
    }
}
