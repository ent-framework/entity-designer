/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph;

public enum Operator {
    EQUALS("="),
    LIKE("LIKE"),
    IN("IN"),
    IS_NULL("IS NULL", false),
    LESS("<"),
    LESS_EQUAL("<="),
    GREATER(">"),
    GREATER_EQUAL(">="),
    NOT_EQUAL("<>"),
    NOT_IN("NOT IN"),
    IS_NOT_NULL("IS NOT NULL", false);

    private final boolean _requiresValue;
    private String _opName;

    Operator(String opName) {
        this(opName, true);
    }


    Operator(String opName, boolean requiresValue) {
        _opName = opName;
        _requiresValue = requiresValue;
    }

    @Override
    public String toString() {
        return _opName;
    }

    public boolean requiresValue() {
        return _requiresValue;
    }
}
