/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.designer.domain;


import java.util.List;

public class Module extends GeneratorObject {
    private String name;
    private String description;

    private List<EntityObject> entities;

    public Module(JavaPackage _package, String name) {
        super(_package);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<EntityObject> getEntities() {
        return entities;
    }

    public void setEntities(List<EntityObject> entities) {
        this.entities = entities;
    }
}
