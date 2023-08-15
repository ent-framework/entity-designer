/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.common.utils;

import io.github.eckig.grapheditor.model.GModel;
import io.github.eckig.grapheditor.model.GNode;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.entframework.javafx.designer.GraphEditorPersistence;
import org.entframework.javafx.designer.entitydesigner.model.EEntityObject;
import org.entframework.javafx.designer.entitydesigner.model.EModuleObject;
import org.entframework.javafx.designer.entitydesigner.model.EPersistenceObject;

import java.util.Collection;
import java.util.List;

public class ResourceUtils {
    public static GModel findModel(EObject item) {
        EList<Resource> resources = item.eResource().getResourceSet().getResources();
        if (resources == null) return null;
        return resources.stream().map(Resource::getContents).flatMap(Collection::stream)
                .filter(eObject -> eObject instanceof GModel)
                .map(eObject -> (GModel) eObject).findFirst().orElse(null);
    }

    public static EPersistenceObject findPersistence(EObject item) {
        EList<Resource> resources = item.eResource().getResourceSet().getResources();
        if (resources == null) return null;
        return resources.stream().map(Resource::getContents).flatMap(Collection::stream)
                .filter(eObject -> eObject instanceof EPersistenceObject)
                .map(eObject -> (EPersistenceObject) eObject).findFirst().orElse(null);
    }

    public static EEntityObject findEntity(EObject item, String id) {
        EPersistenceObject persistence = findPersistence(item);
        if (persistence != null) {
            List<EEntityObject> entities = persistence.getModules().stream().map(EModuleObject::getEntities).flatMap(Collection::stream).toList();
            return entities.stream().filter(entity -> StringUtils.equals(id, entity.getId())).findFirst().orElse(null);
        }
        return null;
    }

    public static GNode findNode(EObject item, String id) {
        GModel model = findModel(item);
        if (model != null) {
            return model.getNodes().stream().filter(entity -> StringUtils.equals(id, entity.getId())).findFirst().orElse(null);
        }
        return null;
    }

    public static String getResourceName(EObject item) {
        EList<Resource> resources = item.eResource().getResourceSet().getResources();
        if (!resources.isEmpty()) {
            URI uri = resources.get(0).getURI();
            if (uri!=null && StringUtils.equals("file", uri.scheme())) {
                return uri.segment(uri.segmentCount()-1);
            }
        }
        return "Untitled" + GraphEditorPersistence.FILE_EXTENSION;
    }
}
