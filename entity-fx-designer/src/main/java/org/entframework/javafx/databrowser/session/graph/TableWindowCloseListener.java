/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph;

@FunctionalInterface
public interface TableWindowCloseListener {
    void closed(TableWindowCtrl tableWindowCtrl);
}
