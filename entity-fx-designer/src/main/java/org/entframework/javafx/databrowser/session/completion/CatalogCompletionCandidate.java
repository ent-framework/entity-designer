/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.completion;

import org.entframework.javafx.databrowser.session.schemainfo.StructItemCatalog;

public class CatalogCompletionCandidate extends CompletionCandidate {
    private StructItemCatalog _catalog;

    public CatalogCompletionCandidate(StructItemCatalog catalog) {
        _catalog = catalog;
    }

    @Override
    public String getReplacement() {
        return _catalog.getCatalog();
    }

    @Override
    public String getObjectTypeName() {
        return "CATALOG";
    }
}
