/*
 * Copyright (C) 2005 - 2014 by TESIS DYNAware GmbH
 */
package io.github.eckig.grapheditor.core.selections;

import io.github.eckig.grapheditor.SelectionManager;
import io.github.eckig.grapheditor.SkinLookup;
import io.github.eckig.grapheditor.core.DefaultGraphEditor;
import io.github.eckig.grapheditor.core.view.GraphEditorView;
import io.github.eckig.grapheditor.model.*;
import javafx.collections.ObservableSet;
import org.eclipse.emf.ecore.EObject;

import java.util.List;


/**
 * Manages all graph editor logic relating to selections of one or more nodes
 * and/or joints.
 *
 * <p>
 * Delegates certain jobs to the following classes.
 *
 * <ol>
 * <li>SelectionCreator - creates selections of objects via clicking or dragging
 * <li>SelectionDragManager - ensures selected objects move together when one is
 * dragged
 * <li>SelectionTracker - keeps track of the current selection
 * </ol>
 *
 * </p>
 */
public class DefaultSelectionManager implements SelectionManager {

    private final SelectionCreator selectionCreator;
    private final SelectionTracker selectionTracker;

    private GModel model;

    /**
     * Creates a new default selection manager. Only one instance should exist
     * per {@link DefaultGraphEditor} instance.
     *
     * @param skinLookup the {@link SkinLookup} instance in use
     * @param view       the {@link GraphEditorView} instance in use
     */
    public DefaultSelectionManager(final SkinLookup skinLookup, final GraphEditorView view) {
        final SelectionDragManager selectionDragManager = new SelectionDragManager(skinLookup, view, this);
        selectionCreator = new SelectionCreator(skinLookup, view, this, selectionDragManager);
        selectionTracker = new SelectionTracker(skinLookup);
    }

    /**
     * Initializes the selection manager for the given model.
     *
     * @param model the {@link GModel} currently being edited
     */
    public void initialize(final GModel model) {
        this.model = model;

        selectionCreator.initialize(model);
        selectionTracker.initialize();
    }

    public void addNode(final GNode node) {
        selectionCreator.addNode(node);
    }

    public void removeNode(final GNode node) {
        selectionCreator.removeNode(node);
    }

    public void addConnector(final GConnector connector) {
        selectionCreator.addConnector(connector);
    }

    public void removeConnector(final GConnector connector) {
        selectionCreator.removeConnector(connector);
    }

    public void addConnection(final GConnection connection) {
        selectionCreator.addConnection(connection);
    }

    public void removeConnection(final GConnection connection) {
        selectionCreator.removeConnection(connection);
    }

    public void addJoint(final GJoint joint) {
        selectionCreator.addJoint(joint);
    }

    public void removeJoint(final GJoint joint) {
        selectionCreator.removeJoint(joint);
    }

    @Override
    public ObservableSet<EObject> getSelectedItems() {
        return selectionTracker.getSelectedItems();
    }

    @Override
    public void select(final EObject object) {
        getSelectedItems().add(object);
    }

    @Override
    public void clearSelection(final EObject object) {
        getSelectedItems().remove(object);
    }

    @Override
    public boolean isSelected(EObject object) {
        return getSelectedItems().contains(object);
    }

    @Override
    public List<GNode> getSelectedNodes() {
        return selectionTracker.getSelectedNodes();
    }

    @Override
    public List<GConnection> getSelectedConnections() {
        return selectionTracker.getSelectedConnections();
    }

    @Override
    public List<GJoint> getSelectedJoints() {
        return selectionTracker.getSelectedJoints();
    }

    @Override
    public void clearSelection() {
        if (!getSelectedItems().isEmpty()) {
            // copy to prevent ConcurrentModificationException
            // (removal triggers update notification which in turn could modify the selection)
            final EObject[] selectedItems = getSelectedItems().toArray(new EObject[0]);
            for (final EObject remove : selectedItems) {
                getSelectedItems().remove(remove);
            }
        }
    }

    @Override
    public void selectAll() {
        if (model != null) {
            getSelectedItems().addAll(model.getNodes());
            for (final GConnection connection : model.getConnections()) {
                getSelectedItems().add(connection);

                for (final GJoint joint : connection.getJoints()) {
                    getSelectedItems().add(joint);
                }
            }
        }
    }
}
