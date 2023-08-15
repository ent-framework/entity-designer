/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.table.tableedit;

public class DatabaseTableUpdateResult {
    private CancelReason _cancelReason;
    private Object _interpretedNewValue = null;
    private int _updateCount = -1;

    public DatabaseTableUpdateResult(Object interpretedNewValue, int updateCount) {
        _interpretedNewValue = interpretedNewValue;
        _updateCount = updateCount;
    }

    public DatabaseTableUpdateResult(CancelReason cancelReason) {
        _cancelReason = cancelReason;
    }

    public Object getInterpretedNewValue() {
        return _interpretedNewValue;
    }

    public boolean success() {
        return null == _cancelReason;
    }

    public static enum CancelReason {
        CANCELED_BY_USER, FAILED_TO_INTERPRET_USER_EDIT, FAILED_TO_EXECUTE_UPDATE, NO_ROWS_AFFECTED
    }
}
