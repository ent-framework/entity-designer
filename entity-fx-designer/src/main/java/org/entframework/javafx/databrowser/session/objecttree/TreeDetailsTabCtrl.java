/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.objecttree;

import javafx.scene.control.Tab;
import javafx.scene.layout.StackPane;
import org.entframework.javafx.databrowser.session.sql.TableDecorator;
import org.entframework.javafx.databrowser.table.TableLoader;

public class TreeDetailsTabCtrl {
    private final Tab _tab;
    private boolean _loaded;

    public TreeDetailsTabCtrl(String tabName, ObjectTreeTableLoaderFactory objectTreeTableLoaderFactory) {
        _tab = new Tab(tabName);
        _tab.setClosable(false);

        _tab.tabPaneProperty().addListener((observable, oldValue, newValue) -> onSelected(objectTreeTableLoaderFactory));
        _tab.setOnSelectionChanged(event -> onSelected(objectTreeTableLoaderFactory));
    }

    private void onSelected(ObjectTreeTableLoaderFactory objectTreeTableLoaderFactory) {
        if (_tab.isSelected() && false == _loaded) {
            TableLoader tableLoader = objectTreeTableLoaderFactory.createTableLoader();

            StackPane stackPane = TableDecorator.decorateNonSqlEditableTable(tableLoader);

            _tab.setContent(stackPane);
            _loaded = true;
        }
    }

    public Tab getTab() {
        return _tab;
    }
}
