/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.completion;


import org.entframework.javafx.databrowser.services.Utils;

public abstract class CompletionCandidate {
    public abstract String getReplacement();

    public abstract String getObjectTypeName();

    public String getPopupDisplayString() {
        return getReplacement();
    }

    @Override
    public String toString() {
        if (Utils.isEmptyString(getObjectTypeName())) {
            return getPopupDisplayString();
        }

        return getPopupDisplayString() + " [" + getObjectTypeName() + "]";

    }

    public boolean isGeneratedJoin() {
        return false;
    }
}
