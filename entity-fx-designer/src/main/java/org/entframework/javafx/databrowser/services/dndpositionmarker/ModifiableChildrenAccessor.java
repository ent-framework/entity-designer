/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.services.dndpositionmarker;

import javafx.collections.ObservableList;
import javafx.scene.Node;

public interface ModifiableChildrenAccessor {
    public ObservableList<Node> getChildrenModifiable();
}
