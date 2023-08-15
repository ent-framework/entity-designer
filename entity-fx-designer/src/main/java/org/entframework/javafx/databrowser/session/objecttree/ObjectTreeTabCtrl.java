/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.objecttree;

import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import org.entframework.javafx.databrowser.services.I18n;
import org.entframework.javafx.databrowser.services.MessageHandler;
import org.entframework.javafx.databrowser.services.MessageHandlerDestination;
import org.entframework.javafx.databrowser.services.SplitPositionSaver;
import org.entframework.javafx.databrowser.session.Session;
import org.entframework.javafx.databrowser.session.SessionTabContext;
import org.entframework.javafx.databrowser.session.action.ActionCfg;
import org.entframework.javafx.databrowser.session.action.ActionScope;
import org.entframework.javafx.databrowser.session.action.ActionUtil;

import java.util.ArrayList;
import java.util.List;

public class ObjectTreeTabCtrl {
    private final Tab _objectsTab;
    private I18n _i18n = new I18n(getClass());
    private SplitPositionSaver _objecttreeSplitPosSaver = new SplitPositionSaver(getClass(), "objecttree.split.loc");
    private SplitPane _objectTabSplitPane = new SplitPane();
    private SessionTabContext _sessionTabContext;
    private TreeView<ObjectTreeNode> _objectsTree = new TreeView<>();

    public ObjectTreeTabCtrl(SessionTabContext sessionTabContext) {
        _sessionTabContext = sessionTabContext;

        Tab objectsTab = new Tab(_i18n.t("session.tab.objects"));
        objectsTab.setClosable(false);

        _objectTabSplitPane.setOrientation(Orientation.HORIZONTAL);

        loadObjectTabSplitPane();

        objectsTab.setContent(_objectTabSplitPane);

        _objectsTab = objectsTab;

        _sessionTabContext.getSession().getSchemaCacheValue().addListener(() -> reloadObjectTabSplitPane());

        _objectTabSplitPane.setOnKeyPressed(this::onHandleKeyEvent);

    }

    private void reloadObjectTabSplitPane() {
        _objecttreeSplitPosSaver.save(_objectTabSplitPane);

        loadObjectTabSplitPane();
    }

    private void onHandleKeyEvent(KeyEvent keyEvent) {
        for (ActionCfg actionCfg : ActionUtil.getAllActionCfgs()) {
            if (actionCfg.getActionScope() == ActionScope.OBJECT_TREE || actionCfg.getActionScope() == ActionScope.UNSCOPED) {
                if (actionCfg.matchesKeyEvent(keyEvent)) {
                    actionCfg.fire();
                    keyEvent.consume();
                    return;
                }
            }
        }
    }


    private void loadObjectTabSplitPane() {
        TreeItem<ObjectTreeNode> formerSelectedTreeItem = null;

        if (0 < _objectTabSplitPane.getItems().size()) {
            formerSelectedTreeItem = _objectsTree.getSelectionModel().getSelectedItem();

            _objectTabSplitPane.getItems().clear();
        }


        _objectsTree.setCellFactory(cf -> new ObjectsTreeCell());

        AliasCatalogsSchemasAndTypesCreator.createNodes(_objectsTree, _sessionTabContext.getSession());

        TablesProceduresAndUDTsCreator.createNodes(_objectsTree, _sessionTabContext.getSession());

        removeEmptySchemasIfRequested(_objectsTree, _sessionTabContext.getSession());

        doEmptyCheck(_objectsTree);

        _objectsTree.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


        _objectTabSplitPane.getItems().add(createObjectsTreePanel());
        _objectTabSplitPane.getItems().add(new TreeDetailsCtrl(_objectsTree, _sessionTabContext.getSession()).getComponent());


        final TreeItem<ObjectTreeNode> treeItemToSelect = ObjectTreeUtil.findTreeItem(_objectsTree, formerSelectedTreeItem);

        if (null == treeItemToSelect) {
            TreeItem<ObjectTreeNode> aliasItem = ObjectTreeUtil.findSingleTreeItem(_objectsTree, ObjectTreeNodeTypeKey.ALIAS_TYPE_KEY);
            ObjectTreeUtil.selectItem(_objectsTree, aliasItem);
        } else {
            _objectsTree.getSelectionModel().select(treeItemToSelect);
            int row = _objectsTree.getRow(treeItemToSelect);
            _objectsTree.scrollTo(row);
        }

        _objecttreeSplitPosSaver.apply(_objectTabSplitPane);
    }

