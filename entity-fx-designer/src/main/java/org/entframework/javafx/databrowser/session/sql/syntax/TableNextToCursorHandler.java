/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql.syntax;

import org.entframework.javafx.databrowser.session.TableInfo;
import org.entframework.javafx.databrowser.session.schemainfo.SchemaCacheProperty;
import org.fife.ui.rsyntaxtextarea.Token;

import java.util.ArrayList;
import java.util.List;

public class TableNextToCursorHandler {
    private final int _caretPosition;
    private final SchemaCacheProperty _schemaCacheValue;
    private LexAndParseResultListener _lexAndParseResultListener;
    private String _completeText;
    private List<TableInfo> _tablesNextToCursor = new ArrayList<>();

    private int _minDistToCursor = Integer.MAX_VALUE;
    private boolean _inSameSQL = false;

    public TableNextToCursorHandler(LexAndParseResultListener lexAndParseResultListener, int caretPosition, SchemaCacheProperty schemaCacheValue, String completeText) {
        _lexAndParseResultListener = lexAndParseResultListener;
        _caretPosition = caretPosition;
        _schemaCacheValue = schemaCacheValue;
        _completeText = completeText;
    }

    public void checkToken(int lineStart, Token token) {
        if (null == _lexAndParseResultListener) {
            return;
        }

        if (token.getType() != SquirrelTokenMarker.TOKEN_IDENTIFIER_TABLE) {
            return;
        }


        if (false == checkCloser(lineStart, token)) {
            return;
        }

        char[] textArray = token.getTextArray();
        _tablesNextToCursor = _schemaCacheValue.get().getTables(textArray, token.getOffset(), token.length());

    }

    private boolean checkCloser(int lineStart, Token token) {
        int tokenPos = lineStart + token.getOffset();

        boolean currentInSameSQL = isInSameSQL(_caretPosition, tokenPos, _completeText);
        int currentDistToCursor = Math.abs(tokenPos - _caretPosition);


        if (_inSameSQL && !currentInSameSQL) {
            return false;
        } else if (!_inSameSQL && currentInSameSQL) {
            // go on
        } else // _inSameSQL == currentInSameSQL
        {
            if (currentDistToCursor >= _minDistToCursor) {
                return false;
            }
        }

        _inSameSQL = currentInSameSQL;
        _minDistToCursor = currentDistToCursor;


        return true;
    }

    private boolean isInSameSQL(int caretPosition, int tokenPos, String completeText) {
        int indexOfSqlSeparator = completeText.substring(Math.min(caretPosition, tokenPos), Math.max(caretPosition, tokenPos)).indexOf(SyntaxConstants.SQL_SEPARATOR);

        return -1 == indexOfSqlSeparator;
    }

    public void fireTableNextToCursor() {
        if (null == _lexAndParseResultListener) {
            return;
        }

        _lexAndParseResultListener.currentTableInfosNextToCaret(_tablesNextToCursor);

    }
}
