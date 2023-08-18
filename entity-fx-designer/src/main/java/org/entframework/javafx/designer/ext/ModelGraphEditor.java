/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.designer.ext;

import io.github.eckig.grapheditor.core.DefaultGraphEditor;
import io.github.eckig.grapheditor.utils.GraphEditorProperties;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.SimpleBooleanProperty;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.entframework.javafx.common.event.DefaultEventBus;
import org.entframework.javafx.common.event.EntityEvent;
import org.entframework.javafx.designer.entitydesigner.model.EEntityObject;
import org.entframework.javafx.designer.entitydesigner.model.EModelObject;
import org.entframework.javafx.designer.entitydesigner.model.EPersistenceObject;

public class ModelGraphEditor extends DefaultGraphEditor {
    private final ObjectProperty<EPersistenceObject> mPersistenceProperty = new ObjectPropertyBase<EPersistenceObject>() {
        @Override
        public Object getBean() {
            return ModelGraphEditor.this;
        }

        @Override
        public String getName() {
            return "persistence";
        }

    };

    private final EContentAdapter mContentAdapter = new ContentChangedAdapter();
    private final Adapter extraAdapter;

    private final BooleanProperty undoStatus = new SimpleBooleanProperty();
    private final BooleanProperty redoStatus = new SimpleBooleanProperty();

    public ModelGraphEditor(Adapter adapter) {
        this(null, adapter);
    }

    public ModelGraphEditor(GraphEditorProperties pProperties, Adapter adapter) {
        super(pProperties);
        this.extraAdapter = adapter;
        this.mPersistenceProperty.addListener((observable, oldValue, newValue) -> persistenceChange(oldValue, newValue));

        modelProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue != null) {
                final EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(oldValue);
                if (editingDomain != null) {
                    editingDomain.getResourceSet().eAdapters().remove(mContentAdapter);
                    editingDomain.getResourceSet().eAdapters().remove(extraAdapter);
                }
            }

            if (newValue != null) {
                final EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(newValue);
                if (editingDomain != null) {
                    editingDomain.getResourceSet().eAdapters().add(mContentAdapter);
                    editingDomain.getResourceSet().eAdapters().add(extraAdapter);
                }
            }
        });
    }

    private EditingDomain getEditingDomain() {
        return AdapterFactoryEditingDomain.getEditingDomainFor(getModel());
    }

    private void persistenceChange(EPersistenceObject oldValue, EPersistenceObject newValue) {
        if (newValue != null) {
            if (newValue.eResource() == null) {
                final XMIResourceFactoryImpl resourceFactory = new XMIResourceFactoryImpl();
                final Resource resource = resourceFactory.createResource(URI.createFileURI(""));
                resource.getContents().add(newValue);
            }
        }
    }

    public EPersistenceObject getPersistence() {
        return mPersistenceProperty.get();
    }

    public void setPersistence(final EPersistenceObject ePersistence) {
        mPersistenceProperty.set(ePersistence);
    }

    public ObjectProperty<EPersistenceObject> persistenceProperty() {
        return mPersistenceProperty;
    }

    public BooleanProperty undoStatusProperty() {
        return undoStatus;
    }

    public BooleanProperty redoStatusProperty() {
        return redoStatus;
    }

    public class ContentChangedAdapter extends EContentAdapter {
        @Override
        public void notifyChanged(Notification notification) {
            super.notifyChanged(notification);
            if (notification.getEventType() != Notification.REMOVING_ADAPTER && notification.getEventType() != Notification.REMOVE) {
                EditingDomain editingDomain = ModelGraphEditor.this.getEditingDomain();
                if (editingDomain != null) {
                    undoStatus.set(editingDomain.getCommandStack().canUndo());
                    redoStatus.set(editingDomain.getCommandStack().canRedo());
                    if (notification.getNotifier() instanceof EEntityObject entityObject) {
                        DefaultEventBus.getInstance().publish(new EntityEvent(entityObject));
                    }
                }
            }
        }
    }
}
