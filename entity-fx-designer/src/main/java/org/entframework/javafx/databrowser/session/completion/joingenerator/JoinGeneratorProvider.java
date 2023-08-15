/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.completion.joingenerator;

import org.entframework.javafx.databrowser.services.CollectionUtil;
import org.entframework.javafx.databrowser.session.Session;
import org.entframework.javafx.databrowser.session.completion.CaretVicinity;
import org.entframework.javafx.databrowser.session.completion.CompletionCandidate;

import java.util.ArrayList;
import java.util.List;

public class JoinGeneratorProvider {
    public static final char GENERATOR_START = '#';

    public static List<CompletionCandidate> getCandidates(Session session, CaretVicinity caretVicinity) {
        ArrayList<CompletionCandidate> ret = new ArrayList<>();

        List<CompletionCandidate> completionCandidates;

        completionCandidates = new InnerJoinGenerator(caretVicinity, session).getCompletionCandidates();
        if (CollectionUtil.contains(completionCandidates, c -> c.isGeneratedJoin())) {
            return completionCandidates;
        }
        ret.addAll(completionCandidates);

        completionCandidates = new LeftJoinGenerator(caretVicinity, session).getCompletionCandidates();
        if (CollectionUtil.contains(completionCandidates, c -> c.isGeneratedJoin())) {
            return completionCandidates;
        }
        ret.addAll(completionCandidates);


        completionCandidates = new SmartJoinGenerator(caretVicinity, session).getCompletionCandidates();
        if (CollectionUtil.contains(completionCandidates, c -> c.isGeneratedJoin())) {
            return completionCandidates;
        }
        ret.addAll(completionCandidates);


        return ret;
    }
}
