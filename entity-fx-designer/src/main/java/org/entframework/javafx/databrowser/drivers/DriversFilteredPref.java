/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.drivers;

import org.entframework.javafx.databrowser.services.Pref;

public class DriversFilteredPref {
    public static final String PREF_DRIVERS_FILTERED = "drivers.filtered";

    public static boolean isFiltered() {
        return new Pref(DriversManager.class).getBoolean(PREF_DRIVERS_FILTERED, false);
    }

    public static void setFiltered(boolean filtered) {
        new Pref(DriversManager.class).set(PREF_DRIVERS_FILTERED, filtered);
    }
}
