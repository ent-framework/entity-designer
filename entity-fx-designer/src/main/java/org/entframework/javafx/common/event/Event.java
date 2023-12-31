/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

/* SPDX-License-Identifier: MIT */
package org.entframework.javafx.common.event;

import java.util.UUID;

public abstract class Event {

    protected final UUID id = UUID.randomUUID();

    protected Event() {
    }

    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Event event = (Event) o;
        return id.equals(event.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                '}';
    }
}
