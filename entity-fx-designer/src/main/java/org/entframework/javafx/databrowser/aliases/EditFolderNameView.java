/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.aliases;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class EditFolderNameView {
    //////////////////////////////////////////////////////////////////////
    // Naming convention, see:
    // http://docs.oracle.com/javafx/2/fxml_get_started/whats_new2.htm
    public TreePositionView treePositionViewController; // fx:id in EditFolderNameView.fxml plus postfix "Controller"
    public AnchorPane treePositionView; // fx:id in EditFolderNameView.fxml
    @FXML
    TextField txtFolderName;
    @FXML
    Button btnOk;
    @FXML
    Button btnCancel;
    //
    ///////////////////////////////////////////////////////////////////////
}
