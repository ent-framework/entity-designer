/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql.bookmark;

import org.entframework.javafx.databrowser.services.I18n;

public enum BookmarkWrapperType {
    ROOT_NODE(""),

    USER_BOOKMARKS_NODE(I18nHelper.i18n.t("bookmarkedit.userBookmarkNode")),
    SQUIRREL_BOOKMARKS_NODE(I18nHelper.i18n.t("bookmarkedit.squirrelBookmarkNode")),

    BOOKMARK(null);


    private String _nodeName;

    BookmarkWrapperType(String nodeName) {
        _nodeName = nodeName;
    }

    public String getNodeName() {
        return _nodeName;
    }

    private static class I18nHelper {
        private static I18n i18n = new I18n(BookmarkWrapperType.class);
    }

}
