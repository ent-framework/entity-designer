/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.parser;

import org.entframework.javafx.databrowser.session.Session;
import org.entframework.javafx.databrowser.session.TableInfo;
import org.entframework.javafx.databrowser.session.parser.kernel.SQLSchema;

import java.util.ArrayList;
import java.util.List;

public class SQLSchemaImpl implements SQLSchema {
    private Session _session;

    SQLSchemaImpl(Session session) {
        _session = session;
    }

    public Table getTable(String catalog, String schema, String name) {
        List<TableInfo> tablesBySimpleName = _session.getSchemaCacheValue().get().getTablesBySimpleName(name);
        if (0 < tablesBySimpleName.size()) {
            return new Table(catalog, schema, name, _session);
        }
        return null;
    }

    public List<Table> getTables(String catalog, String schema, String name) {
        List<TableInfo> tableNames = _session.getSchemaCacheValue().get().getTablesByFullyQualifiedName(catalog, schema, name);

        List<Table> ret = new ArrayList<>();

        for (TableInfo tableInfo : tableNames) {
            Table buf = new Table(catalog, schema, tableInfo.getName(), _session);
            ret.add(buf);
        }
        return ret;
    }

    public Table getTableForAlias(String alias) {
        return null;
    }
}
