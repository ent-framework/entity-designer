/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.services;

import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

/**
 * 左侧DockToolbar构建
 */
public class DockToolbarBuilder {

    private final BorderPane _borderPane;
    private final ToolBar _toolbarLeft;
    private final ToolBar _toolbarRight;

    public DockToolbarBuilder() {
        _borderPane = new BorderPane();

        _toolbarLeft = new ToolBar();
        _toolbarRight = new ToolBar();

        _borderPane.setCenter(_toolbarLeft);
        _borderPane.setRight(_toolbarRight);
    }

    public Button addButtonLeft(Node icon, String tooltip) {
        return addButton(icon, tooltip, _toolbarLeft);
    }

    public Button addButtonRight(Node imageView, String tooltip) {
        return addButton(imageView, tooltip, _toolbarRight);
    }

    public ToggleButton addToggleButtonLeft(Node imageView, String tooltip) {
        return addToggleButton(imageView, tooltip, _toolbarLeft);
    }

    public ToggleButton addToggleButtonRight(Node imageView, String tooltip) {
        return addToggleButton(imageView, tooltip, _toolbarRight);
    }


    private Button addButton(Node icon, String tooltip, ToolBar toolBar) {
        Button btn = new Button();
        btn.setGraphic(icon);
        btn.setTooltip(new Tooltip(tooltip));
        toolBar.getItems().add(btn);
        return btn;
    }


    private ToggleButton addToggleButton(Node imageView, String tooltip, ToolBar toolBar) {
        ToggleButton btn = new ToggleButton();
        btn.setGraphic(imageView);
        btn.setTooltip(new Tooltip(tooltip));
        toolBar.getItems().add(btn);

        return btn;
    }

    public BorderPane getToolbarPane() {
        return _borderPane;
    }

    public void addSeparatorLeft() {
        _toolbarLeft.getItems().add(new Separator());
    }
}
