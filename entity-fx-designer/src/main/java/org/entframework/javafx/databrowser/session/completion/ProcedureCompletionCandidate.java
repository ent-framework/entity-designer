/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.completion;

import org.entframework.javafx.databrowser.session.ProcedureInfo;
import org.entframework.javafx.databrowser.session.schemainfo.StructItemSchema;

public class ProcedureCompletionCandidate extends CompletionCandidate {
    private final ProcedureInfo _procedureInfo;
    private final StructItemSchema _schema;

    public ProcedureCompletionCandidate(ProcedureInfo procedureInfo, StructItemSchema schema) {
        _procedureInfo = procedureInfo;
        _schema = schema;
    }

    @Override
    public String getReplacement() {
        return _procedureInfo.getName();
    }

    @Override
    public String getObjectTypeName() {
        return "PROCEDURE";
    }
}
