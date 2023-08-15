/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.completion;

import org.entframework.javafx.databrowser.session.schemainfo.StructItemSchema;

/**
 * Created by gerd on 16.02.14.
 */
public class SchemaCompletionCandidate extends CompletionCandidate {
    private StructItemSchema _schema;

    public SchemaCompletionCandidate(StructItemSchema schema) {
        _schema = schema;
    }

    @Override
    public String getReplacement() {
        String ret = "";

        if (null != _schema.getCatalog()) {
            ret += _schema.getCatalog();
        }

        return ret + _schema.getSchema();
    }

    @Override
    public String getObjectTypeName() {
        return "SCHEMA";
    }


}
