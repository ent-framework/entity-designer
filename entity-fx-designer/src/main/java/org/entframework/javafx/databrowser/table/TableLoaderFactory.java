/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.table;

import org.entframework.javafx.databrowser.services.CollectionUtil;
import org.entframework.javafx.databrowser.services.I18n;
import org.entframework.javafx.databrowser.services.MessageHandler;
import org.entframework.javafx.databrowser.services.MessageHandlerDestination;
import org.entframework.javafx.databrowser.session.sql.StatementChannel;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TableLoaderFactory {
    public static TableLoader loadDataFromResultSet(ResultSet res, String... excludeColNames) {
        return loadDataFromResultSet(res, new StatementChannel(), excludeColNames);
    }

    public static TableLoader loadDataFromResultSet(ResultSet res, StatementChannel statementChannel, String... excludeColNames) {
        try {
            TableLoader tableLoader = new TableLoader();

            ResultSetMetaData metaData = res.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); ++i) {
                final String colName = metaData.getColumnName(i);
                if (false == CollectionUtil.contains(excludeColNames, (t) -> colName.equalsIgnoreCase(t))) {
                    tableLoader.addColumn(colName);
                }
            }

            while (res.next()) {
                List row = new ArrayList();

                for (int i = 1; i <= metaData.getColumnCount(); ++i) {
                    final String colName = metaData.getColumnName(i);

                    if (statementChannel.isCanceled()) {
                        MessageHandler mh = new MessageHandler(TableLoaderFactory.class, MessageHandlerDestination.MESSAGE_PANEL);
                        I18n i18n = new I18n(TableLoaderFactory.class);
                        mh.warning(i18n.t("session.tab.sql.executing.cancel.building.output"));
                        return tableLoader;
                    }

                    if (false == CollectionUtil.contains(excludeColNames, (t) -> colName.equalsIgnoreCase(t))) {
                        row.add(res.getObject(i));
                    }
                }

                tableLoader.addRow(row);
            }

            return tableLoader;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static TableLoader createEmptyLoader() {
        return new TableLoader();
    }
}
