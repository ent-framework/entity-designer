/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.completion;

import org.entframework.javafx.databrowser.session.UDTInfo;
import org.entframework.javafx.databrowser.session.schemainfo.StructItemSchema;

public class UDTCompletionCandidate extends CompletionCandidate {
    private final UDTInfo _udtInfo;
    private final StructItemSchema _schema;

    public UDTCompletionCandidate(UDTInfo udtInfo, StructItemSchema schema) {
        _udtInfo = udtInfo;
        _schema = schema;
    }

    @Override
    public String getReplacement() {
        return _udtInfo.getName();
    }

    @Override
    public String getObjectTypeName() {
        return "UDT";
    }
}
