/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql.bookmark;

public class SquirrelBookmarkPersistence {
    private String _selShortcut;
    private boolean _useAsBookmark;
    private boolean _useAsAbbreviation;

    public String getSelShortcut() {
        return _selShortcut;
    }

    public void setSelShortcut(String selShortcut) {
        _selShortcut = selShortcut;
    }

    public boolean isUseAsBookmark() {
        return _useAsBookmark;
    }

    public void setUseAsBookmark(boolean useAsBookmark) {
        _useAsBookmark = useAsBookmark;
    }

    public boolean isUseAsAbbreviation() {
        return _useAsAbbreviation;
    }

    public void setUseAsAbbreviation(boolean useAsAbbreviation) {
        _useAsAbbreviation = useAsAbbreviation;
    }
}
