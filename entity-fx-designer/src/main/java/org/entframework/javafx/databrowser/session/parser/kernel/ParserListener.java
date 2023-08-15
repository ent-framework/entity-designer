/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.parser.kernel;

import org.entframework.javafx.databrowser.session.parser.kernel.completions.SQLStatement;

public interface ParserListener {
    void statementAdded(SQLStatement statement);
}
