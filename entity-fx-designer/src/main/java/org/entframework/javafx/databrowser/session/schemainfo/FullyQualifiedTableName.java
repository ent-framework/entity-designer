/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.schemainfo;

import org.entframework.javafx.databrowser.services.CaseInsensitiveString;
import org.entframework.javafx.databrowser.services.SQLUtil;

public class FullyQualifiedTableName {
    private final CaseInsensitiveString _catalog;
    private final CaseInsensitiveString _schema;
    private final CaseInsensitiveString _name;

    public FullyQualifiedTableName(String catalog, String schema, String name) {
        _catalog = (null == catalog ? null : new CaseInsensitiveString(catalog));
        _schema = (null == schema ? null : new CaseInsensitiveString(schema));
        _name = new CaseInsensitiveString(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FullyQualifiedTableName that = (FullyQualifiedTableName) o;

        if (_catalog != null ? !_catalog.equals(that._catalog) : that._catalog != null) return false;
        if (_name != null ? !_name.equals(that._name) : that._name != null) return false;
        if (_schema != null ? !_schema.equals(that._schema) : that._schema != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = _catalog != null ? _catalog.hashCode() : 0;
        result = 31 * result + (_schema != null ? _schema.hashCode() : 0);
        result = 31 * result + (_name != null ? _name.hashCode() : 0);
        return result;
    }

    public CaseInsensitiveString getCatalog() {
        return _catalog;
    }

    public CaseInsensitiveString getSchema() {
        return _schema;
    }

    public CaseInsensitiveString getName() {
        return _name;
    }

    @Override
    public String toString() {
        return SQLUtil.getQualifiedName(_catalog, _schema, _name);
    }
}
