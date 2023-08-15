/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.drivers;

public interface ClassLoaderListener {

    public void loadedZipFile(String filename);

    public void finishedLoadingZipFiles();

}
