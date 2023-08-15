/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.common.event;

public class MessageLogEvent extends MessageEvent {
    public MessageLogEvent(String message, Throwable throwable, Type type) {
        super(message, throwable, type);
    }
}
