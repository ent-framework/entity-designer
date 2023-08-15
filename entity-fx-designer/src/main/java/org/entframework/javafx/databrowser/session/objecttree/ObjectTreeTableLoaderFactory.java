/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.objecttree;

import org.entframework.javafx.databrowser.table.TableLoader;

public interface ObjectTreeTableLoaderFactory {
    public TableLoader createTableLoader();
}
