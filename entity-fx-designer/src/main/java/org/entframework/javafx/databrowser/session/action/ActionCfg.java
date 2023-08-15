/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.action;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyEvent;
import org.entframework.javafx.databrowser.AppState;
import org.entframework.javafx.databrowser.workaround.KeyMatchWA;

public class ActionCfg {
    private final Image _icon;
    private final String _text;
    private final int _actionConfigurationId;
    private ActionScope _actionScope;
    private KeyCodeCombination _keyCodeCombination;
    private String _toolsPopUpSelector;
    private ActionType _actionType;
    private ActionDependency _actionDependency;


    public ActionCfg(Image icon, String text, String toolsPopUpSelector, ActionScope actionScope, KeyCodeCombination keyCodeCombination) {
        this(icon, text, toolsPopUpSelector, actionScope, keyCodeCombination, ActionDependency.SESSION_TAB, ActionType.NON_TOGGLE);
    }

    public ActionCfg(Image icon, String text, String toolsPopUpSelector, ActionScope actionScope, KeyCodeCombination keyCodeCombination, ActionDependency actionDependency, ActionType actionType) {
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Note: ActionConfigurations are supposed to be an application wide state like in the StandardActionConfiguration enum.
        // If though two ActionConfiguration objects for the same action-function would be created this would result in two different ActionHandles with different listeners
        _actionConfigurationId = AppState.get().getActionManager().getNextActionConfigurationId();
        //
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        _toolsPopUpSelector = toolsPopUpSelector;
        _actionScope = actionScope;
        _icon = icon;
        _text = text;
        _keyCodeCombination = keyCodeCombination;
        _actionDependency = actionDependency;
        _actionType = actionType;
    }

    public ActionScope getActionScope() {
        return _actionScope;
    }

    public ImageView getIcon() {
        return new ImageView(_icon);
    }

    public String getText() {
        return _text;
    }

    public String getToolsPopUpSelector() {
        return _toolsPopUpSelector;
    }

    public KeyCodeCombination getKeyCodeCombination() {
        return _keyCodeCombination;
    }


    public boolean matches(ActionCfg actionCfg) {
        return _actionConfigurationId == actionCfg._actionConfigurationId;
    }


    public boolean matchesKeyEvent(KeyEvent keyEvent) {
        return KeyMatchWA.matches(keyEvent, _keyCodeCombination);
    }

    /**
     * Shortcut method to set an action for the current SessionTabContext
     *
     * @param sqFxActionListener
     */
    public void setAction(SqFxActionListener sqFxActionListener) {
        ActionUtil.getActionHandleForActiveOrActivatingSessionTabContext(this).setAction(sqFxActionListener);
    }

    public void setToggleAction(SqFxToggleActionListener toggleActionListener) {
        ActionUtil.getActionHandleForActiveOrActivatingSessionTabContext(this).setToggleAction(toggleActionListener);
    }


    /**
     * Shortcut method to fire an action for the current SessionTabContext
     */
    public void fire() {
        ActionHandle handle = ActionUtil.getActionHandleForActiveOrActivatingSessionTabContext(this);
        handle.fire();
    }

    public void setDisable(boolean b) {
        ActionUtil.getActionHandleForActiveOrActivatingSessionTabContext(this).setDisable(b);
    }

    public boolean isToggleSelected() {
        return ActionUtil.getActionHandleForActiveOrActivatingSessionTabContext(this).isToggleSelected();
    }

    public void setToggleSelected(boolean toggleSelected) {
        ActionUtil.getActionHandleForActiveOrActivatingSessionTabContext(this).setToggleSelectState(toggleSelected);
    }

    public ActionType getActionType() {
        return _actionType;
    }

    public ActionDependency getActionDependency() {
        return _actionDependency;
    }

    public int getActionConfigurationId() {
        return _actionConfigurationId;
    }
}
