/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.common.event;

public class DockButtonToggleEvent extends Event {

    private Type type;
    private boolean selected;
    public DockButtonToggleEvent(Type type, boolean selected) {
        this.type = type;
        this.selected = selected;
    }

    public Type getType() {
        return type;
    }

    public boolean isSelected() {
        return selected;
    }

    public enum Type {
        DESIGNER,
        ALIASES,
        DRIVERS,
        CLOSE_ALL
    }
}
