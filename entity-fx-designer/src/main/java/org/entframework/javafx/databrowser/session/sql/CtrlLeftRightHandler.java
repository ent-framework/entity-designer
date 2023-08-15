/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import org.entframework.javafx.databrowser.workaround.KeyMatchWA;
import org.fxmisc.richtext.CodeArea;

public class CtrlLeftRightHandler {
    private CodeArea _sqlTextArea;

    public CtrlLeftRightHandler(CodeArea sqlTextArea) {
        _sqlTextArea = sqlTextArea;

        // Filters(Capturing) before Handlers(Bubbling)
        // see http://docs.oracle.com/javafx/2/events/processing.htm
        sqlTextArea.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                onHandleKeyEvent(event);
            }
        });

    }

    private void onHandleKeyEvent(KeyEvent event) {
        if (KeyMatchWA.matches(event, new KeyCodeCombination(KeyCode.LEFT, KeyCombination.CONTROL_DOWN))) {
            onLeftCtrl();
            event.consume();
        } else if (KeyMatchWA.matches(event, new KeyCodeCombination(KeyCode.RIGHT, KeyCombination.CONTROL_DOWN))) {
            onRightCtrl();
            event.consume();
        } else if (KeyMatchWA.matches(event, new KeyCodeCombination(KeyCode.LEFT, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN))) {
            onLeftCtrlShift();
            event.consume();
        } else if (KeyMatchWA.matches(event, new KeyCodeCombination(KeyCode.RIGHT, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN))) {
            onRightCtrlShift();
            event.consume();
        }
    }

    private void onLeftCtrlShift() {
        moveCtrlLeft(true);
    }

    private void onLeftCtrl() {
        moveCtrlLeft(false);
        clearSelectionAnchor();
    }

    private void moveCtrlLeft(boolean select) {
        String text = _sqlTextArea.getText();
        int pos = _sqlTextArea.getCaretPosition() - 1;

        if (pos < 0) {
            return;
        }


        for (; pos > 0; --pos) {
            if (WordBoundaryCheck.isToStopAt(text.charAt(pos - 1), text.charAt(pos))) {
                break;
            }
        }

        if (select) {
            moveCaretAndSelect(pos);
        } else {
            _sqlTextArea.moveTo(pos);
        }
    }


    private void onRightCtrlShift() {
        moveCtrlRight(true);
    }

    private void onRightCtrl() {
        moveCtrlRight(false);
        clearSelectionAnchor();
    }

    private void clearSelectionAnchor() {
        _sqlTextArea.selectRange(_sqlTextArea.getCaretPosition(), _sqlTextArea.getCaretPosition());
    }

    private void moveCtrlRight(boolean select) {
        String text = _sqlTextArea.getText();
        int pos = _sqlTextArea.getCaretPosition() + 1;

        if (pos > text.length()) {
            return;
        }


        for (; pos < text.length(); ++pos) {
            if (WordBoundaryCheck.isToStopAt(text.charAt(pos), text.charAt(pos - 1))) {
                break;
            }
        }

        if (select) {
            moveCaretAndSelect(pos);
        } else {
            _sqlTextArea.moveTo(pos);
        }
    }

    private void moveCaretAndSelect(int pos) {
        _sqlTextArea.selectRange(_sqlTextArea.getAnchor(), pos);
    }


}
