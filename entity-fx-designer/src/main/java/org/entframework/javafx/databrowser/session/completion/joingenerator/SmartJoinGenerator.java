/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.completion.joingenerator;

import org.entframework.javafx.databrowser.session.Session;
import org.entframework.javafx.databrowser.session.TableInfo;
import org.entframework.javafx.databrowser.session.completion.CaretVicinity;
import org.entframework.javafx.databrowser.table.TableLoader;
import org.entframework.javafx.databrowser.table.TableLoaderFactory;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class SmartJoinGenerator extends JoinGeneratorBase {
    public SmartJoinGenerator(CaretVicinity caretVicinity, Session session) {
        super(caretVicinity, session);
    }

    protected String createJoinClause(TableInfo table, String fkColumnName) {
        try {
            DatabaseMetaData metaData = getSession().getDbConnectorResult().getSQLConnection().getConnection().getMetaData();

            TableLoader column = TableLoaderFactory.loadDataFromResultSet(metaData.getColumns(table.getCatalog(), table.getSchema(), table.getName(), fkColumnName));

            if ("YES".equalsIgnoreCase(column.getCellAsString("IS_NULLABLE", 0))) {
                return "LEFT JOIN";
            } else {
                return "INNER JOIN";
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected String getGeneratorName() {
        return JoinGeneratorProvider.GENERATOR_START + "j";
    }

    @Override
    protected JoinCompletionCandidateBase createCompletionCandidate(String replacement) {
        return new SmartJoinCompletionCandidate(replacement);
    }
}
