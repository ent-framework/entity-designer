/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.designer;


import org.entframework.javafx.common.spring.AbstractFxmlView;
import org.entframework.javafx.common.spring.FXMLView;

@FXMLView(
        value = "/org/entframework/javafx/designer/LanguageBindingView.fxml",
        bundle = "org.entframework.javafx.designer.i18n",
        css = {"/org/entframework/javafx/designer/LanguageBindingView.css"}
)
public class LanguageBindingView extends AbstractFxmlView {
}
