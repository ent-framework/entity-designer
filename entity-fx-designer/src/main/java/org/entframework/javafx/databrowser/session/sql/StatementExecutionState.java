/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql;

import org.entframework.javafx.databrowser.services.I18n;

public enum StatementExecutionState {
    PREPARING(new I18n(StatementExecutionState.class).t("session.tab.sql.executing.state.preparing")),
    EXECUTING(new I18n(StatementExecutionState.class).t("session.tab.sql.executing.state.executing")),
    PROCESSING_RESULTS(new I18n(StatementExecutionState.class).t("session.tab.sql.executing.state.building.output")),
    FINSHED(new I18n(StatementExecutionState.class).t("session.tab.sql.executing.state.finished")),
    ERROR(new I18n(StatementExecutionState.class).t("session.tab.sql.executing.state.error")),
    CANCELED(new I18n(StatementExecutionState.class).t("session.tab.sql.executing.state.canceled"));

    private String _text;

    StatementExecutionState(String text) {
        _text = text;
    }

    public static boolean isEndState(StatementExecutionState statementExecutionState) {
        return FINSHED == statementExecutionState || ERROR == statementExecutionState || CANCELED == statementExecutionState;
    }

    public String getText() {
        return _text;
    }
}
