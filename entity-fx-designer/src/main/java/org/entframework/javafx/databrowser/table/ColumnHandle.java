/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.table;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.util.Callback;
import org.entframework.javafx.databrowser.session.ColumnInfo;

import java.util.List;

public class ColumnHandle {
    private final Callback _originalCellFactory;
    private CellValueReader _cellValueReader;
    private String _header;
    private int _columnIndex;
    private TableColumn _tableColumn;
    private List _selectableValues;
    private SquirrelDefaultTableCellChannel _squirrelDefaultTableCellChannel;

    /**
     * This attribute is set only when the columns is an SQL result column.
     * Otherwise it is null,
     */
    private ColumnInfo _resultColumnInfo;

    public ColumnHandle(String header, int columnIndex, CellValueReader cellValueReader, List selectableValues, SquirrelDefaultTableCellChannel squirrelDefaultTableCellChannel) {
        _header = header;
        _columnIndex = columnIndex;
        _cellValueReader = cellValueReader;
        _selectableValues = selectableValues;

        _tableColumn = new TableColumn(_header);
        _tableColumn.setId("" + columnIndex);


        if (0 < selectableValues.size()) {
            _tableColumn.setCellFactory(new Callback<TableColumn, TableCell>() {
                @Override
                public TableCell call(TableColumn param) {
                    return new ComboBoxTableCell(selectableValues.toArray());
                }
            });

            _tableColumn.setEditable(true);
        } else {
            _tableColumn.setCellFactory(param -> new SquirrelDefaultTableCell(squirrelDefaultTableCellChannel));
        }

        _originalCellFactory = _tableColumn.getCellFactory();


        _tableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<List<SimpleObjectProperty>, Object>, ObservableValue<Object>>() {
            public ObservableValue<Object> call(TableColumn.CellDataFeatures<List<SimpleObjectProperty>, Object> row) {
                return _cellValueReader.getCellValue(row, _columnIndex);
            }
        });

        _tableColumn.setUserData(this);
    }

    public static int extractColumnIndex(TableColumn selectedColumn) {
        return Integer.parseInt(selectedColumn.getId());
    }

    public String getHeader() {
        return _header;
    }

    public TableColumn getTableColumn() {
        return _tableColumn;
    }

    public void installEditableCellFactory(Callback<TableColumn, TableCell> cellFactory) {
        _tableColumn.setCellFactory(cellFactory);
        _tableColumn.setEditable(true);
    }

    public void uninstallEditableCellFactory() {
        _tableColumn.setCellFactory(_originalCellFactory);
        _tableColumn.setEditable(false);
    }

    public List getSelectableValues() {
        return _selectableValues;
    }

    public ColumnInfo getResultColumnInfo() {
        return _resultColumnInfo;
    }

    public void setResultColumnInfo(ColumnInfo resultColumnInfo) {
        _resultColumnInfo = resultColumnInfo;
    }

}
