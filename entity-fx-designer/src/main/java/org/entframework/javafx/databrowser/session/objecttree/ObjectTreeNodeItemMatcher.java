/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.objecttree;

import javafx.scene.control.TreeItem;

public interface ObjectTreeNodeItemMatcher {
    boolean matches(TreeItem<ObjectTreeNode> objectTreeNodeTreeItem);

}
