/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import org.entframework.javafx.databrowser.Props;
import org.entframework.javafx.databrowser.services.Utils;
import org.entframework.javafx.databrowser.session.ColumnInfo;
import org.entframework.javafx.databrowser.session.graph.filter.FilterCtrl;

public class FilterPane extends BorderPane {
    private FilterPersistence _filterPersistence;
    private ColumnInfo _columnInfo;

    public FilterPane(FilterPersistence filterPersistence, ColumnInfo columnInfo, QueryChannel queryChannel) {
        _filterPersistence = filterPersistence;
        _columnInfo = columnInfo;

        updateIcon();

        addEventHandler(MouseEvent.MOUSE_PRESSED, e -> onFilterCtrl(queryChannel));
    }

    private void onFilterCtrl(QueryChannel queryChannel) {
        new FilterCtrl(_filterPersistence, _columnInfo, queryChannel);
        updateIcon();
    }

    private void updateIcon() {
        ImageView imageView;
        if (Utils.isEmptyString(_filterPersistence.getFilter())) {
            imageView = new ImageView(new Props(getClass()).getImage("filter.gif"));
        } else {
            imageView = new ImageView(new Props(getClass()).getImage("filter_checked.gif"));
        }
        setCenter(imageView);
    }

}
