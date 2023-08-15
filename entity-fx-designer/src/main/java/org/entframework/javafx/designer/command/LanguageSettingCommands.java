/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.designer.command;

import io.github.eckig.grapheditor.model.GModel;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.entframework.javafx.designer.entitydesigner.model.ELanguage;
import org.entframework.javafx.designer.entitydesigner.model.ELanguageBinding;
import org.entframework.javafx.designer.entitydesigner.model.ELanguageSettings;
import org.entframework.javafx.designer.entitydesigner.model.EntityPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LanguageSettingCommands {
    private static final Logger LOGGER = LoggerFactory.getLogger(LanguageSettingCommands.class);

    public static void addSetting(ELanguageSettings languageSettings, ELanguageBinding binding) {
        final EditingDomain editingDomain = getEditingDomain(languageSettings);
        if (editingDomain != null) {

            CompoundCommand command = new CompoundCommand();
            command.append(AddCommand.create(editingDomain, languageSettings, EntityPackage.Literals.ELANGUAGE_SETTINGS__BINDINGS, binding));
            if (binding.getLanguageSpecification() != null) {
                command.append(SetCommand.create(editingDomain, binding, EntityPackage.Literals.ELANGUAGE_BINDING__LANGUAGE_SPECIFICATION, binding.getLanguageSpecification()));
                ELanguage language = binding.getLanguageSpecification().getLanguage();
                if (language != null) {
                    command.append(SetCommand.create(editingDomain, binding.getLanguageSpecification(), EntityPackage.Literals.ELANGUAGE_SPECIFICATION__LANGUAGE, language));
                }
            }
            if (command.canExecute()) {
                editingDomain.getCommandStack().execute(command);
            }
        }
    }

    /**
     * Gets the editing domain associated to the languageSettings.
     *
     * <p>
     * Logs an error if none is found.
     * </p>
     *
     * @param languageSettings a {@link GModel} instance
     * @return the {@link EditingDomain} associated to this languageSettings instance
     */
    private static EditingDomain getEditingDomain(final ELanguageSettings languageSettings) {
        final EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(languageSettings);

        if (editingDomain == null) {
            LOGGER.error("No editing domain found for this languageSettings. Maybe it hasn't been set inside a graph editor?"); //$NON-NLS-1$
        }

        return editingDomain;
    }
}
