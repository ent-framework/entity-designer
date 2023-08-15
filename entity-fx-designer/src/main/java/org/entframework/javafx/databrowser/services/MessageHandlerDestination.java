/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.services;

public enum MessageHandlerDestination {
    MESSAGE_LOG, MESSAGE_PANEL, MESSAGE_LOG_AND_PANEL;

    public boolean matches(MessageHandlerDestination dest) {
        return dest == MESSAGE_LOG_AND_PANEL || dest == this;
    }
}
