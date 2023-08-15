/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql;

import org.entframework.javafx.databrowser.AppState;
import org.entframework.javafx.databrowser.services.Utils;
import org.entframework.javafx.databrowser.session.SessionTabContext;
import org.entframework.javafx.databrowser.session.action.ActionCfg;
import org.entframework.javafx.databrowser.session.action.StdActionCfg;
import org.entframework.javafx.databrowser.session.sql.filteredpopup.FilteredPopup;

import java.util.List;
import java.util.stream.Collectors;

public class ToolsPopupManager {
    private SQLTextAreaServices _sqlTextAreaServices;

    public ToolsPopupManager(SQLTextAreaServices sqlTextAreaServices, SessionTabContext sessionTabContext) {
        _sqlTextAreaServices = sqlTextAreaServices;
        StdActionCfg.SHOW_TOOLS_POPUP.setAction(this::showToolsPopup);
    }

    private void showToolsPopup() {
        List<ActionCfg> allActionsWithToolsPopUpSelector = getAllActionsWithToolsPopUpSelector();

        List<ToolsPopUpActionWrapper> wrappers = ToolsPopUpActionWrapper.wrap(allActionsWithToolsPopUpSelector);


        new FilteredPopup<>(_sqlTextAreaServices, "Tools won't be empty ;-)", wrappers, this::executeAction).showPopup();
    }

    private void executeAction(ToolsPopUpActionWrapper wrapper) {
        wrapper.getActionCfg().fire();
    }

    private List<ActionCfg> getAllActionsWithToolsPopUpSelector() {
        return AppState.get().getActionManager().getAllActionCfgs().stream().filter(ac -> false == Utils.isEmptyString(ac.getToolsPopUpSelector())).collect(Collectors.toList());
    }
}
