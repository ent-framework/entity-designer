/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.sqlreformat;

public class CommentSpec {
    public String commentBegin;
    public String commentEnd;

    public CommentSpec(String commentBegin, String commentEnd) {
        this.commentBegin = commentBegin;
        this.commentEnd = commentEnd;
    }
}
