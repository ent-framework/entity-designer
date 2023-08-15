/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */
package org.entframework.javafx.databrowser.session.parser.kernel;

import java.io.Serializable;
import java.util.Comparator;


/**
 * abstract superclass for completion items
 */
public abstract class SQLCompletion implements Completion {
    public static final int NO_POSITION = -1;
    public static final int NO_LIMIT = 99999;

    public static final String[] EMPTY_RESULT = new String[0];

    protected int startPosition = NO_POSITION, endPosition = NO_LIMIT;


    protected SQLCompletion(int startPosition) {
        this.startPosition = startPosition;
    }

    protected SQLCompletion() {
    }

    public Completion getCompletion(int position) {
        return isEnclosed(position) ? this : null;
    }

    /**
     * @return whether this object reperesents a concrete item, as opposed to being a
     * placeholder for potential items. For example, a non-concrete item may be inserted
     * into the completion tree to allow inserting completions in a certain text area. A
     * concrete item should be created when the parser encounters an existing item in the
     * token stream. During {@link #getCompletion completion lookup}, concrete items are
     * preferred before non-concrete ones
     */
    protected boolean isConcrete() {
        return true;
    }

    public void setEndPosition(int position) {
        this.endPosition = position;
    }

    /**
     * @return the completion text
     * @throws UnsupportedOperationException
     */
    public String getText(int position) {
        throw new UnsupportedOperationException("completion not available");
    }

    /**
     * @return the completion text, provided it is available
     * @throws UnsupportedOperationException
     */
    public String getText(int position, String options) {
        throw new UnsupportedOperationException("completion not available");
    }

    public boolean hasTextPosition() {
        return startPosition != NO_POSITION && endPosition != NO_POSITION;
    }

    public boolean isRepeatable() {
        return false;
    }

    public int getLength() {
        return endPosition - startPosition + 1;
    }

    public int getStart() {
        return startPosition;
    }


    public boolean mustReplace(int position) {
        return false;
    }

    /**
     * @param position the text position to be checked
     * @return whether the given text position is enclosed by this objects range
     */
    protected boolean isEnclosed(int position) {
        return position >= startPosition && position <= endPosition;
    }

    /**
     * A comparator implementation which sorts descending according to startPosition,
     * while preferring {@link #isConcrete concrete} items before non-concrete ones
     */
    public static class ChildComparator implements Comparator<SQLCompletion>,
            Serializable {
        public int compare(SQLCompletion c1, SQLCompletion c2) {
            if (c1.isConcrete() == c2.isConcrete()) {
                return c2.startPosition - c1.startPosition;
            } else {
                return c1.isConcrete() ? -1 : 1;
            }
        }
    }
}
