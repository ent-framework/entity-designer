/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph;

import javafx.scene.image.ImageView;
import org.entframework.javafx.databrowser.Props;
import org.entframework.javafx.databrowser.services.I18n;

public enum AggregateFunction {
    NONE("aggfct.png", "agg.function.none"),
    SUM("aggsum.png", "agg.function.sum"),
    MAX("aggmax.png", "agg.function.max"),
    MIN("aggmin.png", "agg.function.min"),
    COUNT("aggcount.png", "agg.function.count");


    private final String _imageName;
    private String _title;


    AggregateFunction(String imageName, String title) {
        _imageName = imageName;
        _title = new I18n(AggregateFunction.class).t(title);
    }

    /**
     * Images must be created. If not the same image would
     * tried to be rendered at different positions which leads repaint troubles.
     */
    public static ImageView createDisabledImage() {
        return new ImageView(new Props(AggregateFunction.class).getImage("aggfct_disabled.png"));
    }

    /**
     * Images must be created. If not the same image would
     * tried to be rendered at different positions which leads repaint troubles.
     */
    public ImageView createImage() {
        return new ImageView(new Props(AggregateFunction.class).getImage(_imageName));
    }

    public String getTitle() {
        return _title;
    }
}
