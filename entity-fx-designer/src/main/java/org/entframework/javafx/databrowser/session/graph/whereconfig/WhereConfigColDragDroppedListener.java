/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph.whereconfig;

import javafx.scene.control.TreeItem;
import org.entframework.javafx.databrowser.services.dndpositionmarker.RelativeNodePosition;

public interface WhereConfigColDragDroppedListener {
    void dropped(String idToMove, TreeItem<WhereConfigColTreeNode> targetTreeItem, RelativeNodePosition movePosition);
}
