/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.designer.control;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import org.entframework.javafx.common.utils.IdGenerator;
import org.entframework.javafx.common.utils.ResourceUtils;
import org.entframework.javafx.designer.command.EventCommands;
import org.entframework.javafx.designer.entitydesigner.model.*;

public final class TreeContextMenuFactory {
    public static ContextMenu createContextMenu(EModelObject item, TreeItem<EModelObject> parent) {
        ContextMenu contextMenu = new ContextMenu();
        if (item instanceof EEntityObject entity) {

            if (entity.getPrimaryKey() == null) {
                MenuItem addPrimaryKey = new MenuItem("Add Primary Key");
                addPrimaryKey.setOnAction(event -> {
                    EFieldObject field = EntityFactory.eINSTANCE.createEFieldObject();
                    field.setId(IdGenerator.generateId());
                    field.setName("ID");
                    EventCommands.attributeUpdate(entity, EntityPackage.Literals.EENTITY_OBJECT__PRIMARY_KEY, field);
                    //添加到当前节点
                    TreeItem<EModelObject> treeItem = new TreeItem<>(field);
                    parent.getChildren().add(treeItem);
                });
                contextMenu.getItems().add(addPrimaryKey);
            }

            MenuItem menuItem = new MenuItem("Add Field");
            menuItem.setOnAction(event -> {
                EFieldObject field = EntityFactory.eINSTANCE.createEFieldObject();
                field.setId(IdGenerator.generateId());
                field.setName("change later");
                EventCommands.addField(ResourceUtils.findModel(item), entity, field);
                //添加到当前节点
                TreeItem<EModelObject> treeItem = new TreeItem<>(field);
                parent.getChildren().add(treeItem);
            });
            contextMenu.getItems().add(menuItem);



        }
        return contextMenu;
    }
}
