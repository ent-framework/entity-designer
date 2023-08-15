/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session;

import org.entframework.javafx.databrowser.session.schemainfo.StructItemSchema;
import org.entframework.javafx.databrowser.table.TableLoader;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TableInfo implements Serializable {
    private String _catalog;
    private String _schema;
    private String _tableType;
    private String _name;
    private String _qualifiedName;
    private transient TableLoader _columnsAsTableLoader;

    public TableInfo(String catalog, String schema, String tableType, String name, String qualifiedName) {
        _catalog = catalog;
        _schema = schema;
        _tableType = tableType;
        _name = name;
        _qualifiedName = qualifiedName;
    }

    public String getCatalog() {
        return _catalog;
    }

    public String getSchema() {
        return _schema;
    }

    public String getTableType() {
        return _tableType;
    }

    public String getName() {
        return _name;
    }

    public String getQualifiedName() {
        return _qualifiedName;
    }

    public TableLoader getColumnsAsTableLoader() {
        return _columnsAsTableLoader;
    }

    public void setColumnsAsTableLoader(TableLoader columnsAsTableLoader) {
        _columnsAsTableLoader = columnsAsTableLoader;
    }

    public List<ColumnInfo> getColumns() {
        if (null == _columnsAsTableLoader) {
            throw new IllegalStateException();
        }

        return ColumnInfo.createColumnInfosFromTableMetaData(this, _columnsAsTableLoader);
    }

    public List<ColumnInfo> getColumnsIfLoaded() {
        if (null == _columnsAsTableLoader) {
            return new ArrayList<>();
        } else {
            return getColumns();
        }
    }


    public StructItemSchema getStructItemSchema() {
        return new StructItemSchema(_schema, _catalog);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TableInfo tableInfo = (TableInfo) o;

        if (_catalog != null ? !_catalog.equals(tableInfo._catalog) : tableInfo._catalog != null) return false;
        if (_schema != null ? !_schema.equals(tableInfo._schema) : tableInfo._schema != null) return false;
        if (_tableType != null ? !_tableType.equals(tableInfo._tableType) : tableInfo._tableType != null) return false;
        return !(_name != null ? !_name.equals(tableInfo._name) : tableInfo._name != null);

    }

    @Override
    public int hashCode() {
        int result = _catalog != null ? _catalog.hashCode() : 0;
        result = 31 * result + (_schema != null ? _schema.hashCode() : 0);
        result = 31 * result + (_tableType != null ? _tableType.hashCode() : 0);
        result = 31 * result + (_name != null ? _name.hashCode() : 0);
        return result;
    }
}
