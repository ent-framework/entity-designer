/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.designer.form;

import com.dlsc.formsfx.model.structure.Form;
import com.dlsc.formsfx.view.renderer.FormRenderer;
import org.entframework.javafx.databrowser.services.I18n;
import org.entframework.javafx.designer.entitydesigner.model.EModelObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;

public abstract class ModelForm<T extends EModelObject> {

    protected Logger LOGGER = LoggerFactory.getLogger(getClass());

    protected final I18n i18n = new I18n(getClass());

    protected final T model;

    protected ModelForm(T model) {
        this.model = model;
    }
    public final FormRenderer getFormRenderer() {
        bind();
        Form form = getForm();
        return new FormRenderer(form);
    }

    public abstract Form getForm();
    public abstract void bind();

    public abstract void cleanAdapters();

    public T getModel() {
        return model;
    }



}
