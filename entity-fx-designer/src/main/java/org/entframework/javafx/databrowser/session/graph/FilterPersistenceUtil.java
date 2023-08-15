/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.graph;

public class FilterPersistenceUtil {
    public static boolean isEmpty(FilterPersistence filterPersistence) {
        return null == filterPersistence.getFilter() && Operator.valueOf(filterPersistence.getOperatorAsString()).requiresValue();
    }

}
