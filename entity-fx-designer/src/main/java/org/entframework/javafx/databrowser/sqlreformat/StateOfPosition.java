/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.sqlreformat;

public class StateOfPosition {
    boolean isTopLevel;

    int commentIndex = -1;
    int literalSepCount = 0;
    int braketDepth = 0;

    public Object clone() {
        StateOfPosition ret = new StateOfPosition();
        ret.commentIndex = commentIndex;
        ret.literalSepCount = literalSepCount;
        ret.braketDepth = braketDepth;
        ret.isTopLevel = isTopLevel;

        return ret;
    }
}
