/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.completion.joingenerator;

public class SmartJoinCompletionCandidate extends JoinCompletionCandidateBase {
    public SmartJoinCompletionCandidate(String replacement) {
        super(replacement);
    }

    protected String getNonGeneratedTypeName() {
        return "left/inner join statement generation";
    }

    protected String getNonGeneratedPopupDisplay() {
        return "#j,table1,table2,...,tableN,";
    }
}
