/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.settings;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class GeneralView {
    @FXML
    TextField txtStatementSeparator;
    @FXML
    RadioButton radStandardProps;
    @FXML
    RadioButton radUserDefinedProps;
    @FXML
    AnchorPane apProperties;
    @FXML
    TextField txtPropertiesFileLocation;
    @FXML
    CheckBox chkMultibleLinesInCells;
    @FXML
    CheckBox chkLimitRowsByDefault;
    @FXML
    TextField txtLimitRowsDefault;
    @FXML
    Button btnSaveStandardProperties;
    @FXML
    TextField txtResultTabsLimit;
    @FXML
    CheckBox chkCopyAliasProperties;
    @FXML
    CheckBox chkCopyQuotedToClip;
    @FXML
    CheckBox chkMarkCurrentSql;
    @FXML
    ColorPicker colPickCurrentSqlMark;


    @FXML
    AnchorPane apMarkCurrentSql;

}
