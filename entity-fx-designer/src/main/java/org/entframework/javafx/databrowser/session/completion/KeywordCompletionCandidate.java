/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.completion;

public class KeywordCompletionCandidate extends CompletionCandidate {
    private String _keyword;

    public KeywordCompletionCandidate(String keyword) {
        _keyword = keyword;
    }

    @Override
    public String getReplacement() {
        return _keyword;
    }

    @Override
    public String getObjectTypeName() {
        return "KEYWORD";
    }
}
