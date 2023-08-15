/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.action;

import javafx.scene.control.ToolBar;
import org.entframework.javafx.databrowser.AppState;
import org.entframework.javafx.databrowser.Props;
import org.entframework.javafx.databrowser.globalicons.GlobalIconNames;
import org.entframework.javafx.databrowser.services.I18n;
import org.entframework.javafx.databrowser.services.MessageHandler;
import org.entframework.javafx.databrowser.services.MessageHandlerDestination;
import org.entframework.javafx.databrowser.services.SquirrelProperty;

public class LogTest {
    public static void checkAndAddTestToolbarButtons(ToolBar toolBar) {
        if (!AppState.get().getPropertiesHandler().getBooleanProperty(SquirrelProperty.LOG_TEST_TOOLBAR_BUTTONS)) {
            return;
        }

        Props props = new Props(LogTest.class);
        I18n i18n = new I18n(LogTest.class);

        ActionCfg actError = new ActionCfg(props.getImage(GlobalIconNames.ERROR), i18n.t("log.test.error"), null, ActionScope.UNSCOPED, null);
        AppState.get().getActionManager().addActionToToolbar(toolBar, actError).setAction(LogTest::logError);

        ActionCfg actWarn = new ActionCfg(props.getImage(GlobalIconNames.WARNING), i18n.t("log.test.warning"), null, ActionScope.UNSCOPED, null);
        AppState.get().getActionManager().addActionToToolbar(toolBar, actWarn).setAction(LogTest::logWarning);

        ActionCfg actInfo = new ActionCfg(props.getImage(GlobalIconNames.INFORMATION), i18n.t("log.test.info"), null, ActionScope.UNSCOPED, null);
        AppState.get().getActionManager().addActionToToolbar(toolBar, actInfo).setAction(LogTest::logInfo);
    }

    private static void logInfo() {
        new MessageHandler(LogTest.class, MessageHandlerDestination.MESSAGE_LOG).info("Log test: INFO");
    }

    private static void logWarning() {
        new MessageHandler(LogTest.class, MessageHandlerDestination.MESSAGE_LOG).warning("Log test: WARNING", new Throwable("Test warning throwable"));
    }

    private static void logError() {
        new MessageHandler(LogTest.class, MessageHandlerDestination.MESSAGE_LOG).error("Log test: ERROR", new Throwable("Test error throwable"));
    }
}
