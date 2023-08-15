/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.sqlreformat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CodeReformator implements ICodeReformator {


    /**
     * Platform-specific line separator string
     */
    private String _lineSep = CODE_REFORMATOR_LINE_SEPARATOR;

    private CodeReformatorConfig _codeReformatorConfig;


    public CodeReformator(CodeReformatorConfig codeReformatorConfig) {
        _codeReformatorConfig = codeReformatorConfig;
    }

    /**
     * @see ICodeReformator#reformat(java.lang.String)
     */
    public String reformat(String in) {
        in = flatenWhiteSpaces(in, false);

        PieceMarkerSpec[] markerExcludeComma = createPieceMarkerSpecExcludeColon();

        String[] pieces = getReformatedPieces(in, markerExcludeComma).toArray(new String[0]);

        if (_codeReformatorConfig.isDoInsertValuesAlign()) {
            pieces = doInsertSpecial(pieces);
        }

        StringBuffer ret = new StringBuffer();

        int indentCount = 0;

        SectionsHandler sectionsHandler = new SectionsHandler(_codeReformatorConfig.isIndentSections());

        for (int i = 0; i < pieces.length; ++i) {
            if (pieceStartsWithComment(pieces[i])) {
                ret.append(pieces[i]);
            } else {

                sectionsHandler.before(pieces[i]);

                if (")".equals(pieces[i])) {
                    --indentCount;
                }

                ret.append(indent(pieces[i], indentCount + sectionsHandler.getExtraIndentCount()));

                sectionsHandler.after(pieces[i]);

                if ("(".equals(pieces[i])) {
                    ++indentCount;
                }

            }
            ret.append(_lineSep);
        }

        validate(in, ret.toString());

        return ret.toString();
    }

    private boolean pieceStartsWithComment(String piece) {
        for (CommentSpec commentSpec : _codeReformatorConfig.getCommentSpecs()) {
            if (piece.trim().startsWith(commentSpec.commentBegin)) {
                return true;
            }
        }

        return false;
    }


    private void validate(String beforeReformat, String afterReformat) {
        String normalizedBefore = getNormalized(beforeReformat);
        String normalizedAfter = getNormalized(afterReformat);

        if (!normalizedBefore.equalsIgnoreCase(normalizedAfter)) {
            int minLen = Math.min(normalizedAfter.length(), normalizedBefore
                    .length());
            StringBuffer diffPos = new StringBuffer();
            for (int i = 0; i < minLen; ++i) {
                if (Character.toUpperCase(normalizedBefore.charAt(i)) != Character
                        .toUpperCase(normalizedAfter.charAt(i))) {
                    break;
                }
                diffPos.append('-');
            }
            diffPos.append('^');

            // i18n[editextras.reformatFailed=Reformat failed, normalized
            // Strings differ]
            StringBuilder msg = new StringBuilder("Failed to format SQL:");
            msg.append(_lineSep);
            msg.append(normalizedBefore);
            msg.append(_lineSep);
            msg.append(normalizedAfter);
            msg.append(_lineSep);
            msg.append(diffPos.toString());
            msg.append(_lineSep);

            throw new IllegalStateException(msg.toString());
        }
    }

    /**
     * Returns a normalized version of a SQL string. Normalized strings before
     * and after reformatting should be the same. So normalized Strings may be
     * used for validation of the reformating process.
     */
    private String getNormalized(String s) {
        String ret = s.replaceAll("\\(", " ( ");
        ret = ret.replaceAll("\\)", " ) ");
        ret = ret.replaceAll(",", " , ");
        String sep = _codeReformatorConfig.getStatementSeparator();

        // If our separator is the regular expression special char '|', then
        // quote it before formatting.
        if (sep.equals("|")) {
            sep = "\\|";
        }
        ret = ret.replaceAll(sep, concat(" ", sep, " "));
        return flatenWhiteSpaces(ret, true).trim();
    }

    /**
     * Concatenates the specified strings and returns the result.
     *
     * @param strings the strings in array form to concatenate.
     * @return the concatenated result.
     */
    private String concat(String... strings) {
        StringBuilder result = new StringBuilder();
        for (String string : strings) {
            result.append(string);
        }
        return result.toString();
    }

    private List<String> getReformatedPieces(String in, PieceMarkerSpec[] markers) {
        CodeReformatorKernel kernel = new CodeReformatorKernel(markers, _codeReformatorConfig.getCommentSpecs(), _codeReformatorConfig.isLineBreakFor_AND_OR_in_FROM_clause());

        String[] pieces = kernel.toPieces(in);
        ArrayList<String> piecesBuf = new ArrayList<String>();

        ColumnListSpiltHandler columnListSpiltHandler = new ColumnListSpiltHandler(_codeReformatorConfig.getSelectListSpiltMode());

        for (int i = 0; i < pieces.length; ++i) {
            if (_codeReformatorConfig.getTrySplitLineLen() < pieces[i].length() || columnListSpiltHandler.requiresSplit()) {
                String[] splitPieces = trySplit(pieces[i], 0, _codeReformatorConfig.getTrySplitLineLen(), columnListSpiltHandler);
                piecesBuf.addAll(Arrays.asList(splitPieces));
            } else {
                piecesBuf.add(pieces[i]);
            }
        }
        return piecesBuf;
    }

    private String[] doInsertSpecial(String[] pieces) {
        int insertBegin = -1;
        boolean hasValues = false;

        ArrayList<String> ret = new ArrayList<String>();
        ArrayList<String> insertPieces = new ArrayList<String>();

        for (int i = 0; i < pieces.length; ++i) {
            if ("INSERT ".length() <= pieces[i].length() && pieces[i].substring(0, "INSERT ".length()).equalsIgnoreCase("INSERT ")) {
                if (-1 != insertBegin) {
                    // Inserts are not properly separated. We give up.
                    return pieces;
                }
                insertBegin = i;
            }

            if (-1 == insertBegin) {
                ret.add(pieces[i]);
            } else {
                insertPieces.add(pieces[i]);
            }

            if (-1 < insertBegin && -1 != pieces[i].toUpperCase().indexOf("VALUES")) {
                hasValues = true;
            }

            if (-1 < insertBegin && _codeReformatorConfig.getStatementSeparator().equalsIgnoreCase(pieces[i])) {
                if (hasValues) {
                    ret.addAll(reformatInsert(insertPieces));
                } else {
                    // No special treatment
                    ret.addAll(insertPieces);
                }

                insertBegin = -1;
                hasValues = false;
                insertPieces = new ArrayList<String>();
            }
        }

        if (-1 < insertBegin) {
            if (hasValues) {
                ret.addAll(reformatInsert(insertPieces));
            } else {
                // No special treatment
                ret.addAll(insertPieces);
            }
        }

        return ret.toArray(new String[0]);
    }

    private ArrayList<String> reformatInsert(ArrayList<String> piecesIn) {
        String[] pieces =
                splitAsFarAsPossible(piecesIn.toArray(new String[piecesIn.size()]));

        ArrayList<String> insertList = new ArrayList<String>();
        ArrayList<String> valuesList = new ArrayList<String>();
        ArrayList<String> behindInsert = new ArrayList<String>();

        StringBuffer statementBegin = new StringBuffer();
        int braketCountAbsolute = 0;
        for (int i = 0; i < pieces.length; ++i) {
            if (3 < braketCountAbsolute) {
                behindInsert.add(pieces[i]);
            }
            if ("(".equals(pieces[i]) || ")".equals(pieces[i])) {
                ++braketCountAbsolute;
            }

            if (0 == braketCountAbsolute) {
                statementBegin.append(pieces[i]).append(' ');
            }
            if (1 == braketCountAbsolute && !"(".equals(pieces[i])
                    && !")".equals(pieces[i])) {
                String buf = pieces[i].trim();
                if (buf.endsWith(",")) {
                    buf = buf.substring(0, buf.length() - 1);
                } else if (buf.startsWith(",")) // Needed to be introduced with _codeReformatorConfig.isCommasAtLineBegin()
                {
                    buf = buf.substring(1, buf.length());
                }
                insertList.add(buf);
            }
            if (3 == braketCountAbsolute && !"(".equals(pieces[i])
                    && !")".equals(pieces[i])) {
                String buf = pieces[i].trim();
                if (buf.endsWith(",")) {
                    buf = buf.substring(0, buf.length() - 1);
                } else if (buf.startsWith(",")) // Needed to be introduced with _codeReformatorConfig.isCommasAtLineBegin()
                {
                    buf = buf.substring(1, buf.length());
                }
                valuesList.add(buf);
            }
        }

        ArrayList<String> ret = new ArrayList<String>();

        if (0 == insertList.size()) {
            // Not successful
            ret.addAll(piecesIn);
            return ret;
        }

        if (insertList.size() == valuesList.size()) {
            ret.add(statementBegin.toString());
            StringBuffer insert = new StringBuffer();
            StringBuffer values = new StringBuffer();

            String insBuf = insertList.get(0);
            String valsBuf = valuesList.get(0);

            insert.append('(').append(adjustLength(insBuf, valsBuf));
            values.append('(').append(adjustLength(valsBuf, insBuf));

            for (int i = 1; i < insertList.size(); ++i) {
                insBuf = insertList.get(i);
                valsBuf = valuesList.get(i);

                insert.append(',').append(adjustLength(insBuf, valsBuf));
                values.append(',').append(adjustLength(valsBuf, insBuf));
            }
            insert.append(") VALUES");
            values.append(')');
            ret.add(insert.toString());
            ret.add(values.toString());
            ret.addAll(behindInsert);
            return ret;
        } else {
            // Not successful
            ret.addAll(piecesIn);
            return ret;
        }
    }

    private String[] splitAsFarAsPossible(String[] pieces) {
        ArrayList<String> ret = new ArrayList<String>();
        for (int i = 0; i < pieces.length; i++) {
            ret.addAll(Arrays.asList(trySplit(pieces[i], 0, 1, new ColumnListSpiltHandler(ColumnListSpiltMode.REQUIRE_SPLIT))));
        }
        return ret.toArray(new String[ret.size()]);
    }

    private String adjustLength(String s1, String s2) {
        int max = Math.max(s1.length(), s2.length());

        if (s1.length() == max) {
            return s1;
        } else {
            StringBuffer sb = new StringBuffer();
            sb.append(s1);
            while (sb.length() < max) {
                sb.append(' ');
            }
            return sb.toString();
        }
    }

    private String[] trySplit(String piece, int braketDepth, int trySplitLineLen, ColumnListSpiltHandler columnListSpiltHandler) {
        String trimmedPiece = piece.trim();
        CodeReformatorKernel dum = new CodeReformatorKernel(new PieceMarkerSpec[0], _codeReformatorConfig.getCommentSpecs(), _codeReformatorConfig.isLineBreakFor_AND_OR_in_FROM_clause());

        if (hasTopLevelColon(trimmedPiece, dum)) {
            PieceMarkerSpec[] pms = createPieceMarkerSpec(columnListSpiltHandler);

            int internalTrySplitLineLen = trySplitLineLen;

            if (columnListSpiltHandler.requiresSplit()) {
                internalTrySplitLineLen = 1;
            }

            CodeReformatorKernel crk = new CodeReformatorKernel(pms, _codeReformatorConfig.getCommentSpecs(), _codeReformatorConfig.isLineBreakFor_AND_OR_in_FROM_clause());
            String[] splitPieces1 = crk.toPieces(trimmedPiece);
            if (1 == splitPieces1.length) {
                return splitPieces1;
            }

            ArrayList<String> ret = new ArrayList<String>();

            for (int i = 0; i < splitPieces1.length; ++i) {
                if (internalTrySplitLineLen < splitPieces1[i].length() + braketDepth * _codeReformatorConfig.getIndent().length()) {
                    String[] splitPieces2 = trySplit(splitPieces1[i], braketDepth, internalTrySplitLineLen, columnListSpiltHandler);
                    for (int j = 0; j < splitPieces2.length; ++j) {
                        ret.add(splitPieces2[j].trim());
                    }
                } else {
                    ret.add(splitPieces1[i].trim());
                }
            }
            return (purgeEmptyStrings(ret)).toArray(new String[0]);
        } else {
            int[] tlbi = getTopLevelBraketIndexes(trimmedPiece, dum);
            if (-1 != tlbi[0] && tlbi[0] < tlbi[1]) {
                // ////////////////////////////////////////////////////////////////////////
                // Split the first two matching toplevel brakets here
                PieceMarkerSpec[] pms = createPieceMarkerSpec(columnListSpiltHandler);
                CodeReformatorKernel crk = new CodeReformatorKernel(pms, _codeReformatorConfig.getCommentSpecs(), _codeReformatorConfig.isLineBreakFor_AND_OR_in_FROM_clause());

                String[] splitPieces1 = crk.toPieces(trimmedPiece.substring(tlbi[0] + 1, tlbi[1]));

                ArrayList<String> buf = new ArrayList<String>();
                buf.add(trimmedPiece.substring(0, tlbi[0]).trim());
                buf.add("(");
                for (int i = 0; i < splitPieces1.length; ++i) {
                    buf.add(splitPieces1[i]);
                }
                buf.add(")");
                if (tlbi[1] + 1 < trimmedPiece.length()) {
                    buf.add(trimmedPiece.substring(tlbi[1] + 1,
                            trimmedPiece.length()).trim());
                }
                splitPieces1 = buf.toArray(new String[0]);
                //
                // ////////////////////////////////////////////////////////////////////

                // ///////////////////////////////////////////////////////////////////
                // Now check length of Strings in splitPieces1 again
                ArrayList<String> ret = new ArrayList<String>();
                for (int i = 0; i < splitPieces1.length; ++i) {
                    if (trySplitLineLen < splitPieces1[i].length() + braketDepth * _codeReformatorConfig.getIndent().length()) {
                        String[] splitPieces2 = trySplit(splitPieces1[i], braketDepth + 1, trySplitLineLen, columnListSpiltHandler);
                        for (int j = 0; j < splitPieces2.length; ++j) {
                            ret.add(splitPieces2[j]);
                        }
                    } else {
                        ret.add(splitPieces1[i]);
                    }
                }
                //
                // ///////////////////////////////////////////////////////////////////

                return (purgeEmptyStrings(ret)).toArray(new String[0]);
            } else {
                return new String[]{piece};
            }
        }
    }

    private PieceMarkerSpec[] createPieceMarkerSpec(ColumnListSpiltHandler columnListSpiltHandler) {
        PieceMarkerSpec[] pms;

        if (columnListSpiltHandler.allowsSplit()) {
            pms = createPieceMarkerSpecIncludeColon();
        } else {
            pms = createPieceMarkerSpecExcludeColon();
        }
        return pms;
    }

    /**
     * Takes the given list of string and removes elements that are either
     * null or empty strings
     *
     * @param items
     * @return
     */
    private List<String> purgeEmptyStrings(List<String> items) {
        for (Iterator<String> iter = items.iterator(); iter.hasNext(); ) {
            String item = iter.next();
            if (item == null || "".equals(item)) {
                iter.remove();
            }
        }
        return items;
    }

    private boolean hasTopLevelColon(String piece, CodeReformatorKernel crk) {
        int ix = piece.indexOf(",");
        StateOfPosition[] stateOfPositions = crk.getStatesOfPosition(piece);

        while (-1 != ix) {
            if (stateOfPositions[ix].isTopLevel) {
                return true;
            }
            if (ix < piece.length() - 1) {
                ix = piece.indexOf(",", ix + 1);
            } else {
                break;
            }
        }

        return false;

    }

    private int[] getTopLevelBraketIndexes(String piece,
                                           CodeReformatorKernel crk) {
        int[] ret = new int[2];
        ret[0] = -1;
        ret[1] = -1;

        StateOfPosition[] stateOfPositions = crk.getStatesOfPosition(piece);

        int bra = piece.indexOf("(");
        while (-1 != bra) {
            crk.getStatesOfPosition(piece);

            if (0 == bra || stateOfPositions[bra - 1].isTopLevel) {
                ret[0] = bra;
                break; // break when first braket found
            }
            if (bra < piece.length() - 1) {
                bra = piece.indexOf("(", bra + 1);
            } else {
                break;
            }
        }

        if (-1 == ret[0]) {
            return ret;
        }

        int ket = piece.indexOf(")", bra);
        while (-1 != ket) {
            if (ket == piece.length() - 1 || stateOfPositions[ket].isTopLevel) {
                // the next top level ket is the counterpart to bra
                ret[1] = ket;
                break;
            }
            if (ket < piece.length() - 1) {
                ket = piece.indexOf(")", ket + 1);
            } else {
                break;
            }
        }
        return ret;
    }

    private String indent(String piece, int callDepth) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < callDepth; ++i) {
            sb.append(_codeReformatorConfig.getIndent());
        }
        sb.append(piece);

        return sb.toString();
    }

    private String flatenWhiteSpaces(String in, boolean force) {

        if (hasCommentEndingWithLineFeed(in) && !force) {
            // No flaten. We would turn statement parts to comment
            return in;
        }

        StringBuffer ret = new StringBuffer();
        int aposCount = 0;
        char lastAppended = '\0';
        for (int i = 0; i < in.length(); ++i) {

            if ('\'' == in.charAt(i)) {
                ++aposCount;
            }


            boolean append = true;

            if (0 != aposCount % 2) {

            } else {
                if (Character.isWhitespace(in.charAt(i))) {
                    if (i + 1 < in.length() && Character.isWhitespace(in.charAt(i + 1))) {
                        append = false;
                    } else if (',' == lastAppended) {
                        append = false;
                    } else if (i + 1 < in.length() && ',' == in.charAt(i + 1)) {
                        append = false;
                    }
                }
            }

            if (append) {
                if (Character.isWhitespace(in.charAt(i)) && 0 == aposCount % 2) {
                    lastAppended = ' ';
                } else {
                    lastAppended = in.charAt(i);
                }
                ret.append(lastAppended);
            }
        }

        return ret.toString();

    }

    boolean hasCommentEndingWithLineFeed(String in) {
        CodeReformatorKernel dum = new CodeReformatorKernel(new PieceMarkerSpec[0], _codeReformatorConfig.getCommentSpecs(), _codeReformatorConfig.isLineBreakFor_AND_OR_in_FROM_clause());

        StateOfPosition[] sops = dum.getStatesOfPosition(in);

        boolean inComment = false;
        for (int i = 0; i < sops.length; ++i) {
            if (!inComment && -1 < sops[i].commentIndex) {
                if (-1 < _codeReformatorConfig.getCommentSpecs()[sops[i].commentIndex].commentEnd
                        .indexOf('\n')) {
                    return true;
                }
                inComment = true;
            }
            if (-1 == sops[i].commentIndex) {
                inComment = false;
            }
        }
        return false;
    }

    private PieceMarkerSpec[] createPieceMarkerSpecIncludeColon() {
        PieceMarkerSpec[] buf = createPieceMarkerSpecExcludeColon();
        ArrayList<PieceMarkerSpec> ret = new ArrayList<PieceMarkerSpec>();
        ret.addAll(Arrays.asList(buf));

        int type;
        if (_codeReformatorConfig.isCommasAtLineBegin()) {
            type = PieceMarkerSpec.TYPE_PIECE_MARKER_AT_BEGIN;
        } else {
            type = PieceMarkerSpec.TYPE_PIECE_MARKER_AT_END;
        }


        ret.add(new PieceMarkerSpec(",", type));

        return ret.toArray(new PieceMarkerSpec[0]);
    }

    private PieceMarkerSpec[] createPieceMarkerSpecExcludeColon() {
        ArrayList<PieceMarkerSpec> ret = new ArrayList<PieceMarkerSpec>();
        ret.addAll(Arrays.asList(_codeReformatorConfig.getKeywordPieceMarkerSpecs()));
        ret.add(new PieceMarkerSpec(_codeReformatorConfig.getStatementSeparator(), PieceMarkerSpec.TYPE_PIECE_MARKER_IN_OWN_PIECE));

        return ret.toArray(new PieceMarkerSpec[ret.size()]);
    }
}
