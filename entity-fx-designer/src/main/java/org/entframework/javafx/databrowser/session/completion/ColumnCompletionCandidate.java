/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.completion;

import org.entframework.javafx.databrowser.session.ColumnInfo;

public class ColumnCompletionCandidate extends CompletionCandidate {
    private ColumnInfo _columnInfo;
    private TableCompletionCandidate _tableCompletionCandidate;

    public ColumnCompletionCandidate(ColumnInfo columnInfo, TableCompletionCandidate tableCompletionCandidate) {
        _columnInfo = columnInfo;
        _tableCompletionCandidate = tableCompletionCandidate;
    }

    @Override
    public String getReplacement() {
        return _columnInfo.getColName();
    }

//   private String getQualifiyingPrefix()
//   {
//      String qualifyingString = "";
//
//      if (null != _tableCompletionCandidate)
//      {
//         qualifyingString = _tableCompletionCandidate.getReplacement() + ".";
//      }
//      return qualifyingString;
//   }

    @Override
    public String getObjectTypeName() {
        return null;
    }

    @Override
    public String toString() {
        return _columnInfo.getDescription();
    }
}
