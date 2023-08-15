/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ConfigureNonDBConstraintView {
    @FXML
    TextField txtFkTableName;
    @FXML
    TextField txtPkTableName;
    @FXML
    TableView tblColumnPairs;
    @FXML
    Button btnRemoveSelectedEntry;
    @FXML
    Label lblFkColumns;
    @FXML
    Label lblPkColumns;
    @FXML
    ComboBox<GraphColumn> cboFkColumn;
    @FXML
    ComboBox<GraphColumn> cboPkColumn;
    @FXML
    Button btnAdd;
    @FXML
    Button btnOk;
    @FXML
    Button btnCancel;
}
