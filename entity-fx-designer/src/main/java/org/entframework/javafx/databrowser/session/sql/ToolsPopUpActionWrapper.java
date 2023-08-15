/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql;

import org.entframework.javafx.databrowser.session.action.ActionCfg;
import org.entframework.javafx.databrowser.session.sql.filteredpopup.FilteredPopupEntry;

import java.util.List;
import java.util.stream.Collectors;

public class ToolsPopUpActionWrapper implements FilteredPopupEntry {
    private ActionCfg _actionCfg;

    public ToolsPopUpActionWrapper(ActionCfg actionCfg) {
        _actionCfg = actionCfg;
    }

    public static List<ToolsPopUpActionWrapper> wrap(List<ActionCfg> toWrap) {
        return toWrap.stream().map(ToolsPopUpActionWrapper::new).collect(Collectors.toList());
    }

    @Override
    public String getSelShortcut() {
        return _actionCfg.getToolsPopUpSelector();
    }

    @Override
    public String getDescription() {
        if (null == _actionCfg.getKeyCodeCombination()) {
            return _actionCfg.getText();
        } else {
            return _actionCfg.getText() + "  " + _actionCfg.getKeyCodeCombination();
        }
    }

    public ActionCfg getActionCfg() {
        return _actionCfg;
    }
}
