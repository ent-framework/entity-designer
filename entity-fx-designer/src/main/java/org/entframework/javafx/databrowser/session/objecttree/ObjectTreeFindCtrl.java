/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.objecttree;

import javafx.scene.Node;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.entframework.javafx.databrowser.Props;
import org.entframework.javafx.databrowser.globalicons.GlobalIconNames;
import org.entframework.javafx.databrowser.services.FxmlHelper;
import org.entframework.javafx.databrowser.services.I18n;
import org.entframework.javafx.databrowser.session.Session;
import org.entframework.javafx.databrowser.session.action.StdActionCfg;
import org.entframework.javafx.databrowser.session.completion.CompletionCtrl;
import org.entframework.javafx.databrowser.session.completion.TextFieldTextComponentAdapter;

import java.util.List;

public class ObjectTreeFindCtrl {
    private final FxmlHelper<ObjectTreeFindView> _fxmlHelper;
    private final Props _props = new Props(getClass());
    private final CompletionCtrl _completionCtrl;

    private I18n _i18n = new I18n(getClass());
    private TreeView<ObjectTreeNode> _objectsTree;
    private Session _session;
    private ObjectTreeFindView _view;

    public ObjectTreeFindCtrl(TreeView<ObjectTreeNode> objectsTree, Session session) {
        _objectsTree = objectsTree;
        _session = session;
        _fxmlHelper = new FxmlHelper<>(ObjectTreeFindView.class);
        _view = _fxmlHelper.getView();

        _view.btnFind.setGraphic(_props.getImageView(GlobalIconNames.SEARCH));
        _view.btnFind.setTooltip(new Tooltip(_i18n.t("objecttreefind.find.tooltip")));
        _view.btnFind.setOnAction(e -> onFind());


        _view.btnFilter.setGraphic(_props.getImageView("filter.png"));
        _view.btnFilter.setTooltip(new Tooltip(_i18n.t("objecttreefind.filter.tooltip")));
        _view.btnFilter.setOnAction(e -> onFilter());

        _completionCtrl = new CompletionCtrl(_session, new TextFieldTextComponentAdapter(_view.txtText));

        _view.txtText.setOnKeyReleased(e -> onHandleKeyEvent(e, false));
        //_view.txtText.setOnKeyTyped(e -> onHandleKeyEvent(e, true));

    }

    private void onFilter() {
        new ObjectTreeFilterCtrl(_session, _view.txtText.getText());
    }

    private void onHandleKeyEvent(KeyEvent keyEvent, boolean consumeOnly) {
        //if ( KeyMatchWA.matches(keyEvent, StdActionCfg.SQL_CODE_COMPLETION.getActionCfg().getKeyCodeCombination()) )
        if (StdActionCfg.SQL_CODE_COMPLETION.getActionCfg().getKeyCodeCombination().match(keyEvent)) {
            if (false == consumeOnly) {
                _completionCtrl.completeCode();
            }
            keyEvent.consume();
            return;
        } else if (KeyCode.ENTER.equals(keyEvent.getCode())) {
            if (false == consumeOnly) {
                onFind();
            }
            keyEvent.consume();
            return;
        }
    }


    private void onFind() {
        List<TreeItem<ObjectTreeNode>> objectsMatchingNames = ObjectTreeUtil.findObjectsMatchingName(_objectsTree, _view.txtText.getText(), NameMatchMode.EQUALS);

        if (0 == objectsMatchingNames.size()) {
            return;
        }

        ObjectTreeUtil.selectItem(_objectsTree, objectsMatchingNames.get(0));
    }

    public Node getNode() {
        return _fxmlHelper.getRegion();
    }
}
