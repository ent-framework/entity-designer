/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.parser.kernel.completions;

public interface ErrorListener {
    void errorDetected(String message, int line, int column);
}
