/*
 * Copyright (c) 2011-2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph.graphdesktop;

import javafx.collections.ObservableList;

/**
 * @author Michael Hoffer &lt;info@michaelhoffer.de&gt;
 */
public interface Clipboard {
    public boolean select(SelectableNode n, boolean selected);

    public void unselectAll();

    ObservableList<SelectableNode> getSelectedItems();
}
