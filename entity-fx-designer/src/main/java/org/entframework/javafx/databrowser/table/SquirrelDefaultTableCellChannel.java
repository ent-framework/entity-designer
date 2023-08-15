/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.table;

public class SquirrelDefaultTableCellChannel {
    private SearchMatchCheck _searchMatchCheck;

    public SearchMatch getSearchMatch(Object valueToRender, SquirrelDefaultTableCell cell) {
        if (null == _searchMatchCheck) {
            return SearchMatch.MATCH_NONE;
        }


        return _searchMatchCheck.getSearchMatch(valueToRender, cell);
    }

    public void setSearchMatchCheck(SearchMatchCheck searchMatchCheck) {
        _searchMatchCheck = searchMatchCheck;
    }
}
