/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph;

public class AggregateFunctionPersistence {
    private boolean _inSelect;
    private AggregateFunction _aggregateFunction = AggregateFunction.NONE;

    public boolean isInSelect() {
        return _inSelect;
    }

    public void setInSelect(boolean inSelect) {
        _inSelect = inSelect;
    }

    public AggregateFunction getAggregateFunction() {
        return _aggregateFunction;
    }

    public void setAggregateFunction(AggregateFunction aggregateFunction) {
        _aggregateFunction = aggregateFunction;
    }
}
