/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.designer;

import io.github.eckig.grapheditor.GraphEditor;
import io.github.eckig.grapheditor.model.GModel;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.entframework.javafx.common.BusinessException;
import org.entframework.javafx.designer.entitydesigner.model.EPersistenceObject;
import org.entframework.javafx.designer.entitydesigner.model.EntityPackage;
import org.entframework.javafx.designer.ext.ModelGraphEditor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Helper class for crudely loading {@link GModel} states to and from XML.
 *
 * <p>
 * Not part of the graph editor library, only used in the application.
 * </p>
 */
public class GraphEditorPersistence {
    private static final Logger LOGGER = LoggerFactory.getLogger(GraphEditorPersistence.class);
    public static final String FILE_EXTENSION = ".graph"; //$NON-NLS-1$
    public static final String CHOOSER_TEXT = "Graph Model Files (*" + FILE_EXTENSION + ")"; //$NON-NLS-1$ //$NON-NLS-2$

    private File initialDirectory = null;
    private File actualFile = null;

    /**
     * Saves the graph editor's {@link GModel} state to an XML file via the {@link FileChooser}.
     *
     * @param graphEditor the graph editor whose model state is to be saved
     */
    public void saveToFile(final ModelGraphEditor graphEditor, boolean saveAs) {

        final Scene scene = graphEditor.getView().getScene();

        if (scene != null) {
            if (actualFile == null || saveAs) {
                final File file = showFileChooser(scene.getWindow(), true);

                if (file != null && graphEditor.getModel() != null) {
                    saveModel(file, graphEditor.getModel(), graphEditor.getPersistence());
                }
            } else {
                saveModel(actualFile, graphEditor.getModel(), graphEditor.getPersistence());
            }
        }
    }

    /**
     * Opens the file chooser and returns the selected {@link File}.
     *
     * @param window
     * @param save   {@code true} to open a save dialog, {@code false} to open a
     *               load dialog
     * @return the chosen file
     */
    private File showFileChooser(final Window window, final boolean save) {

        final FileChooser fileChooser = new FileChooser();

        final FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter(CHOOSER_TEXT, "*" + FILE_EXTENSION); //$NON-NLS-1$
        fileChooser.getExtensionFilters().add(filter);

        if (initialDirectory != null && initialDirectory.exists()) {
            fileChooser.setInitialDirectory(initialDirectory);
        }

        if (save) {
            return fileChooser.showSaveDialog(window);
        }
        // ELSE:
        return fileChooser.showOpenDialog(window);
    }

    /**
     * Saves the graph editor's model state in the given file.
     *
     * @param file  the {@link File} the model state will be saved in
     * @param model the {@link GModel} to be saved
     */
    private void saveModel(final File file, final GModel model, final EPersistenceObject persistence) {

        String absolutePath = file.getAbsolutePath();
        if (!absolutePath.endsWith(FILE_EXTENSION)) {
            absolutePath += FILE_EXTENSION;
        }

        final EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(model);

        final URI fileUri = URI.createFileURI(absolutePath);
        final XMIResourceFactoryImpl resourceFactory = new XMIResourceFactoryImpl();
        final XMLResource resource = (XMLResource) resourceFactory.createResource(fileUri);
        resource.setEncoding("utf-8");
        resource.getContents().add(model);
        resource.getContents().add(persistence);

        try {
            resource.save(Collections.EMPTY_MAP);
        } catch (final IOException e) {
            e.printStackTrace();
        }

        editingDomain.getResourceSet().getResources().clear();
        editingDomain.getResourceSet().getResources().add(resource);
        actualFile = file;
        initialDirectory = file.getParentFile();
    }

    /**
     * Loads the model from the given file and sets it in the given graph editor.
     *
     * @param file        the {@link File} to be loaded
     * @param graphEditor the {@link GraphEditor} in which the loaded model will be set
     */
    public void loadModel(final File file, final ModelGraphEditor graphEditor) {

        final URI fileUri = URI.createFileURI(file.getAbsolutePath());

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
            throw new BusinessException(e.getMessage(), e);
        }

        if (!resource.getContents().isEmpty()) {
            for (EObject eObject : resource.getContents()) {
                if (eObject instanceof GModel model) {
                    graphEditor.setModel(model);
                }
                if (eObject instanceof EPersistenceObject ePersistence) {
                    graphEditor.setPersistence(ePersistence);
                }
            }
        }
        actualFile = file;
        initialDirectory = file.getParentFile();
    }

    public String getFileName() {
        if (actualFile != null) {
            return actualFile.getName().substring(0, actualFile.getName().lastIndexOf("."));
        }
        return "Untitled";
    }
}
