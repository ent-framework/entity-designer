/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.completion.joingenerator;

import org.entframework.javafx.databrowser.session.Session;
import org.entframework.javafx.databrowser.session.TableInfo;
import org.entframework.javafx.databrowser.session.completion.CaretVicinity;

public class LeftJoinGenerator extends JoinGeneratorBase {
    public LeftJoinGenerator(CaretVicinity caretVicinity, Session session) {
        super(caretVicinity, session);
    }

    protected String createJoinClause(TableInfo table, String fkColumnName) {
        return "LEFT JOIN";
    }

    protected String getGeneratorName() {
        return JoinGeneratorProvider.GENERATOR_START + "l";
    }

    @Override
    protected JoinCompletionCandidateBase createCompletionCandidate(String replacement) {
        return new LeftJoinCompletionCandidate(replacement);
    }


}
