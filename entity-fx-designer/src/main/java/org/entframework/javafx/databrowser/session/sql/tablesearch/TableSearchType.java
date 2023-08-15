/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql.tablesearch;

import org.entframework.javafx.databrowser.services.I18n;

public enum TableSearchType {
    CONTAINS(I18nHelper.i18n.t("search.type.contains")),
    STARTS_WITH(I18nHelper.i18n.t("search.type.starts.with")),
    ENDS_WITH(I18nHelper.i18n.t("search.type.ends.with")),
    REG_EX(I18nHelper.i18n.t("search.type.regExp"));


    private String _toString;


    TableSearchType(String toString) {
        _toString = toString;
    }

    @Override
    public String toString() {
        return _toString;
    }

    private static class I18nHelper {
        private static I18n i18n = new I18n(TableSearchType.class);
    }
}
