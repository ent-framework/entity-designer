/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql;

import javafx.collections.transformation.FilteredList;
import javafx.scene.Node;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Region;
import org.entframework.javafx.databrowser.AppState;
import org.entframework.javafx.databrowser.Props;
import org.entframework.javafx.databrowser.services.*;
import org.entframework.javafx.databrowser.session.Session;

public class SQLEditTopPanelCtrl {
    public static final int DEFAULT_ROW_LIMIT_COUNT = 100;
    private static final String LIMIT_ROWS = "sql.limit.rows";
    private static final String LIMIT_ROWS_COUNT = "sql.limit.rows.count";
    private final I18n _i18n = new I18n(getClass());
    private final SQLEditTopPanelView _view;
    private final Region _region;
    private Pref _pref = new Pref(getClass());
    private SQLTextAreaServices _sqlTextAreaServices;

    private boolean _dontReactToCboChanges;

    public SQLEditTopPanelCtrl(SQLTextAreaServices sqlTextAreaServices, Session session) {
        _sqlTextAreaServices = sqlTextAreaServices;
        FxmlHelper<SQLEditTopPanelView> fxmlHelper = new FxmlHelper<>(SQLEditTopPanelView.class);

        _view = fxmlHelper.getView();

        _region = fxmlHelper.getRegion();

        Settings settings = AppState.get().getSettingsManager().getSettings();
        _view.chkLimitRows.setSelected(settings.isLimitRowsByDefault());
        _view.txtRowLimit.setText("" + settings.getLimitRowsDefault());

        _view.btnOpenHistory.setGraphic(new Props(this.getClass()).getImageView("sql_history.png"));
        _view.btnOpenHistory.setTooltip(new Tooltip(_i18n.t("sqlhistory.search")));

        _view.btnOpenHistory.setOnAction(e -> new SQLHistorySearchCtrl(_sqlTextAreaServices, session, _view.cboLatestSqls.getItems()));

        _view.btnAppendToEditor.setGraphic(new Props(this.getClass()).getImageView("to_editor.png"));
        _view.btnAppendToEditor.setTooltip(new Tooltip(_i18n.t("sqlhistory.append.to.editor")));


        _view.cboLatestSqls.getItems().addAll(AppState.get().getSqlHistoryManager().getHistory());
        if (0 < _view.cboLatestSqls.getItems().size()) {
            _view.cboLatestSqls.getSelectionModel().selectFirst();
        }
        _view.btnAppendToEditor.setOnAction(e -> onAppendToEditor());
        _view.cboLatestSqls.setOnAction(e -> onAppendToEditor());


        Utils.makePositiveIntegerField(_view.txtRowLimit);

        onChkRowLimitChanged();

        _view.chkLimitRows.setOnAction(event -> onChkRowLimitChanged());

    }

    private void onAppendToEditor() {
        if (_dontReactToCboChanges) {
            return;
        }


        SQLHistoryEntry selectedItem = _view.cboLatestSqls.getSelectionModel().getSelectedItem();

        if (null == selectedItem) {
            return;
        }

        if (Utils.isEmptyString(_sqlTextAreaServices.getTextArea().getText())) {
            _sqlTextAreaServices.appendToEditor(selectedItem.getSql());
        } else {
            _sqlTextAreaServices.appendToEditor("\n" + selectedItem.getSql());

        }

        _sqlTextAreaServices.requestFocus();
    }

    private void onChkRowLimitChanged() {
        _view.txtRowLimit.setDisable(!_view.chkLimitRows.isSelected());
    }

    public Node getView() {
        return _region;
    }

    public void close() {
        _pref.set(LIMIT_ROWS, _view.chkLimitRows.isSelected());
        _pref.set(LIMIT_ROWS_COUNT, _getRowLimit());

        FilteredList<SQLHistoryEntry> newEntries = _view.cboLatestSqls.getItems().filtered(sh -> sh.isNew());

        AppState.get().getSqlHistoryManager().addAll(newEntries);
    }

    private int _getRowLimit() {
        String intText = _view.txtRowLimit.getText();
        if (Utils.isEmptyString(intText)) {
            return DEFAULT_ROW_LIMIT_COUNT;
        } else {
            return Integer.parseInt(intText);
        }
    }

    public Integer getRowLimit() {
        if (_view.chkLimitRows.isSelected()) {
            return _getRowLimit();
        }

        return null;
    }

    public void addSqlToHistory(String sql, String aliasName) {
        SQLHistoryEntry buf = new SQLHistoryEntry(sql, aliasName);

        try {
            _dontReactToCboChanges = true;
            _view.cboLatestSqls.getItems().remove(buf);

            _view.cboLatestSqls.getItems().add(0, buf);
            _view.cboLatestSqls.getSelectionModel().selectFirst();
        } finally {
            _dontReactToCboChanges = false;
        }
    }
}
