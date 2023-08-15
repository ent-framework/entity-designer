/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph;

import org.entframework.javafx.databrowser.session.ColumnInfo;

public class NonDbImportedKeyPersistence {
    private String _nonDbFkId;
    private String _catalogName;
    private String _schemaName;
    private String _tableName;
    private String _colName;

    public NonDbImportedKeyPersistence(String nonDbFkId, String catalogName, String schemaName, String tableName, String colName) {

        _nonDbFkId = nonDbFkId;
        _catalogName = catalogName;
        _schemaName = schemaName;
        _tableName = tableName;
        _colName = colName;
    }

    public NonDbImportedKeyPersistence() {
    }

    public static NonDbImportedKeyPersistence toNonDbImportedKeyPersistence(NonDbImportedKey nonDbImportedKey) {
        ColumnInfo col = nonDbImportedKey.getColumnThisImportedKeyPointsTo().getColumnInfo();
        return new NonDbImportedKeyPersistence(nonDbImportedKey.getNonDbFkId(), col.getCatalogName(), col.getSchemaName(), col.getTableName(), col.getColName());
    }

    public String getNonDbFkId() {
        return _nonDbFkId;
    }

    public void setNonDbFkId(String nonDbFkId) {
        _nonDbFkId = nonDbFkId;
    }

    public String getCatalogName() {
        return _catalogName;
    }

    public void setCatalogName(String catalogName) {
        _catalogName = catalogName;
    }

    public String getSchemaName() {
        return _schemaName;
    }

    public void setSchemaName(String schemaName) {
        _schemaName = schemaName;
    }

    public String getTableName() {
        return _tableName;
    }

    public void setTableName(String tableName) {
        _tableName = tableName;
    }

    public String getColName() {
        return _colName;
    }

    public void setColName(String colName) {
        _colName = colName;
    }
}
