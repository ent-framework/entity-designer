/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.frame;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import org.entframework.javafx.common.spring.FXMLController;
import org.entframework.javafx.databrowser.LogFileWrapper;
import org.entframework.javafx.databrowser.services.*;
import org.kordamp.ikonli.antdesignicons.AntDesignIconsOutlined;
import org.kordamp.ikonli.javafx.FontIcon;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@FXMLController
public class ShowLogsCtrl {

    public SplitPane root;
    @FXML
    private CheckBox chkFilterErrors;
    @FXML
    private CheckBox chkFilterWarnings;
    @FXML
    private CheckBox chkFilterInfo;
    @FXML
    private TextField txtLogDir;
    @FXML
    private Button btnOpenLogDir;
    @FXML
    private ListView<LogFileWrapper> lstLogs;
    @FXML
    private TextArea txtLogArea;
    private I18n _i18n = new I18n(getClass(), "org.entframework.javafx.databrowser.i18n");

    public void initialize() {
        // view.setTitle(_i18n.t("showLogsController.title"));
//        _dialog.initModality(Modality.WINDOW_MODAL);
//        _dialog.initOwner(AppState.get().getPrimaryStage());
        GuiUtils.makeEscapeClosable(root);
        // new StageDimensionSaver("showLogsController", _dialog, new Pref(getClass()), 300, 500, _dialog.getOwner());

        chkFilterErrors.setSelected(true);
        chkFilterErrors.setOnAction(e -> showLogFiles());

        chkFilterWarnings.setSelected(true);
        chkFilterWarnings.setOnAction(e -> showLogFiles());

        chkFilterInfo.setSelected(true);
        chkFilterInfo.setOnAction(e -> showLogFiles());

        txtLogDir.setText(Dao.getLogDir().getPath());

        //btnOpenLogDir.setGraphic(new Props(getClass()).getImageView(GlobalIconNames.FOLDER));
        btnOpenLogDir.setGraphic(FontIcon.of(AntDesignIconsOutlined.FOLDER_OPEN));
        btnOpenLogDir.setTooltip(new Tooltip(_i18n.t("showLogsController.btnOpenLogDir.tooltip")));
        btnOpenLogDir.setOnAction(e -> Utils.runOnSwingEDT(this::onOpenLogDir));

        txtLogArea.setEditable(false);

        lstLogs.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> onListSelectionChanged());

        showLogFiles();

        // AppState.get().addApplicationCloseListener(_dialog::close, ApplicationCloseListener.FireTime.AFTER_SESSION_FIRE_TIME);
    }

    private void showLogFiles() {
        java.util.List<LogFileWrapper> wrap = LogFileWrapper.wrap(Dao.getLogFiles());

        List<LogFileWrapper> filtered = CollectionUtil.filter(wrap, this::matchesFilter);

        lstLogs.getItems().clear();
        if (0 < filtered.size()) {
            lstLogs.getItems().addAll(filtered);
            lstLogs.getSelectionModel().selectFirst();
        }
    }

    private boolean matchesFilter(LogFileWrapper w) {
        if (!chkFilterErrors.isSelected() && w.getLogFile().getName().toLowerCase().contains("error")) {
            return false;
        }

        if (!chkFilterWarnings.isSelected() && w.getLogFile().getName().toLowerCase().contains("warning")) {
            return false;
        }

        if (!chkFilterInfo.isSelected() && w.getLogFile().getName().toLowerCase().contains("info")) {
            return false;
        }

        return true;
    }

    private void onListSelectionChanged() {
        try {
            LogFileWrapper selectedItem = lstLogs.getSelectionModel().getSelectedItem();
            if (null == selectedItem) {
                txtLogArea.setText("");
                return;
            }

            FileReader fr = new FileReader(selectedItem.getLogFile());

            BufferedReader br = new BufferedReader(fr);

            StringBuilder sb = new StringBuilder();

            String line = br.readLine();

            while (null != line) {
                sb.append(line).append('\n');
                line = br.readLine();
            }

            br.close();
            fr.close();

            txtLogArea.setText(sb.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void onOpenLogDir() {
        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(Dao.getLogDir());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
