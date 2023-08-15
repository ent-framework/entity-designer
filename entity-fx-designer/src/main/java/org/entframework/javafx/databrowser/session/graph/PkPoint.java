/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph;

public class PkPoint {
    private final double _x;
    private final double _y;
    private final double _arrowAngle;

    public PkPoint(double x, double y, double arrowAngle) {
        _x = x;
        _y = y;
        _arrowAngle = arrowAngle;
    }

    public double getArrowAngle() {
        return _arrowAngle;
    }

    public double getX() {
        return _x;
    }

    public double getY() {
        return _y;
    }
}
