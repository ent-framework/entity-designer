/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.services;

import org.apache.commons.lang3.StringUtils;
import org.entframework.javafx.common.utils.I18N;

public class I18n {
    private Class _clazz;
    private String bundle;

    public I18n(Class clazz) {
        _clazz = clazz;
        this.bundle = clazz.getPackageName() + ".i18n";
    }

    public I18n(Class clazz, String bundle) {
        _clazz = clazz;
        this.bundle = bundle;
    }

    public String t(String s, Object... params) {
        if (StringUtils.isEmpty(this.bundle)) {
            return I18N.get(s, params);
        } else {
            return I18N.get(this.bundle, s, params);
        }
    }
}
