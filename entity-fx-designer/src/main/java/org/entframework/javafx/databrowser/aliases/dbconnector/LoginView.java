/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.aliases.dbconnector;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginView {
    @FXML
    Label lblAlias;
    @FXML
    Label lblDriver;
    @FXML
    Label lblUrl;
    @FXML
    TextField txtUser;
    @FXML
    PasswordField txtPassword;
    @FXML
    Button btnConnect;
    @FXML
    Button btnClose;
}
