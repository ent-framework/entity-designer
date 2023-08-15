/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.services.sqlwrap;

import org.entframework.javafx.databrowser.services.MessageHandler;
import org.entframework.javafx.databrowser.services.MessageHandlerDestination;

import java.io.File;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;


public class SQLDriverClassLoader extends SQLURLClassLoader {
    public SQLDriverClassLoader(List<URL> urls) {
        super(urls);
    }

    private static List<URL> createURLs(String driverName, List<String> fileNames)
            throws MalformedURLException {
        MessageHandler mh = new MessageHandler(SQLDriverClassLoader.class, MessageHandlerDestination.MESSAGE_PANEL);

        List<URL> urls = new ArrayList<>();


        for (String fileName : fileNames) {
            File f = new File(fileName);
            if (!f.exists()) {
                mh.warning(
                        "For driver '" + driverName + "', the JVM says file doesn't exist: " +
                                fileName);
            }
            if (f.isDirectory()) {
                mh.warning(
                        "For driver '" + driverName + "', the JVM says the file is a directory: " +
                                fileName);
            }
            if (!f.canRead()) {
                mh.warning(
                        "For driver '" + driverName + "', the JVM says the file can't be read: " +
                                fileName);
            }

            urls.add(f.toURI().toURL());

        }

        return urls;
    }

    public List<Class> getDriverClasses() {
        List<Class> classes = getAssignableClasses(Driver.class);
        List<Class> list = new ArrayList<>();

        for (Class clazz : classes) {
            if (!Modifier.isAbstract(clazz.getModifiers())) {
                list.add(clazz);
            }
        }
        return list;
    }
}