    private BorderPane createObjectsTreePanel() {
        BorderPane borderPane = new BorderPane();

        borderPane.setTop(new ObjectTreeFindCtrl(_objectsTree, _sessionTabContext.getSession()).getNode());
        borderPane.setCenter(_objectsTree);

        return borderPane;
    }

    private void doEmptyCheck(TreeView<ObjectTreeNode> objectsTree) {
        if (
                ObjectTreeUtil.findTreeItems(objectsTree, ObjectTreeNodeTypeKey.SCHEMA_TYPE_KEY).isEmpty()
                        && ObjectTreeUtil.findTreeItems(objectsTree, ObjectTreeNodeTypeKey.CATALOG_TYPE_KEY).isEmpty()
                        && ObjectTreeUtil.findTreeItems(objectsTree, ObjectTreeNodeTypeKey.TABLE_TYPE_KEY).isEmpty()
                        && ObjectTreeUtil.findTreeItems(objectsTree, ObjectTreeNodeTypeKey.UDT_TYPE_KEY).isEmpty()
                        && ObjectTreeUtil.findTreeItems(objectsTree, ObjectTreeNodeTypeKey.PROCEDURE_TYPE_KEY).isEmpty()
        ) {
            new MessageHandler(getClass(), MessageHandlerDestination.MESSAGE_PANEL).warning(new I18n(getClass()).t("empty.object.tree.erroneous.alias.properties.warning"));
        }

    }

    private void removeEmptySchemasIfRequested(TreeView<ObjectTreeNode> objectsTree, Session session) {
        if (false == session.getSchemaCacheValue().get().getAliasPropertiesDecorator().isHideEmptySchemasInObjectTree()) {
            return;
        }

        List<TreeItem<ObjectTreeNode>> schemas = ObjectTreeUtil.findTreeItems(objectsTree, ObjectTreeNodeTypeKey.SCHEMA_TYPE_KEY);
        removeEmptyNodes(schemas);

        List<TreeItem<ObjectTreeNode>> catalogs = ObjectTreeUtil.findTreeItems(objectsTree, ObjectTreeNodeTypeKey.CATALOG_TYPE_KEY);
        removeEmptyNodes(catalogs);

    }


    private void removeEmptyNodes(List<TreeItem<ObjectTreeNode>> nodes) {
        List<TreeItem<ObjectTreeNode>> toRemove = new ArrayList<>();

        for (TreeItem<ObjectTreeNode> schema : nodes) {
            if (0 == schema.getChildren().size()) {
                toRemove.add(schema);
            }
        }

        for (TreeItem<ObjectTreeNode> del : toRemove) {
            del.getParent().getChildren().remove(del);
        }
    }


    public Tab getObjectsTab() {
        return _objectsTab;
    }

    public void close() {
        _objecttreeSplitPosSaver.save(_objectTabSplitPane);
    }

    public boolean selectObjectInTree(QualifiedObjectName objName) {
        List<TreeItem<ObjectTreeNode>> treeItems = ObjectTreeUtil.findTreeItemsByName(_objectsTree, objName);

        if (0 == treeItems.size()) {
            return false;
        }

        ObjectTreeUtil.selectItem(_objectsTree, treeItems.get(0));

        _objectsTree.scrollTo(_objectsTree.getSelectionModel().getSelectedIndex());

        _objectsTab.getTabPane().getSelectionModel().select(_objectsTab);

        return true;

    }

    public TreeView<ObjectTreeNode> getObjectTree() {
        return _objectsTree;
    }
}
