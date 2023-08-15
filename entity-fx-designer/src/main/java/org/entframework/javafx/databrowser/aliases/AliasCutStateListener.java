/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.aliases;

import javafx.scene.control.TreeItem;

public interface AliasCutStateListener {
    public void treeItemCutChanged(TreeItem<AliasTreeNode> treeItemBeingCut);
}
