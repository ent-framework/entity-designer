/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.designer.skin;

import io.github.eckig.grapheditor.core.view.GraphEditorContainer;
import org.entframework.javafx.designer.ext.ModelGraphEditor;

/**
 * Responsible for default-skin specific logic in the graph editor demo.
 */
public class DefaultSkinController implements SkinController {
    protected final ModelGraphEditor graphEditor;
    protected final GraphEditorContainer graphEditorContainer;

    /**
     * Creates a new {@link DefaultSkinController} instance.
     *
     * @param graphEditor          the graph editor on display in this demo
     * @param graphEditorContainer the graph editor container on display in this demo
     */
    public DefaultSkinController(final ModelGraphEditor graphEditor, final GraphEditorContainer graphEditorContainer) {

        this.graphEditor = graphEditor;
        this.graphEditorContainer = graphEditorContainer;
    }

    @Override
    public void activate() {
        graphEditorContainer.getMinimap().setConnectionFilter(c -> true);
    }
}
