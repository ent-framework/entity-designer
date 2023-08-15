/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */
package org.entframework.javafx.designer.skin;

import io.github.eckig.grapheditor.GConnectorSkin;
import io.github.eckig.grapheditor.GNodeSkin;
import io.github.eckig.grapheditor.GraphEditor;
import io.github.eckig.grapheditor.model.GNode;
import io.github.eckig.grapheditor.utils.GeometryUtils;
import javafx.css.PseudoClass;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.entframework.javafx.common.event.DefaultEventBus;
import org.entframework.javafx.common.event.EntityEvent;
import org.entframework.javafx.common.utils.ResourceUtils;
import org.entframework.javafx.designer.entitydesigner.model.EEntityObject;
import org.entframework.javafx.designer.entitydesigner.model.EFieldObject;
import org.kordamp.ikonli.antdesignicons.AntDesignIconsOutlined;
import org.kordamp.ikonli.javafx.FontIcon;

import java.util.ArrayList;
import java.util.List;

/**
 * A grey node with a navy title-bar for the 'titled-skins' theme.
 */
public class EntityNodeSkin extends GNodeSkin {

    private static final String TITLE_TEXT = "Node "; //$NON-NLS-1$

    private static final String STYLE_CLASS_BORDER = "entity-node-border"; //$NON-NLS-1$
    private static final String ENTITY_NODE_BOX = "entity-node-box"; //$NON-NLS-1$
    private static final String ENTITY_NODE_CONTENT = "entity-node-content"; //$NON-NLS-1$
    private static final String STYLE_CLASS_SELECTION_HALO = "entity-node-selection-halo"; //$NON-NLS-1$
    private static final String STYLE_CLASS_HEADER = "entity-node-header"; //$NON-NLS-1$
    private static final String STYLE_CLASS_TITLE = "entity-node-title"; //$NON-NLS-1$
    private static final String STYLE_CLASS_FIELD = "entity-node-field"; //$NON-NLS-1$

    private static final PseudoClass PSEUDO_CLASS_SELECTED = PseudoClass.getPseudoClass("selected"); //$NON-NLS-1$
    private static final double HALO_OFFSET = 5;
    private static final double HALO_CORNER_SIZE = 10;

    private static final double MIN_WIDTH = 81;
    private static final double MIN_HEIGHT = 81;

    private static final int BORDER_WIDTH = 1;
    private static final int HEADER_HEIGHT = 30;

    private final Rectangle selectionHalo = new Rectangle();
    private final List<GConnectorSkin> inputConnectorSkins = new ArrayList<>();
    private final List<GConnectorSkin> outputConnectorSkins = new ArrayList<>();
    private final Rectangle border = new Rectangle();
    private final VBox contentRoot = new VBox();
    private final VBox fieldContent = new VBox();
    private final HBox header = new HBox();
    private final Label title = new Label();

    /**
     * Creates a new {@link EntityNodeSkin} instance.
     *
     * @param node the {link GNode} this skin is representing
     */
    public EntityNodeSkin(final GNode node) {

        super(node);
        border.getStyleClass().setAll(STYLE_CLASS_BORDER);
        border.widthProperty().bind(getRoot().widthProperty());
        border.heightProperty().bind(getRoot().heightProperty());

        getRoot().getChildren().add(border);
        getRoot().setMinSize(MIN_WIDTH, MIN_HEIGHT);

        addSelectionHalo();

        createContent();

        contentRoot.addEventFilter(MouseEvent.MOUSE_DRAGGED, this::filterMouseDragged);
    }

    @Override
    public void initialize() {
        super.initialize();
        this.initView();
        //监听事件
        DefaultEventBus.getInstance().subscribe(EntityEvent.class, this::entityUpdate);
    }

    private void initView() {
        GNode item = getItem();
        EEntityObject entity = ResourceUtils.findEntity(item, item.getId());
        if (entity != null) {
            title.setText(entity.getName());

            fieldContent.getChildren().clear();
            if (entity.getPrimaryKey() != null) {

            }
            if (ObjectUtils.isNotEmpty(entity.getFields())) {
                for (EFieldObject field : entity.getFields()) {
                    HBox hBox = new HBox();
                    Label label = new Label(field.getName());
                    label.getStyleClass().add(STYLE_CLASS_FIELD);
                    label.setPadding(new Insets(0, 0, 0, 10));
                    label.setGraphic(FontIcon.of(AntDesignIconsOutlined.FIELD_STRING));
                    hBox.getChildren().add(label);
                    fieldContent.getChildren().add(hBox);
                }
            }
        } else {
            title.setText(TITLE_TEXT + getItem().getId());
        }
    }

