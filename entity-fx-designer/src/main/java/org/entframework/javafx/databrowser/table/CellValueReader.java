/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.table;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;

import java.util.List;

public interface CellValueReader {
    public ObservableValue<Object> getCellValue(TableColumn.CellDataFeatures<List<SimpleObjectProperty>, Object> row, int columnIndex);
}
