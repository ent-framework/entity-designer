/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql.searchchandreplace;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

public class SearchView {
    @FXML
    ComboBox cboSearchText;
    @FXML
    Button btnFindNext;
    @FXML
    Button btnFindPrevious;
    @FXML
    CheckBox chkMatchCase;
    @FXML
    CheckBox chkWholeWord;
    @FXML
    Button btnClose;
}
