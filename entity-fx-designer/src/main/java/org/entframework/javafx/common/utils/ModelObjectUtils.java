/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.common.utils;

import javafx.scene.control.TreeItem;
import org.eclipse.emf.ecore.EObject;
import org.entframework.javafx.designer.entitydesigner.model.*;

import java.util.ArrayList;
import java.util.List;

public class ModelObjectUtils {

    public static List<TreeItem<EModelObject>> generateTree(EPersistenceObject persistence) {
        List<TreeItem<EModelObject>> treeItems = new ArrayList<>();
        for (EModuleObject module : persistence.getModules()) {
            TreeItem<EModelObject> moduleItem = new TreeItem<>(module);
            for (EEntityObject entity : module.getEntities()) {
                TreeItem<EModelObject> entityItem = new TreeItem<>(entity);

                if (entity.getPrimaryKey()!=null) {
                    TreeItem<EModelObject> primaryKey = new TreeItem<>(entity.getPrimaryKey());
                    entityItem.getChildren().add(primaryKey);
                }

                for (EFieldObject field : entity.getFields()) {
                    TreeItem<EModelObject> fieldItem = new TreeItem<>(field);
                    entityItem.getChildren().add(fieldItem);
                }
                moduleItem.getChildren().add(entityItem);
            }
            treeItems.add(moduleItem);
        }
        return treeItems;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getTargetType(Class<T> cls, EModelObject modelObject) {
        if (modelObject == null) return null;
        if (cls.isAssignableFrom(modelObject.getClass())) {
            return (T) modelObject;
        } else {
            EObject eContainer = modelObject.eContainer();
            if (eContainer == null) return null;
            do {
                if (cls.isAssignableFrom(eContainer.getClass())) {
                    return (T) eContainer;
                } else {
                    eContainer = eContainer.eContainer();
                }
            } while (eContainer != null);
        }
        return null;
    }
}
