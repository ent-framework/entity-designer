/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.services;

import org.entframework.javafx.common.event.DefaultEventBus;
import org.entframework.javafx.common.event.MessageEvent;
import org.entframework.javafx.common.event.MessageLogEvent;
import org.entframework.javafx.common.event.MessagePanelEvent;
import org.entframework.javafx.databrowser.AppState;

import java.sql.SQLException;

public class MessageHandler {
    private Class _clazz;
    private MessageHandlerDestination _dest;

    public MessageHandler(Class clazz, MessageHandlerDestination dest) {
        _clazz = clazz;
        _dest = dest;
    }

    public void warning(String s) {
        warning(s, null);
    }

    public void warning(String s, Throwable t) {
        GuiUtils.executeOnEDT(() -> _warning(s, t));
    }

    private void _warning(String s, Throwable t) {
        try {
            if (MessageHandlerDestination.MESSAGE_LOG.matches(_dest)) {
                DefaultEventBus.getInstance().publish(new MessageLogEvent(s, t, MessageEvent.Type.WARNING));
            }

            if (MessageHandlerDestination.MESSAGE_PANEL.matches(_dest)) {
                DefaultEventBus.getInstance().publish(new MessagePanelEvent(s, t, MessageEvent.Type.WARNING));
            }
        } catch (Throwable tmh) {
            handleErrorInMessaging(s, t, tmh);
        }
    }

    public void info(String s) {
        GuiUtils.executeOnEDT(() -> _info(s));
    }

    private void _info(String s) {
        try {
            if (MessageHandlerDestination.MESSAGE_LOG.matches(_dest)) {
                DefaultEventBus.getInstance().publish(new MessageLogEvent(s, null, MessageEvent.Type.INFO));
            }

            if (MessageHandlerDestination.MESSAGE_PANEL.matches(_dest)) {
                DefaultEventBus.getInstance().publish(new MessagePanelEvent(s, null, MessageEvent.Type.INFO));
            }
        } catch (Throwable tmh) {
            handleErrorInMessaging(s, null, tmh);
        }
    }

    public void error(String s) {
        error(s, null);
    }


    public void error(Throwable t) {
        error(null, t);
    }

    public void error(String s, Throwable t) {
        GuiUtils.executeOnEDT(() -> _error(s, t));
    }

    private void _error(String s, Throwable t) {
        try {
            if (MessageHandlerDestination.MESSAGE_LOG.matches(_dest)) {
                DefaultEventBus.getInstance().publish(new MessageLogEvent(s, t, MessageEvent.Type.ERROR));
            }

            if (MessageHandlerDestination.MESSAGE_PANEL.matches(_dest)) {
                DefaultEventBus.getInstance().publish(new MessagePanelEvent(s, t, MessageEvent.Type.ERROR));
            }
        } catch (Throwable tmh) {
            handleErrorInMessaging(s, t, tmh);
        }
    }

    private void handleErrorInMessaging(String msg, Throwable originalError, Throwable errorFromMessageHandler) {
        System.err.println("### Error occurred in message/error handling. We provide the following information in the following order:");
        System.err.println("### 1. The original message that failed to be handled");
        System.err.println("### 2. The original error that failed to be handled");
        System.err.println("### 3. The error that occurred during message/error handling");
        System.err.println("### Here we go:");
        System.err.println("### ");
        System.err.println("### 1. The original message that failed to be handled:");

        if (Utils.isEmptyString(msg)) {
            System.err.println("### <MESSAGE WAS NULL>");
        } else {
            System.err.println(msg);
        }

        System.err.println("### ");
        System.err.println("### 2. The original error that failed to be handled:");

        if (null == originalError) {
            System.err.println("### <ERROR WAS NULL>");
        } else {
            originalError.printStackTrace(System.err);
        }

        System.err.println("### ");
        System.err.println("### 3. The error that occurred during message/error handling");

        errorFromMessageHandler.printStackTrace(System.err);


    }

    public static String errorSQLNoStack(SQLException e) {
        SQLException buf = e;

        String errMsg = "";

        while (null != buf) {
            errMsg = getSQLNoStackMessage(buf) + errMsg;
            buf = buf.getNextException();
        }

        return errMsg;
    }

    private static String getSQLNoStackMessage(SQLException e) {
        return e.getMessage() + "\nError code: " + e.getErrorCode() + "\nSQL state: " + e.getSQLState();
    }
}
