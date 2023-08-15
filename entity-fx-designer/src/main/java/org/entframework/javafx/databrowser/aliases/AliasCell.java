/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.aliases;

import javafx.scene.control.Label;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import org.entframework.javafx.databrowser.aliases.channel.AliasTreeNodeChannel;
import org.entframework.javafx.databrowser.drivers.SQLDriver;
import org.entframework.javafx.databrowser.services.Utils;
import org.entframework.javafx.databrowser.services.dndpositionmarker.DndDragPositionMarker;

public class AliasCell extends TreeCell<AliasTreeNode> {
    private static final String STYLE_CUT_COPY_LABEL = "alias-cell-cut-copy";
    private static final String STYLE_NORMAL_LABEL = "alias-cell-normal";
    private AliasCutCopyState _aliasCutCopyState;
    private AliasTreeNodeChannel _aliasTreeNodeChannel;

    public AliasCell(AliasTreeNodeChannel aliasTreeNodeChannel, AliasCutCopyState aliasCutCopyState) {
        _aliasTreeNodeChannel = aliasTreeNodeChannel;
        _aliasCutCopyState = aliasCutCopyState;
        _aliasTreeNodeChannel.addListener(this::onTreeNodeChanged);

        setOnDragDetected(this::onDragDetected);

        DndDragPositionMarker<AliasTreeNode> dragPositionMarker = new DndDragPositionMarker<>(this, this::getChildren);

        setOnDragOver(e -> {
            dragPositionMarker.onDragOver(e);
            onDragOver(e);
        });

        setOnDragExited(dragPositionMarker::onDragExit);

        setOnDragDropped(e -> onDragDropped(e, dragPositionMarker));

        setOnMouseClicked(this::onMouseClicked);

    }

    private void onMouseClicked(MouseEvent mouseEvent) {
        if (Utils.isDoubleClick(mouseEvent)) {
            TreeItem<AliasTreeNode> selectedItem = getTreeItem();

            if (null == selectedItem) {
                return;
            }

            _aliasTreeNodeChannel.doubleClicked(selectedItem);
        }
    }

    private void onDragDropped(DragEvent dragEvent, DndDragPositionMarker<AliasTreeNode> dragPositionMarker) {
        String idToMove = dragEvent.getDragboard().getString();
        TreeItem<AliasTreeNode> itemToMove = AliasTreeUtil.search(getTreeView().getRoot(), idToMove);
        TreeItem<AliasTreeNode> itemToMoveTo = getTreeItem();

        _aliasTreeNodeChannel.moveNodeRequest(itemToMove, itemToMoveTo, dragPositionMarker.getMovePosition());

        dragEvent.consume();
    }


    private void onDragOver(DragEvent dragEvent) {
        if (dragEvent.getDragboard().hasString()) {
            String id = dragEvent.getDragboard().getString();
            if (!isEmpty() && !getItem().getId().equals(id)) {
                dragEvent.acceptTransferModes(TransferMode.MOVE);
            }
        }
        dragEvent.consume();
    }


    private void onDragDetected(MouseEvent event) {
        if (isEmpty()) {
            return;
        }
        Dragboard dragBoard = startDragAndDrop(TransferMode.MOVE);
        ClipboardContent content = new ClipboardContent();
        content.put(DataFormat.PLAIN_TEXT, "" + getItem().getId());
        dragBoard.setContent(content);
        event.consume();
    }

    private void onTreeNodeChanged(TreeItem<AliasTreeNode> ti) {
        if (super.getTreeItem() == ti) {
            updateItem(ti.getValue(), false);
        }
    }


    @Override
    protected void updateItem(AliasTreeNode aliasTreeNode, boolean empty) {
        super.updateItem(aliasTreeNode, empty);

        if (empty) {
            setText(null);
            setGraphic(null);
            return;
        }

        setText(aliasTreeNode.getName());
        setGraphic(getTreeItem().getGraphic());
        getStyleClass().add(getCustomStyleClass(aliasTreeNode));
    }

    private String getCustomStyleClass(AliasTreeNode aliasTreeNode) {
        if (null != _aliasCutCopyState.getTreeItemBeingCut() && aliasTreeNode == _aliasCutCopyState.getTreeItemBeingCut().getValue()) {
            return STYLE_CUT_COPY_LABEL;
        } else {
            return STYLE_NORMAL_LABEL;
        }
    }
}
