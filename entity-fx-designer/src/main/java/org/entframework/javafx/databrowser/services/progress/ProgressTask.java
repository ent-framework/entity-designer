/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.services.progress;

public interface ProgressTask<T> {
    T call();

    void goOn(T t);
}
