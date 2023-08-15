/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.drivers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.entframework.javafx.common.event.DefaultEventBus;
import org.entframework.javafx.common.event.DockButtonToggleEvent;
import org.entframework.javafx.common.spring.AbstractFxmlCtrl;
import org.entframework.javafx.common.spring.FXMLController;
import org.entframework.javafx.databrowser.AppState;
import org.entframework.javafx.databrowser.PreDefinedDrivers;
import org.entframework.javafx.databrowser.Props;
import org.entframework.javafx.databrowser.services.DockToolbarBuilder;
import org.entframework.javafx.databrowser.services.FXMessageBox;
import org.entframework.javafx.databrowser.services.I18n;
import org.entframework.javafx.databrowser.services.Pref;
import org.kordamp.ikonli.antdesignicons.AntDesignIconsOutlined;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.kordamp.ikonli.materialdesign2.MaterialDesignF;

@FXMLController
public class DriversCtrl extends AbstractFxmlCtrl {
    private final static Node _driverLoadedImage = FontIcon.of(AntDesignIconsOutlined.LINK, Color.GREEN);
    private final static Node _driverNotLoadedImage = FontIcon.of(MaterialDesignA.ALERT_DECAGRAM_OUTLINE, Color.RED);
    private static Props _props = new Props(DriversCtrl.class);
    @FXML
    private BorderPane borderPane;
    private I18n _i18n = new I18n(this.getClass());
    private Pref _pref = new Pref(this.getClass());
    private ListView<SQLDriver> _lstDrivers = new ListView();
    private DriversManager driversManager;
    private ToggleButton _btnFilter;

    public static Node getDriverloadedimage() {
        return _driverLoadedImage;
    }

    public static Node getDrivernotloadedimage() {
        return _driverNotLoadedImage;
    }

    public void initialize() {
        borderPane.setTop(createToolBar());
        borderPane.setCenter(_lstDrivers);

        driversManager = new DriversManager();

        _btnFilter.setSelected(DriversFilteredPref.isFiltered());
        onFilter();

        _lstDrivers.setCellFactory(cf -> new DriverCell());

        if (0 < _lstDrivers.getItems().size()) {
            _lstDrivers.getSelectionModel().select(0);
        }

        AppState.get().addSaveSettingsListener(this::onSaveSettings);
    }

    private void onSaveSettings() {
        driversManager.saveDrivers();
    }

    private BorderPane createToolBar() {
        DockToolbarBuilder dockToolbarBuilder = new DockToolbarBuilder();

        dockToolbarBuilder.addButtonLeft(FontIcon.of(AntDesignIconsOutlined.PLUS), _i18n.t("tooltip.add")).setOnAction(e -> onAdd());
        dockToolbarBuilder.addButtonLeft(FontIcon.of(AntDesignIconsOutlined.DELETE), _i18n.t("tooltip.remove")).setOnAction(e -> onRemove());
        dockToolbarBuilder.addButtonLeft(FontIcon.of(AntDesignIconsOutlined.EDIT), _i18n.t("tooltip.edit")).setOnAction(e -> onEdit());

        _btnFilter = dockToolbarBuilder.addToggleButtonLeft(FontIcon.of(MaterialDesignF.FILTER_OUTLINE), _i18n.t("tooltip.filter"));
        _btnFilter.setOnAction(e -> onFilter());

        dockToolbarBuilder.addButtonRight(FontIcon.of(AntDesignIconsOutlined.NODE_COLLAPSE), _i18n.t("tooltip.close")).setOnAction(e -> {
            DefaultEventBus.getInstance().publish(new DockButtonToggleEvent(DockButtonToggleEvent.Type.DRIVERS, false));
        });

        return dockToolbarBuilder.getToolbarPane();
    }

    private void onAdd() {
        SQLDriver newDriver = new SQLDriver();
        DriverEditCtrl driverEditCtrl = new DriverEditCtrl(newDriver);

        if (driverEditCtrl.isOk()) {
            newDriver.update(driverEditCtrl.getDriver());
            _lstDrivers.getItems().add(newDriver);
            _lstDrivers.getSelectionModel().select(newDriver);
            _lstDrivers.scrollTo(_lstDrivers.getItems().size() - 1);

            driversManager.add(newDriver);
        }
    }

    private void onRemove() {
        SQLDriver selectedItem = _lstDrivers.getSelectionModel().getSelectedItem();
        int selIx = _lstDrivers.getSelectionModel().getSelectedIndex();

        Stage stage = AppState.get().getPrimaryStage();

        if (null == selectedItem) {
            FXMessageBox.showInfoOk(stage, _i18n.t("driver.delete.noselection.message"));
            return;
        }


        if (selectedItem.isSquirrelPredefinedDriver()) {
            String delMsg = _i18n.t("predef.driver.delete.message");
            String optRevert = _i18n.t("predef.driver.revert");

            String selOpt = FXMessageBox.showMessageBox(stage, FXMessageBox.Icon.ICON_INFORMATION, FXMessageBox.TITLE_TEXT_INFORMATION, delMsg, 0, FXMessageBox.CANCEL, optRevert);

            if (optRevert.equals(selOpt)) {
                selectedItem.update(PreDefinedDrivers.find(selectedItem.getId()));
                _lstDrivers.getItems().set(selIx, selectedItem);
            }

        } else {
            String opt = FXMessageBox.showYesNo(stage, _i18n.t("driver.delete.confirm"));

            if (FXMessageBox.YES.equals(opt)) {
                _lstDrivers.getItems().remove(selectedItem);
                driversManager.remove(selectedItem);
            }
        }
    }

    private void onFilter() {
        _lstDrivers.getItems().setAll(driversManager.getDrivers(_btnFilter.isSelected()));

        DriversFilteredPref.setFiltered(_btnFilter.isSelected());
    }

    private void onEdit() {
        int selectedIndex = _lstDrivers.getSelectionModel().getSelectedIndex();
        SQLDriver selectedDriver = _lstDrivers.getSelectionModel().getSelectedItem();

        if (null == selectedDriver) {
            FXMessageBox.showInfoOk(AppState.get().getPrimaryStage(), _i18n.t("driver.edit.noselection.message"));
            return;
        }


        DriverEditCtrl driverEditCtrl = new DriverEditCtrl(selectedDriver);

        if (driverEditCtrl.isOk()) {
            selectedDriver.update(driverEditCtrl.getDriver());
            driversManager.editedDriver(selectedDriver);

            _lstDrivers.getItems().set(selectedIndex, selectedDriver);
        }
    }

    public Node getNode() {
        return borderPane;
    }
}
