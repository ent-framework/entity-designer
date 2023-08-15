/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.aliases;

import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.apache.commons.lang3.StringUtils;
import org.entframework.javafx.databrowser.AppState;
import org.entframework.javafx.databrowser.services.FXMessageBox;
import org.entframework.javafx.databrowser.services.FxmlHelper;
import org.entframework.javafx.databrowser.services.GuiUtils;
import org.entframework.javafx.databrowser.services.I18n;

public class EditFolderNameCtrl {
    private EditFolderNameView _editFolderNameView;
    private TreePositionCtrl _treePositionCtrl;
    private I18n _i18n = new I18n(this.getClass());
    private Stage _dialog;
    private String _newFolderName;


    public EditFolderNameCtrl(boolean parentNodeSelected, boolean allowsChildern) {
        _init(parentNodeSelected, allowsChildern, null);
    }

    public EditFolderNameCtrl(String folderNameToEdit) {
        _init(false, false, folderNameToEdit);
    }

    private void _init(boolean parentNodeSelected, boolean allowsChildern, String folderNameToEdit) {
        FxmlHelper<EditFolderNameView> fxmlHelper = new FxmlHelper<>(EditFolderNameView.class);
        _editFolderNameView = fxmlHelper.getView();

        if (null == folderNameToEdit) {
            _treePositionCtrl = new TreePositionCtrl(_editFolderNameView.treePositionViewController, parentNodeSelected, allowsChildern);
        } else {
            _editFolderNameView.treePositionView.setDisable(true);
            _editFolderNameView.txtFolderName.setText(folderNameToEdit);
        }

        _editFolderNameView.btnOk.setOnAction(actionEvent -> onOk());
        _editFolderNameView.btnCancel.setOnAction(actionEvent -> onCancel());


        _dialog = new Stage();
        _dialog.initModality(Modality.WINDOW_MODAL);
        _dialog.setTitle(_i18n.t("aliastree.edit.folder.name.title"));
        _dialog.initOwner(AppState.get().getPrimaryStage());
        _dialog.setScene(new Scene(fxmlHelper.getRegion()));
        GuiUtils.makeEscapeClosable(fxmlHelper.getRegion());

        _dialog.showAndWait();
    }


    private void onCancel() {
        _dialog.close();
    }

    private void onOk() {
        String newFolderName = _editFolderNameView.txtFolderName.getText();
        if (StringUtils.isEmpty(newFolderName)) {
            FXMessageBox.showInfoOk(_dialog, _i18n.t("aliastree.edit.folder.please.enter"));
            return;
        }

        _newFolderName = newFolderName;

        _dialog.close();
    }

    public String getNewFolderName() {
        return _newFolderName;
    }


    public TreePositionCtrl getTreePositionCtrl() {
        return _treePositionCtrl;
    }
}
