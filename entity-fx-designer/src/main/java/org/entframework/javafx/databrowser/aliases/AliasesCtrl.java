/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.aliases;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.apache.commons.lang3.StringUtils;
import org.entframework.javafx.common.event.DefaultEventBus;
import org.entframework.javafx.common.event.DockButtonToggleEvent;
import org.entframework.javafx.common.spring.AbstractFxmlCtrl;
import org.entframework.javafx.common.spring.FXMLController;
import org.entframework.javafx.databrowser.AppState;
import org.entframework.javafx.databrowser.Props;
import org.entframework.javafx.databrowser.aliases.channel.AliasTreeNodeChannel;
import org.entframework.javafx.databrowser.aliases.channel.AliasTreeNodeMoveListener;
import org.entframework.javafx.databrowser.aliases.dbconnector.DBConnector;
import org.entframework.javafx.databrowser.aliases.dbconnector.DbConnectorResult;
import org.entframework.javafx.databrowser.services.*;
import org.entframework.javafx.databrowser.services.dndpositionmarker.RelativeNodePosition;
import org.entframework.javafx.databrowser.session.schemainfo.SchemaCacheConfig;
import org.kordamp.ikonli.antdesignicons.AntDesignIconsOutlined;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignC;
import org.kordamp.ikonli.materialdesign2.MaterialDesignP;

import java.util.ArrayList;
import java.util.List;

@FXMLController
public class AliasesCtrl extends AbstractFxmlCtrl {
    private static final String PREF_ALIASES_PINED = "aliases.pinned";
    private final TreeView<AliasTreeNode> _treeView = new TreeView<>();
    private AliasTreeNodeChannel _aliasTreeNodeChannel;
    @FXML
    private BorderPane borderPane;
    private AliasCutCopyState _aliasCutCopyState;
    private Props _props = new Props(this.getClass());
    private Pref _prefs = new Pref(this.getClass());
    private I18n _i18n = new I18n(this.getClass());

    private ToggleButton _btnPinned;

    public void initialize() {

        _aliasTreeNodeChannel = new AliasTreeNodeChannel(new AliasTreeNodeMoveListener() {
            @Override
            public void moveNodeRequest(TreeItem<AliasTreeNode> itemToMoveTo, TreeItem<AliasTreeNode> itemToMove, RelativeNodePosition relativeNodePosition) {
                onMoveNodeRequest(itemToMoveTo, itemToMove, relativeNodePosition);
            }

            @Override
            public void doubleClicked(TreeItem<AliasTreeNode> selectedItem) {
                onTreeItemDoubleClicked(selectedItem);
            }
        });

        _aliasCutCopyState = new AliasCutCopyState(_aliasTreeNodeChannel);


        borderPane.setTop(createToolBar());
        borderPane.setCenter(_treeView);
        _treeView.setShowRoot(false);
        _treeView.setRoot(new TreeItem<AliasTreeNode>(new AliasFolder("This folder is root and should not be visible")));

        _treeView.setCellFactory(cf -> new AliasCell(_aliasTreeNodeChannel, _aliasCutCopyState));

        borderPane.setOnKeyPressed(this::uncutOnEscape);
        _treeView.setOnKeyPressed(this::uncutOnEscape);

        _btnPinned.setSelected(_prefs.getBoolean(PREF_ALIASES_PINED, false));
        onPinnedChanged();


        AliasTreeStructureNode structRoot = Dao.loadAliasTree();
        List<AliasDecorator> aliases = Dao.loadAliases();

        List<AliasDecorator> unappliedAliases = structRoot.apply(_treeView.getRoot(), aliases);

        //////////////////////////////////////////////////////////////////////////////////////////////////////
        // unappliedAliases should always be empty. But because people are so unhappy when aliases get lost
        // we do this for precautions only.
        for (AliasDecorator unappliedAlias : unappliedAliases) {
            _treeView.getRoot().getChildren().add(new TreeItem<AliasTreeNode>(unappliedAlias));
        }
        //
        //////////////////////////////////////////////////////////////////////////////////////////////////////

        AppState.get().addSaveSettingsListener(this::onSaveSettings);
    }

    private void onTreeItemDoubleClicked(TreeItem<AliasTreeNode> selectedItem) {
        if (selectedItem.getValue() instanceof AliasDecorator) {
            doConnect(selectedItem);
        } else {
            editAliasFolder(selectedItem);
        }
    }

