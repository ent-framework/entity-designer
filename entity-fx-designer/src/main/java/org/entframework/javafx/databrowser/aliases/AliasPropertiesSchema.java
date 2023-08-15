/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.aliases;

import org.entframework.javafx.databrowser.services.SQLUtil;
import org.entframework.javafx.databrowser.session.schemainfo.StructItemCatalog;
import org.entframework.javafx.databrowser.session.schemainfo.StructItemProcedureType;
import org.entframework.javafx.databrowser.session.schemainfo.StructItemSchema;
import org.entframework.javafx.databrowser.session.schemainfo.StructItemTableType;

import java.io.Serializable;

public class AliasPropertiesSchema implements Serializable {
    private String _qualifiedSchemaName;
    private String _catalogName;

    public AliasPropertiesSchema(StructItemSchema schema) {
        _qualifiedSchemaName = schema.getQualifiedName();
    }

    public AliasPropertiesSchema(StructItemCatalog catalog) {
        _catalogName = catalog.getCatalog();
    }

    public AliasPropertiesSchema() // For deserialization only
    {
    }


    public boolean matches(StructItemTableType structItemTableType) {
        if (null != _qualifiedSchemaName) {
            String qualifiedSchema = SQLUtil.getQualifiedName(structItemTableType.getCatalog(), structItemTableType.getSchema());
            return _qualifiedSchemaName.equalsIgnoreCase(qualifiedSchema);
        } else {
            return _catalogName.equalsIgnoreCase(structItemTableType.getCatalog());
        }
    }

    public boolean matches(StructItemProcedureType structItemProcedureType) {
        if (null != _qualifiedSchemaName) {
            String qualifiedSchema = SQLUtil.getQualifiedName(structItemProcedureType.getCatalog(), structItemProcedureType.getSchema());
            return _qualifiedSchemaName.equalsIgnoreCase(qualifiedSchema);
        } else {
            return _catalogName.equalsIgnoreCase(structItemProcedureType.getCatalog());
        }
    }


    @Override
    public String toString() {
        if (null == _qualifiedSchemaName) {
            return _catalogName + "[Catalog]";
        } else {
            return _qualifiedSchemaName;
        }
    }

    public String getQualifiedSchemaName() {
        return _qualifiedSchemaName;
    }

    public void setQualifiedSchemaName(String qualifiedSchemaName) {
        _qualifiedSchemaName = qualifiedSchemaName;
    }

    public String getCatalogName() {
        return _catalogName;
    }

    public void setCatalogName(String catalogName) {
        _catalogName = catalogName;
    }

}
