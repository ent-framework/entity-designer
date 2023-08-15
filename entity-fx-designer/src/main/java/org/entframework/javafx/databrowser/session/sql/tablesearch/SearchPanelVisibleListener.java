/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql.tablesearch;

import javafx.scene.Node;

public interface SearchPanelVisibleListener {
    void showPanel(Node panel, boolean visible);
}
