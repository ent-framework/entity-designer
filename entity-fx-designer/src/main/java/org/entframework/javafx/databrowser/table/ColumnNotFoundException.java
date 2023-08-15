/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.table;


public class ColumnNotFoundException extends IllegalArgumentException {
    public ColumnNotFoundException(String msg) {
        super(msg);
    }
}
