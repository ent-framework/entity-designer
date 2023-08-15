/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.aliases;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;

public class TreePositionView {
    @FXML
    RadioButton radToRoot;
    @FXML
    RadioButton radToSelectedAsChild;
    @FXML
    RadioButton radToSelectedAsAncestor;
    @FXML
    RadioButton radToSelectedAsSuccessor;
}
