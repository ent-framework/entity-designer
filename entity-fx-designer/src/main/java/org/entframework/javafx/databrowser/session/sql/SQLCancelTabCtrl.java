/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.Region;
import org.entframework.javafx.databrowser.services.FxmlHelper;
import org.entframework.javafx.databrowser.services.I18n;

public class SQLCancelTabCtrl {
    private final SQLCancelTabView _view;
    private final Region _region;
    private final Tab _cancelTab;
    private I18n _i18n = new I18n(getClass());


    public SQLCancelTabCtrl(String sql, StatementChannel statementChannel) {
        FxmlHelper<SQLCancelTabView> fxmlHelper = new FxmlHelper<>(SQLCancelTabView.class);

        _view = fxmlHelper.getView();
        _region = fxmlHelper.getRegion();

        _view.txtSql.setText(sql);
        _view.txtStatus.setText(StatementExecutionState.PREPARING.getText());

        long begin = System.currentTimeMillis();

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                _view.txtExecTime.setText("" + (System.currentTimeMillis() - begin));
            }
        };
        animationTimer.start();


        _view.btnCancel.setOnAction((e) -> statementChannel.cancelStatement());

        statementChannel.setStateChannelListener(statementExecutionState -> onExecutionStateChanged(statementExecutionState, animationTimer));


        _region.setPrefWidth(Double.MAX_VALUE);
        _region.setPrefHeight(Double.MAX_VALUE);

        _cancelTab = new Tab();
        _cancelTab.setGraphic(new Label(_i18n.t("session.tab.sql.executing.tab.title")));
        _cancelTab.setContent(_region);

    }

    private void onExecutionStateChanged(StatementExecutionState statementExecutionState, AnimationTimer animationTimer) {
        _view.txtStatus.setText(statementExecutionState.getText());

        if (StatementExecutionState.isEndState(statementExecutionState)) {
            animationTimer.stop();
        }
    }

    public Tab getTab() {
        return _cancelTab;
    }

    public void convertToInfoTab(long completeTime) {
        _view.lblSql.setText(_i18n.t("outputtab.sql.executed"));

        _view.lblExecTime.setText(_i18n.t("outputtab.sql.execution.time"));
        _view.txtExecTime.setText("" + completeTime);

        _cancelTab.setText(_i18n.t("outputtab.max.results.info"));
        _view.btnCancel.setDisable(true);
        _cancelTab.setClosable(false);
    }
}
