/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.completion;

public class FunctionCompletionCandidate extends CompletionCandidate {
    private String _function;

    public FunctionCompletionCandidate(String function) {
        _function = function;
    }

    @Override
    public String getReplacement() {
        return _function;
    }

    @Override
    public String getObjectTypeName() {
        return "FUNCTION";
    }
}
