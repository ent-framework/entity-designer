/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.aliases;

import org.entframework.javafx.databrowser.services.I18n;

public enum SchemaLoadOptions {
    LOAD_BUT_DONT_CACHE(Helper.i18n.t("alias.load.option.load.no.cache")),
    LOAD_AND_CACHE(Helper.i18n.t("alias.load.option.load.and.cache")),
    DONT_LOAD(Helper.i18n.t("alias.load.option.dont.load"));


    private String _toString;


    SchemaLoadOptions(String toString) {

        _toString = toString;
    }

    @Override
    public String toString() {
        return _toString;
    }

    private static class Helper {
        private static I18n i18n = new I18n(SchemaLoadOptions.class, "org.entframework.javafx.databrowser.aliases.i18n");
    }

}
