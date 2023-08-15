/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql.features;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class SqlToTableView {
    @FXML
    TextField txtTableName;
    @FXML
    RadioButton radDrop;
    @FXML
    RadioButton radAppend;
    @FXML
    RadioButton radDoNothing;
    @FXML
    CheckBox chkScriptOnly;
    @FXML
    Button btnOk;
    @FXML
    Button btnCancel;
}
