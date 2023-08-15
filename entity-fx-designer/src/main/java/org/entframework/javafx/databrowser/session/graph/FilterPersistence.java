/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph;

public class FilterPersistence {
    private String _operatorAsString = Operator.EQUALS.name();
    private String _filter;

    public String getOperatorAsString() {
        return _operatorAsString;
    }

    public void setOperatorAsString(String operatorAsString) {
        _operatorAsString = operatorAsString;
    }

    public String getFilter() {
        return _filter;
    }

    public void setFilter(String filter) {
        _filter = filter;
    }
}
