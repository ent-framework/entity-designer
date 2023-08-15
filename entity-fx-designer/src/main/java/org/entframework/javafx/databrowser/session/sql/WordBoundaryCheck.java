/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql;

public class WordBoundaryCheck {
    public static final char DEREFENCER = '.';

    public static final char[] STOP_AT = new char[]{DEREFENCER, '(', ')', '\'', '\n', ',', '=', '<', '>'};

    public static boolean isToStopAt(char toCheck, char former) {
        if (isInStopAtArray(former) || isInStopAtArray(toCheck)) {
            return true;
        } else if (false == Character.isWhitespace(former) && Character.isWhitespace(toCheck) ||
                Character.isWhitespace(former) && false == Character.isWhitespace(toCheck))
        //     else if(Character.isWhitespace(former) && false == Character.isWhitespace(toCheck))
        {
            return true;
        }

        return false;
    }

    private static boolean isInStopAtArray(char toCheck, char... stopsToIgnore) {
        for (char toIgnore : stopsToIgnore) {
            if (toIgnore == toCheck) {
                return false;
            }
        }


        for (int i = 0; i < STOP_AT.length; i++) {
            if (toCheck == STOP_AT[i]) {
                return true;
            }
        }

        return false;

    }

    public static boolean isInStopAtArrayOrWhiteSpace(char c, char... stopsToIgnore) {
        return Character.isWhitespace(c) || isInStopAtArray(c, stopsToIgnore);
    }
}
