/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql.copysqlpart;

import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import org.entframework.javafx.databrowser.AppState;
import org.entframework.javafx.databrowser.services.Utils;
import org.entframework.javafx.databrowser.table.tableselection.CellItemsWithColumn;
import org.entframework.javafx.databrowser.table.tableselection.ExtendedTableSelectionHandler;

import java.util.List;

public class InsertStatCreator {

    public static void onCopyAsInsertStat(ExtendedTableSelectionHandler extendedTableSelectionHandler) {
        String statementSeparator = AppState.get().getSettingsManager().getSettings().getStatementSeparator();


        List<CellItemsWithColumn> selectedCellItemsByColumn = extendedTableSelectionHandler.getSelectedCellItemsWithColumn();


        int rowCount = selectedCellItemsByColumn.get(0).getItems().size();


        StringBuffer buf = new StringBuffer();

        StringBuffer colNames = new StringBuffer();
        StringBuffer vals = new StringBuffer();


        for (int j = 0; j < rowCount; j++) {
            boolean firstCol = true;
            for (int i = 0; i < selectedCellItemsByColumn.size(); i++) {
                CellItemsWithColumn cellItemsWithColumn = selectedCellItemsByColumn.get(i);

                if (firstCol) {
                    colNames.append("INSERT INTO " + getTableName(cellItemsWithColumn) + " (");
                    firstCol = false;
                    vals.append("(");
                } else {
                    colNames.append(",");
                    vals.append(",");
                }

                Object cellObj = cellItemsWithColumn.getItems().get(j);

                colNames.append(cellItemsWithColumn.getColumn().getText());
                vals.append(CopySqlPartUtil.getData(cellItemsWithColumn.getColumnHandle().getResultColumnInfo(), cellObj, StatementType.IN));
            }

            colNames.append(")");
            vals.append(")");

            buf.append(colNames).append(" VALUES ").append(vals);

            if (1 < statementSeparator.length()) {
                buf.append(" ").append(statementSeparator).append("\n");
            } else {
                buf.append(statementSeparator).append("\n");
            }

            colNames.setLength(0);
            vals.setLength(0);

        }

        //String sql = CodeReformatorFractory.createCodeReformator().reformat(buf.toString());

        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent content = new ClipboardContent();
        content.putString(buf.toString());
        clipboard.setContent(content);

    }

    private static String getTableName(CellItemsWithColumn colDef) {
        String tableName = colDef.getColumnHandle().getResultColumnInfo().getTableName();
        if (false == Utils.isEmptyString(tableName)) {
            return tableName;
        }
        return "ReplaceByTableName";
    }

}