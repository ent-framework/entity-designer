/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.objecttree;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FilterResultUpperView {
    @FXML
    TextField txtFilter;
    @FXML
    TextField txtResultCount;
    @FXML
    Button btnCollapse;
    @FXML
    Label lblDescription;
}
