/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.designer.domain;

import java.sql.JDBCType;

public class Field {

    private static final long serialVersionUID = -7928412682947631640L;

    /**
     * 字段名
     */
    private Name name;

    /**
     * 字段Java类型
     */
    private JavaType javaType;

    /**
     * 数据库字段名
     */
    private String column;

    /**
     * 数据库字段类型
     */
    private String columnType;

    private JDBCType jdbcType;

    /**
     * 数据库字段长度
     */
    private int length;

    private boolean nullable;

    private int scale;

    private boolean pk;
    private boolean isVersion;
    private boolean isEnum;

    /**
     * 备注
     */
    private String comment;

    private String typeHandler;

    public Field() {
    }

    public Field(String name) {
        this.name = Name.of(name);
    }

    public Name getName() {
        return name;
    }

    public void setName(String name) {
        this.name = Name.of(name);
        ;
    }

    public boolean isPK() {
        return pk;
    }

    public void setPK(boolean pk) {
        this.pk = pk;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public JDBCType getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(JDBCType jdbcType) {
        this.jdbcType = jdbcType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public JavaType getJavaType() {
        return javaType;
    }

    public void setJavaType(JavaType javaType) {
        this.javaType = javaType;
    }

    public String getTypeHandler() {
        return typeHandler;
    }

    public void setTypeHandler(String typeHandler) {
        this.typeHandler = typeHandler;
    }

    public boolean isEnum() {
        return isEnum;
    }

    public void setEnum(boolean anEnum) {
        isEnum = anEnum;
    }

    public boolean isVersion() {
        return isVersion;
    }

    public void setVersion(boolean version) {
        isVersion = version;
    }

}
