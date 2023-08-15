/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.aliases.channel;

import javafx.scene.control.TreeItem;
import org.entframework.javafx.databrowser.aliases.AliasTreeNode;

public interface AliasTreeNodeChangedListener {
    void treeNodeChanged(TreeItem<AliasTreeNode> ti);
}
