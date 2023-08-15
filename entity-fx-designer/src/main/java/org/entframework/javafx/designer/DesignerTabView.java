/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.designer;

import org.entframework.javafx.common.spring.AbstractFxmlView;
import org.entframework.javafx.common.spring.FXMLView;
import org.springframework.context.annotation.Scope;


@FXMLView(
        value = "/org/entframework/javafx/designer/DesignerTabView.fxml",
        bundle = "org.entframework.javafx.designer.i18n",
        css = {"/org/entframework/javafx/designer/DesignerTabView.css", "/org/entframework/javafx/designer/EntitySkins.css"}
)
@Scope("prototype")
public class DesignerTabView extends AbstractFxmlView {
}
