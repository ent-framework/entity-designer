/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.aliases.channel;

import javafx.scene.control.TreeItem;
import org.entframework.javafx.databrowser.aliases.AliasTreeNode;
import org.entframework.javafx.databrowser.services.dndpositionmarker.RelativeNodePosition;

import java.util.ArrayList;
import java.util.List;

public class AliasTreeNodeChannel {
    private AliasTreeNodeMoveListener _aliasTreeNodeMoveListener;
    private List<AliasTreeNodeChangedListener> _listeners = new ArrayList<>();

    public AliasTreeNodeChannel(AliasTreeNodeMoveListener aliasTreeNodeMoveListener) {
        _aliasTreeNodeMoveListener = aliasTreeNodeMoveListener;
    }

    public void addListener(AliasTreeNodeChangedListener l) {
        _listeners.add(l);
    }

    public void fireChanged(TreeItem<AliasTreeNode> changedItem) {
        if (null == changedItem) {
            return;
        }


        AliasTreeNodeChangedListener[] clone = _listeners.toArray(new AliasTreeNodeChangedListener[_listeners.size()]);

        for (AliasTreeNodeChangedListener listener : clone) {
            listener.treeNodeChanged(changedItem);
        }
    }

    public void moveNodeRequest(TreeItem<AliasTreeNode> itemToMove, TreeItem<AliasTreeNode> itemToMoveTo, RelativeNodePosition relativeNodePosition) {
        _aliasTreeNodeMoveListener.moveNodeRequest(itemToMoveTo, itemToMove, relativeNodePosition);
    }

    public void doubleClicked(TreeItem<AliasTreeNode> selectedItem) {
        _aliasTreeNodeMoveListener.doubleClicked(selectedItem);
    }
}
