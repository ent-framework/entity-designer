/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class SqlConfigCtrl {
    public SqlConfigCtrl(GraphPersistenceWrapper graphPersistenceWrapper) {


    }

    public Pane getPane() {
        return new BorderPane(new Label("onSql"));
    }
}
