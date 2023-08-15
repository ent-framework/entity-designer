/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.parser.kernel;

public interface ParsingFinishedListener {
    void parsingFinished();

    void parserExitedOnException(Throwable e);
}
