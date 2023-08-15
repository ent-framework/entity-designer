/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.parser.kernel.completions;

public interface SQLSelectStatementListener {
    void aliasDefined(String tableName, String aliasName);
}