    private void entityUpdate(EntityEvent e) {
        String entityId = e.getEntity().getId();
        if (StringUtils.isNotEmpty(entityId) && StringUtils.equals(entityId, getItem().getId())) {
            this.initView();
        }
    }

    @Override
    public void setConnectorSkins(final List<GConnectorSkin> connectorSkins) {

        removeAllConnectors();

        inputConnectorSkins.clear();
        outputConnectorSkins.clear();

        if (connectorSkins != null) {
            for (final GConnectorSkin connectorSkin : connectorSkins) {

                final boolean isInput = connectorSkin.getItem().getType().contains("input"); //$NON-NLS-1$
                final boolean isOutput = connectorSkin.getItem().getType().contains("output"); //$NON-NLS-1$

                if (isInput) {
                    inputConnectorSkins.add(connectorSkin);
                } else if (isOutput) {
                    outputConnectorSkins.add(connectorSkin);
                }

                if (isInput || isOutput) {
                    getRoot().getChildren().add(connectorSkin.getRoot());
                }
            }
        }

        setConnectorsSelected();
    }

    @Override
    public void layoutConnectors() {
        layoutLeftAndRightConnectors();
        layoutSelectionHalo();
    }

    @Override
    public Point2D getConnectorPosition(final GConnectorSkin connectorSkin) {

        final Node connectorRoot = connectorSkin.getRoot();

        final double x = connectorRoot.getLayoutX() + connectorSkin.getWidth() / 2;
        final double y = connectorRoot.getLayoutY() + connectorSkin.getHeight() / 2;

        if (inputConnectorSkins.contains(connectorSkin)) {
            return new Point2D(x, y);
        }
        // ELSE:
        // Subtract 1 to align start-of-connection correctly. Compensation for rounding errors?
        return new Point2D(x - 1, y);
    }

    /**
     * Creates the content of the node skin - header, title, close button, etc.
     */
    private void createContent() {

        header.getStyleClass().setAll(STYLE_CLASS_HEADER);
        header.setAlignment(Pos.CENTER);

        title.getStyleClass().setAll(STYLE_CLASS_TITLE);

        header.getChildren().addAll(title);

        fieldContent.getStyleClass().setAll(ENTITY_NODE_CONTENT);

        contentRoot.getChildren().add(header);
        contentRoot.getChildren().add(fieldContent);

        getRoot().getChildren().add(contentRoot);

        contentRoot.minWidthProperty().bind(getRoot().widthProperty());
        contentRoot.prefWidthProperty().bind(getRoot().widthProperty());
        contentRoot.maxWidthProperty().bind(getRoot().widthProperty());
        contentRoot.minHeightProperty().bind(getRoot().heightProperty());
        contentRoot.prefHeightProperty().bind(getRoot().heightProperty());
        contentRoot.maxHeightProperty().bind(getRoot().heightProperty());

        contentRoot.setLayoutX(BORDER_WIDTH);
        contentRoot.setLayoutY(BORDER_WIDTH);

        contentRoot.getStyleClass().setAll(ENTITY_NODE_BOX);
    }

