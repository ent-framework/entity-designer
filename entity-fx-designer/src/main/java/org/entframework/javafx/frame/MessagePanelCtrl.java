/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.frame;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import org.entframework.javafx.common.event.DefaultEventBus;
import org.entframework.javafx.common.event.MessagePanelEvent;
import org.entframework.javafx.common.spring.FXMLController;
import org.entframework.javafx.databrowser.TextBounds;
import org.entframework.javafx.databrowser.services.GuiUtils;
import org.entframework.javafx.databrowser.services.I18n;
import org.entframework.javafx.databrowser.services.Utils;
import org.entframework.javafx.databrowser.services.rightmousemenuhandler.RightMouseMenuHandler;
import org.entframework.javafx.databrowser.workaround.StringWidthWA;


@FXMLController
public class MessagePanelCtrl {
    private static final String STYLE_RED = "-fx-border-color: red; -fx-border-width: 1;";
    private static final String STYLE_YELLOW = "-fx-border-color: yellow; -fx-border-width: 1;";
    private static final String STYLE_GREEN = "-fx-border-color: green; -fx-border-width: 1;";
    private static final String STYLE_LIGHT_RED = "-fx-border-color: indianred; -fx-border-width: 1";
    @FXML
    private ScrollPane root;
    @FXML
    private VBox vBox;

    public void initialize() {
        vBox.setFillWidth(true);
        vBox.heightProperty().addListener((observableValue, oldNumber, newNumber) -> root.setVvalue(newNumber.doubleValue()));

        RightMouseMenuHandler messagePanelRightMouseMenuHandler = new RightMouseMenuHandler(root);
        messagePanelRightMouseMenuHandler.addMenu(getClearMenuText(), this::clearMessagePanel);

        DefaultEventBus.getInstance().subscribe(MessagePanelEvent.class, event -> {
            switch (event.getType()) {
                case INFO -> info(event.getMessage());
                case WARNING -> warning(event.getMessage(), event.getThrowable());
                case ERROR -> error(event.getMessage(), event.getThrowable());
            }
        });
    }

    private void clearMessagePanel() {
        vBox.getChildren().clear();
    }

    private String getClearMenuText() {
        return new I18n(getClass(), "org.entframework.javafx.databrowser.i18n").t("msg.clear.messagepanel");
    }

    public void error(String s) {
        addMessage(s, STYLE_RED);
    }

    public void warning(String s) {
        addMessage(s, STYLE_YELLOW);
    }

    public void warning(String s, Throwable t) {
        addMessage(formatMessageWithStacktrace(s, t), STYLE_YELLOW);
    }


    public void info(String s) {
        addMessage(s, STYLE_GREEN);
    }

    private void addMessage(String s, String style) {
        if (Platform.isFxApplicationThread()) {
            _addMessage(s, style);
        } else {
            Platform.runLater(() -> _addMessage(s, style));
        }

    }

    private void _addMessage(String s, String style) {
        int size = vBox.getChildren().size();
        if (0 < size) {
            TextArea label = (TextArea) vBox.getChildren().get(size - 1);

            if (STYLE_RED.equals(label.getStyle())) {
                label.setStyle(STYLE_LIGHT_RED);
            }
        }

        //https://forums.oracle.com/forums/thread.jspa?threadID=2317231
        TextArea label = new TextArea(s);
        label.setStyle(style);
        label.setEditable(false);
        TextBounds textBounds = getTextBounds(s, label.getFont());
        label.setPrefRowCount(textBounds.getRows());
        label.setMinWidth(textBounds.getTextWidth());
        label.setMaxWidth(textBounds.getTextWidth() + 20);

        MenuItem mnuClear = new MenuItem(getClearMenuText());
        mnuClear.setOnAction(event -> clearMessagePanel());
        GuiUtils.addContextMenuItemToStandardTextAreaMenu(label, mnuClear);

        vBox.getChildren().add(label);
        vBox.requestLayout();
    }

    private TextBounds getTextBounds(String s, Font font) {
        int rows;
        double textWidth = 0;

        String[] splits = s.trim().split("\n");

        rows = splits.length;
        for (String split : splits) {
            textWidth = Math.max(textWidth, StringWidthWA.computeTextWidth(font, split));
        }

        return new TextBounds(textWidth + 50, rows);
    }

    public void error(Throwable t) {
    }

    public Node getNode() {
        return root;
    }

    public void error(String s, Throwable t) {
        if (null == s && null == t) {
            return;
        } else if (null == s) {
            error(Utils.getStackString(t));
        } else if (null == t) {
            error(s);
        } else {
            error(formatMessageWithStacktrace(s, t));
        }

    }

    private String formatMessageWithStacktrace(String s, Throwable t) {
        String ret = s;

        if (null != t) {
            s += "\n" + Utils.getStackString(t);
        }

        return ret;
    }
}
