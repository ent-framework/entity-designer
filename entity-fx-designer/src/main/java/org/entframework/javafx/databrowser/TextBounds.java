/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser;

public class TextBounds {

    private final double _textWidth;
    private final int _rows;

    public TextBounds(double textWidth, int rows) {
        _textWidth = textWidth;
        _rows = rows;
    }

    public double getTextWidth() {
        return _textWidth;
    }

    public int getRows() {
        return _rows;
    }
}
