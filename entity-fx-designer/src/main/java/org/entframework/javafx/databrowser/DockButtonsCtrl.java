/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import org.entframework.javafx.common.event.DefaultEventBus;
import org.entframework.javafx.common.event.DockButtonToggleEvent;
import org.entframework.javafx.common.spring.AbstractFxmlCtrl;
import org.entframework.javafx.common.spring.FXMLController;
import org.entframework.javafx.databrowser.services.I18n;

import java.util.function.Consumer;

@FXMLController
public class DockButtonsCtrl extends AbstractFxmlCtrl {
    private I18n i18n = new I18n(getClass());
    @FXML
    private VBox dockButtons;
    private VerticalToggleButton _btnDesigner;
    private VerticalToggleButton _btnAliases;
    private VerticalToggleButton _btnDrivers;

    public void initialize() {
        DefaultEventBus.getInstance().subscribe(DockButtonToggleEvent.class, new Consumer<DockButtonToggleEvent>() {
            @Override
            public void accept(DockButtonToggleEvent dockButtonToggleEvent) {
                switch (dockButtonToggleEvent.getType()) {
                    case ALIASES -> _btnAliases.setSelected(dockButtonToggleEvent.isSelected());
                    case DRIVERS -> _btnDrivers.setSelected(dockButtonToggleEvent.isSelected());
                    case DESIGNER -> _btnDesigner.setSelected(dockButtonToggleEvent.isSelected());
                }
            }
        });

        _btnDesigner = new VerticalToggleButton(i18n.t("dock.button.designer"));
        _btnDesigner.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onDesigner();
            }
        });
        dockButtons.getChildren().add(_btnDesigner);

        _btnAliases = new VerticalToggleButton(i18n.t("dock.button.aliases"));
        _btnAliases.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onAliases();
            }
        });
        dockButtons.getChildren().add(_btnAliases);


        _btnDrivers = new VerticalToggleButton(i18n.t("dock.button.drivers"));
        _btnDrivers.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onDrivers();
            }
        });
        dockButtons.getChildren().add(_btnDrivers);

        ToggleGroup toggleGroup = new ToggleGroup();
        toggleGroup.getToggles().addAll(_btnDesigner, _btnDrivers, _btnAliases);
    }

    public Node getNode() {
        return dockButtons;
    }

    private void onDrivers() {
        DefaultEventBus.getInstance().publish(new DockButtonToggleEvent(DockButtonToggleEvent.Type.DRIVERS, _btnDrivers.isSelected()));
    }

    private void onAliases() {
        DefaultEventBus.getInstance().publish(new DockButtonToggleEvent(DockButtonToggleEvent.Type.ALIASES, _btnAliases.isSelected()));
    }

    private void onDesigner() {
        DefaultEventBus.getInstance().publish(new DockButtonToggleEvent(DockButtonToggleEvent.Type.DESIGNER, _btnDesigner.isSelected()));
    }
}
