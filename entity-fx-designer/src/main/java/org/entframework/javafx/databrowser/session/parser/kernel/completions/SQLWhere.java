/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */
package org.entframework.javafx.databrowser.session.parser.kernel.completions;

import org.entframework.javafx.databrowser.session.parser.kernel.Completion;
import org.entframework.javafx.databrowser.session.parser.kernel.SQLCompletion;
import org.entframework.javafx.databrowser.session.parser.kernel.SQLSchema;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * a completion which represents the WHERE clause inside SELECT, UPDATE or DLETE
 * statements
 */
public class SQLWhere extends SQLCompletion implements SQLStatementContext {
    private SQLStatement statement;
    private List<Completion> children = new ArrayList<Completion>();

    public SQLWhere(SQLStatement statement, int startPosition) {
        super(startPosition);
        this.statement = statement;
        setEndPosition(NO_LIMIT);
    }

    public void setEndPosition(int position) {
        statement.setEndPosition(position);
        super.setEndPosition(position);
    }

    public Completion getCompletion(int position) {
        if (super.getCompletion(position) != null) {
            Iterator<Completion> it = children.iterator();
            while (it.hasNext()) {
                Completion comp = it.next();
                if ((comp = comp.getCompletion(position)) != null)
                    return comp;
            }
            SQLColumn col = new SQLColumn(this, position);
            col.setRepeatable(false);
            return col;
        }
        return null;
    }

    public SQLStatement getStatement() {
        return statement;
    }

    public void setSqlSchema(SQLSchema schema) {
        //schema should be identical to the statement. Ignore
    }

    public void addContext(SQLStatementContext context) {
        context.setSqlSchema(statement);
        children.add(context);
    }

    public void addColumn(SQLColumn column) {
        children.add(column);
    }
}
