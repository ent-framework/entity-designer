/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.designer.domain;


import org.entframework.javafx.common.utils.TextUtil;

public class Name {
    private final String identifier;

    private Name(String identifier) {
        this.identifier = identifier;
    }

    public static Name of(String identifier) {
        return new Name(identifier);
    }

    public String toString() {
        return identifier;
    }

    public String getText() {
        return identifier;
    }

    public String getPropertyName() {
        return TextUtil.getValidPropertyName(this.identifier);
    }

    public String getHyphen() {
        return TextUtil.nameToHyphen(this.identifier);
    }
}
