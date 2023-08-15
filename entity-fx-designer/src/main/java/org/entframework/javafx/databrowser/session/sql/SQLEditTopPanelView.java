/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class SQLEditTopPanelView {
    @FXML
    CheckBox chkLimitRows;
    @FXML
    TextField txtRowLimit;
    @FXML
    Button btnOpenHistory;
    @FXML
    Button btnAppendToEditor;
    @FXML
    ComboBox<SQLHistoryEntry> cboLatestSqls;
}
