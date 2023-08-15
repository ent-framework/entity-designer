/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.completion;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.entframework.javafx.databrowser.services.Utils;
import org.entframework.javafx.databrowser.session.Session;
import org.entframework.javafx.databrowser.session.TableInfo;
import org.entframework.javafx.databrowser.session.parser.kernel.TableAliasInfo;
import org.entframework.javafx.databrowser.session.sql.WordBoundaryCheck;
import org.entframework.javafx.databrowser.session.sql.syntax.LexAndParseResultListener;

import java.util.ArrayList;
import java.util.List;

public class CompletionCtrl {
    private final Session _session;
    private final TextComponentAdapter _textComponentAdapter;
    private List<TableInfo> _currentTableInfosNextToCaret = new ArrayList<>();
    private TableAliasInfo[] _currentAliasInfos = new TableAliasInfo[0];
    private CompletionSelectedListener _onCompletionSelected;

    public CompletionCtrl(Session session, TextComponentAdapter textComponentAdapter) {
        _session = session;
        _textComponentAdapter = textComponentAdapter;

        _textComponentAdapter.setLexAndParseResultListener(new LexAndParseResultListener() {
            @Override
            public void currentTableInfosNextToCaret(List<TableInfo> tableInfos) {
                _currentTableInfosNextToCaret = tableInfos;
            }

            @Override
            public void aliasesFound(TableAliasInfo[] aliasInfos) {
                _currentAliasInfos = aliasInfos;
            }
        });
    }

    public void completeCode() {
        _completeCode(false);
    }

    private void _completeCode(boolean showPopupForSizeOne) {
        ///////////////////////////////////////////////////////////////////////////////////
        // In case just the caret was moved we refresh _currentTableInfosNextToCaret here
        _textComponentAdapter.calculateTableNextToCaret();
        //
        ///////////////////////////////////////////////////////////////////////////////////

        String tokenAtCaret = _textComponentAdapter.getTokenTillCaret(WordBoundaryCheck.DEREFENCER);
        String lineAtCaret = _textComponentAdapter.getLineTillCaret();


        CaretVicinity caretVicinity = new CaretVicinity(tokenAtCaret, lineAtCaret);

        ObservableList<CompletionCandidate> completions = new Completor(_session, _currentTableInfosNextToCaret, _currentAliasInfos).getCompletions(caretVicinity);

        if (0 == completions.size()) {
            return;
        }

        if (1 == completions.size() && false == showPopupForSizeOne) {
            executeCompletion(completions.get(0), false);
            return;
        }

        ListView<CompletionCandidate> listView = new ListView<>();
        listView.setItems(completions);

        listView.getSelectionModel().selectFirst();


        listView.setOnKeyReleased(keyEvent -> onHandleKeyOnPopupList((KeyEvent) keyEvent, listView));

        listView.setOnMouseClicked(event -> onMouseClickedList(event, listView));

        _textComponentAdapter.setPopupFocusListener((observable, oldValue, newValue) -> hideIfNotFocused(newValue));

        CompletionUtil.prepareCompletionList(listView, _textComponentAdapter.getFont());


        _textComponentAdapter.showPopup(listView, caretVicinity);

    }


    private void hideIfNotFocused(Boolean newValue) {
        if (false == newValue) {
            _textComponentAdapter.closePopup();
        }
    }


    private void onHandleKeyOnPopupList(KeyEvent keyEvent, ListView<CompletionCandidate> listView) {
        //if (KeyMatchWA.matches(keyEvent, new KeyCodeCombination(KeyCode.ENTER)))
        if (KeyCode.ENTER.equals(keyEvent.getCode())) {
            onCompletionSelected(keyEvent, listView, false);
        }
        //else if (KeyMatchWA.matches(keyEvent, new KeyCodeCombination(KeyCode.TAB)))
        else if (KeyCode.TAB.equals(keyEvent.getCode())) {
            onCompletionSelected(keyEvent, listView, true);
        }
        //else if(KeyMatchWA.matches(keyEvent, new KeyCodeCombination(KeyCode.ESCAPE)))
        else if (KeyCode.ESCAPE.equals(keyEvent.getCode())) {
            _textComponentAdapter.closePopup();
            keyEvent.consume();
        } else if (KeyCode.DOWN.equals(keyEvent.getCode())) {
        } else if (KeyCode.UP.equals(keyEvent.getCode())) {
        } else if (KeyCode.PAGE_DOWN.equals(keyEvent.getCode())) {
        } else if (KeyCode.PAGE_UP.equals(keyEvent.getCode())) {
        } else if (KeyCode.SPACE.equals(keyEvent.getCode())) {
        } else if (KeyCode.CONTROL.equals(keyEvent.getCode())) {
        } else {
            _textComponentAdapter.closePopup();
            Platform.runLater(() -> onCompleteNextChar());
        }
    }

    private void onCompleteNextChar() {
        if (false == Utils.isEmptyString(_textComponentAdapter.getTokenTillCaret())) {
            _completeCode(true);
        }
    }

    private void onCompletionSelected(KeyEvent keyEvent, ListView<CompletionCandidate> listView, boolean removeSucceedingChars) {
        finishCompletion(listView, removeSucceedingChars);
        keyEvent.consume();
    }

    private void finishCompletion(ListView<CompletionCandidate> listView, boolean removeSucceedingChars) {
        _textComponentAdapter.closePopup();
        CompletionCandidate selItem = listView.getSelectionModel().getSelectedItems().get(0);
        executeCompletion(selItem, removeSucceedingChars);

        if (null != _onCompletionSelected) {
            _onCompletionSelected.completionSelected();
        }
    }

    private void onMouseClickedList(MouseEvent event, ListView<CompletionCandidate> listView) {
        if (Utils.isDoubleClick(event)) {
            finishCompletion(listView, false);
        }
    }


    private void executeCompletion(CompletionCandidate completionCandidate, boolean removeSucceedingChars) {
        CaretVicinity caretVicinity = new CaretVicinity(_textComponentAdapter.getTokenTillCaret(), _textComponentAdapter.getLineTillCaret());
        String replacement = completionCandidate.getReplacement();
        if (null != replacement) {
            if (completionCandidate.isGeneratedJoin()) {
                _textComponentAdapter.replaceJoinGeneratorAtCaretBy(replacement);
            } else {
                _textComponentAdapter.replaceTokenAtCaretBy(caretVicinity.getCompletedSplitsStringLength(), removeSucceedingChars, replacement);
            }
        }
    }

    public void setOnCompletionSelected(CompletionSelectedListener onCompletionSelected) {
        _onCompletionSelected = onCompletionSelected;
    }
}
