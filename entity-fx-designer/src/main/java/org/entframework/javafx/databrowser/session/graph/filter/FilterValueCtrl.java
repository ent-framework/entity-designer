/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph.filter;

interface FilterValueCtrl {
    void setDisable(boolean b);

    String getFilterValueString();

    void setFilterValueString(String filter);
}
