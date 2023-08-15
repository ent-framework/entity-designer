/*
 * Copyright (c) 2011-2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph.graphdesktop;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Control;

/**
 * A window icon that is the visual representation of an action that can be
 * performed on the window. Usually, icons are shown in the titlebar of a window
 * and react on clicking gestures.
 *
 * @author Michael Hoffer &lt;info@michaelhoffer.de&gt;
 */
public class WindowIcon extends Control {

    public static final String DEFAULT_STYLE_CLASS = "window-icon";
    private final ObjectProperty<EventHandler<ActionEvent>> onActionProperty =
            new SimpleObjectProperty<>();

    /**
     * Constructor.
     */
    public WindowIcon() {
        getStyleClass().setAll(DEFAULT_STYLE_CLASS);
    }

    /**
     * The property that defines the action that shall be performed by/ is
     * represented by this icon.
     *
     * @return the property that defines the action that shall be performed by/
     * is represented by this icon
     */
    public ObjectProperty<EventHandler<ActionEvent>> onActionProperty() {
        return onActionProperty;
    }

    /**
     * Returns the action handler that defines the action that shall be
     * performed by/ is represented by this icon.
     *
     * @return the action handler that defines the action that shall be
     * performed by/ is represented by this icon
     */
    public EventHandler<ActionEvent> getOnAction() {
        return onActionProperty.get();
    }

    /**
     * Defines the action handler that defines the action that shall be
     * performed by/ is represented by this icon.
     *
     * @param handler action handler that defines the action that shall be
     *                performed by/ is represented by this icon
     */
    public void setOnAction(EventHandler<ActionEvent> handler) {
        onActionProperty.set(handler);
    }
}
