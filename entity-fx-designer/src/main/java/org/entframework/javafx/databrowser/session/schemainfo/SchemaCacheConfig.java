/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.schemainfo;

import org.entframework.javafx.databrowser.aliases.AliasPropertiesDecorator;

public class SchemaCacheConfig {
    private SchemaCacheConfigFlags _schemaCacheConfigFlag;
    private AliasPropertiesDecorator _aliasPropertiesDecorator;

    public SchemaCacheConfig(AliasPropertiesDecorator aliasPropertiesDecorator) {
        _aliasPropertiesDecorator = aliasPropertiesDecorator;
    }

    public SchemaCacheConfig(SchemaCacheConfigFlags schemaCacheConfigFlag) {
        _schemaCacheConfigFlag = schemaCacheConfigFlag;
    }

    public static SchemaCacheConfig createLoadNothing() {
        return new SchemaCacheConfig(SchemaCacheConfigFlags.NOTHING);
    }

    public boolean shouldNotLoad() {
        return SchemaCacheConfigFlags.NOTHING == _schemaCacheConfigFlag;
    }

    public boolean shouldLoadTables(StructItemTableType structItemTableType) {
        if (shouldNotLoad()) {
            return false;
        }

        return _aliasPropertiesDecorator.shouldLoadTables(structItemTableType);
    }

    public boolean shouldCacheTables(StructItemTableType structItemTableType) {
        if (shouldNotLoad()) {
            return false;
        }
        return _aliasPropertiesDecorator.shouldCacheTables(structItemTableType);
    }

    public boolean shouldLoadProcedures(StructItemProcedureType structItemProcedureType) {
        if (shouldNotLoad()) {
            return false;
        }
        return _aliasPropertiesDecorator.shouldLoadProcedures(structItemProcedureType);
    }

    public boolean shouldCacheProcedures(StructItemProcedureType structItemProcedureType) {
        if (shouldNotLoad()) {
            return false;
        }
        return _aliasPropertiesDecorator.shouldCacheProcedures(structItemProcedureType);
    }

    public boolean shouldLoadUDTs(StructItemUDTType structItemUDTType) {
        return false; // _aliasPropertiesDecorator.shouldLoadUDTs(structItemUDTType);
    }

    public boolean shouldCacheUDTs(StructItemUDTType structItemUDTType) {
        return false; // _aliasPropertiesDecorator.shouldCacheUDTs(structItemUDTType);
    }

    public AliasPropertiesDecorator getAliasPropertiesDecorator() {
        return _aliasPropertiesDecorator;
    }


    private static enum SchemaCacheConfigFlags {
        ALL,
        NOTHING
    }


}
