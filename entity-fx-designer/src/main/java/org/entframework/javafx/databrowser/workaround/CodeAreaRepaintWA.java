/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.workaround;

import org.fxmisc.richtext.CodeArea;

public class CodeAreaRepaintWA {
    public static void avoidRepaintProblemsAfterTextModification(CodeArea sqlTextArea) {
//      sqlTextArea.requestLayout();
//      sqlTextArea.layout();
//
//      Platform.runLater(() -> sqlTextArea.requestLayout());
//      Platform.runLater(() -> sqlTextArea.layout());

    }
}
