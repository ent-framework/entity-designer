/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.designer;

import com.dlsc.formsfx.model.structure.*;
import com.dlsc.formsfx.view.controls.SimpleCheckBoxControl;
import com.dlsc.formsfx.view.renderer.FormRenderer;
import com.dlsc.formsfx.view.util.ColSpan;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.commons.lang3.StringUtils;
import org.entframework.javafx.common.spring.FXMLController;
import org.entframework.javafx.databrowser.services.GuiUtils;
import org.entframework.javafx.databrowser.services.I18n;
import org.entframework.javafx.designer.command.LanguageSettingCommands;
import org.entframework.javafx.designer.entitydesigner.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.JDBCType;
import java.util.Comparator;
import java.util.List;

@FXMLController
public class LanguageBindingCtrl {
    private static final Logger LOGGER = LoggerFactory.getLogger(LanguageBindingCtrl.class);
    public VBox editPane;
    public ToolBar languageTypes;
    public BorderPane root;
    public Button btnAdd;
    public Button btnReset;
    private final I18n i18n = new I18n(this.getClass());
    private final ObjectProperty<ELanguage> languageProperty = new SimpleObjectProperty<>();
    public TableView<ELanguageBinding> tableView;
    private final ObjectProperty<ELanguageBinding> languageBinding = new SimpleObjectProperty<>();
    private LanguageBindingForm bindingForm;
    private Form form;
    private FormRenderer formRenderer;

    private boolean isEditing = false;

    @Autowired
    private LanguageSettingService languageSettingService;

