/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.parser;

import org.entframework.javafx.databrowser.session.Session;

public interface IParserEventsProcessorFactory {
    /**
     * Will be called several times with the same parameters.
     */
    IParserEventsProcessor getParserEventsProcessor(int tabContextIdentifier, Session sess);
}
