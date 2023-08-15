/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.schemainfo;

import org.entframework.javafx.databrowser.services.I18n;
import org.entframework.javafx.databrowser.services.SQLUtil;
import org.entframework.javafx.databrowser.session.completion.TableTypes;

public class StructItemTableType extends StructItem implements CatalogSchema {
    // static in order to not violate Serializable
    private static I18n _i18n = new I18n(StructItemTableType.class);


    private final String _type;
    private final String _catalog;
    private final String _schema;

    public StructItemTableType(String type, String catalog, String schema) {
        _type = type;
        _catalog = catalog;
        _schema = schema;
    }

    @Override
    public boolean shouldLoad(SchemaCacheConfig schemaCacheConfig) {
        return schemaCacheConfig.shouldLoadTables(this);
    }

    public boolean shouldCache(SchemaCacheConfig schemaCacheConfig) {
        return schemaCacheConfig.shouldCacheTables(this);
    }


    public String getType() {
        return _type;
    }

    public String getCatalog() {
        return _catalog;
    }

    public String getSchema() {
        return _schema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StructItemTableType that = (StructItemTableType) o;

        if (_catalog != null ? !_catalog.equals(that._catalog) : that._catalog != null) return false;
        if (_schema != null ? !_schema.equals(that._schema) : that._schema != null) return false;
        if (_type != null ? !_type.equals(that._type) : that._type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = _type != null ? _type.hashCode() : 0;
        result = 31 * result + (_catalog != null ? _catalog.hashCode() : 0);
        result = 31 * result + (_schema != null ? _schema.hashCode() : 0);
        return result;
    }

    public boolean matchesRespectNull(String catalog, String schema, TableTypes[] allowedTypes) {

        boolean allowed = false;
        for (TableTypes allowedType : allowedTypes) {
            if (allowedType.toString().equalsIgnoreCase(_type)) {
                allowed = true;
                break;
            }

        }

        if (false == allowed) {
            return false;
        }


        return matchesRespectNull(catalog, schema);
    }

    public String getItemName() {
        return _i18n.t("struct.item.name.table", SQLUtil.getQualifiedName(_catalog, _schema), _type);
    }
}
