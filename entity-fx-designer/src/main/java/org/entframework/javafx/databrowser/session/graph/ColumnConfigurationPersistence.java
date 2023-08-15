/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph;


public class ColumnConfigurationPersistence {
    private AggregateFunctionPersistence _aggregateFunctionPersistence = new AggregateFunctionPersistence();
    private FilterPersistence _filterPersistence = new FilterPersistence();
    private OrderByPersistence _orderByPersistence = new OrderByPersistence();
    private int _selectPosition = -1;
    private int _orderByPosition = -1;

    public AggregateFunctionPersistence getAggregateFunctionPersistence() {
        return _aggregateFunctionPersistence;
    }

    public void setAggregateFunctionPersistence(AggregateFunctionPersistence aggregateFunctionPersistence) {
        _aggregateFunctionPersistence = aggregateFunctionPersistence;
    }


    public FilterPersistence getFilterPersistence() {
        return _filterPersistence;
    }

    public void setFilterPersistence(FilterPersistence filterPersistence) {
        _filterPersistence = filterPersistence;
    }

    public OrderByPersistence getOrderByPersistence() {
        return _orderByPersistence;
    }

    public void setOrderByPersistence(OrderByPersistence orderByPersistence) {
        _orderByPersistence = orderByPersistence;
    }

    public int getSelectPosition() {
        return _selectPosition;
    }

    public void setSelectPosition(int selectPosition) {
        _selectPosition = selectPosition;
    }

    public int getOrderByPosition() {
        return _orderByPosition;
    }

    public void setOrderByPosition(int orderByPosition) {
        _orderByPosition = orderByPosition;
    }
}
