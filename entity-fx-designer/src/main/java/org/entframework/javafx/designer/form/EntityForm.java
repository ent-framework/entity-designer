/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.designer.form;

import com.dlsc.formsfx.model.structure.Field;
import com.dlsc.formsfx.model.structure.Form;
import com.dlsc.formsfx.model.structure.Section;
import com.dlsc.formsfx.view.renderer.FormRenderer;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.apache.commons.lang3.StringUtils;
import org.entframework.javafx.common.event.DefaultEventBus;
import org.entframework.javafx.common.event.EntityEvent;
import org.entframework.javafx.designer.command.EventCommands;
import org.entframework.javafx.designer.entitydesigner.model.EEntityObject;
import org.entframework.javafx.designer.entitydesigner.model.EntityFactory;
import org.entframework.javafx.designer.entitydesigner.model.EntityPackage;

import static com.dlsc.formsfx.model.event.FormEvent.EVENT_FORM_PERSISTED;

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
        Form form = Form.of(
                Section.of(
                        Field.ofStringType(name)
                                .label("Name").required("Name can't be empty")
                                .span(12)
                        ,
                        Field.ofStringType(description)
                                .label("Description")
                ).title("Basic").withSpace(4)
        );
        form.addEventHandler(EVENT_FORM_PERSISTED, event -> {
            EventCommands.entityAttributeUpdate(model, getFormValue());
        });
        return form;
    }

    @Override
    public void cleanAdapters() {
        model.eAdapters().remove(nameAdapter);
        model.eAdapters().remove(descriptionAdapter);
    }

    public void bind() {
        name.set(StringUtils.defaultIfEmpty(model.getName(), ""));
        description.set(StringUtils.defaultIfEmpty(model.getDescription(), ""));
    }

    public EEntityObject getFormValue() {
        EEntityObject eEntityObject = EntityFactory.eINSTANCE.createEEntityObject();
        eEntityObject.setName(name.get());
        eEntityObject.setDescription(description.get());
        return eEntityObject;
    }
}
