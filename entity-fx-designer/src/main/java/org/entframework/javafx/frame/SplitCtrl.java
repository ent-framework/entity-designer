/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.frame;

import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.SplitPane;
import org.entframework.javafx.common.event.DefaultEventBus;
import org.entframework.javafx.common.event.DockButtonToggleEvent;
import org.entframework.javafx.common.spring.AbstractFxmlCtrl;
import org.entframework.javafx.common.spring.FXMLController;
import org.entframework.javafx.databrowser.AppState;
import org.entframework.javafx.databrowser.aliases.AliasesView;
import org.entframework.javafx.databrowser.drivers.DriversView;
import org.entframework.javafx.databrowser.services.Pref;
import org.entframework.javafx.databrowser.services.SplitPositionSaver;
import org.entframework.javafx.designer.DesignerView;
import org.entframework.javafx.frame.MessagePanelView;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Consumer;

@FXMLController
public class SplitCtrl extends AbstractFxmlCtrl {
    private final SplitPane _spltHoriz = new SplitPane();
    private final SplitPositionSaver driverSplitPosSaver = new SplitPositionSaver(getClass(), "driver.split.loc");
    private final SplitPositionSaver aliasSplitPosSaver = new SplitPositionSaver(getClass(), "aliases.split.loc");
    private final SplitPositionSaver designerSplitPosSaver = new SplitPositionSaver(getClass(), "designer.split.loc");
    private final SplitPositionSaver messageSplitPosSaver = new SplitPositionSaver(getClass(), "messages.split.loc");

    @FXML
    private SplitPane rootSpltVert;

    @Autowired
    private DriversView driversView;
    @Autowired
    private AliasesView aliasesView;
    @Autowired
    private DesignerView designerView;
    @Autowired
    private MessagePanelView messagePanelView;

    public void initialize() {

        _spltHoriz.setOrientation(Orientation.HORIZONTAL);
        _spltHoriz.getItems().add(AppState.get().getSessionManager().getSessionTabbedPaneCtrl().getNode());

        rootSpltVert.setOrientation(Orientation.VERTICAL);
        rootSpltVert.getItems().add(_spltHoriz);
        rootSpltVert.getItems().add(messagePanelView.getView());

        DefaultEventBus.getInstance().subscribe(DockButtonToggleEvent.class, dockButtonToggleEvent -> {
            switch (dockButtonToggleEvent.getType()) {
                case DRIVERS -> onShowDrivers(dockButtonToggleEvent.isSelected());
                case ALIASES -> onShowAliases(dockButtonToggleEvent.isSelected());
                case DESIGNER -> onShowDesigner(dockButtonToggleEvent.isSelected());
            }
        });
    }

    private void onShowDrivers(boolean selected) {
        checkRemove();
        if (selected) {
            _spltHoriz.getItems().add(0, driversView.getView());
            driverSplitPosSaver.apply(_spltHoriz);
        }
    }

    private void onShowAliases(boolean selected) {
        checkRemove();
        if (selected) {
            _spltHoriz.getItems().add(0, aliasesView.getView());
            aliasSplitPosSaver.apply(_spltHoriz);
        }
    }

    private void onShowDesigner(boolean selected) {
        checkRemove();
        if (selected) {
            _spltHoriz.getItems().add(0, designerView.getView());
            aliasSplitPosSaver.apply(_spltHoriz);
        }
    }

    private void checkRemove() {
        if (_spltHoriz.getItems().get(0) == driversView.getView()) {
            driverSplitPosSaver.save(_spltHoriz);
            _spltHoriz.getItems().remove(0);
        }

        if (_spltHoriz.getItems().get(0) == aliasesView.getView()) {
            aliasSplitPosSaver.save(_spltHoriz);
            _spltHoriz.getItems().remove(0);
        }

        if (_spltHoriz.getItems().get(0) == designerView.getView()) {
            designerSplitPosSaver.save(_spltHoriz);
            _spltHoriz.getItems().remove(0);
        }
    }


    public Node getNode() {
        return rootSpltVert;
    }

    public void close() {
        checkRemove();
        messageSplitPosSaver.save(rootSpltVert);
    }

    public void adjustMessageSplit() {
        messageSplitPosSaver.applyInvertedDefault(rootSpltVert);
    }
}
