/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx;

import org.entframework.javafx.common.spring.AbstractFxmlView;
import org.entframework.javafx.common.spring.FXMLView;

@FXMLView(
        value = "/org/entframework/javafx/MainView.fxml",
        bundle = "org.entframework.javafx.databrowser.i18n",
        css = {"/org/entframework/javafx/MainView.css"}
)
public class MainView extends AbstractFxmlView {
}
