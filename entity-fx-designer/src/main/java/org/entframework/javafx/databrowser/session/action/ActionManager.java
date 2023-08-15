/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.action;

import javafx.scene.control.*;
import org.entframework.javafx.databrowser.services.CollectionUtil;
import org.entframework.javafx.databrowser.services.I18n;
import org.entframework.javafx.databrowser.session.SessionManager;
import org.entframework.javafx.databrowser.session.SessionManagerListener;
import org.entframework.javafx.databrowser.session.SessionTabContext;

import java.util.ArrayList;
import java.util.List;

public class ActionManager {
    private ActionScope _currentActionScope;
    private SessionTabContext _activeOrActivatingSessionTabContext;

    private List<ActionHandle> _actionHandles = new ArrayList<>();
    private volatile int _actionConfigurationIdSequence;

    public ActionManager() {
    }

    public int getNextActionConfigurationId() {
        return ++_actionConfigurationIdSequence;
    }

    public void onContextActiveOrActivating(SessionTabContext sessionTabContext, Menu _sessionMenu) {
        _activeOrActivatingSessionTabContext = sessionTabContext;
        _sessionMenu.getItems().clear();


        if (null == _activeOrActivatingSessionTabContext) {
            _sessionMenu.setDisable(true);
            return;
        }

        _sessionMenu.setDisable(false);
        for (StdActionCfg stdActionCfg : StdActionCfg.SESSION_MENU) {
            if (stdActionCfg == StdActionCfg.SEPARATOR) {
                _sessionMenu.getItems().add(new SeparatorMenuItem());
            } else {
                MenuItem menuItem;
                if (stdActionCfg.getActionCfg().getActionType() == ActionType.NON_TOGGLE) {
                    menuItem = new MenuItem(stdActionCfg.getActionCfg().getText());
                } else // if (stdActionCfg.getActionCfg().getActionType() == ActionType.TOGGLE)
                {
                    menuItem = new CheckMenuItem(stdActionCfg.getActionCfg().getText());
                }

                menuItem.setGraphic(stdActionCfg.getActionCfg().getIcon());

                ActionHandle actionHandle = getActionHandle(stdActionCfg.getActionCfg(), _activeOrActivatingSessionTabContext);
                actionHandle.setMenuItem(menuItem);
                actionHandle.refreshActionUI();

                _sessionMenu.getItems().add(menuItem);
            }
        }

        updateActionUIs();
    }

    public ToolBar createStdActionToolbar() {
        ToolBar ret = new ToolBar();

        for (StdActionCfg stdActionCfg : StdActionCfg.SESSION_TOOLBAR) {
            if (stdActionCfg == StdActionCfg.SEPARATOR) {
                addSeparatorToToolbar(ret);
            } else {
                addActionToToolbar(ret, stdActionCfg.getActionCfg());
            }
        }

        LogTest.checkAndAddTestToolbarButtons(ret);

        return ret;
    }

    private void addSeparatorToToolbar(ToolBar ret) {
        ret.getItems().add(new Separator());
    }

    public ActionHandle addActionToToolbar(ToolBar toolBar, ActionCfg actionCfg) {
        ActionHandle actionHandle = getActionHandleForActiveOrActivatingSessionTabContext(actionCfg);

        ButtonBase b;
        if (actionCfg.getActionType() == ActionType.NON_TOGGLE) {
            b = new Button();
        } else // if (actionCfg.getActionType() == ActionType.NON_TOGGLE)
        {
            b = new ToggleButton();
        }

        actionHandle.addToolbarButton(b);
        toolBar.getItems().add(b);
        return actionHandle;
    }

    public void setActionScope(ActionScope currentActionScope) {
        _currentActionScope = currentActionScope;
        CollectionUtil.forEachFiltered(_actionHandles, ah -> ah.matchesSessionContext(_activeOrActivatingSessionTabContext), ah -> ah.setActionScope(_currentActionScope));
    }

    public void updateActionUIs() {
        CollectionUtil.forEachFiltered(_actionHandles, ah -> ah.matchesSessionContext(_activeOrActivatingSessionTabContext), ah -> ah.refreshActionUI());
    }

    public ActionHandle getActionHandleForActiveOrActivatingSessionTabContext(ActionCfg actionCfg) {
        return getActionHandle(actionCfg, _activeOrActivatingSessionTabContext);
    }

    public ActionHandle getActionHandle(ActionCfg actionCfg, SessionTabContext sessionTabContext) {
        ActionHandle ret;

        List<ActionHandle> handles = CollectionUtil.filter(_actionHandles, ah -> ah.matchesPrimaryKey(actionCfg, sessionTabContext));

        if (0 == handles.size()) {
            ret = new ActionHandle(actionCfg, sessionTabContext);
            ret.setActionScope(_currentActionScope);
            _actionHandles.add(ret);
        } else if (1 == handles.size()) {
            ret = handles.get(0);
        } else {
            String msg = "More than one ActionHandle exist for SessionTabContext = " + sessionTabContext.getSessionTabTitle() + " and ActionConfig = " + actionCfg.getActionConfigurationId();
            throw new IllegalStateException(msg);
        }

        return ret;
    }

    public void onContextClosing(SessionTabContext sessionTabContext) {
        _actionHandles.removeIf(ah -> ah.getSessionTabContext().matches(sessionTabContext));
    }

    public List<ActionCfg> getSQLEditRightMouseActionCfgs() {
        ArrayList<ActionCfg> ret = new ArrayList<>();

        for (StdActionCfg stdActionCfg : StdActionCfg.SQL_EDITOR_RIGHT_MOUSE_MENU) {
            if (StdActionCfg.SEPARATOR != stdActionCfg) {
                ret.add(stdActionCfg.getActionCfg());
            }
        }

        return ret;
    }

    public List<ActionCfg> getAllActionCfgs() {
        ArrayList<ActionCfg> ret = new ArrayList<>();

        for (StdActionCfg stdActionCfg : StdActionCfg.values()) {
            if (StdActionCfg.SEPARATOR != stdActionCfg) {
                ret.add(stdActionCfg.getActionCfg());
            }
        }

        return ret;
    }
}
