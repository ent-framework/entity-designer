/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LogFileWrapper {
    private File _logFile;

    public LogFileWrapper(File logFile) {
        _logFile = logFile;
    }

    public static List<LogFileWrapper> wrap(File[] logFiles) {
        ArrayList<LogFileWrapper> ret = new ArrayList<>();

        for (File logFile : logFiles) {
            ret.add(new LogFileWrapper(logFile));
        }

        return ret;
    }

    @Override
    public String toString() {
        return _logFile.getName();
    }

    public File getLogFile() {
        return _logFile;
    }
}
