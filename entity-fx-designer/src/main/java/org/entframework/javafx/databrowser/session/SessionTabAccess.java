/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session;

import javafx.scene.control.Tab;

public interface SessionTabAccess {
    void addTab(Tab tab, boolean selectTab);
}
