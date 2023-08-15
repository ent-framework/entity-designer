/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.designer.control;

import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import org.entframework.javafx.common.utils.IconUtils;
import org.entframework.javafx.common.utils.IdGenerator;
import org.entframework.javafx.common.utils.ResourceUtils;
import org.entframework.javafx.designer.command.EventCommands;
import org.entframework.javafx.designer.entitydesigner.model.*;
import org.kordamp.ikonli.javafx.FontIcon;

public class EModelObjectTreeCell extends TreeCell<EModelObject> {
    private TextField textField;

    @Override
    protected void updateItem(EModelObject item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            FontIcon icon = IconUtils.getIcon(item);
            if (item instanceof EPersistenceObject) {
                setText(ResourceUtils.getResourceName(item));
            } else {
                setText(item.getName());
            }

            setGraphic(icon);
            setContextMenu(createContextMenu(item));
        }
    }

    @Override
    public void startEdit() {
        if (getItem() instanceof EPersistenceObject) {
            return;
        }
        super.startEdit();

        if (textField == null) {
            createTextField();
        }
        setText(null);
        setGraphic(textField);
        textField.selectAll();
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();
        setText(getItem().getName());
        setGraphic(getTreeItem().getGraphic());
    }

    private void createTextField() {
        textField = new TextField(getText());
        EModelObject modelObject = getItem();
        textField.setOnKeyReleased(t -> {
            if (t.getCode() == KeyCode.ENTER) {
                modelObject.setName(textField.getText());
                commitEdit(modelObject);
            } else if (t.getCode() == KeyCode.ESCAPE) {
                cancelEdit();
            }
        });
    }

    @Override
    protected void layoutChildren() {
        super.layoutChildren();
    }

    private ContextMenu createContextMenu(EModelObject item) {
        ContextMenu contextMenu = new ContextMenu();
        if (item instanceof EEntityObject entity) {
            MenuItem menuItem = new MenuItem("Add Field");
            menuItem.setOnAction(event -> {
                EFieldObject field = EntityFactory.eINSTANCE.createEFieldObject();
                field.setId(IdGenerator.generateId());
                field.setName("change later");
                EventCommands.addField(ResourceUtils.findModel(item), entity, field);
                //添加到当前节点
                TreeItem<EModelObject> treeItem = new TreeItem<>(field);
                getTreeItem().getChildren().add(treeItem);
            });
            contextMenu.getItems().add(menuItem);
        }
        return contextMenu;
    }
}
