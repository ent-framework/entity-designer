/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph;

import javafx.geometry.Point2D;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import org.entframework.javafx.databrowser.AppState;

public class OrderByPane extends BorderPane {
    private OrderByPersistence _orderByPersistence;
    private QueryChannel _queryChannel;

    public OrderByPane(OrderByPersistence orderByPersistence, QueryChannel queryChannel) {
        _orderByPersistence = orderByPersistence;
        _queryChannel = queryChannel;

        OrderBy orderBy = OrderBy.valueOf(_orderByPersistence.getOrderBy());
        setCenter(orderBy.createImage());

        addEventHandler(MouseEvent.MOUSE_PRESSED, e -> showPopup());
    }

    private void showPopup() {

        ImageView noneIcon = OrderBy.NONE.createImage();
        MenuItem none = new MenuItem(OrderBy.NONE.getTitle(), noneIcon);
        none.setOnAction(e -> onFctSelected(OrderBy.NONE));


        ImageView ascIcon = OrderBy.ASC.createImage();
        MenuItem asc = new MenuItem(OrderBy.ASC.getTitle(), ascIcon);
        asc.setOnAction(e -> onFctSelected(OrderBy.ASC));

        ImageView descIcon = OrderBy.DESC.createImage();
        MenuItem desc = new MenuItem(OrderBy.DESC.getTitle(), descIcon);
        desc.setOnAction(e -> onFctSelected(OrderBy.DESC));


        ContextMenu popup = new ContextMenu(none, asc, desc);

        Point2D localToScene = localToScreen(0, 0);

        popup.show(AppState.get().getPrimaryStage(), localToScene.getX(), localToScene.getY());


    }

    private void onFctSelected(OrderBy orderBy) {
        setCenter(orderBy.createImage());
        _orderByPersistence.setOrderBy(orderBy.name());
        _queryChannel.fireChanged();
    }

}
