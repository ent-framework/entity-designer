/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.designer.form;

import com.dlsc.formsfx.model.structure.Form;
import com.dlsc.formsfx.view.renderer.FormRenderer;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.entframework.javafx.databrowser.services.I18n;
import org.entframework.javafx.designer.entitydesigner.model.EModelObject;

import java.util.function.Consumer;

public abstract class ModelForm<T extends EModelObject> {

    protected final I18n i18n = new I18n(getClass());
    protected Button btnOk = new Button(i18n.t("btn.save"));
    protected Button btnReset = new Button(i18n.t("btn.reset"));
    protected final T model;

    protected ModelForm(T model) {
        this.model = model;
    }
    public final FormRenderer getFormRenderer() {
        bind();
        Form form = getForm();
        FormRenderer formRenderer = new FormRenderer(form);
        btnOk.disableProperty().bind(form.persistableProperty().not());
        btnReset.disableProperty().bind(form.changedProperty().not());
        btnOk.setOnAction((e) -> form.persist());
        btnReset.setOnAction((e) -> form.reset());
        formRenderer.getChildren().add(getToolbar());
        return formRenderer;
    }

    public abstract Form getForm();
    public abstract void bind();

    public abstract void cleanAdapters();

    public T getModel() {
        return model;
    }

    private HBox getToolbar() {
        HBox toolBar = new HBox();
        toolBar.setSpacing(10);
        toolBar.getStyleClass().add("h-box");
        toolBar.setPadding(new Insets(0, 10, 0, 10));
        toolBar.getChildren().setAll(btnOk, btnReset);
        return toolBar;
    }

    public static class AttributeFeatureAdapter<T> extends EContentAdapter {

        private final EAttribute attribute;
        private final Consumer<T> subscriber;

        public AttributeFeatureAdapter(EAttribute attribute, Consumer<T> subscriber) {
            this.attribute = attribute;
            this.subscriber = subscriber;
        }

        @Override
        @SuppressWarnings("unchecked")
        public void notifyChanged(Notification notification) {
            super.notifyChanged(notification);
            if (notification.getEventType() != Notification.REMOVING_ADAPTER) {
                if (notification.getFeature().equals(attribute)) {
                    this.subscriber.accept((T)notification.getNewValue());
                }
            }
        }
    }

}
