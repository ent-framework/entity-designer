/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.common.utils;

import org.entframework.javafx.designer.entitydesigner.model.EEntityObject;
import org.entframework.javafx.designer.entitydesigner.model.EFieldObject;
import org.entframework.javafx.designer.entitydesigner.model.EModelObject;
import org.kordamp.ikonli.antdesignicons.AntDesignIconsOutlined;
import org.kordamp.ikonli.javafx.FontIcon;

public class IconUtils {
    public static FontIcon getIcon(EModelObject object) {
        if (object instanceof EEntityObject) {
            return FontIcon.of(AntDesignIconsOutlined.BLOCK, 16);
        } else if (object instanceof EFieldObject) {
            return FontIcon.of(AntDesignIconsOutlined.BLOCK, 16);
        }
        return null;
    }
}
