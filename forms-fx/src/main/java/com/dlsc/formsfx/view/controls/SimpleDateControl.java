package com.dlsc.formsfx.view.controls;

/*-
 * ========================LICENSE_START=================================
 * FormsFX
 * %%
 * Copyright (C) 2017 - 2018 DLSC Software & Consulting
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */

import com.dlsc.formsfx.model.structure.DateField;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * This class provides a specific implementation to edit date values.
 *
 * @author Tomasz Krzemiński
 */
public class SimpleDateControl extends SimpleControl<DateField> {

    protected Label fieldLabel;
    protected DatePicker picker;
    protected Label readOnlyLabel;
    protected StackPane stack;

    @Override
    public void initializeParts() {
        super.initializeParts();

        stack = new StackPane();

        fieldLabel = new Label();
        readOnlyLabel = new Label();
        picker = new DatePicker();
        picker.setEditable(true);
    }

    @Override
    public void layoutParts() {
        super.layoutParts();

        readOnlyLabel.getStyleClass().add("read-only-label");

        picker.setMaxWidth(Double.MAX_VALUE);

        stack.setAlignment(Pos.CENTER_LEFT);
        stack.getChildren().addAll(picker, readOnlyLabel);

        Node labelDescription = field.getLabelDescription();
        Node valueDescription = field.getValueDescription();

        if (labelDescription != null) {
            Tooltip tooltip = new Tooltip();
            tooltip.setGraphic(labelDescription);
            fieldLabel.setTooltip(tooltip);
        }

        int labelSpan = field.getLabelSpan();
        add(fieldLabel, 0, 0, labelSpan, 1);
        add(stack, labelSpan, 0, 12 - labelSpan, 1);

    }

    @Override
    public void setupBindings() {
        super.setupBindings();

        picker.disableProperty().bind(field.editableProperty().not());
        readOnlyLabel.visibleProperty().bind(field.editableProperty().not());

        picker.getEditor().textProperty().bindBidirectional(field.userInputProperty());
        fieldLabel.textProperty().bind(field.labelProperty());
        picker.promptTextProperty().bind(field.placeholderProperty());
        picker.managedProperty().bind(picker.visibleProperty());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setupEventHandlers() {
        picker.getEditor().textProperty().addListener((observable, oldValue, newValue) -> field.userInputProperty().setValue(String.valueOf(newValue)));
    }

    @Override
    public Pane getContainer() {
        return stack;
    }
}
