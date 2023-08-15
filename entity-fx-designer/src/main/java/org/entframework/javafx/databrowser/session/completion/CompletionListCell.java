/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.completion;

import javafx.scene.control.ListCell;
import javafx.scene.text.Font;

public class CompletionListCell extends ListCell {

    public CompletionListCell(Font font) {
        setFont(font);
    }

    @Override
    protected void updateItem(Object item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setText(null);
            return;
        }


        setText(item.toString());
    }
}
