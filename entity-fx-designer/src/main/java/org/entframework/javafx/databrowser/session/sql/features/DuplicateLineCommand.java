/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql.features;

import org.entframework.javafx.databrowser.session.sql.SQLTextAreaServices;

public class DuplicateLineCommand {
    public DuplicateLineCommand(SQLTextAreaServices sqlTextAreaServices) {
        String selectedText = sqlTextAreaServices.getTextArea().getSelectedText();

        if (null != selectedText && 0 < selectedText.length()) {
            int selectionEnd = sqlTextAreaServices.getTextArea().getSelection().getEnd();
            sqlTextAreaServices.getTextArea().insertText(selectionEnd, selectedText);
            sqlTextAreaServices.getTextArea().selectRange(selectionEnd, selectionEnd + selectedText.length());
        } else {
            duplicateCurrentLine(sqlTextAreaServices);
        }

    }

    private void duplicateCurrentLine(SQLTextAreaServices sqlTextAreaServices) {
        String text = sqlTextAreaServices.getTextArea().getText();
        int caretPosition = sqlTextAreaServices.getTextArea().getCaretPosition();

        int docLen = text.length();


        int lineBeg = 0;
        for (int i = caretPosition - 1; i > 0; --i) {
            if (text.charAt(i) == '\n') {
                lineBeg = i;
                break;
            }
        }

        int lineEnd = text.length();
        for (int i = caretPosition; i < docLen; ++i) {
            if (text.charAt(i) == '\n') {
                lineEnd = i;
                break;
            }
        }

        String line = text.substring(lineBeg, lineEnd);

        if (0 == lineBeg) {
            line += "\n";
        }

        sqlTextAreaServices.getTextArea().insertText(lineBeg, line);

        sqlTextAreaServices.getTextArea().moveTo(caretPosition + line.length());
    }

}
