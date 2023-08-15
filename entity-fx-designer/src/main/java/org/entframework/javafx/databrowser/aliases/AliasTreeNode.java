/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.aliases;

import org.entframework.javafx.databrowser.services.dndpositionmarker.DropIntoInfo;

public interface AliasTreeNode extends DropIntoInfo {
    String getId();

    String getName();

    @Override
    default boolean allowsDropInto() {
        return this instanceof AliasFolder;
    }
}