    public void initialize() {

        GuiUtils.makeEscapeClosable(root);

        ToggleGroup languageGroup = new ToggleGroup();
        ELanguage[] languages = ELanguage.values();
        int index = 0;
        for (ELanguage language : languages) {
            ToggleButton button = new ToggleButton();
            button.setId(language.getName());
            button.setText(language.getLiteral());
            button.setOnAction((e) -> {
                languageProperty.set(language);
                formRenderer.setDisable(true);
                loadLanguageBindings();
            });
            languageTypes.getItems().add(button);
            languageGroup.getToggles().add(button);
            if (index == 0) {
                button.setSelected(true);
                languageProperty.set(language);
            }
            index++;
        }

        //显示数据
        loadLanguageBindings();

        ELanguageBinding lb = EntityFactory.eINSTANCE.createELanguageBinding();
        lb.setLanguageSpecification(EntityFactory.eINSTANCE.createELanguageSpecification());
        languageBinding.set(lb);

        TableColumn<ELanguageBinding, String> shortNameCol = new TableColumn<>(i18n.t("table.binding.shortName"));
        shortNameCol.setMinWidth(50);
        shortNameCol.setCellValueFactory(param -> {
            if (param.getValue() != null && param.getValue().getLanguageSpecification() != null) {
                return new SimpleStringProperty(StringUtils.defaultIfEmpty(param.getValue().getLanguageSpecification().getShortName(), ""));
            }
            return null;
        });
        TableColumn<ELanguageBinding, Boolean> primitiveCol = new TableColumn<>(i18n.t("table.binding.primitive"));
        primitiveCol.setMinWidth(30);
        primitiveCol.setCellValueFactory(param -> {
            if (param.getValue() != null && param.getValue().getLanguageSpecification() != null) {
                return new SimpleBooleanProperty(param.getValue().getLanguageSpecification().isPrimitive());
            }
            return null;
        });
        TableColumn<ELanguageBinding, String> qualifiedNameCol = new TableColumn<>(i18n.t("table.binding.qualifiedName"));
        qualifiedNameCol.setMinWidth(120);
        qualifiedNameCol.setCellValueFactory(param -> {
            if (param.getValue() != null && param.getValue().getLanguageSpecification() != null) {
                return new SimpleStringProperty(StringUtils.defaultIfEmpty(param.getValue().getLanguageSpecification().getQualifiedName(), ""));
            }
            return null;
        });

        TableColumn<ELanguageBinding, String> jdbcTypesCol = new TableColumn<>(i18n.t("table.binding.jdbc-types"));
        jdbcTypesCol.setMinWidth(300);
        jdbcTypesCol.setCellValueFactory(param -> {
            if (param.getValue() != null && param.getValue().getJdbcTypes() != null) {
                return new SimpleStringProperty(StringUtils.join(param.getValue().getJdbcTypes().stream()
                        .map(type -> JDBCType.valueOf(type.getJdbcType())).map(JDBCType::getName).toList(), ","));
            }
            return null;
        });

        tableView.getColumns().addAll(shortNameCol, primitiveCol, qualifiedNameCol, jdbcTypesCol);
        tableView.setEditable(false);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            isEditing = true;
            if (newValue != null) {
                languageBinding.set(newValue);
                formRenderer.setDisable(false);
            } else {
                formRenderer.setDisable(true);
            }

        });

        initForm();

        btnAdd.disableProperty().bind(form.persistableProperty().not());
        btnReset.disableProperty().bind(form.changedProperty().not());
        btnAdd.setOnAction((e) -> onSave());
        btnReset.setOnAction((e) -> form.reset());
    }

    private void onSave() {
        form.persist();
        ELanguageBinding binding = languageBinding.get();
        binding.getLanguageSpecification().setShortName(bindingForm.shortName.get());
        binding.getLanguageSpecification().setPrimitive(bindingForm.primitive.get());
        binding.getLanguageSpecification().setQualifiedName(bindingForm.qualifiedName.get());
        binding.getJdbcTypes().clear();
        for (JDBCType jdbcType : bindingForm.jdbcTypes) {
            ESupportedJdbcTypes supportedJdbcType = EntityFactory.eINSTANCE.createESupportedJdbcTypes();
            supportedJdbcType.setJdbcType(jdbcType.getVendorTypeNumber());
            binding.getJdbcTypes().add(supportedJdbcType);
        }
        binding.getLanguageSpecification().setLanguage(languageProperty.get());
        LanguageSettingCommands.addSetting(languageSettingService.getLanguageSettings(), binding);
        languageSettingService.saveSettings();
        //刷新数据
        if (isEditing) {
            tableView.refresh();
        } else {
            loadLanguageBindings();
        }

    }

    private void initForm() {
        bindingForm = new LanguageBindingForm();
        StringField name = Field.ofStringType(bindingForm.shortName)
                .label(i18n.t("table.binding.shortName")).required("Name can't be empty");
        BooleanField primitive = Field.ofBooleanType(bindingForm.primitive)
                .label(i18n.t("table.binding.primitive"));
        StringField qualifiedName = Field.ofStringType(bindingForm.qualifiedName)
                .label(i18n.t("table.binding.qualifiedName"));
        MultiSelectionField<JDBCType> jdbcTypes = Field.ofMultiSelectionType(bindingForm.allJdbcTypes, bindingForm.jdbcTypes)
                .label(i18n.t("table.binding.jdbc-types")).render(new SimpleCheckBoxControl<>());
        form = Form.of(
                Group.of(
                        name,
                        jdbcTypes,
                        primitive,
                        qualifiedName
                )
        );
        formRenderer = new FormRenderer(form);
        ((CheckBox) primitive.getRenderer().getControl()).selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                if (newValue) {
                    qualifiedName.editable(false);
                    qualifiedName.getRenderer().setVisible(false);
                } else {
                    qualifiedName.editable(true);
                    qualifiedName.getRenderer().setVisible(true);
                }
            }
        });
        jdbcTypes.getRenderer().getContainer();
        editPane.getChildren().add(formRenderer);
    }

    @FXML
    private void onClose(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    private void onOk(ActionEvent event) {

    }

    private void loadLanguageBindings() {
        tableView.getItems().clear();
        ELanguage language = languageProperty.get();
        if (language != null) {
            List<ELanguageBinding> bindings = languageSettingService.getLanguageSettings().getBindings()
                    .stream().filter(eLanguageBinding -> {
                        ELanguageSpecification languageSpecification = eLanguageBinding.getLanguageSpecification();
                        return languageSpecification != null && languageSpecification.getLanguage().equals(language);
                    }).toList();

            bindings.forEach(eLanguageBinding -> {
                tableView.getItems().add(eLanguageBinding);
            });
        }
    }

    public void addBinding() {
        ELanguageBinding lb = EntityFactory.eINSTANCE.createELanguageBinding();
        lb.setLanguageSpecification(EntityFactory.eINSTANCE.createELanguageSpecification());
        formRenderer.setDisable(false);
        languageBinding.set(lb);
        isEditing = false;
    }

    public class LanguageBindingForm {
        private final StringProperty shortName = new SimpleStringProperty("");
        private final BooleanProperty primitive = new SimpleBooleanProperty(true);
        private final StringProperty qualifiedName = new SimpleStringProperty("");
        private final ListProperty<JDBCType> jdbcTypes = new SimpleListProperty<>();
        private final ListProperty<JDBCType> allJdbcTypes = new SimpleListProperty<>(FXCollections.observableArrayList(JDBCType.values())
                .sorted(Comparator.comparing(Enum::name)));


        public LanguageBindingForm() {
            ELanguageBinding binding = languageBinding.get();
            bind(binding);
            languageBinding.addListener((observable, oldValue, newValue) -> bind(newValue));
        }

        private void bind(ELanguageBinding binding) {
            shortName.set(StringUtils.defaultIfEmpty(binding.getLanguageSpecification().getShortName(), ""));
            primitive.set(binding.getLanguageSpecification().isPrimitive());
            qualifiedName.set(StringUtils.defaultIfEmpty(binding.getLanguageSpecification().getQualifiedName(), ""));
            jdbcTypes.clear();
            if (!binding.getJdbcTypes().isEmpty()) {
                binding.getJdbcTypes().forEach(eSupportedJdbcTypes -> {
                    jdbcTypes.add(JDBCType.valueOf(eSupportedJdbcTypes.getJdbcType()));
                });
            } else {
                jdbcTypes.setValue(FXCollections.observableArrayList());
            }

        }
    }
}
