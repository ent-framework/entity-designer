/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session;

public class CaretVicinityInfo {
    private final int _tokenBeginPos;
    private final int _caretPosition;
    private String _tokenTillCaret;
    private String _tokenAtCaret;
    private int _tokenEndPos;

    public CaretVicinityInfo(String tokenTillCaret, String tokenAtCaret, int tokenBeginPos, int tokenEndPos, int caretPosition) {
        _tokenTillCaret = tokenTillCaret;
        _tokenAtCaret = tokenAtCaret;
        _tokenBeginPos = tokenBeginPos;
        _tokenEndPos = tokenEndPos;
        _caretPosition = caretPosition;
    }

    public String getTokenTillCaret() {
        return _tokenTillCaret;
    }

    public String getTokenAtCaret() {
        return _tokenAtCaret;
    }

    public int getTokenBeginPos() {
        return _tokenBeginPos;
    }

    public int getTokenEndPos() {
        return _tokenEndPos;
    }

    public int getCaretPosition() {
        return _caretPosition;
    }
}
