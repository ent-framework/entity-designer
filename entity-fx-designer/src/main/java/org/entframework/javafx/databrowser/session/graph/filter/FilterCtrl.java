/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph.filter;

import javafx.stage.Stage;
import org.entframework.javafx.databrowser.services.FxmlHelper;
import org.entframework.javafx.databrowser.services.GuiUtils;
import org.entframework.javafx.databrowser.services.Pref;
import org.entframework.javafx.databrowser.services.Utils;
import org.entframework.javafx.databrowser.session.ColumnInfo;
import org.entframework.javafx.databrowser.session.graph.FilterPersistence;
import org.entframework.javafx.databrowser.session.graph.Operator;
import org.entframework.javafx.databrowser.session.graph.QueryChannel;

public class FilterCtrl {

    private final Stage _dlg;
    private final FilterView _view;
    private final FilterValueCtrl _filterValueCtrl;
    private FilterPersistence _filterPersistence;
    private QueryChannel _queryChannel;

    public FilterCtrl(FilterPersistence filterPersistence, ColumnInfo columnInfo, QueryChannel queryChannel) {
        FxmlHelper<FilterView> fxmlHelper = new FxmlHelper(FilterView.class);
        _view = fxmlHelper.getView();

        _dlg = GuiUtils.createModalDialog(fxmlHelper.getRegion(), new Pref(getClass()), 470, 210, "FilterCtrl");

        _dlg.setTitle(columnInfo.getQualifiedTableColumnName());


        _filterPersistence = filterPersistence;
        _queryChannel = queryChannel;
        _filterValueCtrl = FilterValueCtrlFactory.getCtrl(columnInfo, _view.bpValueContainer, _view.btnDate, _view.lblEncloseApostrophes, _dlg, _view.cboOperator);

        _view.cboOperator.getItems().addAll(Operator.values());
        _view.cboOperator.getSelectionModel().select(Operator.valueOf(filterPersistence.getOperatorAsString()));

        _view.cboOperator.valueProperty().addListener((observable, oldValue, newValue) -> onOperatorChanged());
        onOperatorChanged();

        _filterValueCtrl.setFilterValueString(filterPersistence.getFilter());

        _view.btnCancel.setCancelButton(true);
        _view.btnOk.setDefaultButton(true);

        _view.btnCancel.setOnAction(e -> onCancel());
        _view.btnOk.setOnAction(e -> onOk());


        onOperatorChanged();

        _dlg.showAndWait();
    }

    private void onOperatorChanged() {
        Operator value = _view.cboOperator.getValue();
        _filterValueCtrl.setDisable(!value.requiresValue());
    }

    private void onOk() {
        String text = _filterValueCtrl.getFilterValueString();

        if (Utils.isEmptyString(text)) {
            _filterPersistence.setFilter(null);
        } else {
            _filterPersistence.setFilter(text);
        }

        Operator selectedItem = _view.cboOperator.getSelectionModel().getSelectedItem();
        _filterPersistence.setOperatorAsString(selectedItem.name());
        _dlg.close();

        _queryChannel.fireChanged();
    }

    private void onCancel() {
        _dlg.close();
    }
}
