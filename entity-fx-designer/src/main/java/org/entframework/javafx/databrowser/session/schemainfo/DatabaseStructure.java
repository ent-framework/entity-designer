/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.schemainfo;

import org.entframework.javafx.databrowser.services.CollectionUtil;
import org.entframework.javafx.databrowser.services.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseStructure extends StructItem {
    private String _aliasName;
    private SchemaCacheConfig _schemaCacheConfig;

    public DatabaseStructure(String aliasName, SchemaCacheConfig schemaCacheConfig) {
        _aliasName = aliasName;
        _schemaCacheConfig = schemaCacheConfig;
    }

    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new ByteArrayOutputStream());

        oos.writeObject(new DatabaseStructure(null, null));
    }

    public List<StructItem> getLeaves() {
        List<StructItem> ret = new ArrayList<>();

        fillLeaves(ret);

        return ret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DatabaseStructure that = (DatabaseStructure) o;

        if (_aliasName != null ? !_aliasName.equals(that._aliasName) : that._aliasName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return _aliasName != null ? _aliasName.hashCode() : 0;
    }

    public <T> T visitTopToBottom(DatabaseStructureVisitor<T> databaseStructureVisitor, SchemaCacheConfig schemaCacheConfig) {
        T parent = databaseStructureVisitor.visit(null, this);

        visit(databaseStructureVisitor, parent, schemaCacheConfig);

        return parent;
    }

    private <T extends StructItem> List<T> getStructItemsByType(final Class<T> structItemClass) {
        List<T> ret = new ArrayList<>();

        DatabaseStructureVisitor<Object> databaseStructureVisitor = new DatabaseStructureVisitor<Object>() {
            @Override
            public Object visit(Object resultOfParenVisit, StructItem structItem) {
                if (structItemClass.equals(structItem.getClass())) {
                    ret.add((T) structItem);
                }
                return null;
            }
        };

        visitTopToBottom(databaseStructureVisitor, _schemaCacheConfig);
        return ret;
    }

    public List<StructItemCatalog> getCatalogs() {
        return getStructItemsByType(StructItemCatalog.class);
    }

    public List<StructItemSchema> getSchemas() {
        return getStructItemsByType(StructItemSchema.class);
    }

    public StructItemCatalog getCatalogByName(String catalogName) {
        List<StructItemCatalog> catalogs = CollectionUtil.filter(getCatalogs(), (t) -> Utils.compareRespectEmpty(t.getCatalog(), catalogName));

        if (0 == catalogs.size()) {
            return null;
        }

        return catalogs.get(0);
    }

    public List<StructItemSchema> getSchemasByName(String schemaName) {
        return CollectionUtil.filter(getSchemas(), (t) -> Utils.compareRespectEmpty(schemaName, t.getSchema()));
    }

    public List<StructItemSchema> getSchemaByNameAsArray(String catalogName, String schemaName) {
        return CollectionUtil.filter(getSchemas(), (t) -> Utils.compareRespectEmpty(catalogName, t.getCatalog()) && Utils.compareRespectEmpty(schemaName, t.getSchema()));
    }

    @Override
    public String getItemName() {
        return "Database";
    }

    //////////////////////////////////////////////////////////////////////////////
    // Objects of this class should not be serialized.
    // All other inheritors of StructItem should.
    private void writeObject(ObjectOutputStream out) throws IOException {
        throw new NotSerializableException("DatabaseStructure should not take part in Schema caching.");
    }

    private Object readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        throw new NotSerializableException("DatabaseStructure should not take part in Schema caching.");
    }

    //
    //////////////////////////////////////////////////////////////////////////////

}
