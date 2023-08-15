/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql.searchchandreplace;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

public class ReplaceView {
    //////////////////////////////////////////////////////////////////////
    // Naming convention, see:
    // http://docs.oracle.com/javafx/2/fxml_get_started/whats_new2.htm
    @FXML
    AnchorPane searchView;
    @FXML
    SearchView searchViewController;
    //
    //////////////////////////////////////////////////////////////////////

    @FXML
    ComboBox cboReplaceText;
    @FXML
    Button btnReplace;
    @FXML
    Button btnReplaceAll;
    @FXML
    Button btnExclude;
}
