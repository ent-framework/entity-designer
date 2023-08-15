/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.designer.skin;

import io.github.eckig.grapheditor.GConnectorSkin;
import io.github.eckig.grapheditor.GNodeSkin;
import io.github.eckig.grapheditor.GTailSkin;
import io.github.eckig.grapheditor.core.skins.defaults.DefaultConnectorSkin;
import io.github.eckig.grapheditor.core.skins.defaults.DefaultNodeSkin;
import io.github.eckig.grapheditor.core.skins.defaults.DefaultTailSkin;
import io.github.eckig.grapheditor.core.view.GraphEditorContainer;
import io.github.eckig.grapheditor.model.GConnector;
import io.github.eckig.grapheditor.model.GNode;
import org.entframework.javafx.designer.ext.ModelGraphEditor;

/**
 * Responsible for grey-skin specific logic in the graph editor demo.
 */
public class EntitySkinController extends DefaultSkinController {

    /**
     * Creates a new {@link EntitySkinController} instance.
     *
     * @param graphEditor          the graph editor on display in this demo
     * @param graphEditorContainer the graph editor container on display in this demo
     */
    public EntitySkinController(final ModelGraphEditor graphEditor, final GraphEditorContainer graphEditorContainer) {
        super(graphEditor, graphEditorContainer);
    }

    @Override
    public void activate() {
        super.activate();
        graphEditor.setNodeSkinFactory(this::createSkin);
        graphEditor.setConnectorSkinFactory(this::createSkin);
        graphEditor.setTailSkinFactory(this::createTailSkin);
    }

    private GNodeSkin createSkin(final GNode node) {
        return EntitySkinConstants.TITLED_NODE.equals(node.getType()) ? new EntityNodeSkin(node) : new DefaultNodeSkin(node);
    }

    private GConnectorSkin createSkin(final GConnector connector) {
        return EntitySkinConstants.TITLED_INPUT_CONNECTOR.equals(connector.getType()) || EntitySkinConstants.TITLED_OUTPUT_CONNECTOR.equals(connector.getType()) ?
                new EntityConnectorSkin(connector) : new DefaultConnectorSkin(connector);
    }

    private GTailSkin createTailSkin(final GConnector connector) {
        return EntitySkinConstants.TITLED_INPUT_CONNECTOR.equals(connector.getType()) || EntitySkinConstants.TITLED_INPUT_CONNECTOR.equals(connector.getType()) ?
                new EntityTailSkin(connector) : new DefaultTailSkin(connector);
    }
}
