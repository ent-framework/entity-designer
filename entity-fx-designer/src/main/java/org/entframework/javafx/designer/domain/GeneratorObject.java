/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.designer.domain;

public class GeneratorObject {
    private final JavaPackage _package;

    public GeneratorObject(JavaPackage _package) {
        this._package = _package;
    }

    public JavaPackage getPackage() {
        return _package;
    }
}
