/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SQLHistorySearchView {
    @FXML
    ComboBox<SqlHistoryFilterType> cboFilterType;
    @FXML
    TextField txtFilter;
    @FXML
    Button btnApply;
    @FXML
    CheckBox chkFiltered;
    @FXML
    SplitPane split;
}
