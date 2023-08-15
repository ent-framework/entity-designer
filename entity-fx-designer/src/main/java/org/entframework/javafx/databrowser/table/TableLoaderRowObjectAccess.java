/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.table;

public interface TableLoaderRowObjectAccess<T> {
    Object getColumn(T rowObject, int colIx);

    void setColumn(T rowObject, int colIx, Object cellValue);
}
