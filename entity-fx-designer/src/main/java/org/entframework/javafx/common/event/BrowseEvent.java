/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

/* SPDX-License-Identifier: MIT */
package org.entframework.javafx.common.event;

import java.net.URI;

public class BrowseEvent extends Event {

    private final URI uri;

    public BrowseEvent(URI uri) {
        this.uri = uri;
    }

    public URI getUri() {
        return uri;
    }

    @Override
    public String toString() {
        return "BrowseEvent{" +
                "uri=" + uri +
                "} " + super.toString();
    }
}
