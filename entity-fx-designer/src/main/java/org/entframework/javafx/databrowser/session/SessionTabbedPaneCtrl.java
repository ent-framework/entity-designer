/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session;

import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import org.entframework.javafx.databrowser.session.sql.NewSqlTabCtrl;

public class SessionTabbedPaneCtrl {
    private TabPane _tabPane = new TabPane();

    public Node getNode() {
        return _tabPane;
    }

    public void addTab(Tab tab) {
        _tabPane.getTabs().add(tab);
        _tabPane.getSelectionModel().select(tab);
    }

    public SessionTabAdmin addSessionTab(SessionCtrl sessionCtrl) {
        SessionTabAdmin tabAdmin = sessionCtrl.getSessionTabAdmin();
        return addTabAndSelect(tabAdmin);
    }

    public SessionTabAdmin addSqlTab(NewSqlTabCtrl newSqlTabCtrl) {
        SessionTabAdmin tabAdmin = newSqlTabCtrl.getSessionTabAdmin();
        return addTabAndSelect(tabAdmin);
    }

    private SessionTabAdmin addTabAndSelect(SessionTabAdmin sessionTabAdmin) {
        _tabPane.getTabs().add(sessionTabAdmin.getTab());
        _tabPane.getSelectionModel().select(sessionTabAdmin.getTab());
        return sessionTabAdmin;
    }

}
