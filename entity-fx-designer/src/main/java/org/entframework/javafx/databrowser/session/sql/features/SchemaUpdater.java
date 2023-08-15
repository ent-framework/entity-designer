/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql.features;

import org.entframework.javafx.databrowser.session.Session;
import org.entframework.javafx.databrowser.session.sql.SQLTextAreaServices;

import java.util.ArrayList;

public class SchemaUpdater {
    ArrayList<String> sqls = new ArrayList<>();
    private Session _session;

    public SchemaUpdater(Session session) {
        _session = session;
    }

    public void addSql(String currentSql) {
        sqls.add(currentSql);
    }

    public void doUpdates(SQLTextAreaServices sqlTextAreaServices) {
        boolean schemaUpdated = false;


        for (String sql : sqls) {
            String tableSimpleName = SchemaUpdaterSqlAnalyzer.getTableSimpleName(sql);

            if (null != tableSimpleName) {
                schemaUpdated = true;
                _session.getSchemaCacheValue().get().reloadMatchingTables(tableSimpleName);
            }


            String procedureSimpleName = SchemaUpdaterSqlAnalyzer.getProcedureSimpleName(sql);
            if (null != procedureSimpleName) {
                schemaUpdated = true;
                _session.getSchemaCacheValue().get().reloadMatchingProcedures(procedureSimpleName);
            }

            //_session.getSchemaCacheValue().get().reloadMatchingUDTs("receipts");
        }

        if (schemaUpdated) {
            sqlTextAreaServices.updateHighlighting();
            _session.getDbConnectorResult().fireCacheUpdate();
        }

    }
}
