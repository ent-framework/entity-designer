/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.aliases.dbconnector;

import javafx.stage.Stage;
import javafx.stage.Window;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.entframework.javafx.databrowser.aliases.Alias;
import org.entframework.javafx.databrowser.services.FxmlHelper;
import org.entframework.javafx.databrowser.services.GuiUtils;
import org.entframework.javafx.databrowser.services.I18n;
import org.entframework.javafx.databrowser.services.Pref;

import java.sql.SQLException;

public class ConnectFailedCtrl {
    private final Stage _stage;
    private I18n _i18n = new I18n(this.getClass(), "org.entframework.javafx.databrowser.aliases.dbconnector.i18n");
    private FxmlHelper<ConnectFailedView> _connectFailedViewFxml;
    private ConnectFailureDecisionListener _connectFailureDecisionListener;

    public ConnectFailedCtrl(Alias alias, DbConnectorResult dbConnectorResult, ConnectFailureDecisionListener connectFailureDecisionListener, Window owner) {
        _connectFailedViewFxml = new FxmlHelper<>(ConnectFailedView.class);

        _stage = GuiUtils.createModalDialog(_connectFailedViewFxml.getRegion(), new Pref(getClass()), 600, 400, "ConnectFailedController");
        _stage.initOwner(owner);


        _connectFailedViewFxml.getView().lblAliasConnecting.setText(_i18n.t("connectingctrl.alias.display", alias.getName(), alias.getUrl(), alias.getUserName()));

        _connectFailedViewFxml.getView().btnClose.setOnAction(e -> close());
        _connectFailedViewFxml.getView().btnRelogin.setOnAction(e -> onRelogin());
        _connectFailedViewFxml.getView().btnEditAlias.setOnAction(e -> onEditAlias());

        displayAndDecideOnConnectFailure(dbConnectorResult, connectFailureDecisionListener);

        _stage.show();
    }

    private void onEditAlias() {
        close();
        _connectFailureDecisionListener.decided(ConnectFailureDecisionListener.Decision.EDIT_ALIAS_REQUESTED);
    }

    private void onRelogin() {
        close();
        _connectFailureDecisionListener.decided(ConnectFailureDecisionListener.Decision.RELOGIN_REQUESTED);
    }


    private void displayAndDecideOnConnectFailure(DbConnectorResult dbConnectorResult, ConnectFailureDecisionListener connectFailureDecisionListener) {
        _connectFailureDecisionListener = connectFailureDecisionListener;

        String text = dbConnectorResult.getConnectException().getMessage();

        if (dbConnectorResult.getConnectException() instanceof SQLException) {
            SQLException sqlException = (SQLException) dbConnectorResult.getConnectException();

            text += "\nSQLState: " + sqlException.getSQLState();
            text += "\nErrorCode: " + sqlException.getErrorCode();
            text += "\n\n" + ExceptionUtils.getStackTrace(dbConnectorResult.getConnectException());
        } else {
            text += "\nMessage: " + dbConnectorResult.getConnectException().getMessage();
            text += "\n\n" + ExceptionUtils.getStackTrace(dbConnectorResult.getConnectException());
        }

        _connectFailedViewFxml.getView().txtErrMessage.setStyle("-fx-vbar-policy: always");
        _connectFailedViewFxml.getView().txtErrMessage.setText(text);
    }

    private void close() {
        _stage.close();
    }
}
