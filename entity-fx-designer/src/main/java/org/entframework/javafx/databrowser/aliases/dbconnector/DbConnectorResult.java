/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.aliases.dbconnector;

import org.entframework.javafx.databrowser.aliases.AliasDecorator;
import org.entframework.javafx.databrowser.services.sqlwrap.SQLConnection;
import org.entframework.javafx.databrowser.session.schemainfo.SchemaCache;
import org.entframework.javafx.databrowser.session.schemainfo.SchemaCacheProperty;

public class DbConnectorResult {
    private Throwable _connectException;
    private AliasDecorator _alias;

    private String _user; // Should only be null if login was canceled.
    private String _password;

    private boolean _canceled;
    private boolean _editAliasRequested;
    private boolean _loginCanceled;
    private SQLConnection _sqlConnection;
    private SchemaCacheProperty _schemaCacheProperty = new SchemaCacheProperty();

    public DbConnectorResult(AliasDecorator alias, String user, String password) {
        _alias = alias;
        _user = user;
        _password = password;
    }

    public boolean isConnected() {
        return null != _sqlConnection;
    }

    public Throwable getConnectException() {
        return _connectException;
    }

    public void setConnectException(Throwable connectException) {
        _connectException = connectException;
    }

    public boolean isCanceled() {
        return _canceled;
    }

    public void setCanceled(boolean canceled) {
        _canceled = canceled;
    }

    public boolean isEditAliasRequested() {
        return _editAliasRequested;
    }

    public void setEditAliasRequested(boolean editAliasRequested) {
        _editAliasRequested = editAliasRequested;
    }

    public boolean isLoginCanceled() {
        return _loginCanceled;
    }

    public void setLoginCanceled(boolean loginCanceled) {
        _loginCanceled = loginCanceled;
    }

    public SQLConnection getSQLConnection() {
        return _sqlConnection;
    }

    public void setSQLConnection(SQLConnection sqlConnection) {
        _sqlConnection = sqlConnection;
    }

    public AliasDecorator getAliasDecorator() {
        return _alias;
    }

    public String getUser() {
        return _user;
    }

    public void setSchemaCache(SchemaCache schemaCache) {
        _schemaCacheProperty.set(schemaCache);
    }

    public SchemaCacheProperty getSchemaCacheProperty() {
        return _schemaCacheProperty;
    }

    public void fireCacheUpdate() {
        _schemaCacheProperty.fireChanged();
    }

    public String getPassword() {
        return _password;
    }

    public void close() {
        _schemaCacheProperty.get().writeCache();
        _sqlConnection.close();
    }
}
