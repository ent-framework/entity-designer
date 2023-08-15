/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.designer;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.entframework.javafx.databrowser.AppState;
import org.entframework.javafx.designer.entitydesigner.model.ELanguageSettings;
import org.entframework.javafx.designer.entitydesigner.model.EntityFactory;
import org.entframework.javafx.designer.entitydesigner.model.EntityPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class LanguageSettingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LanguageSettingService.class);
    private static final URI DEFAULT_URI = URI.createFileURI("");
    private final ObjectProperty<ELanguageSettings> languageSettings = new SimpleObjectProperty<>();

    public ELanguageSettings getLanguageSettings() {
        if (languageSettings.get() == null) {
            createSettings();
        }
        return languageSettings.get();
    }

    public ObjectProperty<ELanguageSettings> languageSettingsProperty() {
        return languageSettings;
    }

    public void saveSettings() {
        File settingFile = new File(AppState.get().getUserDir(), "languageSettings.xml");
        if (languageSettings.get() != null) {
            final EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(languageSettings.get());

            final URI fileUri = URI.createFileURI(settingFile.getAbsolutePath());
            final XMIResourceFactoryImpl resourceFactory = new XMIResourceFactoryImpl();
            final XMLResource resource = (XMLResource) resourceFactory.createResource(fileUri);
            resource.setEncoding("utf-8");
            resource.getContents().add(languageSettings.get());

            try {
                resource.save(Collections.EMPTY_MAP);
            } catch (final IOException e) {
                e.printStackTrace();
            }

            editingDomain.getResourceSet().getResources().clear();
            editingDomain.getResourceSet().getResources().add(resource);
        }
    }

    private void createSettings() {

        File settingFile = new File(AppState.get().getUserDir(), "languageSettings.xml");
        if (settingFile.exists()) {
            final URI fileUri = URI.createFileURI(settingFile.getAbsolutePath());

            final XMIResourceFactoryImpl resourceFactory = new XMIResourceFactoryImpl();
            final XMLResource resource = (XMLResource) resourceFactory.createResource(fileUri);
            final Map<String, Object> options = new HashMap<>();
            //强制加载 emf
            EntityPackage.eINSTANCE.getNsPrefix();
            try {
                resource.setEncoding("utf-8");
                resource.load(options);
            } catch (final IOException e) {
                LOGGER.error(e.getMessage());
                e.printStackTrace();
            }

            if (!resource.getContents().isEmpty()) {
                for (EObject eObject : resource.getContents()) {
                    if (eObject instanceof ELanguageSettings ls) {
                        languageSettings.set(ls);
                    }
                }
            }
        }
        if (languageSettings.get() == null) {
            languageSettings.set(EntityFactory.eINSTANCE.createELanguageSettings());
        }
        initDomain(languageSettings.get());
    }

    private void initDomain(ELanguageSettings languageSettings) {
        if (languageSettings.eResource() == null) {
            final XMIResourceFactoryImpl resourceFactory = new XMIResourceFactoryImpl();
            final Resource resource = resourceFactory.createResource(DEFAULT_URI);
            resource.getContents().add(languageSettings);
        }
        EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(languageSettings);
        if (editingDomain == null) {
            final ComposedAdapterFactory.Descriptor.Registry registry = ComposedAdapterFactory.Descriptor.Registry.INSTANCE;
            final AdapterFactory adapterFactory = new ComposedAdapterFactory(registry);

            editingDomain = new AdapterFactoryEditingDomain(adapterFactory, new BasicCommandStack());
            editingDomain.getResourceSet().getResources().add(languageSettings.eResource());
        }
    }
}
