/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.services.progress;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class SimpleProgressView {
    @FXML
    ProgressIndicator progressIndicator;
    @FXML
    TextArea txtProgressMsg;
    @FXML
    Button btnCancelClose;
    @FXML
    BorderPane availableArea;
}
