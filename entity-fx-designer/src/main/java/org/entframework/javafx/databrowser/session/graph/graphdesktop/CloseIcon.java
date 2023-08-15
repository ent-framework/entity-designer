/*
 * Copyright (c) 2011-2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph.graphdesktop;

import javafx.event.ActionEvent;

/**
 * @author Michael Hoffer &lt;info@michaelhoffer.de&gt;
 */
public class CloseIcon extends WindowIcon {

    public static final String DEFAULT_STYLE_CLASS = "window-close-icon";

    public CloseIcon(final Window w) {

        getStyleClass().setAll(DEFAULT_STYLE_CLASS);

        setOnAction((ActionEvent t) -> {
            w.close();
        });
    }
}
