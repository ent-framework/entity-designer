/*
 * Copyright (C) 2005 - 2014 by TESIS DYNAware GmbH
 */
package io.github.eckig.grapheditor.window;

import io.github.eckig.grapheditor.SelectionManager;
import io.github.eckig.grapheditor.model.*;
import javafx.beans.InvalidationListener;
import javafx.beans.WeakInvalidationListener;
import javafx.beans.property.ObjectProperty;
import javafx.css.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.*;
import java.util.function.Predicate;


/**
 * The minimap representation of all nodes in the graph editor.
 *
 * <p>
 * This is responsible for drawing mini versions of all nodes in a
 * {@link GModel}. This group of mini-nodes is then displayed inside the
 * {@link GraphEditorMinimap}.
 * </p>
 */
class MinimapNodeGroup extends Parent {

    private static final PseudoClass PSEUDO_CLASS_SELECTED = PseudoClass.getPseudoClass("selected"); //$NON-NLS-1$

    private final InvalidationListener checkSelectionListener = obs -> checkSelection();
    private final InvalidationListener checkSelectionWeakListener = new WeakInvalidationListener(checkSelectionListener);

    private SelectionManager selectionManager;
    private GModel model;

    private final Map<GNode, Node> nodes = new HashMap<>();

    private IMinimapRenderer<?> minimapRenderer = new IMinimapRenderer.DefaultMinimapRenderer();
    private Predicate<GConnection> connectionFilter = c -> true;

    private double width = -1;
    private double height = -1;
    private double scaleFactor = -1;
    private final Canvas canvas = new Canvas();

    private final StyleableObjectProperty<Color> connectionColor = new StyleableObjectProperty<>(Color.GRAY) {

        @Override
        public String getName() {
            return "connectionColor"; //$NON-NLS-1$
        }

        @Override
        public Object getBean() {
            return "GraphEditorMinimap"; //$NON-NLS-1$
        }

        @Override
        public CssMetaData<? extends Styleable, Color> getCssMetaData() {
            return StyleableProperties.CONNECTION_COLOR;
        }
    };

    /**
     * Default constructor
     */
    public MinimapNodeGroup() {
        getChildren().add(canvas);
    }

    /**
     * Sets the selection manager instance currently in use by this graph
     * editor.
     *
     * <p>
     * This will be used to show what nodes are currently selected.
     * <p>
     *
     * @param pSelectionManager a {@link SelectionManager} instance
     */
    public void setSelectionManager(final SelectionManager pSelectionManager) {
        if (selectionManager != null) {
            selectionManager.getSelectedItems().removeListener(checkSelectionWeakListener);
        }

        selectionManager = pSelectionManager;

        if (selectionManager != null) {
            selectionManager.getSelectedItems().addListener(checkSelectionWeakListener);
        }
        checkSelection();
    }

    /**
     * Sets the model whose nodes will be drawn in the minimap.
     *
     * @param pModel the {@link GModel} whose nodes are to be drawn
     */
    public void setModel(final GModel pModel) {
        model = pModel;
    }

    private void checkSelection() {
        for (final Map.Entry<GNode, Node> entry : nodes.entrySet()) {
            entry.getValue().pseudoClassStateChanged(PSEUDO_CLASS_SELECTED, isSelected(entry.getKey()));
        }
    }

    private boolean isSelected(final GNode node) {
        return selectionManager != null && selectionManager.isSelected(node);
    }

    private static double scaleSharp(final double value, final double scale) {
        return Math.round(value * scale) + 0.5;
    }

    /**
     * Set a filter {@link Predicate} to only draw the desired connections onto
     * the minimap
     *
     * @param pConnectionFilter connection filter {@link Predicate}
     * @see #setConnectionColor(Color)
     */
    public void setConnectionFilter(final Predicate<GConnection> pConnectionFilter) {
        connectionFilter = pConnectionFilter;
    }

    /**
     * @param pMinimapRenderer {@link IMinimapRenderer}
     */
    public void setMinimapRenderer(final IMinimapRenderer<?> pMinimapRenderer) {
        minimapRenderer = pMinimapRenderer;
        draw();
    }

    /**
     * Set a {@link Color} to paint the connections onto the minimap
     *
     * @param pConnectionColor connection {@link Color}
     * @see #setConnectionFilter(Predicate)
     */
    public void setConnectionColor(final Color pConnectionColor) {
        connectionColor.set(pConnectionColor);
    }

    /**
     * @return current {@link Color} to paint the connections onto the minimap
     */
    public Color getConnectionColor() {
        return connectionColor.get();
    }

    /**
     * @return {@link ObjectProperty} controlling the {@link Color} to paint the
     * connections onto the minimap
     */
    public ObjectProperty<Color> connectionColorProperty() {
        return connectionColor;
    }

    @Override
    public boolean isResizable() {
        return true;
    }

    @Override
    public void resize(double pWidth, double pHeight) {
        if (width != pWidth || height != pHeight) {
            width = pWidth;
            height = pHeight;
            redraw();
        }
    }

