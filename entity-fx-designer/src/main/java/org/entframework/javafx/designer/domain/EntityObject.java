/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.designer.domain;

import org.entframework.javafx.common.utils.TextUtil;
import org.springframework.util.StringUtils;

import java.util.*;

public class EntityObject extends GeneratorObject {

    private static final long serialVersionUID = 6739294315192751908L;

    private Name name;

    /**
     * 表名称
     */
    private String table;

    private String description;

    private JavaType baseEntity;

    private String comment;

    /**
     * 表中的字段
     */
    private List<Field> fields;
    private List<Relationship> relationships;

    public EntityObject() {
        super(null);
    }

    public EntityObject(JavaPackage javaPackage) {
        super(javaPackage);
    }

    public EntityObject(List<Field> fields) {
        super(null);
        this.fields = fields;
    }

    public EntityObject(String name, List<Field> fields) {
        super(null);
        this.name = Name.of(name);
        this.table = TextUtil.camelToUnderline(name);
        this.fields = fields;
    }


    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }


    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }


    public List<Field> getFields() {
        if (fields == null) {
            fields = Collections.emptyList();
        }
        return fields;
    }


    public void setFields(List<Field> fields) {
        this.fields = fields;
    }


    public List<Relationship> getRelationships() {
        if (relationships == null) {
            relationships = Collections.emptyList();
        }
        return relationships;
    }

    public void setRelationships(List<Relationship> relationships) {
        this.relationships = relationships;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public JavaType getBaseEntity() {
        return baseEntity;
    }

    public void setBaseEntity(JavaType baseEntity) {
        this.baseEntity = baseEntity;
    }

    public Field getPK() {
        return getFields().stream().filter(Field::isPK).findAny().orElse(null);
    }


    public List<String> getImportList() {
        Set<String> imports = new HashSet<>();
        JavaPackage javaPackage = Objects.requireNonNull(getPackage());
        if (fields != null) {
            fields.forEach(field -> {
                JavaType javaType = field.getJavaType();
                if (javaType != null && javaType.isExplicitlyImported()) {
                    if (!StringUtils.endsWithIgnoreCase(javaType.getPackageName(), javaPackage.getValue())) {
                        imports.add(javaType.getFullyQualifiedName());
                    }
                }
            });
        }
        return imports.stream().toList();
    }


    public Field getVersion() {
        return getFields().stream().filter(Field::isVersion).findAny().orElse(null);
    }


    public boolean getHasEnum() {
        return getFields().stream().allMatch(Field::isEnum);
    }


    public boolean getHasRelation() {
        return !getFields().isEmpty();
    }


    public boolean getHasManyToOne() {
        return getRelationships().stream()
                .anyMatch(relationship -> StringUtils.endsWithIgnoreCase(relationship.getRelationType(), Relationship.MANY_TO_ONE));
    }


    public boolean getHasOneToMany() {
        return getRelationships().stream()
                .anyMatch(relationship -> StringUtils.endsWithIgnoreCase(relationship.getRelationType(), Relationship.ONE_TO_MANY));
    }

}
