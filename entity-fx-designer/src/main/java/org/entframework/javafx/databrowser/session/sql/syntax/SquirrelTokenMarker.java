/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql.syntax;

import org.fife.ui.rsyntaxtextarea.Token;

public class SquirrelTokenMarker extends SquirrelTokenMakerBase {
    private static int _curTokenArrayIndex = Token.DEFAULT_NUM_TOKEN_TYPES;

    public static final int TOKEN_IDENTIFIER_TABLE = _curTokenArrayIndex++;
    public static final int TOKEN_IDENTIFIER_COLUMN = _curTokenArrayIndex++;
    public static final int TOKEN_IDENTIFIER_FUNCTION = _curTokenArrayIndex++;
    public static final int TOKEN_IDENTIFIER_STATEMENT_SEPARATOR = _curTokenArrayIndex++;
//   public static final int TOKEN_IDENTIFIER_ERROR = _curTokenArrayIndex++;
//   public static final int TOKEN_IDENTIFIER_SCHEMA = _curTokenArrayIndex++;
//   public static final int TOKEN_IDENTIFIER_CATALOG = _curTokenArrayIndex++;


    private ISyntaxHighlightTokenMatcher _syntaxHighlightTokenMatcher;

    public SquirrelTokenMarker(ISyntaxHighlightTokenMatcher syntaxHighlightTokenMatcher) {
        _syntaxHighlightTokenMatcher = syntaxHighlightTokenMatcher;
    }

    public static int getNumTokenTypes() {
        return _curTokenArrayIndex;
    }

    public void addToken(char[] array, int start, int end, int tokenType, int startOffset, boolean hyperlink) {
        int len = end + 1 - start;

        if (_syntaxHighlightTokenMatcher.isError(startOffset, len)) {
            // Errors must be first.
            super.addToken(array, start, end, Token.ERROR_IDENTIFIER, startOffset, hyperlink);
        } else if (Token.IDENTIFIER == tokenType) {
//         String s = new String(array).substring(start, end+1);
//         System.out.println("Squirrel: -->" + s + "<--");
            if (_syntaxHighlightTokenMatcher.isKeyword(array, start, len)) {
                super.addToken(array, start, end, Token.RESERVED_WORD, startOffset, hyperlink);
            } else if (_syntaxHighlightTokenMatcher.isTable(array, start, len)) {
                super.addToken(array, start, end, TOKEN_IDENTIFIER_TABLE, startOffset, hyperlink);
            } else if (_syntaxHighlightTokenMatcher.isColumn(array, start, len)) {
                super.addToken(array, start, end, TOKEN_IDENTIFIER_COLUMN, startOffset, hyperlink);
            } else if (_syntaxHighlightTokenMatcher.isFunction(array, start, len)) {
                super.addToken(array, start, end, TOKEN_IDENTIFIER_FUNCTION, startOffset, hyperlink);
            } else if (_syntaxHighlightTokenMatcher.isStatementSeparator(array, start, len)) {
                super.addToken(array, start, end, TOKEN_IDENTIFIER_STATEMENT_SEPARATOR, startOffset, hyperlink);
            } else {
                super.addToken(array, start, end, tokenType, startOffset, hyperlink);
            }
        } else {
            super.addToken(array, start, end, tokenType, startOffset, hyperlink);
        }
    }
}
