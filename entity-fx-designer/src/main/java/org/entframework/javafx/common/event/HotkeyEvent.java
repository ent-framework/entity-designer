/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

/* SPDX-License-Identifier: MIT */
package org.entframework.javafx.common.event;

import javafx.scene.input.KeyCodeCombination;

public class HotkeyEvent extends Event {

    private final KeyCodeCombination keys;

    public HotkeyEvent(KeyCodeCombination keys) {
        this.keys = keys;
    }

    public KeyCodeCombination getKeys() {
        return keys;
    }

    @Override
    public String toString() {
        return "HotkeyEvent{" +
                "keys=" + keys +
                "} " + super.toString();
    }
}
