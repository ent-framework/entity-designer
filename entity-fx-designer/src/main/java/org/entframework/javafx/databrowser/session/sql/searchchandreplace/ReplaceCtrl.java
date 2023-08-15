/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql.searchchandreplace;

import javafx.scene.layout.BorderPane;
import org.entframework.javafx.databrowser.services.EditableComboCtrl;
import org.entframework.javafx.databrowser.services.FxmlHelper;
import org.entframework.javafx.databrowser.session.action.StdActionCfg;
import org.entframework.javafx.databrowser.session.sql.SQLTextAreaServices;

public class ReplaceCtrl {
    private BorderPane _borderPane;
    private SQLTextAreaServices _sqlTextAreaServices;
    private EditableComboCtrl _editableComboCtrl;
    private SearchCtrl _searchCtrl;

    public ReplaceCtrl(BorderPane borderPane, SQLTextAreaServices sqlTextAreaServices) {
        _borderPane = borderPane;
        _sqlTextAreaServices = sqlTextAreaServices;
        StdActionCfg.REPLACE_IN_TEXT.setAction(this::onOpenReplace);

    }

    private void onOpenReplace() {
        FxmlHelper<ReplaceView> fxmlHelper = new FxmlHelper<>(ReplaceView.class);

        ReplaceView view = fxmlHelper.getView();
        _searchCtrl = SearchCtrl.create(_borderPane, _sqlTextAreaServices, view.searchViewController);

        _editableComboCtrl = new EditableComboCtrl(view.cboReplaceText, getClass().getName(), null);

        view.btnReplace.setOnAction(e -> onReplace(false));
        view.btnExclude.setOnAction(e -> _searchCtrl.findNext());
        view.btnReplaceAll.setOnAction(e -> onReplaceAll());

        _borderPane.setTop(fxmlHelper.getRegion());
    }

    private void onReplaceAll() {
        onReplace(false);

        while (onReplace(true))
            ;

    }

    private boolean onReplace(boolean inReplaceAllLoop) {

        if (false == inReplaceAllLoop) {
            _editableComboCtrl.addCurrentTextToHistory();
        }


        if (false == _searchCtrl.isFoundPositionSelected()) {
            _searchCtrl.findNext();
            return false;
        }

        _sqlTextAreaServices.replaceSelection(_editableComboCtrl.getText(), false);

        if (inReplaceAllLoop && _sqlTextAreaServices.getTextArea().getSelectedText().length() < _editableComboCtrl.getText().length()) {
            // This is to prevent endless loops when onReplaceAll() is executed and a string like '12' is replaced by '1212'
            _searchCtrl.increaseNextStartPosBy(_editableComboCtrl.getText().length() - _sqlTextAreaServices.getTextArea().getSelectedText().length());
        }
        _searchCtrl.findNext();
        return false == _searchCtrl.isEOFReached();
    }


}
