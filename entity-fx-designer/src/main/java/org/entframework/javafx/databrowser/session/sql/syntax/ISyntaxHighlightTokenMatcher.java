/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql.syntax;

public interface ISyntaxHighlightTokenMatcher {
    boolean isError(int offset, int len);

    boolean isTable(char[] buffer, int offset, int len);

    boolean isFunction(char[] buffer, int offset, int len);

    boolean isStatementSeparator(char[] buffer, int offset, int len);

    boolean isColumn(char[] buffer, int offset, int len);

    boolean isKeyword(char[] buffer, int offset, int len);
}
