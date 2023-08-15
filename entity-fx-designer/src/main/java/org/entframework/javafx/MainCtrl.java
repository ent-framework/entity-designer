/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.apache.commons.lang3.StringUtils;
import org.entframework.javafx.common.Resources;
import org.entframework.javafx.common.spring.AbstractFxmlCtrl;
import org.entframework.javafx.common.spring.FXMLController;
import org.entframework.javafx.common.spring.GUIState;
import org.entframework.javafx.common.theme.ThemeManager;
import org.entframework.javafx.common.utils.I18N;
import org.entframework.javafx.databrowser.*;
import org.entframework.javafx.databrowser.services.*;
import org.entframework.javafx.databrowser.session.SessionManagerListener;
import org.entframework.javafx.databrowser.session.SessionTabContext;
import org.entframework.javafx.databrowser.settings.SettingsDialogCtrl;
import org.entframework.javafx.frame.ShowLogsView;
import org.entframework.javafx.frame.SplitCtrl;
import org.entframework.javafx.frame.SplitView;
import org.entframework.javafx.frame.StatusBarView;
import org.springframework.beans.factory.annotation.Autowired;

@FXMLController
public class MainCtrl extends AbstractFxmlCtrl {

    public BorderPane mainPane;
    public MenuBar menuBar;

    public Menu languageMenu;
    public Menu themeSettingMenu;
    public Menu sessionMenu;
    @FXML
    private RadioMenuItem themePrimerLightButton;
    @FXML
    private RadioMenuItem themePrimerDarkButton;
    @FXML
    private RadioMenuItem themeNordLightButton;
    @FXML
    private RadioMenuItem themeNordDarkButton;
    @FXML
    private RadioMenuItem themeCupertinoLightButton;
    @FXML
    private RadioMenuItem themeCupertinoDarkButton;
    @FXML
    private RadioMenuItem themeDraculaButton;

    private final I18n i18n = new I18n(getClass(), "org.entframework.javafx.databrowser.i18n");
    private final Pref pref = new Pref(getClass());

    @Autowired
    private SplitView splitView;
    @Autowired
    private StatusBarView statusBarView;
    @Autowired
    private DockButtonsView dockButtonsView;
    @Autowired
    private ShowLogsView showLogsView;
    private SplitCtrl _splitController;

    public void initialize() {

        mainPane.setCenter(splitView.getView());
        _splitController = (SplitCtrl) splitView.getPresenter();

        Node dockButtons = dockButtonsView.getView();
        mainPane.setLeft(dockButtons);

        mainPane.setBottom(statusBarView.getView());

        createMenuBar();

        adjustMessageSplit();

        final StageDimensionSaver dimensionSaver = new StageDimensionSaver("main", GUIState.getStage(), pref, 1000d, 800d, null);
        //注册关闭事件
        GUIState.getStage().setOnCloseRequest(windowEvent -> onClose(dimensionSaver));
    }

    private void createMenuBar() {

        sessionMenu.setDisable(true);
        AppState.get().getSessionManager().addSessionManagerListener(new SessionManagerListener() {
            @Override
            public void contextActiveOrActivating(SessionTabContext sessionTabContext) {
                AppState.get().getActionManager().onContextActiveOrActivating(sessionTabContext, sessionMenu);
            }

            @Override
            public void contextClosing(SessionTabContext sessionTabContext) {
                AppState.get().getActionManager().onContextClosing(sessionTabContext);
            }
        });

        final ToggleGroup themeGroup = new ToggleGroup();
        themeGroup.getToggles().addAll(themePrimerLightButton, themePrimerDarkButton);
        themeGroup.getToggles().addAll(themeNordLightButton, themeNordDarkButton);
        themeGroup.getToggles().addAll(themeCupertinoLightButton, themeCupertinoDarkButton);
        themeGroup.getToggles().add(themeDraculaButton);

        themeGroup.getToggles().forEach(toggle -> {
            if (toggle instanceof RadioMenuItem radioMenuItem) {
                String theme = Resources.getPreferences().get("theme", ThemeManager.getInstance().getDefaultTheme().getName());
                if (StringUtils.equals(theme, radioMenuItem.getText())) {
                    radioMenuItem.setSelected(true);
                }
            }
        });


        themeGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue instanceof RadioMenuItem radioMenuItem) {
                ThemeManager.getInstance().setThemeByName(radioMenuItem.getText());
            }
        });


        final ToggleGroup languageGroup = new ToggleGroup();

        I18N.getSupportedLocales().forEach(locale -> {
            RadioMenuItem radioMenuItem = new RadioMenuItem();
            radioMenuItem.setId(locale.getDisplayName());
            radioMenuItem.setText(locale.getDisplayName());
            if (locale.equals(I18N.getLocale())) {
                radioMenuItem.setSelected(true);
            }
            languageMenu.getItems().add(radioMenuItem);
            radioMenuItem.selectedProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null && newValue) {
                    FXMessageBox.showInfoOk(GUIState.getStage(), i18n.t("tooltip.language.switch"));
                    pref.set("locale", locale.toString());
                    saveSettings();
                }
            });
            languageGroup.getToggles().addAll(radioMenuItem);
        });
    }

    @FXML
    private void showLogs() {
        showLogsView.showViewAndWait(GUIState.getStage(), Modality.WINDOW_MODAL, i18n.t("showLogsController.title"));
    }

    @FXML
    private void showSettings() {
        new SettingsDialogCtrl();
    }

    @FXML
    private void onExit() {
        Stage primaryStage = GUIState.getStage();
        primaryStage.fireEvent(new WindowEvent(primaryStage, WindowEvent.WINDOW_CLOSE_REQUEST));
    }

    @FXML
    private void saveSettings() {
        AppState.get().fireSaveSettings();
        AppState.get().getPrefImpl().flush();
        new MessageHandler(getClass(), MessageHandlerDestination.MESSAGE_PANEL).info(i18n.t("main.save.settings.complete"));
    }

    private void onClose(StageDimensionSaver dimensionSaver) {
        AppState.get().fireApplicationClosing();
        _splitController.close();

        dimensionSaver.save(); // Needed because we are going to exit

        //////////////////////////////////////////////////////////////////////////////////////////////////
        // Done after fire closing because during fire close open sessions add their new SQL history
        // entries. These have to be saved too.
        //
        // Whenever we run into problems with this handling please consider SQL history when the
        // application is closed while Sessions are open
        saveSettings();
        //
        ////////////////////////////////////////////////////////////////////////////////////

        Platform.exit();
        System.exit(0);
    }

    private void adjustMessageSplit() {
        Runnable runnable = new Runnable() {
            public void run() {
                _splitController.adjustMessageSplit();
            }
        };

        Platform.runLater(runnable);
    }

    public void showAbout(ActionEvent actionEvent) {
        new AboutCtrl();
    }
}
