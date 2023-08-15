/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.aliases;

import javafx.scene.control.ToggleGroup;
import org.entframework.javafx.databrowser.services.I18n;
import org.entframework.javafx.databrowser.services.dndpositionmarker.RelativeNodePosition;

public class TreePositionCtrl {
    private final TreePositionView _treePositionView;
    private I18n _i18n = new I18n(this.getClass());


    public TreePositionCtrl(TreePositionView treePositionView, boolean parentNodeSelected, boolean parentAllowsChildren) {
        _treePositionView = treePositionView;

        ToggleGroup toggleGroup = new ToggleGroup();

        toggleGroup.getToggles().addAll
                (
                        _treePositionView.radToRoot,
                        _treePositionView.radToSelectedAsChild,
                        _treePositionView.radToSelectedAsAncestor,
                        _treePositionView.radToSelectedAsSuccessor
                );

        if (parentNodeSelected) {
            if (parentAllowsChildren) {
                _treePositionView.radToSelectedAsChild.setSelected(true);
            } else {
                _treePositionView.radToSelectedAsChild.setDisable(true);
                _treePositionView.radToSelectedAsSuccessor.setSelected(true);
            }
        } else {
            _treePositionView.radToRoot.setSelected(true);

            _treePositionView.radToRoot.setDisable(true);
            _treePositionView.radToSelectedAsChild.setDisable(true);
            _treePositionView.radToSelectedAsAncestor.setDisable(true);
            _treePositionView.radToSelectedAsSuccessor.setDisable(true);
        }
    }

    public RelativeNodePosition getRelativeNodePosition() {
        if (_treePositionView.radToRoot.isSelected()) {
            return RelativeNodePosition.ROOT;
        } else if (_treePositionView.radToSelectedAsChild.isSelected()) {
            return RelativeNodePosition.CHILD;
        } else if (_treePositionView.radToSelectedAsAncestor.isSelected()) {
            return RelativeNodePosition.UPPER_SIBLING;
        } else if (_treePositionView.radToSelectedAsSuccessor.isSelected()) {
            return RelativeNodePosition.LOWER_SIBLING;
        } else {
            throw new IllegalStateException("You may ask yourself: How did I get here");
        }


    }
}
