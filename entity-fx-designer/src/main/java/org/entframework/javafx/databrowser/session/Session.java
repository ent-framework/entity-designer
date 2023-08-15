/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session;

import org.entframework.javafx.databrowser.aliases.Alias;
import org.entframework.javafx.databrowser.aliases.dbconnector.DbConnectorResult;
import org.entframework.javafx.databrowser.services.sqlwrap.SQLConnection;
import org.entframework.javafx.databrowser.session.schemainfo.SchemaCacheProperty;

public class Session {
    private DbConnectorResult _dbConnectorResult;
    private SessionTabContext _mainTabContext;
    private SessionCtrl _sessionCtrl;

    public Session(DbConnectorResult dbConnectorResult) {
        _dbConnectorResult = dbConnectorResult;
    }

    public Alias getAlias() {
        return _dbConnectorResult.getAliasDecorator().getAlias();
    }

    public void close() {
        _dbConnectorResult.close();
    }

    public DbConnectorResult getDbConnectorResult() {
        return _dbConnectorResult;
    }

    public SchemaCacheProperty getSchemaCacheValue() {
        return _dbConnectorResult.getSchemaCacheProperty();
    }

    public SessionProperties getSessionProperties() {
        return new SessionProperties();
    }

    public SessionTabContext getMainTabContext() {
        return _mainTabContext;
    }

    public void setMainTabContext(SessionTabContext mainTabContext) {
        _mainTabContext = mainTabContext;
    }

    public SQLConnection getSQLConnection() {
        return _dbConnectorResult.getSQLConnection();
    }

    public SessionCtrl getSessionCtrl() {
        return _sessionCtrl;
    }

    public void setSessionCtrl(SessionCtrl sessionCtrl) {
        _sessionCtrl = sessionCtrl;
    }
}
