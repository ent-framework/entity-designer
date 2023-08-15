/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.table.tableedit;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.TablePosition;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;
import org.entframework.javafx.databrowser.services.Utils;
import org.entframework.javafx.databrowser.table.CellDataPopupCtrl;
import org.entframework.javafx.databrowser.table.CellProperties;
import org.entframework.javafx.databrowser.table.TableCellUtil;

public class SquirrelTextFieldTableCell extends TextFieldTableCell {
    private CellDataPopupEditListener _cellDataPopupEditListener;

    public SquirrelTextFieldTableCell(CellDataPopupEditListener cellDataPopupEditListener) {
        super(
                new StringConverter() {
                    @Override
                    public String toString(Object object) {
                        return "" + object;
                    }

                    @Override
                    public Object fromString(String string) {
                        return string;
                    }
                }
        );


        addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                onDoubleClick(event);
            }
        });

        _cellDataPopupEditListener = cellDataPopupEditListener;
    }


    private void onDoubleClick(MouseEvent event) {
        if (Utils.isDoubleClick(event) && false == isEditable()) {
            Object item = getItem();
            TablePosition tp = new TablePosition(getTableView(), getTableRow().getIndex(), getTableColumn());


            new CellDataPopupCtrl(item, event, getTableRow(), tp, _cellDataPopupEditListener);
        }
    }


    @Override
    public void updateItem(Object item, boolean empty) {
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
            super.setStyle(cellProperties.getStyle());

            if (cellProperties.isMultiLineCell()) {
                setEditable(false);
            }

            super.setGraphic(null);
        }
    }
}
