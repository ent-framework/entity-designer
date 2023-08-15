/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.workaround;

import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class SessionTabSelectionRepaintWA {
    public static void forceTabContentRepaintOnSelection(TabPane sessionTabPane) {
        sessionTabPane.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> onTabChanged(newValue));
    }

    private static void onTabChanged(Tab newValue) {
        if (false == newValue.getContent() instanceof SplitPane) {
            return;
        }

        SplitPane objectTreeOrSqlTab = (SplitPane) newValue.getContent();

        double divPos = objectTreeOrSqlTab.getDividerPositions()[0];

        double differentDivPos;
        if (Math.abs(divPos - 0.5d) < 0.1d) {
            differentDivPos = 0;
        } else {
            differentDivPos = 1 - divPos;
        }
        objectTreeOrSqlTab.setDividerPosition(0, differentDivPos);

        SplitDividerWA.adjustDivider(objectTreeOrSqlTab, 0, divPos);

        //System.out.println("org.squirrelsql.workaround.SessionTabSelectionRepaintWA.changed");
    }
}
