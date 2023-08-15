/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */
package org.entframework.javafx.databrowser.session.parser.kernel.completions;

import org.entframework.javafx.databrowser.session.parser.kernel.ParserLogger;
import org.entframework.javafx.databrowser.session.parser.kernel.SQLCompletion;
import org.entframework.javafx.databrowser.session.parser.kernel.SQLSchema;

import java.util.Collections;
import java.util.List;

/**
 * this class represents a table completion, as it appears within the FROM
 * clause of a a select statement, and in other places.<br>
 * <em>Note: do not confuse with SQLSchema.Table</em>
 */
public class SQLTable extends SQLCompletion {
    public String catalog;
    public String schema;
    public String name;
    public String alias;

    private SQLStatement statement;

    public SQLTable(SQLStatement statement, int start) {
        super(start);
        ParserLogger.log("SQLTable: " + start);
        this.statement = statement;
    }

    public SQLTable(SQLStatement statement, int start, int end) {
        super(start);
        ParserLogger.log("SQLTable: " + start + " " + end);
        this.statement = statement;
        setEndPosition(end);
    }

    public SQLStatement getStatement() {
        return statement;
    }

    public void setCatalog(String catalog, int pos) {
        this.catalog = catalog;
        setEndPosition(pos + catalog.length() - 1);
    }

    public void setSchema(String schema, int pos) {
        this.schema = schema;
        setEndPosition(pos + schema.length() - 1);
    }

    public void setName(String name, int pos) {
        this.name = name;
        setEndPosition(pos + name.length() - 1);
    }

    public void setAlias(String alias, int pos) {
        this.alias = alias;
        setEndPosition(pos + alias.length() - 1);
    }

    public SQLSchema.Table[] getCompletions(int position) {
        String tb = (name != null && position > startPosition) ?
                name.substring(0, position - startPosition) : null;

        List<SQLSchema.Table> tables = getStatement().getTables(catalog, schema, tb);
        Collections.sort(tables);
        return tables.toArray(new SQLSchema.Table[tables.size()]);
    }

    /**
     * @return true if the name is set
     */
    protected boolean isConcrete() {
        return name != null;
    }

    /**
     * tables are safe to repeat, as they only appear in the from clause
     *
     * @return <em>true</em>
     */
    public boolean isRepeatable() {
        return true;
    }

    public boolean mustReplace(int position) {
        return name != null && position >= startPosition && position <= endPosition;
    }

    public String getText(int position, String option) {
        return option;
    }
}
