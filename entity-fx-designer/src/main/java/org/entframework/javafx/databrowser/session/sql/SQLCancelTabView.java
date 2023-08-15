/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SQLCancelTabView {
    @FXML
    Label lblExecTime;
    @FXML
    Label lblSql;
    @FXML
    TextField txtExecTime;
    @FXML
    TextArea txtSql;
    @FXML
    TextField txtStatus;
    @FXML
    Button btnCancel;
}
