/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.common.event;

import org.entframework.javafx.designer.entitydesigner.model.EEntityObject;

public class EntityEvent extends Event {

    private final EEntityObject entity;
    private final Type type;

    public EntityEvent(EEntityObject entity) {
        this.entity = entity;
        this.type =  Type.UPDATE;
    }

    public EntityEvent(EEntityObject entity, Type type) {
        this.entity = entity;
        this.type = type;
    }


    public EEntityObject getEntity() {
        return entity;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        ADD,
        UPDATE,
        REMOVE,
    }
}
