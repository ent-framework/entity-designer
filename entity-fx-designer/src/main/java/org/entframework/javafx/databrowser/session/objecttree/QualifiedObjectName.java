/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.objecttree;

import org.entframework.javafx.databrowser.services.SQLUtil;
import org.entframework.javafx.databrowser.services.Utils;

public class QualifiedObjectName {
    private final String _catalog;
    private final String _schema;
    private final String _objectName;

    public QualifiedObjectName(String objectName) {
        this(null, objectName);
    }

    public QualifiedObjectName(String schema, String objectName) {
        this(null, schema, objectName);
    }

    public QualifiedObjectName(String catalog, String schema, String objectName) {
        _catalog = catalog;
        _schema = schema;
        _objectName = objectName;
    }

    public boolean matches(ObjectTreeNode value) {
        if (false == Utils.isEmptyString(_catalog) && false == _catalog.equalsIgnoreCase(value.getCatalog())) {
            return false;
        }

        if (false == Utils.isEmptyString(_schema) && false == _schema.equalsIgnoreCase(value.getSchema())) {
            return false;
        }

        return _objectName.equalsIgnoreCase(value.getNodeName());
    }

    @Override
    public String toString() {
        return SQLUtil.getQualifiedName(_catalog, _schema, _objectName);
    }
}
