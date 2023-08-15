/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph;

import org.entframework.javafx.databrowser.session.ColumnInfo;
import org.entframework.javafx.databrowser.table.TableLoader;

public class PrimaryKeyInfo {
    private TableLoader _pkAsTableLoader;

    public PrimaryKeyInfo(TableLoader pkAsTableLoader) {

        _pkAsTableLoader = pkAsTableLoader;
    }

    public boolean belongsToPk(ColumnInfo columnInfo) {
        for (int i = 0; i < _pkAsTableLoader.size(); i++) {
            if (columnInfo.getColName().equalsIgnoreCase(_pkAsTableLoader.getCellAsString("COLUMN_NAME", i))) {
                return true;
            }
        }

        return false;
    }
}
