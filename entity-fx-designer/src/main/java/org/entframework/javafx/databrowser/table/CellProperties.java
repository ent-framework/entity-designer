/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.table;

public class CellProperties {
    public static final String MULTI_LINE_STYLE = "-fx-background-color: cyan;";
    public static final String SEARCH_MATCH_STYLE = "-fx-background-color: limegreen;";
    public static final String CURRENT_SEARCH_MATCH_STYLE = "-fx-background-color: mediumseagreen;";


    private final String _value;
    private final String _style;
    private boolean _multiLineCell;

    public CellProperties(String value, String style, boolean multiLineCell) {
        _value = value;
        _style = style;
        _multiLineCell = multiLineCell;
    }

    public String getValue() {
        return _value;
    }

    public String getStyle() {
        return _style;
    }

    public boolean isMultiLineCell() {
        return _multiLineCell;
    }
}
