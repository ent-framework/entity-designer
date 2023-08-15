/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.common.event;

import io.github.eckig.grapheditor.model.GModel;
import io.github.eckig.grapheditor.model.GNode;

public class NodeEvent extends Event {

    private final GModel model;
    private final GNode node;
    private final EventType type;

    public NodeEvent(GModel source, GNode node, EventType type) {
        this.model = source;
        this.node = node;
        this.type = type;
    }

    public GModel getModel() {
        return model;
    }

    public GNode getNode() {
        return node;
    }

    public EventType getType() {
        return type;
    }

    public enum EventType {
        ADD,
        REMOVE,
        CLEAR,
        UNDO,
        REDO,
    }
}
