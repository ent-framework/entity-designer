/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.parser;

import org.entframework.javafx.databrowser.session.parser.kernel.ErrorInfo;
import org.entframework.javafx.databrowser.session.parser.kernel.TableAliasInfo;

public interface ParserEventsListener {
    void aliasesFound(TableAliasInfo[] aliasInfos);

    void errorsFound(ErrorInfo[] errorInfos);
}