    /**
     * Lays out all connectors.
     */
    private void layoutLeftAndRightConnectors() {

        final int inputCount = inputConnectorSkins.size();
        final double inputOffsetY = (getRoot().getHeight() - HEADER_HEIGHT) / (inputCount + 1);

        for (int i = 0; i < inputCount; i++) {

            final GConnectorSkin inputSkin = inputConnectorSkins.get(i);
            final Node connectorRoot = inputSkin.getRoot();

            final double layoutX = GeometryUtils.moveOnPixel(0 - inputSkin.getWidth() / 2);
            final double layoutY = GeometryUtils.moveOnPixel((i + 1) * inputOffsetY - inputSkin.getHeight() / 2);

            connectorRoot.setLayoutX(layoutX);
            connectorRoot.setLayoutY(layoutY + HEADER_HEIGHT);
        }

        final int outputCount = outputConnectorSkins.size();
        final double outputOffsetY = (getRoot().getHeight() - HEADER_HEIGHT) / (outputCount + 1);

        for (int i = 0; i < outputCount; i++) {

            final GConnectorSkin outputSkin = outputConnectorSkins.get(i);
            final Node connectorRoot = outputSkin.getRoot();

            final double layoutX = GeometryUtils.moveOnPixel(getRoot().getWidth() - outputSkin.getWidth() / 2);
            final double layoutY = GeometryUtils.moveOnPixel((i + 1) * outputOffsetY - outputSkin.getHeight() / 2);

            connectorRoot.setLayoutX(layoutX);
            connectorRoot.setLayoutY(layoutY + HEADER_HEIGHT);
        }
    }

    /**
     * Adds the selection halo and initializes some of its values.
     */
    private void addSelectionHalo() {

        getRoot().getChildren().add(selectionHalo);

        selectionHalo.setManaged(false);
        selectionHalo.setMouseTransparent(false);
        selectionHalo.setVisible(false);

        selectionHalo.setLayoutX(-HALO_OFFSET);
        selectionHalo.setLayoutY(-HALO_OFFSET);

        selectionHalo.getStyleClass().add(STYLE_CLASS_SELECTION_HALO);
    }

    /**
     * Lays out the selection halo based on the current width and height of the node skin region.
     */
    private void layoutSelectionHalo() {

        if (selectionHalo.isVisible()) {

            selectionHalo.setWidth(getRoot().getWidth() + 2 * HALO_OFFSET);
            selectionHalo.setHeight(getRoot().getHeight() + 2 * HALO_OFFSET);

            final double cornerLength = 2 * HALO_CORNER_SIZE;
            final double xGap = getRoot().getWidth() - 2 * HALO_CORNER_SIZE + 2 * HALO_OFFSET;
            final double yGap = getRoot().getHeight() - 2 * HALO_CORNER_SIZE + 2 * HALO_OFFSET;

            selectionHalo.setStrokeDashOffset(HALO_CORNER_SIZE);
            selectionHalo.getStrokeDashArray().setAll(cornerLength, yGap, cornerLength, xGap);
        }
    }


    @Override
    protected void selectionChanged(final boolean isSelected) {
        if (isSelected) {
            selectionHalo.setVisible(true);
            layoutSelectionHalo();
            contentRoot.pseudoClassStateChanged(PSEUDO_CLASS_SELECTED, true);
            getRoot().toFront();
        } else {
            selectionHalo.setVisible(false);
            contentRoot.pseudoClassStateChanged(PSEUDO_CLASS_SELECTED, false);
        }
        setConnectorsSelected();
    }

    /**
     * Removes any input and output connectors from the list of children, if they exist.
     */
    private void removeAllConnectors() {

        for (final GConnectorSkin connectorSkin : inputConnectorSkins) {
            getRoot().getChildren().remove(connectorSkin.getRoot());
        }

        for (final GConnectorSkin connectorSkin : outputConnectorSkins) {
            getRoot().getChildren().remove(connectorSkin.getRoot());
        }
    }

    /**
     * Adds or removes the 'selected' pseudo-class from all connectors belonging to this node.
     */
    private void setConnectorsSelected() {

        final GraphEditor editor = getGraphEditor();
        if (editor == null) {
            return;
        }

        for (final GConnectorSkin skin : inputConnectorSkins) {
            if (skin instanceof EntityConnectorSkin) {
                editor.getSelectionManager().select(skin.getItem());
            }
        }

        for (final GConnectorSkin skin : outputConnectorSkins) {
            if (skin instanceof EntityConnectorSkin) {
                editor.getSelectionManager().select(skin.getItem());
            }
        }
    }

    /**
     * Stops the node being dragged if it isn't selected.
     *
     * @param event a mouse-dragged event on the node
     */
    private void filterMouseDragged(final MouseEvent event) {
        if (event.isPrimaryButtonDown() && !isSelected()) {
            event.consume();
        }
    }
}
