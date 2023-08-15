/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.schemainfo;

public interface DatabaseStructureVisitor<T> {
    T visit(T resultOfParenVisit, StructItem structItem);
}
