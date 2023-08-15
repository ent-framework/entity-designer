/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.designer.domain;

import org.apache.commons.lang3.StringUtils;

public class JavaPackage {
    private String packagePath;

    private JavaPackage(String packagePath) {
        this.packagePath = packagePath;
    }

    public static JavaPackage of(String packagePath) {
        return new JavaPackage(packagePath);
    }

    public JavaPackage getParent() {
        String parentPath = StringUtils.substringBeforeLast(packagePath, ".");
        return new JavaPackage(parentPath);
    }

    public String toString() {
        return packagePath;
    }


    public String getValue() {
        return packagePath;
    }
}
