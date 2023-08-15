/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql.copysqlpart;

import org.entframework.javafx.databrowser.session.ColumnInfo;

public class InStatColumnInfo {
    private ColumnInfo _columnInfo;

    private StringBuffer _instat;

    public ColumnInfo getColumnInfo() {
        return _columnInfo;
    }

    public void setColumnInfo(ColumnInfo columnInfo) {
        _columnInfo = columnInfo;
    }

    public StringBuffer getInstat() {
        return _instat;
    }

    public void setInstat(StringBuffer instat) {
        _instat = instat;
    }


}
