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
import org.entframework.javafx.designer.entitydesigner.model.EModuleObject;
import org.entframework.javafx.designer.entitydesigner.model.EntityPackage;

public class ModuleForm extends ModelForm<EModuleObject> {
    private final StringProperty name = new SimpleStringProperty("");
    private final StringProperty description = new SimpleStringProperty("");
    private final AttributeFeatureAdapter<String> nameAdapter = new AttributeFeatureAdapter<String>(EntityPackage.Literals.EMODULE_OBJECT__NAME, name::set);
    private final AttributeFeatureAdapter<String> descriptionAdapter = new AttributeFeatureAdapter<String>(EntityPackage.Literals.EMODULE_OBJECT__DESCRIPTION, description::set);

    public ModuleForm(EModuleObject model) {
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
                        ,
                        Field.ofStringType(description)
                                .label("Description")
                ).title("Basic").withSpace(4)
        );
        return form;
    }

    public void bind() {
        name.set(StringUtils.defaultIfEmpty(model.getName(), ""));
        description.set(StringUtils.defaultIfEmpty(model.getDescription(), ""));
    }

    @Override
    public void cleanAdapters() {
        model.eAdapters().remove(nameAdapter);
        model.eAdapters().remove(descriptionAdapter);
    }
}
