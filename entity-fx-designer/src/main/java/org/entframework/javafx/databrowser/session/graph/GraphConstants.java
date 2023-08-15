/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph;

import javafx.scene.image.Image;
import org.entframework.javafx.databrowser.Props;

public class GraphConstants {
    public static final Image ARROW_RIGHT_IMAGE_BLUE = new Props(GraphConstants.class).getImage("arrow_right_blue.png");
    public static final Image ARROW_RIGHT_IMAGE = new Props(GraphConstants.class).getImage("arrow_right.png");

    public static final double IMAGE_HEIGHT = ARROW_RIGHT_IMAGE.getHeight();
    public static final double IMAGE_WIDTH = ARROW_RIGHT_IMAGE.getWidth();

    public static final double X_GATHER_DIST = 20;

    public static final int TITLEBAR_HEIGHT = 27;

}
