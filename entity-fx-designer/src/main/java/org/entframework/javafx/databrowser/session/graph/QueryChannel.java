/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph;

import java.util.ArrayList;

public class QueryChannel {
    private ArrayList<QueryChannelListener> _listeners = new ArrayList<>();

    public void fireChanged() {
        for (QueryChannelListener queryChannelListener : _listeners.toArray(new QueryChannelListener[0])) {
            queryChannelListener.changed();
        }
    }

    public void addQueryChannelListener(QueryChannelListener queryChannelListener) {
        _listeners.add(queryChannelListener);
    }
}
