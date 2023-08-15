/*
 * Copyright (c) 2002-2023. Licensed under the Apache License, Version 2.0.
 */
package org.entframework.javafx.databrowser.session.parser.kernel.completions;

import org.entframework.javafx.databrowser.session.parser.kernel.Completion;
import org.entframework.javafx.databrowser.session.parser.kernel.SQLSchema;


/**
 * a context which gives access to the nearest statement
 */
public interface SQLStatementContext extends Completion {
    SQLStatement getStatement();

    void setSqlSchema(SQLSchema schema);

    void addContext(SQLStatementContext context);

    void addColumn(SQLColumn column);
}
