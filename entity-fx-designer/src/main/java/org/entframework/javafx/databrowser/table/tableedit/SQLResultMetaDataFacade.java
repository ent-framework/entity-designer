/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.table.tableedit;

import org.entframework.javafx.databrowser.table.ResultSetMetaDataLoaderConstants;
import org.entframework.javafx.databrowser.table.TableLoader;

import java.util.List;

public class SQLResultMetaDataFacade {
    private TableLoader _resultMetaDataTableLoader;

    public SQLResultMetaDataFacade(TableLoader resultMetaDataTableLoader) {
        _resultMetaDataTableLoader = resultMetaDataTableLoader;
    }

    public String getColumnNameAt(int resultColIx) {
        return getColumnNames().get(resultColIx);
    }

    public String getColumnClassNameAt(int colIx) {
        return _getMetaDataCells(ResultSetMetaDataLoaderConstants.GET_COLUMN_CLASS_NAME).get(colIx);
    }


    public List<String> getColumnNames() {
        return _getMetaDataCells(ResultSetMetaDataLoaderConstants.GET_COLUMN_NAME);
    }

    private List<String> _getMetaDataCells(ResultSetMetaDataLoaderConstants resultSetMetaDataLoaderConstant) {
        return _resultMetaDataTableLoader.getCellsAsString(resultSetMetaDataLoaderConstant.getMetaDataColumnName());
    }

    public int getSqlTypeAt(int colIx) {
        return Integer.parseInt(_getMetaDataCells(ResultSetMetaDataLoaderConstants.GET_COLUMN_TYPE).get(colIx));
    }

    public String getSqlTypeNameAt(int colIx) {
        return _getMetaDataCells(ResultSetMetaDataLoaderConstants.GET_COLUMN_TYPE_NAME).get(colIx);
    }

    public int getColumnDisplaySizeAt(int colIx) {
        return Integer.parseInt(_getMetaDataCells(ResultSetMetaDataLoaderConstants.GET_COLUMN_DISPLAY_SIZE).get(colIx));
    }

    public int getColumnScaleAt(int colIx) {
        return Integer.parseInt(_getMetaDataCells(ResultSetMetaDataLoaderConstants.GET_SCALE).get(colIx));
    }

    public int getColumnCount() {
        return _resultMetaDataTableLoader.size();
    }
}
