/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser;

public interface ApplicationCloseListener {
    public void applicationClosing();


    public enum FireTime {
        WITHIN_SESSION_FIRE_TIME,
        AFTER_SESSION_FIRE_TIME
    }
}
