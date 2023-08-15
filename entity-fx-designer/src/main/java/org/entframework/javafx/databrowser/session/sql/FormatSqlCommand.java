/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql;

import org.entframework.javafx.databrowser.sqlreformat.CodeReformator;
import org.entframework.javafx.databrowser.sqlreformat.CodeReformatorFractory;

public class FormatSqlCommand {
    public FormatSqlCommand(SQLTextAreaServices sqlTextAreaServices) {
        CodeReformator codeReformator = CodeReformatorFractory.createCodeReformator();

        String reformatedSQL = codeReformator.reformat(sqlTextAreaServices.getCurrentSql());

        sqlTextAreaServices.replaceCurrentSql(reformatedSQL);
    }
}
