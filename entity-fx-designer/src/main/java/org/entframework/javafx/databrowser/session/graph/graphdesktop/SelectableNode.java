/*
 * Copyright (c) 2011-2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph.graphdesktop;

/**
 * A node must implement this interface to be selectable. Usually, nodes/windows
 * are selected via selection rectangle gesture.
 *
 * @author Michael Hoffer &lt;info@michaelhoffer.de&gt;
 */
public interface SelectableNode {

    /**
     * Requests selection/deselection.
     *
     * @param select defines whether to select or deselect the node
     * @return <code>true</code> if request is accepted;<code>false</code>
     * otherwise
     */
    public boolean requestSelection(boolean select);
}
