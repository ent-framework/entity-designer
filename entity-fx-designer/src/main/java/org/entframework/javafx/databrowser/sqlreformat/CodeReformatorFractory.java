/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.sqlreformat;

import org.entframework.javafx.databrowser.AppState;
import org.entframework.javafx.databrowser.services.Dao;
import org.entframework.javafx.databrowser.services.SQLUtil;
import org.entframework.javafx.databrowser.settings.SQLFormatSettings;

public class CodeReformatorFractory {
    public static CodeReformator createCodeReformator(SQLFormatSettings sqlFormatSettings) {
        CodeReformatorConfig codeReformatorConfig = new CodeReformatorConfig(AppState.get().getSettingsManager().getSettings().getStatementSeparator(), new CommentSpec[]{new CommentSpec(SQLUtil.LINE_COMMENT_BEGIN, "\n")}, sqlFormatSettings);
        return new CodeReformator(codeReformatorConfig);
    }

    public static CodeReformator createCodeReformator() {
        return createCodeReformator(Dao.loadSQLFormatSeetings());
    }
}
