/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph.graphdesktop;

import javafx.beans.Observable;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.value.ObservableNumberValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Utility class that provides methods to simplify node handling. Possible use
 * cases are searching for nodes at specific locations, adding/removing nodes
 * to/from parents (Parent interface does not give write access to children).
 *
 * @author Michael Hoffer &lt;info@michaelhoffer.de&gt;
 * @author Tom Eugelink &lt;tbee@tbee.org&gt;
 */
public class NodeUtil {

    // no instantiation allowed
    private NodeUtil() {
        throw new AssertionError(); // not in this class either!
    }

    /**
     * @param node
     * @return The X coordinate of the node within the parent.
     */
    static public double xInParent(Node node, Node parent) {
        double lX = 0;

        while (node != parent) {
            double lXDelta = node.getBoundsInParent().getMinX();
            lX += lXDelta;
            //System.out.println("xInParent " + node + " -> " + lXDelta + " " + lX);
            node = node.getParent();
        }
        return lX;
    }

    /**
     * @param node
     * @return The Y coordinate of the node within the parent.
     */
    static public double yInParent(Node node, Node parent) {
        double lY = 0;

        while (node != parent) {
            double lYDelta = node.getBoundsInParent().getMinY();
            lY += lYDelta;
            //System.out.println("yInParent " + node + " -> " + lYDelta + " " + lY);
            node = node.getParent();
        }
        return lY;
    }

    /**
     * @param node
     * @return The X screen coordinate of the node.
     */
    static public double screenX(Node node) {
        return sceneX(node) + node.getScene().getWindow().getX();
    }

    /**
     * @param node
     * @return The Y screen coordinate of the node.
     */
    static public double screenY(Node node) {
        return sceneY(node) + node.getScene().getWindow().getY();
    }

    /**
     * @param node
     * @return The X scene coordinate of the node.
     */
    static public double sceneX(Node node) {
        return node.localToScene(node.getBoundsInLocal()).getMinX() + node.getScene().getX();
    }

    /**
     * @param node
     * @return The Y scene coordinate of the node.
     */
    static public double sceneY(Node node) {
        return node.localToScene(node.getBoundsInLocal()).getMinY() + node.getScene().getY();
    }

    /**
     * Removes the specified node from its parent.
     *
     * @param n the node to remove
     * @throws IllegalArgumentException if an unsupported parent class has been
     *                                  specified or the parent is <code>null</code>
     */
    public static void removeFromParent(Node n) {
        if (n.getParent() instanceof Group) {
            ((Group) n.getParent()).getChildren().remove(n);
        } else if (n.getParent() instanceof Pane) {
            ((Pane) n.getParent()).getChildren().remove(n);
        } else {
            throw new IllegalArgumentException("Unsupported parent: " + n.getParent());
        }
    }

    /**
     * Adds the given node to the specified parent.
     *
     * @param p parent
     * @param n node
     * @throws IllegalArgumentException if an unsupported parent class has been
     *                                  specified or the parent is <code>null</code>
     */
    public static void addToParent(Parent p, Node n) {
        if (p instanceof Group) {
            ((Group) p).getChildren().add(n);
        } else if (p instanceof Pane) {
            ((Pane) p).getChildren().add(n);
        } else {
            throw new IllegalArgumentException("Unsupported parent: " + p);
        }
    }

    /**
     * Returns the first node at the given location that is an instance of the
     * specified class object. The search is performed recursively until either
     * a node has been found or a leaf node is reached.
     *
     * @param p         parent node
     * @param sceneX    x coordinate
     * @param sceneY    y coordinate
     * @param nodeClass node class to search for
     * @return a node that contains the specified screen coordinates and is an
     * instance of the specified class or {@code null} if no such node
     * exist
     */
    public static Node getNode(Parent p, double sceneX, double sceneY, Class<?> nodeClass) {

        // dammit! javafx uses "wrong" children order.
        List<Node> rightOrder = new ArrayList<>();
        rightOrder.addAll(p.getChildrenUnmodifiable());
        Collections.reverse(rightOrder);

        for (Node n : rightOrder) {
            boolean contains = n.contains(n.sceneToLocal(sceneX, sceneY));

            if (contains) {

                if (nodeClass.isAssignableFrom(n.getClass())) {
                    return n;
                }

                if (n instanceof Parent) {
                    return getNode((Parent) n, sceneX, sceneY, nodeClass);
                }
            }
        }

        return null;
    }

    /**
     * This method prevents blurry horizontal or vertical lines, use snapXY(x) instead of x.
     *
     * @param position (x or y)
     * @return
     */
    public static double snapXY(double position) {
        return ((int) position) + .5;
    }

    /**
     * This is the snapXY method for using in a binding, for example:
     * p1.bind( snapXY( p2.multiply(0.1) ));
     *
     * @param position (x or y)
     * @return
     */
    public static DoubleBinding snapXY(final ObservableNumberValue position) {
        return new DoubleBinding() {
            {
                super.bind(position);
            }

            @Override
            public void dispose() {
                super.unbind(position);
            }

            @Override
            protected double computeValue() {
                return NodeUtil.snapXY(position.doubleValue());
            }

            @Override
            public ObservableList<?> getDependencies() {
                return FXCollections.singletonObservableList(position);
            }
        };
    }


    /**
     * This method prevents blurry horizontal or vertical lines, use snapWH(x, w) instead of w.
     *
     * @param position (x or y)
     * @param offset   (width or height)
     * @return
     */
    public static double snapWH(double position, double offset) {
        return snapXY(position + offset) - snapXY(position);
    }

    /**
     * This is the snapXY method for using in a binding, for example:
     * p1.bind( snapXY( p2.multiply(0.1) ));
     *
     * @param position     (x or y)
     * @param offset       (width or height)
     * @param dependencies
     * @return
     */
    public static DoubleBinding snapWH(final ObservableNumberValue position, final ObservableNumberValue offset, final Observable... dependencies) {
        return new DoubleBinding() {
            {
                super.bind(dependencies);
            }

            @Override
            public void dispose() {
                super.unbind(dependencies);
            }

            @Override
            protected double computeValue() {
                return NodeUtil.snapWH(position.doubleValue(), offset.doubleValue());
            }

            @Override
            public ObservableList<?> getDependencies() {
                return (dependencies.length == 1) ?
                        FXCollections.singletonObservableList(dependencies[0])
                        : FXCollections.unmodifiableObservableList(FXCollections.observableArrayList(dependencies));
            }
        };
    }

    /**
     * This method is used to prevent the remove-add constructs on styleclasses.
     * This prevents CSS reprocessed unnecessary, because that is a time consuming process.
     *
     * @param node
     * @param styleclass
     */
    static public void addStyleClass(Node node, String styleclass) {
        if (!node.getStyleClass().contains(styleclass)) {
            node.getStyleClass().add(styleclass);
        }
    }

    /**
     * The remove operation is already "cheap", so this method is here to only mirror the addStyleClass (which is not cheap)
     *
     * @param node
     * @param styleclass
     */
    static public void removeStyleClass(Node node, String styleclass) {
        node.getStyleClass().remove(styleclass);
    }
}
