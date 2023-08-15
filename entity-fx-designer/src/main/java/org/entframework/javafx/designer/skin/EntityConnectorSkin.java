/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */
package org.entframework.javafx.designer.skin;

import io.github.eckig.grapheditor.GConnectorSkin;
import io.github.eckig.grapheditor.GConnectorStyle;
import io.github.eckig.grapheditor.model.GConnector;
import javafx.css.PseudoClass;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

/**
 * A square-shaped connector skin for the 'grey-skins' theme.
 */
public class EntityConnectorSkin extends GConnectorSkin {

    private static final String STYLE_CLASS = "entity-connector"; //$NON-NLS-1$
    private static final String STYLE_CLASS_FORBIDDEN_GRAPHIC = "entity-connector-forbidden-graphic"; //$NON-NLS-1$

    private static final double SIZE = 15;

    private static final PseudoClass PSEUDO_CLASS_ALLOWED = PseudoClass.getPseudoClass("allowed"); //$NON-NLS-1$
    private static final PseudoClass PSEUDO_CLASS_FORBIDDEN = PseudoClass.getPseudoClass("forbidden"); //$NON-NLS-1$
    private static final PseudoClass PSEUDO_CLASS_SELECTED = PseudoClass.getPseudoClass("selected"); //$NON-NLS-1$

    private final Pane root = new Pane();

    private final Group forbiddenGraphic;

    /**
     * Creates a new {@link EntityConnectorSkin} instance.
     *
     * @param connector the {@link GConnector} that this skin is representing
     */
    public EntityConnectorSkin(final GConnector connector) {

        super(connector);

        root.setMinSize(SIZE, SIZE);
        root.setPrefSize(SIZE, SIZE);
        root.setMaxSize(SIZE, SIZE);
        root.getStyleClass().setAll(STYLE_CLASS);
        root.setPickOnBounds(false);

        forbiddenGraphic = createForbiddenGraphic();
        root.getChildren().addAll(forbiddenGraphic);
    }

    @Override
    public Node getRoot() {
        return root;
    }

    @Override
    public double getWidth() {
        return SIZE;
    }

    @Override
    public double getHeight() {
        return SIZE;
    }

    @Override
    public void applyStyle(final GConnectorStyle style) {

        switch (style) {

            case DEFAULT:
                root.pseudoClassStateChanged(PSEUDO_CLASS_FORBIDDEN, false);
                root.pseudoClassStateChanged(PSEUDO_CLASS_ALLOWED, false);
                forbiddenGraphic.setVisible(false);
                break;

            case DRAG_OVER_ALLOWED:
                root.pseudoClassStateChanged(PSEUDO_CLASS_FORBIDDEN, false);
                root.pseudoClassStateChanged(PSEUDO_CLASS_ALLOWED, true);
                forbiddenGraphic.setVisible(false);
                break;

            case DRAG_OVER_FORBIDDEN:
                root.pseudoClassStateChanged(PSEUDO_CLASS_FORBIDDEN, true);
                root.pseudoClassStateChanged(PSEUDO_CLASS_ALLOWED, false);
                forbiddenGraphic.setVisible(true);
                break;
        }
    }

    @Override
    protected void selectionChanged(boolean isSelected) {
        if (isSelected) {
            root.pseudoClassStateChanged(PSEUDO_CLASS_SELECTED, true);
        } else {
            root.pseudoClassStateChanged(PSEUDO_CLASS_SELECTED, false);
        }
    }

    /**
     * Creates a graphic to display a 'forbidden' effect in the connector.
     *
     * @return the new graphic
     */
    private Group createForbiddenGraphic() {

        final Group group = new Group();
        final Line firstLine = new Line(1, 1, SIZE - 1, SIZE - 1);
        final Line secondLine = new Line(1, SIZE - 1, SIZE - 1, 1);

        firstLine.getStyleClass().add(STYLE_CLASS_FORBIDDEN_GRAPHIC);
        secondLine.getStyleClass().add(STYLE_CLASS_FORBIDDEN_GRAPHIC);

        group.getChildren().addAll(firstLine, secondLine);
        group.setVisible(false);

        return group;
    }
}
