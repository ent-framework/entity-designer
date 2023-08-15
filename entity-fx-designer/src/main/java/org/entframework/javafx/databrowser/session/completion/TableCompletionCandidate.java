/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.completion;

import org.entframework.javafx.databrowser.session.TableInfo;
import org.entframework.javafx.databrowser.session.schemainfo.StructItemSchema;

public class TableCompletionCandidate extends CompletionCandidate {
    private TableInfo _tableInfo;
    private StructItemSchema _schema;
    private boolean _showQualifiedHint;

    public TableCompletionCandidate(TableInfo tableInfo) {
        this(tableInfo, tableInfo.getStructItemSchema());
    }

    public TableCompletionCandidate(TableInfo tableInfo, StructItemSchema schema) {
        _tableInfo = tableInfo;
        _schema = schema;
    }

    @Override
    public String getReplacement() {
        return _tableInfo.getName();
    }

    @Override
    public String getObjectTypeName() {
        String ret;

        if (TableTypes.TABLE.toString().equalsIgnoreCase(_tableInfo.getTableType())) {
            ret = TableTypes.TABLE.toString();
        } else if (TableTypes.VIEW.toString().equalsIgnoreCase(_tableInfo.getTableType())) {
            ret = TableTypes.VIEW.toString();
        } else {
            ret = "TABLE/" + _tableInfo.getTableType();
        }

        if (_showQualifiedHint) {
            ret += " in " + CompletionUtil.getCatalogSchemaString(_tableInfo.getStructItemSchema());
        }

        return ret;
    }

    public TableInfo getTableInfo() {
        return _tableInfo;
    }

    public String getSimpleName() {
        return _tableInfo.getName();
    }

    public void setShowQualifiedHint(boolean showQualifiedHint) {
        _showQualifiedHint = showQualifiedHint;
    }
}
