/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql.tablesearch;

import org.entframework.javafx.databrowser.services.Utils;
import org.entframework.javafx.databrowser.table.SearchMatch;
import org.entframework.javafx.databrowser.table.SquirrelDefaultTableCell;
import org.entframework.javafx.databrowser.table.TableLoader;

import java.util.HashSet;

public class SearchResult {
    private SearchCell _currentMatch;
    private HashSet<SearchCell> _matches = new HashSet<>();

    public SearchMatch getSearchMatch(Object valueToRender, SquirrelDefaultTableCell cell) {
        if (Utils.compareRespectEmpty(_currentMatch, createSearchCell(cell))) {
            return SearchMatch.MATCH_CURRENT;
        } else if (_matches.contains(createSearchCell(cell))) {
            return SearchMatch.MATCH;
        } else {
            return SearchMatch.MATCH_NONE;
        }

    }


    public void reset() {
        _currentMatch = null;
        _matches.clear();
    }

    public SearchCell getStartCell(TableLoader resultTableLoader, boolean forward) {
        if (forward) {
            if (null == _currentMatch) {
                return new SearchCell();
            }
        } else {
            if (null == _currentMatch) {
                return new SearchCell(resultTableLoader.size() - 1, resultTableLoader.getColumnCount() - 1);
            }
        }

        return _currentMatch.createNextCell(resultTableLoader.size(), resultTableLoader.getColumnCount(), forward);
    }

    public void setCurrentMatchCell(int row, int col) {
        _currentMatch = new SearchCell(row, col);
        _matches.add(_currentMatch);
    }


    private SearchCell createSearchCell(SquirrelDefaultTableCell cell) {
        if (null == cell.getTableRow() || null == cell.getTableView() || -1 == cell.getTableView().getColumns().indexOf(cell.getTableColumn())) {
            return SearchCell.INVALID;
        }


        int row = cell.getTableRow().getIndex();
        int col = cell.getTableView().getColumns().indexOf(cell.getTableColumn());
        return new SearchCell(row, col);
    }


    public void resetCurrentMatchCell() {
        _currentMatch = null;
    }
}
