/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.designer.form;

import org.entframework.javafx.designer.entitydesigner.model.EEntityObject;
import org.entframework.javafx.designer.entitydesigner.model.EModelObject;
import org.entframework.javafx.designer.entitydesigner.model.EModuleObject;

public final class ModelFormFactory {

    public static ModelForm<?> getForm(EModelObject object) {
        if (object instanceof EEntityObject entityObject) {
            return new EntityForm(entityObject);
        }
        if (object instanceof EModuleObject modelObject) {
            return new ModuleForm(modelObject);
        }

        return null;
    }
}
