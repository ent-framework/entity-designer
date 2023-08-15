/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.designer.control;

import javafx.scene.control.ListCell;
import org.entframework.javafx.designer.entitydesigner.model.ELanguageBinding;

public class LanguageBindingCell extends ListCell<ELanguageBinding> {
    @Override
    protected void updateItem(ELanguageBinding item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            setText(item.getLanguageSpecification().getShortName());
        }
    }
}
