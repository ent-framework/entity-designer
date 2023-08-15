/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql.makeeditable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EditableSqlCheck {
    private static final int ALLOWS_EDITING_FALSE = 0;
    private static final int ALLOWS_EDITING_TRUE = 1;
    private static final int ALLOWS_EDITING_UNKNOWN = 2;

    private String _tableNameFromSQL = null;

    public EditableSqlCheck(String sql) {
        _tableNameFromSQL = getTableFromSQLIntern(sql);
    }

    private String getTableFromSQLIntern(String sql) {

        String sqlInOriginalCase = sql.trim();

        Pattern patternBeforeTable = Pattern.compile("SELECT\\s+[A-Z0-9_\\*\\.',\\s]*\\s+FROM\\s+([A-Z0-9_\\.]+)");
        sql = sql.toUpperCase().trim();
        // Bug 1371587 - remove useless accent characters if they exist
        sql = sql.replaceAll("\\`", "");
        Matcher matcher;

        matcher = patternBeforeTable.matcher(sql);
        if (false == matcher.find()) {
            return null;
        }

        String table;
        if (sqlInOriginalCase.length() == sql.length()) {
            // If possible we keep the original case for datadase systems that are case sensitive like MySQL in some situations.
            table = sqlInOriginalCase.substring(matcher.start(1), matcher.end(1));
        } else {
            table = matcher.group(1);
        }


        String behindTable = sql.substring(matcher.end(1)).trim();

        int ret = behindTableAllowsEditing(behindTable);

        if (ALLOWS_EDITING_UNKNOWN == ret) {
            // This might be because an table alias is used maybe with an AS before it.

            Pattern patternBehindTable;
            if (behindTable.startsWith("AS") && 2 < behindTable.length() && Character.isWhitespace(behindTable.charAt(2))) {
                patternBehindTable = Pattern.compile("AS\\s+([A-Z0-9_]+)\\s+");
            } else {
                patternBehindTable = Pattern.compile("([A-Z0-9_]+)\\s+|[A-Z0-9_]+$");
            }

            matcher = patternBehindTable.matcher(behindTable);
            if (false == matcher.find()) {
                return null;
            }

            String alias = matcher.group(0);
            String behindAlias = behindTable.substring(matcher.end(0)).trim();

            ret = behindTableAllowsEditing(behindAlias);

            if (ALLOWS_EDITING_TRUE == ret) {
                return table;
            } else {
                return null;
            }
        } else if (ALLOWS_EDITING_TRUE == ret) {
            return table;
        } else //(ALLOWS_EDITING_FALSE == ret)
        {
            return null;
        }
    }

    private int behindTableAllowsEditing(String behindTable) {
        if (0 == behindTable.length()) {
            return ALLOWS_EDITING_TRUE;
        } else if (behindTable.startsWith("WHERE")
                || behindTable.startsWith("ORDER")
                || behindTable.startsWith("GROUP")) {
            return ALLOWS_EDITING_TRUE;
        } else if (behindTable.startsWith(",")
                || behindTable.startsWith("INNER")
                || behindTable.startsWith("LEFT")
                || behindTable.startsWith("RIGHT")
                || behindTable.startsWith("OUTER")
                || behindTable.startsWith(",")) {
            return ALLOWS_EDITING_FALSE;
        } else {
            return ALLOWS_EDITING_UNKNOWN;
        }
    }


    public boolean allowsEditing() {
        return null != _tableNameFromSQL;
    }

    public String getTableNameFromSQL() {
        return _tableNameFromSQL;
    }
}
