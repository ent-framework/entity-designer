/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph;

import org.entframework.javafx.databrowser.session.TableInfo;

public class NonDbImportedKey {
    private final String _nonDbFkId;
    private final GraphColumn _columnThisImportedKeyPointsTo;
    private final TableInfo _tableThisImportedKeyPointsTo;

    public NonDbImportedKey(String nonDbFkId, GraphColumn columnThisImportedKeyPointsTo, TableInfo tableThisImportedKeyPointsTo) {
        _nonDbFkId = nonDbFkId;
        _columnThisImportedKeyPointsTo = columnThisImportedKeyPointsTo;
        _tableThisImportedKeyPointsTo = tableThisImportedKeyPointsTo;
    }

    public String getNonDbFkId() {
        return _nonDbFkId;
    }

    public GraphColumn getColumnThisImportedKeyPointsTo() {
        return _columnThisImportedKeyPointsTo;
    }

    public TableInfo getTableThisImportedKeyPointsTo() {
        return _tableThisImportedKeyPointsTo;
    }
}
