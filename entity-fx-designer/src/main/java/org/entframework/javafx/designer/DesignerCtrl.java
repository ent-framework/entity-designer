/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.designer;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Window;
import org.entframework.javafx.common.event.DefaultEventBus;
import org.entframework.javafx.common.event.DockButtonToggleEvent;
import org.entframework.javafx.common.event.MessagePanelEvent;
import org.entframework.javafx.common.spring.*;
import org.entframework.javafx.databrowser.AppState;
import org.entframework.javafx.databrowser.services.*;
import org.entframework.javafx.designer.control.TabWithSpringView;
import org.kordamp.ikonli.antdesignicons.AntDesignIconsOutlined;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignP;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

@FXMLController
public class DesignerCtrl extends AbstractFxmlCtrl {
    private static final String PREF_DESIGNER_PINED = "designer.pinned";
    private final I18n _i18n = new I18n(this.getClass());
    private final Pref _prefs = new Pref(this.getClass());

    @FXML
    private BorderPane borderPane;
    private ToggleButton _btnPinned;

    @Autowired
    private LanguageBindingView languageBindingView;

    public DesignerCtrl() {
    }

    /**
     * Called by JavaFX when FXML is loaded.
     */
    public void initialize() {
        borderPane.setTop(createToolBar());
        _btnPinned.setSelected(_prefs.getBoolean(PREF_DESIGNER_PINED, false));
        onPinnedChanged();
    }

    private BorderPane createToolBar() {
        DockToolbarBuilder dockToolbarBuilder = new DockToolbarBuilder();


        dockToolbarBuilder.addButtonLeft(FontIcon.of(AntDesignIconsOutlined.PLUS), _i18n.t("tooltip.create")).setOnAction(e -> onCreate());
        dockToolbarBuilder.addButtonLeft(FontIcon.of(AntDesignIconsOutlined.FOLDER_OPEN), _i18n.t("tooltip.open")).setOnAction(e -> onOpen());
        dockToolbarBuilder.addButtonLeft(FontIcon.of(AntDesignIconsOutlined.SETTING), _i18n.t("tooltip.language-binding")).setOnAction(e -> onShowLanguageBinding());

        _btnPinned = dockToolbarBuilder.addToggleButtonRight(FontIcon.of(MaterialDesignP.PIN_OFF_OUTLINE), _i18n.t("tooltip.pinned"));
        _btnPinned.setOnAction(e -> onPinnedChanged());

        dockToolbarBuilder.addButtonRight(FontIcon.of(AntDesignIconsOutlined.NODE_COLLAPSE), _i18n.t("tooltip.close")).setOnAction(e -> {
            DefaultEventBus.getInstance().publish(new DockButtonToggleEvent(DockButtonToggleEvent.Type.DESIGNER, false));
        });

        return dockToolbarBuilder.getToolbarPane();
    }

    private void onShowLanguageBinding() {
        languageBindingView.showViewAndWait(GUIState.getStage(), Modality.WINDOW_MODAL, _i18n.t("showLanguageBinding.title"), true, "showLanguageBinding");
    }

    private void onOpen() {
        final File file = showFileChooser(GUIState.getScene().getWindow());
        if (file != null && file.exists() && file.isFile()) {
            //添加一个Tab

            try {
                AbstractFxmlView view = SpringUtil.getBean(DesignerTabView.class);
                TabWithSpringView tab = new TabWithSpringView(view);
                DesignerTabCtrl designerTabController = (DesignerTabCtrl) view.getPresenter();
                designerTabController.loadFromFile(file);
                tab.setClosable(true);
                tab.setText(file.getName());
                tab.setOnClosed(event -> designerTabController.clearListener());
                AppState.get().getSessionManager().getSessionTabbedPaneCtrl().addTab(tab);

                if (!_btnPinned.isSelected()) {
                    DefaultEventBus.getInstance().publish(new DockButtonToggleEvent(DockButtonToggleEvent.Type.DESIGNER, false));
                }
            } catch (Exception ex) {
                MessageHandler handler = new MessageHandler(DesignerCtrl.class, MessageHandlerDestination.MESSAGE_LOG_AND_PANEL);
                handler.error(ex.getMessage(), ex.getCause());
            }

        }
    }

    private File showFileChooser(final Window window) {
        final FileChooser fileChooser = new FileChooser();
        final FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter(GraphEditorPersistence.CHOOSER_TEXT, "*" + GraphEditorPersistence.FILE_EXTENSION); //$NON-NLS-1$
        fileChooser.getExtensionFilters().add(filter);
        // ELSE:
        return fileChooser.showOpenDialog(window);
    }

    private void onCreate() {
        //添加一个Tab
        AbstractFxmlView view = SpringUtil.getBean(DesignerTabView.class);
        TabWithSpringView tab = new TabWithSpringView(view);
        DesignerTabCtrl designerTabController = (DesignerTabCtrl) view.getPresenter();
        tab.setClosable(true);
        tab.setText("Untiled" + GraphEditorPersistence.FILE_EXTENSION);
        tab.setOnClosed(event -> designerTabController.clearListener());
        tab.setModified(true);
        AppState.get().getSessionManager().getSessionTabbedPaneCtrl().addTab(tab);

        if (!_btnPinned.isSelected()) {
            DefaultEventBus.getInstance().publish(new DockButtonToggleEvent(DockButtonToggleEvent.Type.DESIGNER, false));
        }
    }

    private void onPinnedChanged() {
        if (_btnPinned.isSelected()) {
            _btnPinned.setGraphic(FontIcon.of(MaterialDesignP.PIN_OUTLINE));
        } else {
            _btnPinned.setGraphic(FontIcon.of(MaterialDesignP.PIN_OFF_OUTLINE));
        }

        _prefs.set(PREF_DESIGNER_PINED, _btnPinned.isSelected());
    }
}