    /**
     * @param pScaleFactor the ratio between the size of the content and the size of the
     *                     minimap (between 0 and 1)
     */
    public void setScaleFactor(final double pScaleFactor) {
        if (scaleFactor != pScaleFactor) {
            scaleFactor = pScaleFactor;
            redraw();
        }
    }

    private void redraw() {
        if (nodes.isEmpty()) {
            draw();
        } else {
            requestLayout();
        }
    }

    /**
     * Draws the model's nodes at a scaled-down size to be displayed in the
     * minimap.
     */
    public void draw() {
        nodes.clear();
        if (getChildren().size() > 1) {
            getChildren().remove(1, getChildren().size());
        }

        if (width == -1 || height == -1 || scaleFactor == -1 || minimapRenderer == null) {
            return;
        }

        if (model != null) {
            for (int i = 0; i < model.getNodes().size(); i++) {
                final GNode node = model.getNodes().get(i);
                final Node minimapNode = minimapRenderer == null ? null : minimapRenderer.createMinimapNode(node);
                if (minimapNode != null) {
                    getChildren().add(minimapNode);
                    nodes.put(node, minimapNode);
                }
            }
            checkSelection();
        }

        requestLayout();
    }

    @Override
    protected void layoutChildren() {
        if (width < 1 || height < 1 || minimapRenderer == null) {
            return;
        }

        final GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        canvas.setWidth(width);
        canvas.setHeight(height);

        gc.beginPath();
        gc.setStroke(connectionColor.get());
        gc.setLineWidth(1);

        if (model != null) {
            for (int i = 0; i < model.getConnections().size(); i++) {
                final GConnection conn = model.getConnections().get(i);
                if (connectionFilter != null && !connectionFilter.test(conn)) {
                    continue;
                }

                final GConnector source = conn.getSource();
                final GNode parentSource = source.getParent();

                double x = scaleSharp(source.getX() + parentSource.getX() - 10, scaleFactor),
                        y = scaleSharp(source.getY() + parentSource.getY(), scaleFactor);
                gc.moveTo(x, y);

                for (int j = 0; j <= conn.getJoints().size(); j++) {
                    final double newX;
                    final double newY;
                    if (j < conn.getJoints().size()) {
                        final GJoint joint = conn.getJoints().get(j);
                        newX = scaleSharp(joint.getX(), scaleFactor);
                        newY = scaleSharp(joint.getY(), scaleFactor);
                    } else {
                        final GConnector target = conn.getTarget();
                        final GNode parentTarget = target.getParent();
                        newX = scaleSharp(target.getX() + parentTarget.getX(), scaleFactor);
                        newY = scaleSharp(target.getY() + parentTarget.getY(), scaleFactor);
                    }

                    // only draw direct rectangular and sharp lines:
                    if (Math.abs(newX - x) < Math.abs(newY - y)) {
                        gc.lineTo(x, newY);
                    } else {
                        gc.lineTo(newX, y);
                    }

                    x = newX;
                    y = newY;
                }

                gc.stroke();
            }

            for (final Map.Entry<GNode, Node> entry : nodes.entrySet()) {
                resizeRelocate(entry.getKey(), entry.getValue(), minimapRenderer);
            }
        }
    }

    private <N extends Node> void resizeRelocate(final GNode node, final Node rendered,
                                                 final IMinimapRenderer<N> pRenderer) {
        final double x = (Math.round(node.getX() * scaleFactor));
        final double y = (Math.round(node.getY() * scaleFactor));
        final double width = (Math.round(node.getWidth() * scaleFactor));
        final double height = (Math.round(node.getHeight() * scaleFactor));
        if (rendered != null && pRenderer.getType().isAssignableFrom(rendered.getClass())) {
            pRenderer.resizeRelocate(pRenderer.getType().cast(rendered), x, y, width, height);
        }
    }

    @Override
    public List<CssMetaData<? extends Styleable, ?>> getCssMetaData() {
        return getClassCssMetaData();
    }

    /**
     * @return The CssMetaData associated with this class, which may include the
     * CssMetaData of its super classes.
     */
    public static List<CssMetaData<? extends Styleable, ?>> getClassCssMetaData() {
        return StyleableProperties.STYLEABLES;
    }

    private static class StyleableProperties {

        static final CssMetaData<MinimapNodeGroup, Color> CONNECTION_COLOR = new CssMetaData<>("-connection-color", //$NON-NLS-1$
                StyleConverter.getColorConverter(), Color.GRAY) {

            @Override
            public boolean isSettable(final MinimapNodeGroup node) {
                return !node.connectionColor.isBound();
            }

            @Override
            public StyleableProperty<Color> getStyleableProperty(MinimapNodeGroup node) {
                return node.connectionColor;
            }
        };

        static final List<CssMetaData<? extends Styleable, ?>> STYLEABLES;

        static {

            final List<CssMetaData<? extends Styleable, ?>> styleables = new ArrayList<>(Node.getClassCssMetaData());
            styleables.add(CONNECTION_COLOR);
            STYLEABLES = Collections.unmodifiableList(styleables);
        }
    }
}
