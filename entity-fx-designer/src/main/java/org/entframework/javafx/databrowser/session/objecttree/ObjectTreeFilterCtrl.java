/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.objecttree;

import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.entframework.javafx.databrowser.AppState;
import org.entframework.javafx.databrowser.services.*;
import org.entframework.javafx.databrowser.session.Session;
import org.entframework.javafx.databrowser.session.action.StdActionCfg;
import org.entframework.javafx.databrowser.session.completion.CompletionCtrl;
import org.entframework.javafx.databrowser.session.completion.TextFieldTextComponentAdapter;
import org.entframework.javafx.databrowser.session.graph.GraphChannel;
import org.entframework.javafx.databrowser.session.graph.ObjectTreeFilterDoubleClickListener;
import org.entframework.javafx.databrowser.workaround.KeyMatchWA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ObjectTreeFilterCtrl {
    public static final String DRAGGING_TO_QUERY_BUILDER = "DRAGGING_TO_QUERY_BUILDER";


    private final FxmlHelper<FilterResultUpperView> _fxmlHelper;
    private final TreeView<ObjectTreeNode> _filterResultTree;
    private final CompletionCtrl _completionCtrl;
    private final I18n _i18n = new I18n(getClass());
    private final Stage _dialog;
    private TreeView<ObjectTreeNode> _sessionsObjectTree;
    private ObjectTreeFilterCtrlMode _mode;
    private GraphChannel _graphChannel;
    private ObjectTreeFilterDoubleClickListener _objectTreeFilterDoubleClickListener;

    public ObjectTreeFilterCtrl(Session session, String filterText) {
        this(session, filterText, ObjectTreeFilterCtrlMode.OBJECT_TREE_SEARCH);
    }

    public ObjectTreeFilterCtrl(Session session, String filterText, GraphChannel graphChannel, ObjectTreeFilterDoubleClickListener objectTreeFilterDoubleClickListener) {
        this(session, filterText, ObjectTreeFilterCtrlMode.ADD_TO_QUERY_BUILDER);
        _graphChannel = graphChannel;
        _objectTreeFilterDoubleClickListener = objectTreeFilterDoubleClickListener;
    }

    private ObjectTreeFilterCtrl(Session session, String filterText, ObjectTreeFilterCtrlMode mode) {
        _mode = mode;
        _sessionsObjectTree = session.getSessionCtrl().getObjectTree();
        _filterResultTree = createObjectsTree();

        _filterResultTree.getSelectionModel().getSelectedItems().addListener(new ListChangeListener<TreeItem<ObjectTreeNode>>() {
            @Override
            public void onChanged(Change<? extends TreeItem<ObjectTreeNode>> c) {
                onFilterResultTreeSelectionChanged(_mode);
            }
        });

        _fxmlHelper = new FxmlHelper<>(FilterResultUpperView.class);

        FilterResultUpperView view = _fxmlHelper.getView();

        view.txtFilter.setText(filterText);
        //_fxmlHelper.getView().txtFilter.setOnKeyTyped(e -> Platform.runLater(() -> applyFilterString()));
        view.txtFilter.setOnKeyPressed(e -> onHandleKeyEvent(e, false));
        view.txtFilter.setOnKeyTyped(e -> onHandleKeyEvent(e, true));
        _completionCtrl = new CompletionCtrl(session, new TextFieldTextComponentAdapter(view.txtFilter));
        _completionCtrl.setOnCompletionSelected(() -> Platform.runLater(() -> applyFilterString()));


        view.btnCollapse.setOnAction(e -> onCollapseTree());

        view.txtResultCount.setEditable(false);

        BorderPane borderPane = new BorderPane();

        borderPane.setTop(_fxmlHelper.getRegion());

        borderPane.setCenter(_filterResultTree);

        _dialog = GuiUtils.createNonModalDialog(borderPane, new Pref(getClass()), 600, 400, "objecttree.FilterResult");

        applyFilterString();

        String title;
        if (ObjectTreeFilterCtrlMode.OBJECT_TREE_SEARCH == _mode) {
            view.lblDescription.setText(_i18n.t("objecttreefind.filter.view.explain.objecttreesearch"));
            title = _i18n.t("objecttreefind.filter.window.title");
        } else // ObjectTreeFilterCtrlMode.ADD_TO_QUERY_BUILDER
        {
            view.lblDescription.setText(_i18n.t("objecttreefind.filter.view.explain.addToQueryBuilder"));
            title = _i18n.t("objecttreefind.filter.window.title.for.graph.add.table");

            _filterResultTree.setOnDragDetected(this::onDragToQueryBuilder);
            _filterResultTree.setOnDragOver(this::onDragOver);
        }

        _dialog.setTitle(title);
        _dialog.show();


        AppState.get().getSessionManager().getCurrentlyActiveOrActivatingContext().addOnSessionTabClosed(sessionTabContext -> _dialog.close());

    }

    private void onDragToQueryBuilder(MouseEvent e) {
        if (hasSelectedTables()) {
            Dragboard dragBoard = _filterResultTree.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.put(DataFormat.PLAIN_TEXT, DRAGGING_TO_QUERY_BUILDER);
            dragBoard.setContent(content);
            _graphChannel.setLastDraggingObjectTreeFilter(this);
        }

        e.consume();
    }

    private void onDragOver(DragEvent dragEvent) {
        if (dragEvent.getDragboard().hasString()) {
            if (hasSelectedTables()) {
                dragEvent.acceptTransferModes(TransferMode.MOVE);
            }
        }
        dragEvent.consume();
    }

    private boolean hasSelectedTables() {
        return _filterResultTree.getSelectionModel().getSelectedItems().stream().filter(this::isTable).findFirst().isPresent();
    }

    private boolean isTable(TreeItem<ObjectTreeNode> tn) {
        return null != tn && tn.getValue().isOfType(ObjectTreeNodeTypeKey.TABLE_TYPE_KEY);
    }


    private void onFilterResultTreeSelectionChanged(ObjectTreeFilterCtrlMode mode) {
        if (ObjectTreeFilterCtrlMode.ADD_TO_QUERY_BUILDER == mode) {
            return;
        }

        List<ObjectTreeNode> selected = CollectionUtil.transform(_filterResultTree.getSelectionModel().getSelectedItems(), otn -> otn.getValue());

        List<TreeItem<ObjectTreeNode>> matches = ObjectTreeUtil.findTreeItemsByObjectTreeNodes(_sessionsObjectTree, selected);

        ObjectTreeUtil.selectItems(_sessionsObjectTree, matches);
    }

    private void onHandleKeyEvent(KeyEvent keyEvent, boolean consumeOnly) {
        if (KeyMatchWA.matches(keyEvent, StdActionCfg.SQL_CODE_COMPLETION.getActionCfg().getKeyCodeCombination())) {
            if (false == consumeOnly) {
                _completionCtrl.completeCode();
            }
            keyEvent.consume();
            return;
        } else {
            if (false == consumeOnly) {
                Platform.runLater(() -> applyFilterString());
            }
        }

    }

    private void applyFilterString() {
        String filterText = _fxmlHelper.getView().txtFilter.getText();

        List<TreeItem<ObjectTreeNode>> filterResult;

        if (ObjectTreeFilterCtrlMode.OBJECT_TREE_SEARCH == _mode) {
            filterResult = ObjectTreeUtil.findObjectsMatchingName(_sessionsObjectTree, filterText, NameMatchMode.STARTS_WITH);
        } else {
            filterResult = ObjectTreeUtil.findObjectsMatchingNameAndType(_sessionsObjectTree, filterText, NameMatchMode.STARTS_WITH, ObjectTreeNodeTypeKey.TABLE_TYPE_KEY);
        }

        _filterResultTree.setRoot(null);
        fillTreeFromFilterResult(filterResult, _filterResultTree);


        _fxmlHelper.getView().txtResultCount.setText("" + filterResult.size());

        if (null != _filterResultTree.getRoot()) {
            _filterResultTree.getRoot().setExpanded(true);
            ObjectTreeUtil.setExpandedAll(_filterResultTree, true);
        }
    }

    private void onCollapseTree() {
        ObjectTreeUtil.setExpandedAll(_filterResultTree, false);
        _filterResultTree.getRoot().setExpanded(true);
    }

    private void fillTreeFromFilterResult(List<TreeItem<ObjectTreeNode>> filterResult, TreeView<ObjectTreeNode> objectsTree) {
        HashMap<ObjectTreeNode, TreeItem<ObjectTreeNode>> cache = new HashMap<>();

        for (TreeItem<ObjectTreeNode> item : filterResult) {
            List<TreeItem<ObjectTreeNode>> treePath = getTreePath(item);


            for (int i = 0; i < treePath.size(); i++) {

                TreeItem<ObjectTreeNode> ti = cache.get(treePath.get(i).getValue());

                if (null == ti) {
                    TreeItem<ObjectTreeNode> newTreeItem = new TreeItem<>(treePath.get(i).getValue());

                    if (0 == i) {
                        objectsTree.setRoot(newTreeItem);
                    } else {
                        TreeItem<ObjectTreeNode> parentTi = cache.get(treePath.get(i - 1).getValue());
                        parentTi.getChildren().add(newTreeItem);
                    }

                    cache.put(newTreeItem.getValue(), newTreeItem);
                }
            }
        }
    }

    private TreeView<ObjectTreeNode> createObjectsTree() {
        TreeView<ObjectTreeNode> objectsTree = new TreeView<>();
        objectsTree.setCellFactory(cf -> new ObjectsTreeCell(otn -> onDoubleClick(otn)));

        objectsTree.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        return objectsTree;
    }

    private void onDoubleClick(ObjectTreeNode otn) {
        if (null != _objectTreeFilterDoubleClickListener) {
            _objectTreeFilterDoubleClickListener.doubleClicked(otn.getTableInfo());
        }

        _dialog.close();
    }

    private List<TreeItem<ObjectTreeNode>> getTreePath(TreeItem<ObjectTreeNode> treeItem) {
        ArrayList<TreeItem<ObjectTreeNode>> ret = new ArrayList<>();

        while (null != treeItem) {
            ret.add(treeItem);
            treeItem = treeItem.getParent();
        }

        Collections.reverse(ret);

        return ret;
    }


    public List<ObjectTreeNode> getSelectedObjectTreeNodes() {
        List<TreeItem<ObjectTreeNode>> buf = CollectionUtil.filter(_filterResultTree.getSelectionModel().getSelectedItems(), this::isTable);

        return CollectionUtil.transform(buf, TreeItem::getValue);
    }
}
