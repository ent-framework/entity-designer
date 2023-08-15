/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.common.event;

public abstract class MessageEvent extends Event {
    private final String message;
    private final Throwable throwable;
    private final Type type;
    public MessageEvent(String message, Throwable throwable, Type type) {
        this.message = message;
        this.throwable = throwable;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        WARNING,
        INFO,
        ERROR
    }
}
