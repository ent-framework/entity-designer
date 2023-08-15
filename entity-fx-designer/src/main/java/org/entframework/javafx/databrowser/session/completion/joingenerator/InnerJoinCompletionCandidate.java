/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.completion.joingenerator;

public class InnerJoinCompletionCandidate extends JoinCompletionCandidateBase {
    public InnerJoinCompletionCandidate(String replacement) {
        super(replacement);
    }

    protected String getNonGeneratedTypeName() {
        return "inner join statement generation";
    }

    protected String getNonGeneratedPopupDisplay() {
        return "#i,table1,table2,...,tableN,";
    }
}
