/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.aliases.dbconnector;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import org.entframework.javafx.databrowser.Props;
import org.entframework.javafx.databrowser.aliases.AliasDecorator;
import org.entframework.javafx.databrowser.aliases.AliasPropertiesEditCtrl;
import org.entframework.javafx.databrowser.services.I18n;

public class SessionLoadingTimeHintCtrl {
    public SessionLoadingTimeHintCtrl(BorderPane availableArea, AliasDecorator aliasDecorator) {
        I18n i18n = new I18n(getClass(), "org.entframework.javafx.databrowser.aliases.dbconnector.i18n");
        Props props = new Props(getClass());

        availableArea.setCenter(new Label(i18n.t("session.loading.time.hint")));

        Button button = new Button(i18n.t("open.alias.properties"), props.getImageView("alias_properties.png"));
        availableArea.setBottom(button);
        BorderPane.setAlignment(button, Pos.BOTTOM_RIGHT);

        button.setOnAction(e -> openAliasProperties(aliasDecorator));
    }

    private void openAliasProperties(AliasDecorator aliasDecorator) {
        new AliasPropertiesEditCtrl(aliasDecorator);
    }
}
