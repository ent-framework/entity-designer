/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql;

import javafx.scene.control.Tab;
import org.entframework.javafx.databrowser.services.I18n;
import org.entframework.javafx.databrowser.session.SessionTabContext;

public class SqlTabCtrl {
    private final Tab _sqlTab;
    private final SqlPaneCtrl _sqlPaneCtrl;
    private I18n _i18n = new I18n(getClass());

    public SqlTabCtrl(SessionTabContext sessionTabContext) {
        _sqlTab = new Tab(_i18n.t("session.tab.sql"));
        _sqlTab.setClosable(false);

        _sqlPaneCtrl = new SqlPaneCtrl(sessionTabContext);

        _sqlTab.setContent(_sqlPaneCtrl.getSqlPane());
    }

    public Tab getSqlTab() {
        return _sqlTab;
    }

    public void close() {
        _sqlPaneCtrl.close();
    }

    public void requestFocus() {
        _sqlPaneCtrl.requestFocus();
    }

    public SQLTextAreaServices getSQLTextAreaServices() {
        return _sqlPaneCtrl.getSQLTextAreaServices();
    }
}

