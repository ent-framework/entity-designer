/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.drivers;

import org.entframework.javafx.common.spring.AbstractFxmlView;
import org.entframework.javafx.common.spring.FXMLView;

@FXMLView(
        value = "/org/entframework/javafx/databrowser/drivers/DriversView.fxml",
        bundle = "org.entframework.javafx.databrowser.drivers.i18n",
        css = {"/org/entframework/javafx/databrowser/drivers/DriversView.css"}
)
public class DriversView extends AbstractFxmlView {
}
