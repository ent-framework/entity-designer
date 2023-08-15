/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.designer.control;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import org.entframework.javafx.common.spring.AbstractFxmlView;
import org.kordamp.ikonli.antdesignicons.AntDesignIconsFilled;
import org.kordamp.ikonli.javafx.FontIcon;

public class TabWithSpringView extends Tab {
    private AbstractFxmlView view;

    private SimpleBooleanProperty mModifiedProperty = new SimpleBooleanProperty();

    public TabWithSpringView(AbstractFxmlView view) {
        this.view = view;
        setContent(view.getView());
        mModifiedProperty.addListener((observable, oldValue, newValue) -> {
            if (newValue != null && newValue) {
                setGraphic(FontIcon.of(AntDesignIconsFilled.STAR, 4, Color.RED));
            } else {
                setGraphic(null);
            }
        });
    }

    public Object getController() {
        return this.view.getPresenter();
    }

    public void resize(double width, double height) {
        VBox borderPane = (VBox) getContent();
        borderPane.setPrefWidth(width);
        borderPane.setPrefHeight(height);
        borderPane.autosize();
    }

    public void setModified(boolean modified) {
        mModifiedProperty.set(modified);
    }

}
