/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.splash;

import org.entframework.javafx.databrowser.services.I18n;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Version {

    private static final String COPYRIGHT = new I18n(Version.class).t("Version.copyright");
    private static final String APP_NAME = new I18n(Version.class).t("Version.appname");
    private static String shortVersion = null;

    public static String getCopyrightStatement() {
        return COPYRIGHT;
    }

    public static String getVersion() {
        StringBuffer buf = new StringBuffer();
        buf.append(APP_NAME);
        buf.append(" ");
        if (!isSnapshotVersion()) {
            buf.append("Version ");
        }
        buf.append(getShortVersion());
        return buf.toString();
    }

    public static boolean isSnapshotVersion() {
        return getShortVersion().toLowerCase().startsWith("snapshot");
    }

    synchronized public static String getShortVersion() {
        if (shortVersion == null) {
            InputStream is = Version.class.getResourceAsStream("Version.properties");
            Properties props = new Properties();
            try {
                props.load(is);
                shortVersion = props.getProperty("squirrelsql.version");
            } catch (IOException e) {
                shortVersion = "Unknown Version";
            } finally {
                try {
                    is.close();
                } catch (IOException e) {

                }
            }
        }
        return shortVersion;
    }


}
