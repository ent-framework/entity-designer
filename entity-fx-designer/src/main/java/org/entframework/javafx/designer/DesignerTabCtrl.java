/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.designer;

import com.dlsc.formsfx.view.renderer.FormRenderer;
import io.github.eckig.grapheditor.GraphEditor;
import io.github.eckig.grapheditor.core.view.GraphEditorContainer;
import io.github.eckig.grapheditor.model.GConnector;
import io.github.eckig.grapheditor.model.GModel;
import io.github.eckig.grapheditor.model.GNode;
import io.github.eckig.grapheditor.model.GraphFactory;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.collections.SetChangeListener;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import org.eclipse.emf.ecore.EObject;
import org.entframework.javafx.common.event.DefaultEventBus;
import org.entframework.javafx.common.event.EntityEvent;
import org.entframework.javafx.common.event.NodeEvent;
import org.entframework.javafx.common.spring.AbstractFxmlCtrl;
import org.entframework.javafx.common.spring.FXMLController;
import org.entframework.javafx.common.spring.SpringUtil;
import org.entframework.javafx.common.utils.AwesomeIcon;
import org.entframework.javafx.common.utils.IdGenerator;
import org.entframework.javafx.common.utils.ModelObjectUtils;
import org.entframework.javafx.common.utils.ResourceUtils;
import org.entframework.javafx.designer.command.EventCommands;
import org.entframework.javafx.designer.control.EModelObjectTreeCell;
import org.entframework.javafx.designer.entitydesigner.model.*;
import org.entframework.javafx.designer.ext.ModelGraphEditor;
import org.entframework.javafx.designer.form.ModelForm;
import org.entframework.javafx.designer.form.ModelFormFactory;
import org.entframework.javafx.designer.selections.SelectionCopier;
import org.entframework.javafx.designer.skin.EntitySkinConstants;
import org.entframework.javafx.designer.skin.EntitySkinController;
import org.entframework.javafx.designer.skin.SkinController;
import org.kordamp.ikonli.antdesignicons.AntDesignIconsOutlined;
import org.kordamp.ikonli.javafx.FontIcon;
import org.springframework.context.annotation.Scope;
import org.springframework.core.ResolvableType;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@FXMLController
@Scope("prototype")
public class DesignerTabCtrl extends AbstractFxmlCtrl {
    private static final String STYLE_CLASS_ENTITY_SKINS = "entity-skins"; //$NON-NLS-1$
    private final ModelGraphEditor graphEditor = new ModelGraphEditor();
    private final GraphEditorPersistence graphEditorPersistence = new GraphEditorPersistence();
    private final SelectionCopier selectionCopier = new SelectionCopier(graphEditor.getSkinLookup(),
            graphEditor.getSelectionManager());

    private final ObjectProperty<EModuleObject> mModuleProperty = new ObjectPropertyBase<>() {

        @Override
        public Object getBean() {
            return DesignerTabCtrl.this;
        }

        @Override
        public String getName() {
            return "module";
        }

    };

    @FXML
    public AnchorPane propertyPane;
    @FXML
    public AnchorPane graphEditorPane;
    @FXML
    public TreeView<EModelObject> treeView;
    @FXML
    public TextField treeSearchInput;
    public ToggleButton minimapButton;
    public BorderPane borderPane;
    public ToggleButton showGridBtn;
    public ToggleButton snapToGridBtn;
    public Button btnUndo;
    public Button btnRedo;
    @FXML
    private GraphEditorContainer graphEditorContainer;
    private EntitySkinController entitySkinController;

    private ModelForm<?> modelForm;

