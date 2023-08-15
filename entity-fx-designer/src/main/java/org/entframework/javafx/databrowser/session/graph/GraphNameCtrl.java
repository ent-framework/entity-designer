/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph;

import javafx.stage.Stage;
import org.entframework.javafx.databrowser.services.FxmlHelper;
import org.entframework.javafx.databrowser.services.GuiUtils;
import org.entframework.javafx.databrowser.services.Pref;
import org.entframework.javafx.databrowser.services.Utils;

public class GraphNameCtrl {
    private String _graphName;
    private String _defaultTabTitle;

    public GraphNameCtrl() {
        this(null);
    }

    public GraphNameCtrl(String defaultTabTitle) {
        _defaultTabTitle = defaultTabTitle;
        FxmlHelper<GraphNameView> fxmlHelper = new FxmlHelper<>(GraphNameView.class);

        Stage dlg = GuiUtils.createModalDialog(fxmlHelper.getRegion(), new Pref(getClass()), 285, 135, "GraphNameDialog");

        fxmlHelper.getView().btnOk.setOnAction(e -> onOk(fxmlHelper, dlg));
        fxmlHelper.getView().btnCancel.setOnAction(e -> dlg.close());

        fxmlHelper.getView().txtFileName.setText(defaultTabTitle);

        dlg.showAndWait();

    }

    private void onOk(FxmlHelper<GraphNameView> fxmlHelper, Stage dlg) {
        _graphName = fxmlHelper.getView().txtFileName.getText();
        dlg.close();
    }

    public String getGraphName() {
        if (Utils.isEmptyString(_graphName) || Utils.compareRespectEmpty(_graphName, _defaultTabTitle)) {
            return null;
        }

        return _graphName;
    }
}
