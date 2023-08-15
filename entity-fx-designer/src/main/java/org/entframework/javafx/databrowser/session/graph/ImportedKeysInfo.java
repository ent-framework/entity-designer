/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph;

import org.entframework.javafx.databrowser.session.ColumnInfo;
import org.entframework.javafx.databrowser.session.TableInfo;
import org.entframework.javafx.databrowser.session.schemainfo.FullyQualifiedTableName;
import org.entframework.javafx.databrowser.table.TableLoader;

public class ImportedKeysInfo {
    private TableLoader _impKeysAsTableLoader;

    public ImportedKeysInfo(TableLoader impKeysAsTableLoader) {
        _impKeysAsTableLoader = impKeysAsTableLoader;
    }

    public boolean isFk(ColumnInfo columnInfo) {
        for (int i = 0; i < _impKeysAsTableLoader.size(); i++) {
            if (columnInfo.getColName().equalsIgnoreCase(_impKeysAsTableLoader.getCellAsString("FKCOLUMN_NAME", i))) {
                return true;
            }
        }

        return false;
    }

    public String getFkNameTo(TableInfo toPkTable, ColumnInfo columnInfo) {
        for (int i = 0; i < _impKeysAsTableLoader.size(); i++) {
            if (columnInfo.getColName().equalsIgnoreCase(_impKeysAsTableLoader.getCellAsString("FKCOLUMN_NAME", i))
                    && toPkTable.getName().equalsIgnoreCase(_impKeysAsTableLoader.getCellAsString("PKTABLE_NAME", i))) {
                return _impKeysAsTableLoader.getCellAsString("FK_NAME", i);
            }
        }

        return null;
    }

    public boolean belongsToFk(String fkName, ColumnInfo columnInfo) {
        for (int i = 0; i < _impKeysAsTableLoader.size(); i++) {
            if (columnInfo.getColName().equalsIgnoreCase(_impKeysAsTableLoader.getCellAsString("FKCOLUMN_NAME", i))
                    && fkName.equalsIgnoreCase(_impKeysAsTableLoader.getCellAsString("FK_NAME", i))) {
                return true;
            }
        }

        return false;
    }

    public FullyQualifiedTableName getPkTable(String fkName) {
        for (int i = 0; i < _impKeysAsTableLoader.size(); i++) {
            if (fkName.equalsIgnoreCase(_impKeysAsTableLoader.getCellAsString("FK_NAME", i))) {
                String catalog = _impKeysAsTableLoader.getCellAsString("PKTABLE_CAT", i);
                String schema = _impKeysAsTableLoader.getCellAsString("PKTABLE_SCHEM", i);
                String table = _impKeysAsTableLoader.getCellAsString("PKTABLE_NAME", i);

                return new FullyQualifiedTableName(catalog, schema, table);
            }
        }
        return null;
    }
}
