/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.parser.kernel;


public class TableAliasInfo {
    public String aliasName;
    public String tableName;
    public int statBegin;

    public TableAliasInfo(String aliasName, String tableName, int statBegin) {
        this.aliasName = aliasName;
        this.tableName = tableName;
        this.statBegin = statBegin;
    }
}
