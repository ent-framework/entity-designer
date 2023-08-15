/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph;

public class ColumnPersistenceId {
    public static String createId(ColumnPersistence columnPersistence) {
        return columnPersistence.getTableName() + "." + columnPersistence.getColName();
    }
}
