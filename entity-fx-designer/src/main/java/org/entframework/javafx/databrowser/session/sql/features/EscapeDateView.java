/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql.features;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EscapeDateView {
    @FXML
    TextField txtYear;
    @FXML
    TextField txtMonth;
    @FXML
    TextField txtDay;
    @FXML
    TextField txtSecond;
    @FXML
    TextField txtMinute;
    @FXML
    TextField txtHour;
    @FXML
    Button btnTimestamp;
    @FXML
    Button btnDate;
    @FXML
    Button btnTime;
}
