/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph;

import org.entframework.javafx.databrowser.globalicons.GlobalIconNames;

public enum JoinConfig {
    INNER_JOIN(GlobalIconNames.EQUAL),
    LEFT_JOIN(GlobalIconNames.EQUAL_LEFT),
    RIGHT_JOIN(GlobalIconNames.EQUAL_RIGHT),
    NO_JOIN(GlobalIconNames.EQUAL_CROSSED);

    private String _imageName;

    JoinConfig(String imageName) {
        _imageName = imageName;
    }

    public String getImageName() {
        return _imageName;
    }
}
