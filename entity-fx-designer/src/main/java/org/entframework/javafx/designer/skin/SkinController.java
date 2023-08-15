/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.designer.skin;

import javafx.geometry.Side;

/**
 * Responsible for skin-specific logic in the graph editor demo.
 */
public interface SkinController {
    int NODE_INITIAL_X = 19;
    int NODE_INITIAL_Y = 19;

    /**
     * activates this skin
     */
    void activate();
}
