/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.completion;

import org.entframework.javafx.databrowser.session.parser.kernel.TableAliasInfo;

public class AliasCompletionCandidate extends CompletionCandidate {
    private TableAliasInfo _currentAliasInfo;

    public AliasCompletionCandidate(TableAliasInfo currentAliasInfo) {
        _currentAliasInfo = currentAliasInfo;
    }

    @Override
    public String getReplacement() {
        return _currentAliasInfo.aliasName;
    }

    @Override
    public String getObjectTypeName() {
        return "ALIAS for table " + _currentAliasInfo.tableName;
    }
}
