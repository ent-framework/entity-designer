/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.designer.form;

import com.dlsc.formsfx.model.structure.Field;
import com.dlsc.formsfx.model.structure.Form;
import com.dlsc.formsfx.model.structure.Section;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.apache.commons.lang3.StringUtils;
import org.entframework.javafx.designer.command.EventCommands;
import org.entframework.javafx.designer.emf.AttributeFeatureAdapter;
import org.entframework.javafx.designer.entitydesigner.model.EEntityObject;
import org.entframework.javafx.designer.entitydesigner.model.EntityPackage;

public class EntityForm extends ModelForm<EEntityObject> {

    private final StringProperty name = new SimpleStringProperty("");
    private final StringProperty description = new SimpleStringProperty("");
    private final AttributeFeatureAdapter<String> nameAdapter = new AttributeFeatureAdapter<String>(EntityPackage.Literals.EENTITY_OBJECT__NAME, name::set);
    private final AttributeFeatureAdapter<String> descriptionAdapter = new AttributeFeatureAdapter<String>(EntityPackage.Literals.EENTITY_OBJECT__DESCRIPTION, description::set);

    public EntityForm(EEntityObject model) {
        super(model);
        model.eAdapters().add(nameAdapter);
        model.eAdapters().add(descriptionAdapter);
    }

    @Override
    public Form getForm() {
        return Form.of(
                Section.of(
                        Field.ofStringType(name)
                                .label("Name").required("Name can't be empty")
                                .span(12)
                        ,
                        Field.ofStringType(description)
                                .label("Description")
                ).title("Basic").withSpace(4).fireChangeImmediately(true)
        );
    }

    @Override
    public void cleanAdapters() {
        model.eAdapters().remove(nameAdapter);
        model.eAdapters().remove(descriptionAdapter);
    }

    public void bind() {
        name.set(StringUtils.defaultIfEmpty(model.getName(), ""));
        description.set(StringUtils.defaultIfEmpty(model.getDescription(), ""));

        name.addListener((observable, oldValue, newValue) -> EventCommands.attributeUpdate(model, EntityPackage.Literals.EENTITY_OBJECT__NAME, newValue));
        description.addListener((observable, oldValue, newValue) -> EventCommands.attributeUpdate(model, EntityPackage.Literals.EENTITY_OBJECT__DESCRIPTION, newValue));
    }
}
