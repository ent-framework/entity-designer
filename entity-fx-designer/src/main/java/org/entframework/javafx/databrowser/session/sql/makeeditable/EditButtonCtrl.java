/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql.makeeditable;

import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;
import org.entframework.javafx.databrowser.Props;
import org.entframework.javafx.databrowser.globalicons.GlobalIconNames;
import org.entframework.javafx.databrowser.services.I18n;
import org.entframework.javafx.databrowser.session.Session;
import org.entframework.javafx.databrowser.session.sql.SQLResult;
import org.entframework.javafx.databrowser.table.TableState;
import org.entframework.javafx.databrowser.table.tableedit.EditableTableCtrl;

public class EditButtonCtrl {
    private final EditableSqlCheck _editableSqlCheck;
    private I18n _i18n = new I18n(getClass());
    private ToggleButton _btnEdit;
    private EditableTableCtrl _editableTableCtrl;
    private Session _session;
    private MenuItem _mnuDeleteRows;


    public EditButtonCtrl(Session session, String sql) {
        _session = session;
        _btnEdit = new ToggleButton();
        _btnEdit.setTooltip(new Tooltip(_i18n.t("outputtab.edit.result")));
        _btnEdit.setGraphic(new Props(getClass()).getImageView(GlobalIconNames.EDIT));

        _editableSqlCheck = new EditableSqlCheck(sql);

        _btnEdit.setDisable(false == _editableSqlCheck.allowsEditing());

        _btnEdit.setOnAction(e -> onEditableChanged());
    }

    private void onEditableChanged() {
        _editableTableCtrl.setEditable(_btnEdit.isSelected());

        _mnuDeleteRows.setDisable(!_btnEdit.isSelected());

    }

    public ToggleButton getEditButton() {
        return _btnEdit;
    }

    public boolean allowsEditing() {
        return _editableSqlCheck.allowsEditing();
    }

    public void displayAndPrepareEditing(SQLResult sqlResult, TableView tv, TableState tableState) {
        _editableTableCtrl = new EditableTableCtrl(_session, sqlResult, tv, tableState, _editableSqlCheck.getTableNameFromSQL());
    }

    public void deleteSelectedRows() {
        _editableTableCtrl.deleteSelectedRows();
    }

    public void setDeleteRowsMenuItem(MenuItem mnuDeleteRows) {
        _mnuDeleteRows = mnuDeleteRows;
        _mnuDeleteRows.setDisable(true);
    }
}
