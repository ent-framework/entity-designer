/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph;

import javafx.scene.image.ImageView;
import org.entframework.javafx.databrowser.Props;
import org.entframework.javafx.databrowser.services.I18n;

public enum OrderBy {
    NONE("sort.png", "order.none"),
    ASC("sort_asc.gif", "order.asc"),
    DESC("sort_desc.gif", "order.desc");

    private final String _imageName;
    private final String _title;

    OrderBy(String imageName, String title) {
        _imageName = imageName;
        _title = new I18n(AggregateFunction.class).t(title);
    }

    public ImageView createImage() {
        return new ImageView(new Props(OrderBy.class).getImage(_imageName));
    }

    public String getTitle() {
        return _title;
    }


}
