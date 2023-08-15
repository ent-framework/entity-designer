/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser;

import org.entframework.javafx.databrowser.services.Dao;
import org.entframework.javafx.databrowser.session.sql.SQLHistoryEntry;

import java.util.List;

public class SqlHistoryManager {
    public static final int MAX_SQL_HISTORY_LENGTH = 500;
    private List<SQLHistoryEntry> _sqlHistoryEntries;

    public SqlHistoryManager() {
        init();
    }

    private void init() {
        _sqlHistoryEntries = Dao.loadSqlHistory();
        AppState.get().addSaveSettingsListener(this::saveHistoy);
    }

    public void saveHistoy() {
        Dao.writeSqlHistory(_sqlHistoryEntries);
    }

    public void addAll(List<SQLHistoryEntry> newEntries) {

        for (SQLHistoryEntry newEntry : newEntries) {
            newEntry.setNew(false);
            _sqlHistoryEntries.remove(newEntry);
            _sqlHistoryEntries.add(0, newEntry);
        }

        if (MAX_SQL_HISTORY_LENGTH < _sqlHistoryEntries.size()) {
            List<SQLHistoryEntry> toRemove = _sqlHistoryEntries.subList(MAX_SQL_HISTORY_LENGTH, _sqlHistoryEntries.size());
            _sqlHistoryEntries.removeAll(toRemove);
        }
    }

    public List<SQLHistoryEntry> getHistory() {
        return _sqlHistoryEntries;
    }
}
