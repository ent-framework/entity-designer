/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.aliases;

import org.entframework.javafx.databrowser.services.I18n;

public enum AliasPropertiesObjectTypes {
    TABLE(I18nHelper.i18n.t("alias.properties.object.type.tables")),
    VIEW(I18nHelper.i18n.t("alias.properties.object.type.views")),
    PROCEDURE(I18nHelper.i18n.t("alias.properties.object.type.procedures")),
    OTHER_TABLE_TYPES(I18nHelper.i18n.t("alias.properties.object.type.othertabletypes"));

    private String _toString;

    AliasPropertiesObjectTypes(String toString) {
        _toString = toString;
    }

    @Override
    public String toString() {
        return _toString;
    }

    private static class I18nHelper {
        private static I18n i18n = new I18n(AliasPropertiesObjectTypes.class);
    }


}
