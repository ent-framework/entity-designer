/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser;

import javafx.application.Platform;
import org.entframework.javafx.databrowser.services.MessageHandler;
import org.entframework.javafx.databrowser.services.MessageHandlerDestination;

public class ExceptionHandler {

    public static void initHandling() {
        if (!Platform.isFxApplicationThread()) {
            throw new IllegalStateException("Must be on called on FxApplicationThread");
        }

        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                onUncaughtException(e);
            }
        });
    }

    private static void onUncaughtException(Throwable e) {
        if (Platform.isFxApplicationThread()) {
            handle(e);
        }

        Platform.runLater(() -> handle(e));
    }

    public static void handle(final Throwable t) {
        MessageHandler mh = new MessageHandler(ExceptionHandler.class, MessageHandlerDestination.MESSAGE_LOG);
        mh.error(t);
    }


}
