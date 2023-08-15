/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.action;

import javafx.scene.control.ToolBar;
import org.entframework.javafx.databrowser.AppState;
import org.entframework.javafx.databrowser.session.SessionTabContext;

import java.util.List;


public class ActionUtil {

    public static ToolBar createStdActionToolbar() {
        return AppState.get().getActionManager().createStdActionToolbar();
    }

    public static void setActionScope(ActionScope actionScope) {
        AppState.get().getActionManager().setActionScope(actionScope);
    }

    public static ActionHandle getActionHandleForActiveOrActivatingSessionTabContext(ActionCfg actionCfg) {
        return AppState.get().getActionManager().getActionHandleForActiveOrActivatingSessionTabContext(actionCfg);
    }

    public static ActionHandle addActionToToolbar(ToolBar toolBar, ActionCfg actionCfg) {
        return AppState.get().getActionManager().addActionToToolbar(toolBar, actionCfg);
    }

    public static ActionHandle getActionHandle(StdActionCfg stdActionCfg, SessionTabContext sessionTabContext) {
        return AppState.get().getActionManager().getActionHandle(stdActionCfg.getActionCfg(), sessionTabContext);
    }

    public static void updateActionUIs() {
        AppState.get().getActionManager().updateActionUIs();
    }

    public static List<ActionCfg> getSQLEditRightMouseActionCfgs() {
        return AppState.get().getActionManager().getSQLEditRightMouseActionCfgs();
    }

    public static List<ActionCfg> getAllActionCfgs() {
        return AppState.get().getActionManager().getAllActionCfgs();
    }
}
