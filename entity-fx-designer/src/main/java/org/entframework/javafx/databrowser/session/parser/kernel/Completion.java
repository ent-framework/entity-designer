/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */
package org.entframework.javafx.databrowser.session.parser.kernel;

/**
 * requirements of a completion item
 */
public interface Completion {
    /**
     * Find a completion item for the given text position. This method can be overridden by
     * subclasses to implement the composite pattern. If the object is not a composite, it
     * should return itself. Otherwise, it can delegate the lookup to its children.
     *
     * @param position the caret position at which the completion is requested
     * @return an appropriate completion object, or <em>null</em> of none available
     */
    Completion getCompletion(int position);

    /**
     * return completion text if the completion is fully defined
     *
     * @param position the caret position at which the text should be inserted
     * @return return the completion text to be inserted into the underlying document
     */
    String getText(int position);

    /**
     * return completion text which is defined from this object and the derived option
     *
     * @param position the caret position at which the text should be inserted
     * @param option   an option string, which was earlier derived from this object
     * @return return the completion text to be inserted into the underlying document
     */
    String getText(int position, String option);

    /**
     * @return whether this completion is assigned to a specific position within the
     * underlying document
     */
    boolean hasTextPosition();

    /**
     * @return whether this completion can be used to generate lists of items, e.g. columns
     * in a SQL select clause
     */
    boolean isRepeatable();

    /**
     * @return the length of the text currently occupied by this completion
     */
    int getLength();

    /**
     * @return the starting text position
     */
    int getStart();

    /**
     * @param position the position at which the status should be determined
     * @return whether the text between the start position and <em>position</em> must be replaced
     */
    boolean mustReplace(int position);
}
