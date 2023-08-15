/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.sqlreformat;

/**
 * An interface to allow alternate implementations of the CodeReformator to be configured by plugins.
 */
public interface ICodeReformator {
    public static final String CODE_REFORMATOR_LINE_SEPARATOR = "\n";


    /**
     * Reformats the specified String, returning the reformatted version.
     *
     * @param in the string to apply formatting to.
     * @return the formatted result
     */
    String reformat(String in);
}