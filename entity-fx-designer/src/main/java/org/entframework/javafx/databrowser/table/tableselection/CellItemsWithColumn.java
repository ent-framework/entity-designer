/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.table.tableselection;

import javafx.scene.control.TableColumn;
import org.entframework.javafx.databrowser.table.ColumnHandle;

import java.util.ArrayList;

public class CellItemsWithColumn {
    private ArrayList _items = new ArrayList();
    private TableColumn _column;

    public CellItemsWithColumn(TableColumn column) {
        _column = column;
    }

    public void addItem(Object item) {
        _items.add(item);
    }

    public ArrayList getItems() {
        return _items;
    }

    public TableColumn getColumn() {
        return _column;
    }

    public ColumnHandle getColumnHandle() {
        return (ColumnHandle) _column.getUserData();
    }
}
