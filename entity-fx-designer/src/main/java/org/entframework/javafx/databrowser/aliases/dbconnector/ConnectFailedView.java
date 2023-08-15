/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.aliases.dbconnector;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class ConnectFailedView {
    @FXML
    Label lblAliasConnecting;
    @FXML
    Label lblErrorOccured;
    @FXML
    TextArea txtErrMessage;
    @FXML
    Button btnClose;
    @FXML
    Button btnRelogin;
    @FXML
    Button btnEditAlias;


}
