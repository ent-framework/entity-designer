/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql;

public interface StateChannelListener {
    void stateChanged(StatementExecutionState statementExecutionState);
}
