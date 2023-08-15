/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.services;

import org.entframework.javafx.databrowser.services.progress.ProgressTask;

public interface CancelableProgressTask<T> extends ProgressTask<T> {
    void cancel();
}
