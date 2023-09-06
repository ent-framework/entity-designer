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
            setContextMenu(TreeContextMenuFactory.createContextMenu(item, getTreeItem()));
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
        textField.requestFocus();
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
                setValueByNodeType(modelObject, textField.getText());
            } else if (t.getCode() == KeyCode.ESCAPE) {
                cancelEdit();
            }
        });
    }

    private void setValueByNodeType(EModelObject modelObject, String text) {
        if (modelObject instanceof EEntityObject) {
            EventCommands.attributeUpdate(modelObject, EntityPackage.Literals.EENTITY_OBJECT__NAME, text);
        } else if (modelObject instanceof EModuleObject) {
            EventCommands.attributeUpdate(modelObject, EntityPackage.Literals.EMODULE_OBJECT__NAME, text);
        } else if (modelObject instanceof EFieldObject) {
            EventCommands.attributeUpdate(modelObject, EntityPackage.Literals.EFIELD_OBJECT__NAME, text);
        }
        commitEdit(modelObject);
    }

    @Override
    protected void layoutChildren() {
        super.layoutChildren();
    }
}
