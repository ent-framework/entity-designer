/*
 * Copyright (c) 2002-2023. Licensed under the Apache License, Version 2.0.
 */
package org.entframework.javafx.databrowser.session.parser.kernel.completions;

import org.entframework.javafx.databrowser.session.parser.kernel.Completion;
import org.entframework.javafx.databrowser.session.parser.kernel.ParserLogger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * an SQL statement class representing modyfing statements, i.e.
 * INSERT, UPDATE and DELETE. The important common trait of these statements
 * is that they alow for only one target table to be specified
 */
public class SQLModifyingStatement extends SQLStatement {
    private SQLTable m_table;
    private int updateListStart = NO_POSITION;
    private int updateListEnd = NO_POSITION;

    public SQLModifyingStatement(int start) {
        super(start);
    }

    public List<Table> getTables(String catalog, String schema, String name) {
        if (name != null || m_table == null) {
            return super.getTables(catalog, schema, name);
        } else {
            List<Table> tables = super.getTables(m_table.catalog, m_table.schema, m_table.name);
            List<Table> result = new ArrayList<Table>();
            Iterator<Table> it = tables.iterator();
            while (it.hasNext()) {
                Table table = it.next();
                if (table.matches(catalog, schema, name))
                    result.add(table);
            }
            return result;
        }
    }

    public void addTable(SQLTable table) {
        super.addTable(table);
        m_table = table;
    }

    public Table getTable() {
        return getTable(m_table.catalog, m_table.schema, m_table.name);
    }

    public boolean setTable(String catalog, String schema, String name, String alias) {
        return super.setTable(catalog, schema, name, alias);
    }

    public void setUpdateListStart(int position) {
        ParserLogger.log("updateListStart: " + position);
        updateListStart = position;
        updateListEnd = NO_LIMIT;
    }

    public void setUpdateListEnd(int position) {
        updateListEnd = position;
    }

    public Completion getCompletion(int position) {
        Completion c = super.getCompletion(position);
        if (c == null) {
            if (position >= updateListStart && position <= updateListEnd) {
                SQLColumn col = new SQLColumn(this, position);
                col.setRepeatable(false);
                return col;
            }
        }
        return c;
    }
}
