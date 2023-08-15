/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.settings;

import javafx.scene.control.Tab;

public interface SettingsTabCtrl {
    void setSettingsContext(SettingsContext settingsContext);

    Tab getTab();

    void saveSettings();
}
