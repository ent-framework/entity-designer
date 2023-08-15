/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.settings;

import javafx.stage.Stage;
import javafx.stage.Window;
import org.entframework.javafx.databrowser.services.FxmlHelper;
import org.entframework.javafx.databrowser.services.GuiUtils;
import org.entframework.javafx.databrowser.services.I18n;
import org.entframework.javafx.databrowser.services.Pref;

import java.util.Arrays;
import java.util.List;

public class SettingsDialogCtrl {
    private final Stage _dialog;
    private final Pref _pref;
    private final SettingsDialogView _settingsDialogView;
    private I18n _i18n = new I18n(getClass());
    private List<SettingsTabCtrl> _settingsTabCtrls = Arrays.asList(new GeneralCtrl(), new SQLReformatCtrl());


    public SettingsDialogCtrl() {
        _pref = new Pref(getClass());

        FxmlHelper<SettingsDialogView> fxmlHelper = new FxmlHelper<>(SettingsDialogView.class);

        _settingsDialogView = fxmlHelper.getView();

        _dialog = GuiUtils.createNonModalDialog(fxmlHelper.getRegion(), _pref, 1000, 800, "showSettingsController");

        _dialog.setTitle(_i18n.t("showSettings.title"));

        _settingsTabCtrls.forEach(c -> loadTab(c));

        _settingsDialogView.btnOk.setOnAction((e) -> onOk());
        _settingsDialogView.btnCancel.setOnAction((e) -> onCancel());

        _dialog.show();
    }

    private void loadTab(SettingsTabCtrl settingsTabCtrl) {
        settingsTabCtrl.setSettingsContext(new SettingsContext() {
            @Override
            public Window getDialog() {
                return _dialog;
            }
        });

        _settingsDialogView.tabPaneSettings.getTabs().add(settingsTabCtrl.getTab());
    }


    private void onCancel() {
        _dialog.close();
    }

    private void onOk() {
        _settingsTabCtrls.forEach(c -> c.saveSettings());
        _dialog.close();
    }

}
