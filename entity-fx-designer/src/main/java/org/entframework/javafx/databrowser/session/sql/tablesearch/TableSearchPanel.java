/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql.tablesearch;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

public class TableSearchPanel {
    @FXML
    ComboBox<TableSearchType> cboSearchType;
    @FXML
    CheckBox chkCaseSensitive;
    @FXML
    ComboBox<String> cboSearchString;
    @FXML
    Button btnFindNext;
    @FXML
    Button btnFindPrevious;
    @FXML
    Button btnHighlightAllMatches;
    @FXML
    Button btnUnhighlightAll;
    @FXML
    Button btnResultInOwnTable;
}
