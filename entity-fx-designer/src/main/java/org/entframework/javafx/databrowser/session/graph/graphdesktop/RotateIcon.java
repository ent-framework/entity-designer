/*
 * Copyright (c) 2011-2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph.graphdesktop;

import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 * @author Michael Hoffer &lt;info@michaelhoffer.de&gt;
 */
public class RotateIcon extends WindowIcon {

    public static final String DEFAULT_STYLE_CLASS = "window-rotate-icon";

    public RotateIcon(final Window w) {

        getStyleClass().setAll(DEFAULT_STYLE_CLASS);

        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {

                RotateTransition rotationY = new RotateTransition();
                rotationY.setAxis(Rotate.Z_AXIS);
                rotationY.setDuration(Duration.seconds(1));
                rotationY.setByAngle(-360);
                rotationY.setNode(w);
                rotationY.setCycleCount(1);
                rotationY.play();
            }
        });
    }
}
