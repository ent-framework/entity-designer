/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.aliases.channel;

import javafx.scene.control.TreeItem;
import org.entframework.javafx.databrowser.aliases.AliasTreeNode;
import org.entframework.javafx.databrowser.services.dndpositionmarker.RelativeNodePosition;

public interface AliasTreeNodeMoveListener {
    void moveNodeRequest(TreeItem<AliasTreeNode> itemToMoveTo, TreeItem<AliasTreeNode> itemToMove, RelativeNodePosition relativeNodePosition);

    void doubleClicked(TreeItem<AliasTreeNode> selectedItem);
}
