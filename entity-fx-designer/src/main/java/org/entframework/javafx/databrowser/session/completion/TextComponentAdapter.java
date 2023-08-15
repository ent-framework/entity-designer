/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.completion;

import javafx.beans.value.ChangeListener;
import javafx.scene.control.ListView;
import javafx.scene.text.Font;
import org.entframework.javafx.databrowser.session.sql.syntax.LexAndParseResultListener;

/**
 * Created by gerd on 02.02.16.
 */
public interface TextComponentAdapter {
    void setLexAndParseResultListener(LexAndParseResultListener lexAndParseResultListener);

    void calculateTableNextToCaret();

    String getTokenTillCaret(char... stopsToIgnore);

    String getLineTillCaret();

    void setPopupFocusListener(ChangeListener<Boolean> listener);

    Font getFont();

    void showPopup(ListView<CompletionCandidate> popupContent, CaretVicinity caretVicinity);

    void closePopup();

    void replaceJoinGeneratorAtCaretBy(String replacement);

    void replaceTokenAtCaretBy(int completedSplitsStringLength, boolean removeSucceedingChars, String replacement);
}
