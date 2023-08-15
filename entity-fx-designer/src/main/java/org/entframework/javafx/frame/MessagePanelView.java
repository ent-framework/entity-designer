/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.frame;

import org.entframework.javafx.common.spring.AbstractFxmlView;
import org.entframework.javafx.common.spring.FXMLView;

@FXMLView(
        value = "/org/entframework/javafx/frame/MessagePanelView.fxml",
        css = {"/org/entframework/javafx/frame/MainView.css"}
)
public class MessagePanelView extends AbstractFxmlView {
}
