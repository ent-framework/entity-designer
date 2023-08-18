/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.designer.command;

import io.github.eckig.grapheditor.Commands;
import io.github.eckig.grapheditor.SkinLookup;
import io.github.eckig.grapheditor.model.GModel;
import io.github.eckig.grapheditor.model.GNode;
import io.github.eckig.grapheditor.model.GraphPackage;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.entframework.javafx.common.event.DefaultEventBus;
import org.entframework.javafx.common.event.EntityEvent;
import org.entframework.javafx.common.event.NodeEvent;
import org.entframework.javafx.common.utils.IdGenerator;
import org.entframework.javafx.common.utils.ResourceUtils;
import org.entframework.javafx.designer.entitydesigner.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

public class EventCommands {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventCommands.class);

    public static void addNode(GModel model, GNode node, EPersistenceObject persistence, EModuleObject module, EEntityObject entity) {
        final EditingDomain editingDomain = getEditingDomain(model);
        if (editingDomain != null) {
            CompoundCommand command = new CompoundCommand();
            command.append(AddCommand.create(editingDomain, model, GraphPackage.Literals.GMODEL__NODES, node));
            if (module == null) {
                module = EntityFactory.eINSTANCE.createEModuleObject();
                module.setName("Untitled Module");
                module.setId(IdGenerator.generateId());
                command.append(AddCommand.create(editingDomain, persistence, EntityPackage.Literals.EPERSISTENCE_OBJECT__MODULES, module));
            }
            if (!model.eResource().getResourceSet().getResources().contains(persistence.eResource())) {
                model.eResource().getResourceSet().getResources().add(persistence.eResource());
            }
            command.append(AddCommand.create(editingDomain, module, EntityPackage.Literals.EMODULE_OBJECT__ENTITIES, entity));
            if (command.canExecute()) {
                editingDomain.getCommandStack().execute(command);
                DefaultEventBus.getInstance().publish(new NodeEvent(model, node, NodeEvent.EventType.ADD));
            }
        }
    }

    public static void addField(GModel model, EEntityObject entity, EFieldObject field) {
        final EditingDomain editingDomain = getEditingDomain(model);
        if (editingDomain != null) {
            Command command = AddCommand.create(editingDomain, entity, EntityPackage.Literals.EENTITY_OBJECT__FIELDS, field);
            if (command.canExecute()) {
                command.execute();
                DefaultEventBus.getInstance().publish(new EntityEvent(entity));
            }
        }
    }

    public static void removeNode(GModel model, GNode node) {
        Commands.removeNode(model, node);
        DefaultEventBus.getInstance().publish(new NodeEvent(model, node, NodeEvent.EventType.REMOVE));
    }

    public static void clear(GModel model) {
        Commands.clear(model);
        DefaultEventBus.getInstance().publish(new NodeEvent(model, null, NodeEvent.EventType.CLEAR));
    }

    public static void clearConnectors(GModel model, List<GNode> nodes) {
        Commands.clearConnectors(model, nodes);
        DefaultEventBus.getInstance().publish(new NodeEvent(model, null, NodeEvent.EventType.CLEAR));
    }

    public static void updateLayoutValues(CompoundCommand command, GModel model, SkinLookup skinLookup) {
        Commands.updateLayoutValues(command, model, skinLookup);
    }

    public static void undo(GModel model) {
        Commands.undo(model);
        DefaultEventBus.getInstance().publish(new NodeEvent(model, null, NodeEvent.EventType.UNDO));
    }

    public static void redo(GModel model) {
        Commands.redo(model);
        DefaultEventBus.getInstance().publish(new NodeEvent(model, null, NodeEvent.EventType.REDO));
    }

    /**
     * Common attribute update method
     * @param targetObject
     * @param attribute
     * @param pNewValue
     */
    public static void attributeUpdate(EObject targetObject, EAttribute attribute, Object pNewValue) {
        Objects.requireNonNull(targetObject);
        Objects.requireNonNull(pNewValue);
        GModel model = Objects.requireNonNull(ResourceUtils.findModel(targetObject));
        final EditingDomain editingDomain = getEditingDomain(model);
        if (editingDomain != null) {
            Command command = SetCommand.create(editingDomain, targetObject, attribute, pNewValue);
            if (command.canExecute()) {
                editingDomain.getCommandStack().execute(command);
            }
        }
    }

    /**
     * Gets the editing domain associated to the model.
     *
     * <p>
     * Logs an error if none is found.
     * </p>
     *
     * @param model a {@link GModel} instance
     * @return the {@link EditingDomain} associated to this model instance
     */
    private static EditingDomain getEditingDomain(final GModel model) {
        final EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(model);

        if (editingDomain == null) {
            LOGGER.error("No editing domain found for this model. Maybe it hasn't been set inside a graph editor?"); //$NON-NLS-1$
        }

        return editingDomain;
    }
}
