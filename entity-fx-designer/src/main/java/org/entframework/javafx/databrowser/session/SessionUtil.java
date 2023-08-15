/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session;

import org.entframework.javafx.databrowser.aliases.Alias;
import org.entframework.javafx.databrowser.services.I18n;

public class SessionUtil {

    public static String getSessionTabTitle(SessionTabContext tabContext) {
        Alias alias = tabContext.getSession().getAlias();
        return new I18n(SessionUtil.class).t("session.tab.header", alias.getName(), alias.getUserName());
    }
}