    private void onMoveNodeRequest(TreeItem<AliasTreeNode> itemToMoveTo, TreeItem<AliasTreeNode> itemToMove, RelativeNodePosition relativeNodePosition) {
        if (isEqualsOrAbove(itemToMove, itemToMoveTo)) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    showInvalidMoveMessage();
                }
            });

            return;

        }

        positionItem(itemToMoveTo, itemToMove, relativeNodePosition);
        //System.out.println("Moving " + itemToMove.getValue().getName() + " to " + itemToMoveTo.getValue().getName() + " as " + relativeNodePosition);

    }

    private void showInvalidMoveMessage() {
        FXMessageBox.showInfoOk(AppState.get().getPrimaryStage(), _i18n.t("aliases.cannot.cutnpaste.to.itself.ordesc"));
    }


    private void onSaveSettings() {
        ObservableList<TreeItem<AliasTreeNode>> items = _treeView.getRoot().getChildren();

        List<AliasDecorator> aliases = new ArrayList<>();

        AliasTreeStructureNode structRoot = new AliasTreeStructureNode();
        structRoot.addAll(items, aliases);

        Dao.writeAliases(aliases, structRoot);
    }

    private void uncutOnEscape(KeyEvent ke) {
        if (ke.getCode() == KeyCode.ESCAPE) {
            _aliasCutCopyState.setTreeItemBeingCut(null);
        }
    }

    private BorderPane createToolBar() {
        DockToolbarBuilder dockToolbarBuilder = new DockToolbarBuilder();


        dockToolbarBuilder.addButtonLeft(FontIcon.of(MaterialDesignC.CONNECTION), _i18n.t("tooltip.connect")).setOnAction(e -> onConnect());
        //dockToolbarBuilder.addSeparatorLeft();
        dockToolbarBuilder.addButtonLeft(FontIcon.of(AntDesignIconsOutlined.PLUS), _i18n.t("tooltip.add")).setOnAction(e -> onAdd());
        dockToolbarBuilder.addButtonLeft(FontIcon.of(AntDesignIconsOutlined.COPY), _i18n.t("tooltip.copy")).setOnAction(e -> onCopy());
        dockToolbarBuilder.addButtonLeft(FontIcon.of(AntDesignIconsOutlined.EDIT), _i18n.t("tooltip.edit")).setOnAction(e -> onEdit());
        dockToolbarBuilder.addButtonLeft(FontIcon.of(AntDesignIconsOutlined.SETTING), _i18n.t("tooltip.alias_properties")).setOnAction(e -> onAliasProperties());
        dockToolbarBuilder.addButtonLeft(FontIcon.of(AntDesignIconsOutlined.DELETE), _i18n.t("tooltip.remove")).setOnAction(e -> onRemove());
        //dockToolbarBuilder.addSeparatorLeft();
        //dockToolbarBuilder.addButtonLeft(FontIcon.of(AntDesignIconsOutlined.SORT_ASCENDING), _i18n.t("tooltip.sort")).setOnAction(e -> onSort());
        dockToolbarBuilder.addSeparatorLeft();
        dockToolbarBuilder.addButtonLeft(FontIcon.of(AntDesignIconsOutlined.FOLDER_ADD), _i18n.t("tooltip.new.alias.folder")).setOnAction(e -> onNewFolder());
        dockToolbarBuilder.addButtonLeft(FontIcon.of(AntDesignIconsOutlined.COPY), _i18n.t("tooltip.copy.alias.to.clip")).setOnAction(e -> onCopyToClip());
        dockToolbarBuilder.addButtonLeft(FontIcon.of(MaterialDesignC.CONTENT_CUT), _i18n.t("tooltip.cut.alias")).setOnAction(e -> onCut());
        dockToolbarBuilder.addButtonLeft(FontIcon.of(MaterialDesignC.CONTENT_PASTE), _i18n.t("tooltip.paste.alias")).setOnAction(e -> onPaste());

        _btnPinned = dockToolbarBuilder.addToggleButtonRight(FontIcon.of(MaterialDesignP.PIN_OFF_OUTLINE), _i18n.t("tooltip.pinned"));
        _btnPinned.setOnAction(e -> onPinnedChanged());

        dockToolbarBuilder.addButtonRight(FontIcon.of(AntDesignIconsOutlined.NODE_COLLAPSE), _i18n.t("tooltip.close")).setOnAction(e -> {
            DefaultEventBus.getInstance().publish(new DockButtonToggleEvent(DockButtonToggleEvent.Type.ALIASES, false));
        });

        return dockToolbarBuilder.getToolbarPane();
    }

    private void onPaste() {
        if (null == _aliasCutCopyState.getTreeItemBeingCut() && null == _aliasCutCopyState.getTreeItemBeingCopied()) {
            FXMessageBox.showInfoOk(AppState.get().getPrimaryStage(), _i18n.t("aliases.nothing.to.paste"));
            return;
        }

        if (null != _aliasCutCopyState.getTreeItemBeingCut()) {
            TreeItem<AliasTreeNode> selectedItem = _treeView.getSelectionModel().getSelectedItem();

            TreeItem<AliasTreeNode> beingCut = _aliasCutCopyState.getTreeItemBeingCut();

            if (isEqualsOrAbove(beingCut, selectedItem)) {
                showInvalidMoveMessage();
                return;
            }

            TreeItem<AliasTreeNode> oldParent = beingCut.getParent();

            oldParent.getChildren().remove(beingCut);


            addToTree(selectedItem, beingCut);

            _aliasCutCopyState.setTreeItemBeingCut(null);
        } else if (null != _aliasCutCopyState.getTreeItemBeingCopied()) {
            TreeItem<AliasTreeNode> selectedItem = _treeView.getSelectionModel().getSelectedItem();

            TreeItem<AliasTreeNode> beingCopied = _aliasCutCopyState.getTreeItemBeingCopied();

            if (null == selectedItem) {
                selectedItem = _treeView.getRoot();
            }


            TreeItem<AliasTreeNode> aliasNodePathCopy = AliasTreeUtil.deepCopy(beingCopied);

            addToTree(selectedItem, aliasNodePathCopy);

            _aliasCutCopyState.setTreeItemBeingCopied(null);

        }
    }


    private void addToTree(TreeItem<AliasTreeNode> toAddTo, TreeItem<AliasTreeNode> toAdd) {
        if (null == toAddTo) {
            _treeView.getRoot().getChildren().add(toAdd);

        } else {
            toAddTo.getChildren().add(toAdd);
            toAddTo.setExpanded(true);
        }
    }

    private boolean isEqualsOrAbove(TreeItem<AliasTreeNode> item, TreeItem<AliasTreeNode> toCheck) {
        TreeItem<AliasTreeNode> p = toCheck;

        while (null != p) {
            if (p == item) {
                return true;
            }

            p = p.getParent();
        }

        return false;
    }

    private void onCut() {
        TreeItem<AliasTreeNode> selectedItem = getSelectedNodeOrComplain("aliases.select.node.to.cut");
        if (selectedItem == null) {
            return;
        }


        _aliasCutCopyState.setTreeItemBeingCut(selectedItem);
    }

    private void onCopyToClip() {

        TreeItem<AliasTreeNode> selectedItem = getSelectedNodeOrComplain("aliases.select.node.to.copy");
        if (selectedItem == null) {
            return;
        }

        _aliasCutCopyState.setTreeItemBeingCopied(selectedItem);
    }

    private void onNewFolder() {
        TreeItem<AliasTreeNode> selectedItem = _treeView.getSelectionModel().getSelectedItem();

        EditFolderNameCtrl editFolderNameCtrl = new EditFolderNameCtrl(null != selectedItem, null != selectedItem && selectedItem.getValue() instanceof AliasFolder);

        String newFolderName = editFolderNameCtrl.getNewFolderName();

        if (StringUtils.isEmpty(newFolderName)) {
            return;
        }

        TreeItem<AliasTreeNode> newTreeItem = AliasTreeUtil.createFolderNode(newFolderName);

        positionItem(selectedItem, newTreeItem, editFolderNameCtrl.getTreePositionCtrl().getRelativeNodePosition());
    }

    private void positionItem(TreeItem<AliasTreeNode> selectedItem, TreeItem<AliasTreeNode> treeItemToPosition, RelativeNodePosition relativeNodePosition) {
        if (null != treeItemToPosition.getParent()) {
            treeItemToPosition.getParent().getChildren().remove(treeItemToPosition);
        }


        if (relativeNodePosition == RelativeNodePosition.ROOT) {
            _treeView.getRoot().getChildren().add(treeItemToPosition);
        } else if (relativeNodePosition == RelativeNodePosition.CHILD) {
            selectedItem.getChildren().add(treeItemToPosition);
            selectedItem.setExpanded(true);
        } else if (relativeNodePosition == RelativeNodePosition.UPPER_SIBLING) {
            TreeItem<AliasTreeNode> parent = selectedItem.getParent();

            int ixOfSelected = parent.getChildren().indexOf(selectedItem);
            parent.getChildren().add(ixOfSelected, treeItemToPosition);

        } else if (relativeNodePosition == RelativeNodePosition.LOWER_SIBLING) {
            TreeItem<AliasTreeNode> parent = selectedItem.getParent();

            int ixOfSelected = parent.getChildren().indexOf(selectedItem);
            parent.getChildren().add(ixOfSelected + 1, treeItemToPosition);
        }
    }

    private void onSort() {
        AliasTreeUtil.sortChildren(_treeView.getRoot());
    }

    private void onEdit() {
        TreeItem<AliasTreeNode> selectedItem = getSelectedNodeOrComplain("aliases.select.node.to.edit");
        if (selectedItem == null) {
            return;
        }


        if (selectedItem.getValue() instanceof AliasFolder) {
            editAliasFolder(selectedItem);
        } else {
            editAlias(selectedItem);
        }
    }

    private void onAliasProperties() {
        TreeItem<AliasTreeNode> selectedItem = getSelectedNodeOrComplain("aliases.select.node.to.edit.properties");
        if (selectedItem == null || selectedItem.getValue() instanceof AliasFolder) {
            return;
        }

        AliasDecorator aliasDecorator = (AliasDecorator) selectedItem.getValue();
        new AliasPropertiesEditCtrl(aliasDecorator);
    }


    private void editAlias(TreeItem<AliasTreeNode> item) {
        AliasDecorator aliasDecorator = (AliasDecorator) item.getValue();

        AliasEditCtrl aliasEditCtrl = new AliasEditCtrl(aliasDecorator, AliasEditCtrl.ConstructorState.EDIT);

        if (aliasEditCtrl.isOk()) {
            aliasDecorator.updateAlias(aliasEditCtrl.getAlias());
            item.setValue(aliasDecorator);
            _aliasTreeNodeChannel.fireChanged(item);
        }
    }

    private void editAliasFolder(TreeItem<AliasTreeNode> selectedItem) {
        AliasFolder af = (AliasFolder) selectedItem.getValue();
        EditFolderNameCtrl editFolderNameCtrl = new EditFolderNameCtrl(af.getName());

        String changedFolderName = editFolderNameCtrl.getNewFolderName();

        if (StringUtils.isEmpty(changedFolderName)) {
            return;
        }

        af.setName(changedFolderName);
        _aliasTreeNodeChannel.fireChanged(selectedItem);
    }

    private void onRemove() {

        TreeItem<AliasTreeNode> selectedItem = getSelectedNodeOrComplain("aliases.select.node.to.remove");
        if (selectedItem == null) {
            return;
        }


        if (selectedItem.getValue() instanceof AliasDecorator) {
            String msg = _i18n.t("alias.confirm.remove", selectedItem.getValue().getName());
            if (false == FXMessageBox.YES.equals(FXMessageBox.showYesNo(AppState.get().getPrimaryStage(), msg))) {
                return;
            }
        } else {
            String msg = _i18n.t("aliasfolder.confirm.remove", selectedItem.getValue().getName());
            if (false == FXMessageBox.YES.equals(FXMessageBox.showYesNo(AppState.get().getPrimaryStage(), msg))) {
                return;
            }
        }

        selectedItem.getParent().getChildren().remove(selectedItem);
    }

    private void onCopy() {

        TreeItem<AliasTreeNode> selectedItem = getSelectedNodeOrComplain("aliases.select.alias.to.copy");
        if (selectedItem == null) {
            return;
        }

        if (selectedItem.getValue() instanceof AliasFolder) {
            Stage stage = AppState.get().getPrimaryStage();
            String msg = _i18n.t("aliases.cannot.copy.folder");
            if (FXMessageBox.YES.equals(FXMessageBox.showYesNo(stage, msg, _props.getImageView("copy_to_clip.png")))) {
                onCopyToClip();
            }
            return;
        }

        AliasDecorator aliasDecorator = (AliasDecorator) selectedItem.getValue();

        aliasDecorator = AliasTreeUtil.cloneAlias(aliasDecorator);

        AliasEditCtrl aliasEditCtrl = new AliasEditCtrl(aliasDecorator, AliasEditCtrl.ConstructorState.COPY);

        if (aliasEditCtrl.isOk()) {
            aliasDecorator.updateAlias(aliasEditCtrl.getAlias());
            TreeItem<AliasTreeNode> newTreeItem = AliasTreeUtil.createAliasNode(aliasDecorator);
            positionItem(selectedItem, newTreeItem, RelativeNodePosition.LOWER_SIBLING);
        }

    }

    private void onAdd() {
        TreeItem<AliasTreeNode> selectedItem = _treeView.getSelectionModel().getSelectedItem();


        AliasEditCtrl aliasEditCtrl = new AliasEditCtrl(null != selectedItem, null != selectedItem && selectedItem.getValue() instanceof AliasFolder);

        if (aliasEditCtrl.isOk()) {
            Alias alias = aliasEditCtrl.getAlias();
            TreeItem<AliasTreeNode> newTreeItem = AliasTreeUtil.createAliasNode(new AliasDecorator(alias));
            positionItem(selectedItem, newTreeItem, aliasEditCtrl.getTreePositionCtrl().getRelativeNodePosition());
        }
    }

    private void onPinnedChanged() {
        if (_btnPinned.isSelected()) {
            _btnPinned.setGraphic(FontIcon.of(MaterialDesignP.PIN_OUTLINE));
        } else {
            _btnPinned.setGraphic(FontIcon.of(MaterialDesignP.PIN_OFF_OUTLINE));
        }

        _prefs.set(PREF_ALIASES_PINED, _btnPinned.isSelected());
    }

    private void onConnect() {
        TreeItem<AliasTreeNode> selectedItem = _treeView.getSelectionModel().getSelectedItem();

        if (null == selectedItem || false == selectedItem.getValue() instanceof AliasDecorator) {
            FXMessageBox.showInfoOk(AppState.get().getPrimaryStage(), _i18n.t("aliases.select.node.to.connect"));
            return;
        }

        doConnect(selectedItem);
    }

    private void doConnect(TreeItem<AliasTreeNode> selectedItem) {
        AliasDecorator aliasDecorator = (AliasDecorator) selectedItem.getValue();


        DBConnector dbConnector = new DBConnector(aliasDecorator, null, new SchemaCacheConfig(aliasDecorator.getAliasPropertiesDecorator()));


        dbConnector.tryConnect(r -> onTryConnectFinished(r, aliasDecorator.getAlias()));
    }

    private void onTryConnectFinished(DbConnectorResult dbConnectorResult, Alias alias) {
        if (dbConnectorResult.isEditAliasRequested()) {
            TreeItem<AliasTreeNode> searchRes = AliasTreeUtil.search(_treeView.getRoot(), alias.getId());

            if (null == searchRes) {
                FXMessageBox.showInfoOk(AppState.get().getPrimaryStage(), _i18n.t("aliasecontroller.cannotfind.alias.to.edit"));
                return;
            }

            editAlias(searchRes);
            return;
        }

        if (!dbConnectorResult.isConnected()) {
            return;
        }


        if (!_btnPinned.isSelected()) {
            DefaultEventBus.getInstance().publish(new DockButtonToggleEvent(DockButtonToggleEvent.Type.ALIASES, false));
        }

        AppState.get().getSessionManager().createSession(dbConnectorResult);
    }

    private TreeItem<AliasTreeNode> getSelectedNodeOrComplain(String complaintMessageKey) {
        TreeItem<AliasTreeNode> selectedItem = _treeView.getSelectionModel().getSelectedItem();

        if (null == selectedItem) {
            FXMessageBox.showInfoOk(AppState.get().getPrimaryStage(), _i18n.t(complaintMessageKey));
            return null;
        }
        return selectedItem;
    }


    public Node getNode() {
        return borderPane;
    }
}
