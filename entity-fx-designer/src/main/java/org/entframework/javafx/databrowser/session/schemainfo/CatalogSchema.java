/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.schemainfo;

public interface CatalogSchema {
    String getCatalog();

    String getSchema();

    default boolean matchesRespectNull(String catalog, String schema) {
        return (null == catalog || catalog.equalsIgnoreCase(getCatalog()))
                && (null == schema || schema.equalsIgnoreCase(getSchema()));

    }
}
