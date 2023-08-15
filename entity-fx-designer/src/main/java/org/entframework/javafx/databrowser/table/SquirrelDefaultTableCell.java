/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.table;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.TableCell;
import javafx.scene.control.TablePosition;
import javafx.scene.input.MouseEvent;
import org.entframework.javafx.databrowser.services.Utils;


/**
 * First of all a copy of javafx.scene.control.TableColumn.DEFAULT_CELL_FACTORY
 */
public class SquirrelDefaultTableCell extends TableCell<Object, Object> {
    private SquirrelDefaultTableCellChannel _squirrelDefaultTableCellChannel;

    public SquirrelDefaultTableCell(SquirrelDefaultTableCellChannel squirrelDefaultTableCellChannel) {
        _squirrelDefaultTableCellChannel = squirrelDefaultTableCellChannel;

        addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                onDoubleClick(event);
            }
        });
    }

    private void onDoubleClick(MouseEvent event) {
        if (Utils.isDoubleClick(event)) {
            Object item = getItem();

            TablePosition tp = new TablePosition(getTableView(), getTableRow().getIndex(), getTableColumn());

            new CellDataPopupCtrl(item, event, getTableRow(), tp);
        }
    }

    @Override
    protected void updateItem(Object item, boolean empty) {
        if (item == getItem()) return;

        super.updateItem(item, empty);

        if (item == null) {
            super.setText(null);
            super.setGraphic(null);
        } else if (item instanceof Node) {
            super.setText(null);
            super.setGraphic((Node) item);
        } else {
            CellProperties cellProperties = TableCellUtil.getCellProperties(item);
            super.setText(cellProperties.getValue());


            if (SearchMatch.MATCH == _squirrelDefaultTableCellChannel.getSearchMatch(item, this)) {
                super.setStyle(CellProperties.SEARCH_MATCH_STYLE);
            } else if (SearchMatch.MATCH_CURRENT == _squirrelDefaultTableCellChannel.getSearchMatch(item, this)) {
                super.setStyle(CellProperties.CURRENT_SEARCH_MATCH_STYLE);
            } else {
                super.setStyle(cellProperties.getStyle());
            }

            super.setGraphic(null);
        }
    }
}
