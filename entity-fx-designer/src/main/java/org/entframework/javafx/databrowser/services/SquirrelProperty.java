/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.services;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public enum SquirrelProperty {
    USER_DIR("userdir", new File(new File(System.getProperty("user.home")), ".entity-designer-fx/").getAbsolutePath()),
    LOG_TEST_TOOLBAR_BUTTONS("log.test.toolbar.buttons", "false");

    private final String _key;
    private final String _defaultValue;

    SquirrelProperty(String key, String defaultValue) {
        _key = key;
        _defaultValue = defaultValue;
    }

    public static String getDefaultsString() {
        String ret = "";
        for (SquirrelProperty squirrelProperty : values()) {
            if (!StringUtils.isEmpty(ret)) {
                ret += "\n";
            }

            ret += squirrelProperty._key + "=" + squirrelProperty._defaultValue;
        }

        return ret;

    }

    public static void writeStandardPropertiesToFile(File file) {
        try {
            Properties props = new Properties();
            FileWriter fileWriter = new FileWriter(file);

            for (SquirrelProperty squirrelProperty : SquirrelProperty.values()) {
                props.put(squirrelProperty._key, squirrelProperty._defaultValue);
            }

            props.store(fileWriter, "SQuirreL SQL FX properties");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getKey() {
        return _key;
    }

    public String getDefaultValue() {
        return _defaultValue;
    }

}
