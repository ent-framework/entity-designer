/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.services;

import javafx.scene.control.SplitPane;
import org.entframework.javafx.databrowser.workaround.SplitDividerWA;

public class SplitPositionSaver {
    public static final double DEFAULT_POS = 0.2d;
    private String _prefKey;
    private Pref _pref;

    public SplitPositionSaver(Class clazz, String prefKey) {
        _pref = new Pref(clazz);
        _prefKey = prefKey;
    }

    public void apply(SplitPane split) {
        _apply(split, DEFAULT_POS);
    }

    private void _apply(SplitPane split, double defaultPos) {
        SplitDividerWA.adjustDivider(split, 0, _pref.getDouble(_prefKey, defaultPos));
    }

    public void save(SplitPane split) {
        _pref.set(_prefKey, split.getDividerPositions()[0]);
    }

    public void applyInvertedDefault(SplitPane split) {
        _apply(split, 1d - DEFAULT_POS);
    }
}
