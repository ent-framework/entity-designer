/*
 * Copyright (c) 2011-2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph.graphdesktop;

import javafx.event.ActionEvent;

/**
 * @author Michael Hoffer &lt;info@michaelhoffer.de&gt;
 */
public class MinimizeIcon extends WindowIcon {

    public static final String DEFAULT_STYLE_CLASS = "window-minimize-icon";

    private Window w;

    public MinimizeIcon(final Window w) {

        this.w = w;

        getStyleClass().setAll(DEFAULT_STYLE_CLASS);

        setOnAction((ActionEvent t) -> {
            w.setMinimized(!w.isMinimized());
        });
    }
}
