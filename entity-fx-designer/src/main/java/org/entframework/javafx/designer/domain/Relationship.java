/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.designer.domain;

public class Relationship {
    public static final String MANY_TO_ONE = "many-to-one";
    public static final String ONE_TO_MANY = "one-to-many";

    private String name;
    private String comment;
    private String relationType;
    private JavaType targetEntity;
    private Field bindField;

    public String getRelationType() {
        return relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public JavaType getTargetEntity() {
        return targetEntity;
    }

    public void setTargetEntity(JavaType targetEntity) {
        this.targetEntity = targetEntity;
    }

    public Field getBindField() {
        return bindField;
    }

    public void setBindField(Field bindingField) {
        this.bindField = bindingField;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
