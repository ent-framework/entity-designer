/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.drivers;

import javafx.scene.Node;
import javafx.scene.control.ListCell;
import org.entframework.javafx.databrowser.Props;

public class DriverCell extends ListCell<SQLDriver> {

    private Props _props = new Props(this.getClass());

    private static final String STYLE_PREDEFINED_LABEL = "driver-cell-predefined";
    private static final String STYLE_NORMAL_LABEL = "driver-cell-custom";

    public DriverCell() {
    }

    @Override
    protected void updateItem(SQLDriver sqlDriver, boolean empty) {
        super.updateItem(sqlDriver, empty);

        if (empty) {
            setText(null);
            setGraphic(null);
            return;
        }
        setText(sqlDriver.getName());
        setGraphic(getIcon(sqlDriver));
        getStyleClass().add(getCustomStyleClass(sqlDriver));
    }

    private String getCustomStyleClass(SQLDriver sqlDriver) {
        if (sqlDriver.isSquirrelPredefinedDriver()) {
            return STYLE_PREDEFINED_LABEL;
        } else {
            return STYLE_NORMAL_LABEL;
        }
    }

    private Node getIcon(SQLDriver sqlDriver) {
        if (sqlDriver.isLoaded()) {
            return DriversCtrl.getDriverloadedimage();
        } else {
            return DriversCtrl.getDrivernotloadedimage();
        }
    }
}
