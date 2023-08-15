/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.schemainfo;

import org.entframework.javafx.databrowser.aliases.Alias;
import org.entframework.javafx.databrowser.aliases.dbconnector.DbConnectorResult;
import org.entframework.javafx.databrowser.services.Utils;
import org.entframework.javafx.databrowser.services.sqlwrap.SQLConnection;
import org.entframework.javafx.databrowser.session.DBSchema;

import java.sql.SQLException;
import java.util.List;

public class SchemaCacheFactory {
    public static SchemaCache createSchemaCache(DbConnectorResult dbConnectorResult, SQLConnection sqlConnection, SchemaCacheConfig schemaCacheConfig) {
        return new SchemaCache(dbConnectorResult, schemaCacheConfig, createDatabaseStructure(dbConnectorResult.getAliasDecorator().getAlias(), sqlConnection, schemaCacheConfig));
    }

    private static DatabaseStructure createDatabaseStructure(Alias alias, SQLConnection sqlConnection, SchemaCacheConfig schemaCacheConfig) {
        DatabaseStructure aliasRoot = new DatabaseStructure(alias.getName(), schemaCacheConfig);

        recursiveAppendChildren(aliasRoot, sqlConnection);

        return aliasRoot;

    }

    private static void recursiveAppendChildren(StructItem parent, SQLConnection sqlConnection) {
        if (appendChildren(parent, sqlConnection)) {
            for (StructItem child : parent.getChildren()) {
                recursiveAppendChildren(child, sqlConnection);
            }
        }

    }

    private static boolean appendChildren(StructItem parent, SQLConnection sqlConnection) {

        boolean supportsCatalogs = supportsCatalogs(sqlConnection);

        boolean supportsSchemas = supportsSchemas(sqlConnection);

        boolean addedChildren = false;

        if (parent instanceof DatabaseStructure) {
            // If a driver says it supports schemas/catalogs but doesn't
            // provide schema/catalog nodes, try to get other nodes.
            if (supportsCatalogs) {
                addedChildren = appendCatalogs(parent, sqlConnection);
            }

            if (false == addedChildren && supportsSchemas) {
                addedChildren = appendSchemas(parent, sqlConnection, null);
            }

            if (false == addedChildren) {
                addedChildren = appendTypes(parent, sqlConnection, null, null);
            }
        } else if (parent instanceof StructItemCatalog) {
            // If a driver says it supports schemas but doesn't
            // provide schema nodes, try to get other nodes.
            final String catalogName = ((StructItemCatalog) parent).getCatalog();
            if (supportsSchemas) {
                addedChildren = appendSchemas(parent, sqlConnection, catalogName);
            }
            if (false == addedChildren) {
                addedChildren = appendTypes(parent, sqlConnection, catalogName, null);
            }
        } else if (parent instanceof StructItemSchema) {
            StructItemSchema schema = (StructItemSchema) parent;
            addedChildren = appendTypes(parent, sqlConnection, schema.getCatalog(), schema.getSchema());
        }

        return addedChildren;
    }

    private static boolean supportsSchemas(SQLConnection sqlConnection) {
        boolean supportsSchemas = false;
        try {
            supportsSchemas = sqlConnection.supportsSchemas();
        } catch (SQLException ex) {
        }
        return supportsSchemas;
    }

    private static boolean supportsCatalogs(SQLConnection sqlConnection) {
        boolean supportsCatalogs = false;
        try {
            supportsCatalogs = sqlConnection.supportsCatalogs();
        } catch (Exception ex) {
        }
        return supportsCatalogs;
    }

    private static boolean supportsProcerdures(SQLConnection sqlConnection) {
        boolean supportsProcedures = false;
        try {
            supportsProcedures = sqlConnection.supportsStoredProcedures();
        } catch (Exception ex) {
        }
        return supportsProcedures;
    }


    private static boolean appendTypes(StructItem parent, SQLConnection sqlConnection, String catalog, String schema) {
        boolean addedChildren = false;

        List<String> types = sqlConnection.getTableTypes();

        for (String type : types) {
            parent.getChildren().add(new StructItemTableType(type, catalog, schema));
            addedChildren = true;
        }

        if (supportsProcerdures(sqlConnection)) {
            parent.getChildren().add(new StructItemProcedureType(catalog, schema));
        }

        parent.getChildren().add(new StructItemUDTType(catalog, schema));

        return addedChildren;
    }


    private static boolean appendSchemas(StructItem parent, SQLConnection sqlConnection, String catalogName) {
        boolean addedChildren = false;
        List<DBSchema> schemas = sqlConnection.getSchemas();

        for (DBSchema schema : schemas) {
            if (Utils.compareRespectEmpty(catalogName, schema.getCatalog())) {
                parent.getChildren().add(new StructItemSchema(schema.getSchema(), catalogName));
                addedChildren = true;
            }
        }
        return addedChildren;
    }

    private static boolean appendCatalogs(StructItem parent, SQLConnection sqlConnection) {
        boolean addedChildren = false;
        List<String> catalogs = sqlConnection.getCatalogs();

        for (String catalog : catalogs) {
            parent.getChildren().add(new StructItemCatalog(catalog));
            addedChildren = true;
        }
        return addedChildren;
    }

}
