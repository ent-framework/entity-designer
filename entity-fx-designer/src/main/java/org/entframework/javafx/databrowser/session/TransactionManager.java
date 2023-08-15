/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session;

import org.entframework.javafx.databrowser.services.I18n;
import org.entframework.javafx.databrowser.services.MessageHandler;
import org.entframework.javafx.databrowser.services.MessageHandlerDestination;
import org.entframework.javafx.databrowser.session.action.StdActionCfg;

import java.sql.SQLException;

public class TransactionManager {
    private Session _session;

    public TransactionManager(Session session) {
        _session = session;
        StdActionCfg.TRANSACT_TOGGLE_AUTO_COMMIT.setToggleSelected(false);
        StdActionCfg.TRANSACT_TOGGLE_AUTO_COMMIT.setToggleAction(this::onToggleAutocommit);

        StdActionCfg.TRANSACT_COMMIT.setDisable(true);
        StdActionCfg.TRANSACT_ROLLBACK.setDisable(true);

        StdActionCfg.TRANSACT_COMMIT.setAction(TransactionManager.this::onCommit);
        StdActionCfg.TRANSACT_ROLLBACK.setAction(TransactionManager.this::onRollback);

    }

    private void onRollback() {
        try {
            _session.getSQLConnection().getConnection().rollback();
            new MessageHandler(getClass(), MessageHandlerDestination.MESSAGE_PANEL).info(new I18n(getClass()).t("TransactionManager.performed.rollback"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void onCommit() {
        try {
            _session.getSQLConnection().getConnection().commit();
            new MessageHandler(getClass(), MessageHandlerDestination.MESSAGE_PANEL).info(new I18n(getClass()).t("TransactionManager.performed.commit"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void onToggleAutocommit(boolean toggleIsSelected) {
        try {
            _session.getSQLConnection().getConnection().setAutoCommit(false == toggleIsSelected);

            StdActionCfg.TRANSACT_COMMIT.setDisable(!toggleIsSelected);
            StdActionCfg.TRANSACT_ROLLBACK.setDisable(!toggleIsSelected);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isAutoCommit() {
        return false == StdActionCfg.TRANSACT_TOGGLE_AUTO_COMMIT.isToggleSelected();
    }
}
