/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.workaround;

import javafx.application.Platform;
import javafx.scene.Node;

import java.util.Timer;
import java.util.TimerTask;

public class FocusNodeWA {
    public static void forceFocus(Node node) {
        node.requestFocus();

        final Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                onTimerTick(timer, node);
            }
        };
        timer.schedule(timerTask, 0, 100);

    }

    private static void onTimerTick(Timer timer, Node node) {
        Platform.runLater(() -> forceFocus(timer, node));
    }

    private static void forceFocus(Timer timer, Node node) {
        //System.out.println("org.squirrelsql.workaround.FocusSqlTextAreaWA.forceFocus");

        if (false == node.isFocused()) {
            node.requestFocus();
            return;
        }

        timer.cancel();
        timer.purge();
    }
}
