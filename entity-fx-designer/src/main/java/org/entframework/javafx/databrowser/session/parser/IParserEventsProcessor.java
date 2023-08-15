/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.parser;

public interface IParserEventsProcessor {
    public void addParserEventsListener(ParserEventsListener l);

    public void removeParserEventsListener(ParserEventsListener l);

    public void triggerParser();
}
