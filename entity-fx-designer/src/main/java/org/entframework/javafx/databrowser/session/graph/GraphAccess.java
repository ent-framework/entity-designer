/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.control.Tab;
import javafx.util.Duration;
import org.entframework.javafx.databrowser.services.Dao;
import org.entframework.javafx.databrowser.session.SessionTabAccess;
import org.entframework.javafx.databrowser.session.SessionTabContext;

import java.util.List;

public class GraphAccess {
    private final SessionTabContext _sessionTabContext;
    private final SessionTabAccess _sessionTabAccess;

    public GraphAccess(SessionTabContext sessionTabContext, SessionTabAccess sessionTabAccess) {
        _sessionTabContext = sessionTabContext;
        _sessionTabAccess = sessionTabAccess;

        loadGraphTabs(Dao.loadGraphPersistences(_sessionTabContext.getSession().getAlias()));
    }

    public void onNewGraph() {
        loadGraphTab(new GraphPersistenceWrapper(), true);
    }

    private void loadGraphTabs(List<GraphPersistenceWrapper> graphPersistenceWrappers) {
        for (GraphPersistenceWrapper graphPersistenceWrapper : graphPersistenceWrappers) {
            loadGraphTab(graphPersistenceWrapper, false);
        }
    }

    private void loadGraphTab(GraphPersistenceWrapper graphPersistenceWrapper, boolean newGraph) {
        Tab tab = new Tab();

        GraphTabListener graphTabListener = new GraphTabListener() {
            @Override
            public void selectTab() {
                onSelectTab(tab);
            }

            @Override
            public void removeTab() {
                onRemoveTab(tab);
            }
        };

        GraphChannel graphChannel = new GraphChannel(graphTabListener);

        tab.setGraphic(new GraphTabHeaderCtrl(graphChannel, graphPersistenceWrapper.getTabTitle()).getGraphTabHeader());
        GraphPaneCtrl graphPaneCtrl = new GraphPaneCtrl(graphChannel, _sessionTabContext.getSession(), graphPersistenceWrapper);
        tab.setContent(graphPaneCtrl.getPane());

        _sessionTabAccess.addTab(tab, newGraph);

        Platform.runLater(() -> pushAddTableToolbarButton(newGraph, graphPaneCtrl));
    }

    private void pushAddTableToolbarButton(boolean newGraph, final GraphPaneCtrl graphPaneCtrl) {
        if (newGraph) {
            Timeline tl = new Timeline(new KeyFrame(Duration.millis(700), event -> graphPaneCtrl.pushAddTableBtn()));
            tl.setCycleCount(1);
            tl.play();
        }
    }

    private void onRemoveTab(Tab tab) {
        tab.getTabPane().getTabs().remove(tab);
    }

    private void onSelectTab(Tab tab) {
        tab.getTabPane().getSelectionModel().select(tab);
    }
}