    public void initialize() {

        final GModel model = GraphFactory.eINSTANCE.createGModel();
        final EPersistenceObject persistence = EntityFactory.eINSTANCE.createEPersistenceObject();
        graphEditor.setModel(model);
        graphEditor.setPersistence(persistence);

        graphEditorContainer.setGraphEditor(graphEditor);

        graphEditor.getView().getStyleClass().add(STYLE_CLASS_ENTITY_SKINS);
        graphEditor.getProperties().gridVisibleProperty().bind(showGridBtn.selectedProperty());
        graphEditor.getProperties().snapToGridProperty().bind(snapToGridBtn.selectedProperty());

        entitySkinController = new EntitySkinController(graphEditor, graphEditorContainer);
        entitySkinController.activate();

        graphEditor.modelProperty().addListener((w, o, n) -> selectionCopier.initialize(n));

        selectionCopier.initialize(model);

        minimapButton.setGraphic(AwesomeIcon.MAP.node());

        graphEditor.persistenceProperty().addListener((observableValue, oldValue, newValue) -> resetTree(newValue));

        DefaultEventBus.getInstance().subscribe(NodeEvent.class, this::handleApplicationEvent);

        treeView.setCellFactory(param -> new EModelObjectTreeCell());
        treeView.setEditable(true);

        treeView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue == null || newValue.getValue() == null) return;
            treeItemClicked(newValue.getValue());
        });
        treeView.addEventHandler(TreeView.editCommitEvent(), event -> {
            if (event.getTreeItem().getValue() instanceof EModelObject modelObject) {
                EEntityObject entity = ModelObjectUtils.getTargetType(EEntityObject.class, modelObject);
                if (entity != null) {
                    DefaultEventBus.getInstance().publish(new EntityEvent(entity));
                }
            }
        });

        graphEditor.getSelectionManager().getSelectedItems().addListener((SetChangeListener<EObject>) change -> {
            if (change.getSet().size() == 1) {
                EObject eObject = change.getElementAdded();
            }
        });

        btnUndo.setDisable(true);
        btnRedo.setDisable(true);
        btnUndo.disableProperty().bind(graphEditor.undoStatusProperty().not());
        btnRedo.disableProperty().bind(graphEditor.redoStatusProperty().not());

    }

    /***
     * 鼠标点击，触发事件
     * @param modelObject
     */
    private void treeItemClicked(EModelObject modelObject) {
        setSelectedModule(modelObject);
        propertyPane.getChildren().clear();
        if (modelForm != null) {
            modelForm.cleanAdapters();
        }
        ModelForm<?> form = ModelFormFactory.getForm(modelObject);
        if (form != null) {
            FormRenderer formRenderer = form.getFormRenderer();
            propertyPane.getChildren().setAll(formRenderer);
            AnchorPane.setLeftAnchor(formRenderer, 2d);
            AnchorPane.setRightAnchor(formRenderer, 2d);
            modelForm = form;
        }
        selectNode(modelObject);
    }

    private void selectNode(EModelObject modelObject) {
        EEntityObject entity = ModelObjectUtils.getTargetType(EEntityObject.class, modelObject);
        if (entity != null) {
            GNode node = ResourceUtils.findNode(modelObject, entity.getId());
            if (node != null) {
                graphEditor.getSelectionManager().clearSelection();
                graphEditor.getSelectionManager().select(node);
                graphEditorContainer.panTo(node.getX(), node.getY());
            }
        }
    }

    private void setSelectedModule(EModelObject modelObject) {
        EModuleObject module = ModelObjectUtils.getTargetType(EModuleObject.class, modelObject);
        if (module != null) {
            this.mModuleProperty.set(module);
        }
    }

    public void loadFromFile(final File file) {
        graphEditorPersistence.loadModel(file, this.graphEditor);
        graphEditorContainer.panTo(Pos.CENTER);
        resetTree(this.graphEditor.getPersistence());
    }

    public SkinController getSkinController() {
        return this.entitySkinController;
    }

    public SelectionCopier getSelectionCopier() {
        return selectionCopier;
    }

    private void resetTree(EPersistenceObject persistence) {
        TreeItem<EModelObject> root = this.treeView.getRoot();
        if (root == null) {
            root = new TreeItem<>(persistence);
            root.setGraphic(FontIcon.of(AntDesignIconsOutlined.BANK, 16));
            this.treeView.setRoot(root);
        } else {
            root.getChildren().clear();
        }
        root.getChildren().addAll(ModelObjectUtils.generateTree(Objects.requireNonNull(persistence)));
    }

    @FXML
    public void addNode() {
        addNode(graphEditor.getView().getLocalToSceneTransform().getMxx());
    }

    @FXML
    public void undo() {
        EventCommands.undo(graphEditor.getModel());
    }

    @FXML
    public void redo() {
        EventCommands.redo(graphEditor.getModel());
    }

    @FXML
    public void toggleMinimap() {
        graphEditorContainer.getMinimap().visibleProperty().bind(minimapButton.selectedProperty());
    }

    private void addNode(final double currentZoomFactor) {

        String id = IdGenerator.generateId();
        final double windowXOffset = graphEditorContainer.getContentX() / currentZoomFactor;
        final double windowYOffset = graphEditorContainer.getContentY() / currentZoomFactor;

        final GNode node = GraphFactory.eINSTANCE.createGNode();
        node.setY(SkinController.NODE_INITIAL_Y + windowYOffset);

        node.setType(EntitySkinConstants.TITLED_NODE);
        node.setX(SkinController.NODE_INITIAL_X + windowXOffset);
        node.setId(id);

        final GConnector input = GraphFactory.eINSTANCE.createGConnector();
        node.getConnectors().add(input);
        input.setType(EntitySkinConstants.TITLED_INPUT_CONNECTOR);

        final GConnector output = GraphFactory.eINSTANCE.createGConnector();
        node.getConnectors().add(output);
        output.setType(EntitySkinConstants.TITLED_OUTPUT_CONNECTOR);

        final EEntityObject entity = EntityFactory.eINSTANCE.createEEntityObject();
        entity.setId(id);
        entity.setName("Untitled Entity");

        EventCommands.addNode(graphEditor.getModel(), node, graphEditor.getPersistence(), mModuleProperty.get(), entity);
    }

    public void panToCenter() {
        graphEditorContainer.panTo(Pos.CENTER);
    }

    @FXML
    public void save() {
        saveToFile(false);
    }

    @FXML
    public void saveAs() {
        saveToFile(true);
    }

    @FXML
    public void selectAll() {
        graphEditor.getSelectionManager().selectAll();
    }

    @FXML
    public void clearAll() {
        EventCommands.clear(graphEditor.getModel());
    }

    @FXML
    public void deleteSelection() {
        final List<EObject> selection = new ArrayList<>(graphEditor.getSelectionManager().getSelectedItems());
        graphEditor.delete(selection);
        DefaultEventBus.getInstance().publish(new NodeEvent(graphEditor.getModel(), null, NodeEvent.EventType.REMOVE));
    }

    public void copy() {
        selectionCopier.copy();
    }

    public void paste() {
        selectionCopier.paste(null);
    }

    public void saveToFile(boolean saveAs) {
        this.graphEditorPersistence.saveToFile(this.graphEditor, saveAs);
    }

    public void handleApplicationEvent(NodeEvent event) {
        if (event.getModel().equals(this.graphEditor.getModel())) {
            switch (event.getType()) {
                case ADD, REMOVE -> {
                    resetTree(graphEditor.getPersistence());
                }
                case CLEAR -> {
                    if (this.treeView.getRoot() != null) {
                        this.treeView.getRoot().getChildren().clear();
                    }
                }
                default -> {
                }
            }
        }
    }

    public void clearListener() {
        DefaultEventBus.getInstance().unsubscribe(this::handleApplicationEvent);
    }
}
