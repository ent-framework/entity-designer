/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql;

import org.entframework.javafx.databrowser.table.TableState;

public class PredecessorTabData {
    private final int _indexToReplace;
    private final TableState _tableState;

    public PredecessorTabData(int indexToReplace, TableState tableState) {
        _indexToReplace = indexToReplace;
        _tableState = tableState;
    }

    public int getIndexToReplace() {
        return _indexToReplace;
    }

    public TableState getTableState() {
        return _tableState;
    }
}
