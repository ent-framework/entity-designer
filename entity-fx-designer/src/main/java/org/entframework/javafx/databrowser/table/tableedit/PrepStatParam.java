/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.table.tableedit;

public class PrepStatParam {
    private final Object _val;
    private final int _sqlType;

    public PrepStatParam(Object val, int sqlType) {
        _val = val;
        _sqlType = sqlType;
    }

    public Object getVal() {
        return _val;
    }

    public int getSqlType() {
        return _sqlType;
    }
}
