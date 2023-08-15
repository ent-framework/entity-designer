/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph;

import org.entframework.javafx.databrowser.services.SQLUtil;
import org.entframework.javafx.databrowser.session.ColumnInfo;
import org.entframework.javafx.databrowser.session.TableInfo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class ColumnPersistence {
    private String _catalogName;
    private String _schemaName;
    private String _tableName;
    private String _colName;

    private HashSet<String> _nonDbFkIdsPointingAtMe = new HashSet<>();
    private HashMap<String, NonDbImportedKeyPersistence> _nonDbImportedKeyPersistenceByNonDbFkId = new HashMap<>();
    private ColumnConfigurationPersistence _columnConfigurationPersistence = new ColumnConfigurationPersistence();


    public ColumnPersistence(String catalogName, String schemaName, String tableName, String colName) {
        _catalogName = catalogName;
        _schemaName = schemaName;
        _tableName = tableName;
        _colName = colName;
    }

    public ColumnPersistence() {
    }

    public static ColumnPersistence getMatching(ColumnInfo c, List<ColumnPersistence> columnPersistences) {
        for (ColumnPersistence pers : columnPersistences) {
            if (SQLUtil.getQualifiedName(pers.getCatalogName(), pers.getSchemaName(), pers.getTableName()).equalsIgnoreCase(SQLUtil.getQualifiedName(c.getCatalogName(), c.getSchemaName(), c.getTableName()))) {
                if (pers.getColName().equalsIgnoreCase(c.getColName())) {
                    return pers;
                }
            }
        }

        return null;
    }

    public static HashMap<String, NonDbImportedKey> toNonDbImportedKeyByNonDbFkId(ColumnPersistence pers, GraphFinder finder) {
        HashMap<String, NonDbImportedKey> ret = new HashMap<>();

        for (Map.Entry<String, NonDbImportedKeyPersistence> entry : pers.getNonDbImportedKeyPersistenceByNonDbFkId().entrySet()) {
            NonDbImportedKeyPersistence value = entry.getValue();

            GraphColumn col = finder.findCol(value.getCatalogName(), value.getSchemaName(), value.getTableName(), value.getColName());
            TableInfo table = finder.getTable(SQLUtil.getQualifiedName(value.getCatalogName(), value.getSchemaName(), value.getTableName()));

            //if (null != col && null != table)
            {
                ret.put(entry.getKey(), new NonDbImportedKey(value.getNonDbFkId(), col, table));
            }
        }

        return ret;
    }

    public HashSet<String> getNonDbFkIdsPointingAtMe() {
        return _nonDbFkIdsPointingAtMe;
    }

    public void setNonDbFkIdsPointingAtMe(HashSet<String> nonDbFkIdsPointingAtMe) {
        _nonDbFkIdsPointingAtMe = nonDbFkIdsPointingAtMe;
    }

    public HashMap<String, NonDbImportedKeyPersistence> getNonDbImportedKeyPersistenceByNonDbFkId() {
        return _nonDbImportedKeyPersistenceByNonDbFkId;
    }

    public void setNonDbImportedKeyPersistenceByNonDbFkId(HashMap<String, NonDbImportedKeyPersistence> nonDbImportedKeyPersistenceByNonDbFkId) {
        _nonDbImportedKeyPersistenceByNonDbFkId = nonDbImportedKeyPersistenceByNonDbFkId;
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

    public ColumnConfigurationPersistence getColumnConfigurationPersistence() {
        return _columnConfigurationPersistence;
    }

    public void setColumnConfigurationPersistence(ColumnConfigurationPersistence columnConfigurationPersistence) {
        _columnConfigurationPersistence = columnConfigurationPersistence;
    }
}
