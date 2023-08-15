/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.table;

public interface SearchMatchCheck {
    SearchMatch getSearchMatch(Object valueToRender, SquirrelDefaultTableCell cell);
}
