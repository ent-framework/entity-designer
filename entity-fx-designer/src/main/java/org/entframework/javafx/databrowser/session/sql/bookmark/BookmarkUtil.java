/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql.bookmark;

import java.util.List;

public class BookmarkUtil {
    public static SquirrelBookmarkPersistence findMatchingSquirrelBookmarkPersistence(Bookmark bookmark, List<SquirrelBookmarkPersistence> squirrelBookmarkPersistences) {
        SquirrelBookmarkPersistence sbp = null;

        for (SquirrelBookmarkPersistence squirrelBookmarkPersistence : squirrelBookmarkPersistences) {
            if (squirrelBookmarkPersistence.getSelShortcut().equalsIgnoreCase(bookmark.getSelShortcut())) {
                sbp = squirrelBookmarkPersistence;
                break;
            }
        }
        return sbp;
    }
}
