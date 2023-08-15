/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session;

public interface SessionManagerListener {
    void contextActiveOrActivating(SessionTabContext sessionTabContext);

    void contextClosing(SessionTabContext sessionTabContext);
}
