/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql.syntax;


import org.entframework.javafx.databrowser.session.TableInfo;
import org.entframework.javafx.databrowser.session.parser.kernel.TableAliasInfo;

import java.util.List;

public interface LexAndParseResultListener {
    /**
     * @param tableInfos more than one tables occur only if tables with equal names exist in different schemas/catalogs
     */
    void currentTableInfosNextToCaret(List<TableInfo> tableInfos);

    void aliasesFound(TableAliasInfo[] aliasInfos);
}
