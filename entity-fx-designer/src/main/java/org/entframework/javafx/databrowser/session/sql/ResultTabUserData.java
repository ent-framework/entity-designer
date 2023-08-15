/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql;

import org.entframework.javafx.databrowser.table.TableLoader;

public class ResultTabUserData {
    private String _sql;
    private TableLoader _resultTableLoader;

    public ResultTabUserData(String sql, TableLoader resultTableLoader) {
        _sql = sql;
        _resultTableLoader = resultTableLoader;
    }

    public String getSql() {
        return _sql;
    }

    public TableLoader getResultTableLoader() {
        return _resultTableLoader;
    }
}
