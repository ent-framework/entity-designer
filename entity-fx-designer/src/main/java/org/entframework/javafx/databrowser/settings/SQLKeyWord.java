/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.settings;

import org.entframework.javafx.databrowser.sqlreformat.PieceMarkerSpec;

import java.util.ArrayList;
import java.util.List;

public enum SQLKeyWord {
    UNION, FROM, INNER_LEFT_RIGHT_JOIN, WHERE, AND, OR, GROUP, ORDER, UPDATE, DELETE, INSERT, VALUES, SELECT;

    public List<PieceMarkerSpec> createPieceMarkerSpec(KeyWordBehavior keyWordBehavior) {
        ArrayList<PieceMarkerSpec> ret = new ArrayList<>();

        if (this == INNER_LEFT_RIGHT_JOIN) {
            ret.add(new PieceMarkerSpec("JOIN", PieceMarkerSpec.TYPE_PIECE_MARKER_AT_BEGIN));
            ret.add(new PieceMarkerSpec("INNER JOIN", PieceMarkerSpec.TYPE_PIECE_MARKER_AT_BEGIN));
            ret.add(new PieceMarkerSpec("LEFT JOIN", PieceMarkerSpec.TYPE_PIECE_MARKER_AT_BEGIN));
            ret.add(new PieceMarkerSpec("RIGHT JOIN", PieceMarkerSpec.TYPE_PIECE_MARKER_AT_BEGIN));
        } else {
            ret.add(new PieceMarkerSpec(this.toString(), keyWordBehavior.getPieceMarkerType()));
        }

        return ret;


    }
}
