/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.services;

public class SettingsManager {
    private Settings _settings;

    public void writeSettings() {
        Dao.writeSettings(_settings);
    }

    private void checkInit() {
        if (null == _settings) {
            _settings = Dao.loadSettings();
        }
    }

    public Settings getSettings() {
        checkInit();
        return _settings;
    }
}
