/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.completion;


import java.util.HashMap;

public class DuplicateSimpleNamesCheck {
    private HashMap<String, TableCompletionCandidate> _checkHash = new HashMap<>();

    public void check(TableCompletionCandidate tableCompletionCandidate) {
        String simpleName = tableCompletionCandidate.getSimpleName();
        TableCompletionCandidate match = _checkHash.get(simpleName);

        if (null != match) {
            match.setShowQualifiedHint(true);
            tableCompletionCandidate.setShowQualifiedHint(true);
        }

        _checkHash.put(simpleName, tableCompletionCandidate);

    }
}
