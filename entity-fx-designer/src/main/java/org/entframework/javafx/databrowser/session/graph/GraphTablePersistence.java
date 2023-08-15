/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphTablePersistence {
    private String _catalog;
    private String _schema;
    private String _name;
    private String _tableType;


    private double _minX;
    private double _minY;
    private double _width;
    private double _height;

    private HashMap<String, FkPropsPersistence> _persistentFkPropsPersistenceByFkName = new HashMap<>();
    private List<ColumnPersistence> _columnPersistences = new ArrayList<>();

    /**
     * For serialization only
     */
    public GraphTablePersistence() {
    }

    public GraphTablePersistence(TableWindowCtrl ctrl) {
        _catalog = ctrl.getTableInfo().getCatalog();
        _schema = ctrl.getTableInfo().getSchema();
        _name = ctrl.getTableInfo().getName();
        _tableType = ctrl.getTableInfo().getTableType();

        _minX = ctrl.getWindow().getLayoutX();
        _minY = ctrl.getWindow().getLayoutY();
        _width = ctrl.getWindow().getWidth();
        _height = ctrl.getWindow().getHeight();

        _persistentFkPropsPersistenceByFkName = FkPropsPersistence.toFkPropsPersitences(ctrl.getFkPropsByFkName());

        _columnPersistences = ctrl.getNonDbColumnImportPersistences();

    }


    public double getMinX() {
        return _minX;
    }

    public void setMinX(double minX) {
        _minX = minX;
    }

    public double getMinY() {
        return _minY;
    }

    public void setMinY(double minY) {
        _minY = minY;
    }

    public double getWidth() {
        return _width;
    }

    public void setWidth(double width) {
        _width = width;
    }

    public double getHeight() {
        return _height;
    }

    public void setHeight(double height) {
        _height = height;
    }

    public String getCatalog() {
        return _catalog;
    }

    public void setCatalog(String catalog) {
        _catalog = catalog;
    }

    public String getSchema() {
        return _schema;
    }

    public void setSchema(String schema) {
        _schema = schema;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getTableType() {
        return _tableType;
    }

    public void setTableType(String tableType) {
        _tableType = tableType;
    }

    public HashMap<String, FkPropsPersistence> getPersistentFkPropsPersistenceByFkName() {
        return _persistentFkPropsPersistenceByFkName;
    }

    public void setPersistentFkPropsPersistenceByFkName(HashMap<String, FkPropsPersistence> persistentFkPropsPersistenceByFkName) {
        _persistentFkPropsPersistenceByFkName = persistentFkPropsPersistenceByFkName;
    }

    public List<ColumnPersistence> getColumnPersistences() {
        return _columnPersistences;
    }

    public void setColumnPersistences(List<ColumnPersistence> columnPersistences) {
        _columnPersistences = columnPersistences;
    }
}
