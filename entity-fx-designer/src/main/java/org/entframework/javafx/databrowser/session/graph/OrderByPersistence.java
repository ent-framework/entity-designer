/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph;

public class OrderByPersistence {
    private String _orderBy = OrderBy.NONE.name();

    public String getOrderBy() {
        return _orderBy;
    }

    public void setOrderBy(String orderBy) {
        _orderBy = orderBy;
    }
}
