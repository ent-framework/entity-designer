/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.completion.joingenerator;

public class LeftJoinCompletionCandidate extends JoinCompletionCandidateBase {
    public LeftJoinCompletionCandidate(String replacement) {
        super(replacement);
    }

    protected String getNonGeneratedTypeName() {
        return "left join statement generation";
    }

    protected String getNonGeneratedPopupDisplay() {
        return "#l,table1,table2,...,tableN,";
    }
}
