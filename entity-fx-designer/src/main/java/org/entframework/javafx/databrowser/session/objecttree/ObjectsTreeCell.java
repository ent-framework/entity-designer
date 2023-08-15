/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.objecttree;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseEvent;
import org.entframework.javafx.databrowser.services.CollectionUtil;
import org.entframework.javafx.databrowser.services.I18n;
import org.entframework.javafx.databrowser.services.SQLUtil;
import org.entframework.javafx.databrowser.services.Utils;

public class ObjectsTreeCell extends TreeCell<ObjectTreeNode> {
    private static I18n _i18n = new I18n(ObjectsTreeCell.class);
    private ObjectsTreeCellDoubleClickListener _listener;

    public ObjectsTreeCell() {
        this(null);
    }

    public ObjectsTreeCell(ObjectsTreeCellDoubleClickListener listener) {
        if (null == listener) {
            return;
        }


        _listener = listener;
        addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                onDoubleClick(event);
            }
        });
    }

    private void onDoubleClick(MouseEvent event) {
        if (Utils.isDoubleClick(event)) {
            ObjectTreeNode item = getItem();

            if (null != item) {
                _listener.nodeDoubleClicked(item);
            }
        }
    }


    @Override
    protected void updateItem(ObjectTreeNode objectTreeNode, boolean empty) {
        super.updateItem(objectTreeNode, empty);

        if (empty) {
            setText(null);
            setGraphic(null);
            return;
        }

        setText(objectTreeNode.getNodeName());
        setGraphic(objectTreeNode.getImageView());

        ContextMenu contextMenu = new ContextMenu();

        addContextMenu(contextMenu, "contextmenu.copy.object.name", e -> onCopy(false));
        addContextMenu(contextMenu, "contextmenu.copy.qualified.object.name", e -> onCopy(true));

        setContextMenu(contextMenu);

    }

    private void onCopy(boolean qualified) {
        ObservableList<TreeItem<ObjectTreeNode>> selectedItems = getTreeView().getSelectionModel().getSelectedItems();

        String commaSepNames = CollectionUtil.getCommaSeparatedNames(selectedItems, ti -> getObjectTreeNodeName(ti.getValue(), qualified));

        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent content = new ClipboardContent();
        content.putString(commaSepNames);
        clipboard.setContent(content);
    }

    private String getObjectTreeNodeName(ObjectTreeNode node, boolean qualified) {
        String name;
        if (qualified) {
            name = SQLUtil.getQualifiedName(node.getCatalog(), node.getSchema(), node.getNodeName());
        } else {
            name = node.getNodeName();
        }
        return name;
    }

    private void addContextMenu(ContextMenu contextMenu, String i18nKey, EventHandler<ActionEvent> eventHandler) {
        MenuItem menuItem = new MenuItem(_i18n.t(i18nKey));
        menuItem.setOnAction(eventHandler);
        contextMenu.getItems().add(menuItem);
    }
}
