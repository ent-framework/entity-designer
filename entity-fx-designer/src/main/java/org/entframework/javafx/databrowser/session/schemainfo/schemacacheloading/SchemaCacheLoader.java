/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.schemainfo.schemacacheloading;

import org.entframework.javafx.databrowser.aliases.dbconnector.DbConnectorResult;
import org.entframework.javafx.databrowser.services.CaseInsensitiveString;
import org.entframework.javafx.databrowser.services.I18n;
import org.entframework.javafx.databrowser.services.Utils;
import org.entframework.javafx.databrowser.services.progress.Progressable;
import org.entframework.javafx.databrowser.session.ProcedureInfo;
import org.entframework.javafx.databrowser.session.TableInfo;
import org.entframework.javafx.databrowser.session.UDTInfo;
import org.entframework.javafx.databrowser.session.schemainfo.*;

import java.util.ArrayList;
import java.util.List;

public class SchemaCacheLoader {
    private final SchemaCacheData _scd;
    private I18n _i18n = new I18n(getClass(), "org.entframework.javafx.databrowser.session.schemainfo.schemacacheloading.i18n");
    private DbConnectorResult _dbConnectorResult;

    private SerializedCacheManager _serializedCacheManager;

    public SchemaCacheLoader(DbConnectorResult dbConnectorResult, SchemaCacheConfig schemaCacheConfig, DatabaseStructure databaseStructure) {
        _dbConnectorResult = dbConnectorResult;
        _serializedCacheManager = new SerializedCacheManager(_dbConnectorResult.getAliasDecorator().getAlias());
        _scd = new SchemaCacheData(schemaCacheConfig, databaseStructure);
    }

    public void load(Progressable progressable) {
        if (_scd.getSchemaCacheConfig().shouldNotLoad()) {
            return;
        }

        List<StructItem> leaves = _scd.getDatabaseStructure().getLeaves();


        int stepCount = 6 + leaves.size();

        progressable.update(_i18n.t("Loading.data.types"), 1, stepCount);
        _scd.setDataBaseMetadData(DataBaseMetaDataLoader.loadMetaData(_dbConnectorResult.getAliasDecorator().getAlias(), _dbConnectorResult.getSQLConnection()));
        _scd.setDataTypes(DataTypesLoader.loadTypes(_dbConnectorResult.getSQLConnection()));


        progressable.update(_i18n.t("Loading.numeric.functions"), 2, stepCount);
        _scd.setNumericFunctions(DataBaseMetaDataLoader.loadNumericFunctions(_dbConnectorResult.getSQLConnection()));
        _scd.getNumericFunctions().getRows().forEach(e -> _scd.getCaseInsensitiveCache().addProc((String) e.get(0)));

        progressable.update(_i18n.t("Loading.string.functions"), 3, stepCount);
        _scd.setStringFunctions(DataBaseMetaDataLoader.loadStringFunctions(_dbConnectorResult.getSQLConnection()));
        _scd.getStringFunctions().getRows().forEach(e -> _scd.getCaseInsensitiveCache().addProc((String) e.get(0)));

        progressable.update(_i18n.t("Loading.system.functions"), 4, stepCount);
        _scd.setSystemFunctions(DataBaseMetaDataLoader.loadSystemFunctions(_dbConnectorResult.getSQLConnection()));
        _scd.getSystemFunctions().getRows().forEach(e -> _scd.getCaseInsensitiveCache().addProc((String) e.get(0)));

        progressable.update(_i18n.t("Loading.time.date.functions"), 5, stepCount);
        _scd.setTimeDateFunctions(DataBaseMetaDataLoader.loadTimeDateFunctions(_dbConnectorResult.getSQLConnection()));
        _scd.getTimeDateFunctions().getRows().forEach(e -> _scd.getCaseInsensitiveCache().addProc((String) e.get(0)));

        progressable.update(_i18n.t("Loading.keywords"), 6, stepCount);
        _scd.setKeywords(DataBaseMetaDataLoader.loadKeyWords(_dbConnectorResult.getSQLConnection()));
        _scd.getKeywords().getRows().forEach(e -> _scd.getCaseInsensitiveCache().addKeyword((String) e.get(0)));

        for (String keyWord : DefaultKeywords.KEY_WORDS) {
            _scd.getCaseInsensitiveCache().addKeyword(keyWord);
        }


        for (int i = 0; i < leaves.size(); i++) {
            if (progressable.isCancelled()) {
                progressable.update(_i18n.t("Stopping.schema.loading"));
                return;
            }

            StructItem leaf = leaves.get(i);

            if (leaf instanceof StructItemTableType) {
                loadMatchingTables((StructItemTableType) leaf, null, false);
            } else if (leaf instanceof StructItemProcedureType) {
                loadMatchingProcedures((StructItemProcedureType) leaf, null, false);
            } else if (leaf instanceof StructItemUDTType) {
                loadMatchingUDTs((StructItemUDTType) leaf, null);
            }

            progressable.update(_i18n.t("Loading.struct.item", leaf.getItemName()), 7 + i, stepCount);

        }

    }


    private void loadMatchingUDTs(StructItemUDTType udtType, String udtName) {
        if (udtType.shouldLoad(_scd.getSchemaCacheConfig())) {
            List<UDTInfo> udtInfos;

            if (udtType.shouldCache(_scd.getSchemaCacheConfig()) && null != _serializedCacheManager.getUDTInfos(udtType)) {
                udtInfos = _serializedCacheManager.getUDTInfos(udtType);
            } else {
                udtInfos = _dbConnectorResult.getSQLConnection().getUDTInfos(udtType.getCatalog(), udtType.getSchema(), udtName);

                if (udtType.shouldCache(_scd.getSchemaCacheConfig())) {
                    _serializedCacheManager.putUDTInfos(udtType, udtInfos);
                }
            }

            List<UDTInfo> buf = _scd.getUdtInfos().get(udtType);
            if (null == buf) {
                buf = new ArrayList<>();
                _scd.getUdtInfos().put(udtType, buf);
            }
            buf.addAll(udtInfos);
        }
    }

    public void reloadMatchingProcedures(String procedureName) {
        List<String> caseSensitiveProcedureNames = _scd.getCaseInsensitiveCache().getMatchingCaseSensitiveProcedureNames(procedureName);

        for (String caseSensitiveProcedureName : caseSensitiveProcedureNames) {
            if (false == _reloadMatchingProcedures(caseSensitiveProcedureName)) {
                // There several ways database systems store names. One of these three should always match.
                if (false == _reloadMatchingProcedures(caseSensitiveProcedureName.toLowerCase())) {
                    _reloadMatchingProcedures(caseSensitiveProcedureName.toUpperCase());
                }
            }
        }
    }

    private boolean _reloadMatchingProcedures(String procedureName) {
        ArrayList<ProcedureInfo> procedureInfos = new ArrayList<>();

        procedureInfos.addAll(Utils.convertNullToArray(_dbConnectorResult.getSQLConnection().getProcedureInfos(null, null, procedureName)));
        procedureInfos.addAll(Utils.convertNullToArray(_scd.getCaseInsensitiveCache().getProcedures(procedureName)));

        boolean reloaded = false;

        for (ProcedureInfo procedureInfo : procedureInfos) {
            StructItemProcedureType procedureType = new StructItemProcedureType(procedureInfo.getCatalog(), procedureInfo.getSchema());
            List<ProcedureInfo> toRemoveFrom = _scd.getProcedureInfos().get(procedureType);

            if (null != toRemoveFrom) {
                toRemoveFrom.remove(procedureInfo);
            }

            _scd.getCaseInsensitiveCache().removeProc(procedureName);


            loadMatchingProcedures(procedureType, procedureName, true);

            reloaded = true;
        }

        return reloaded;
    }

    private void loadMatchingProcedures(StructItemProcedureType procedureType, String procedureName, boolean forceReloadFromDB) {
        if (procedureType.shouldLoad(_scd.getSchemaCacheConfig())) {
            List<ProcedureInfo> procedureInfos;

            if (false == forceReloadFromDB && procedureType.shouldCache(_scd.getSchemaCacheConfig()) && null != _serializedCacheManager.getProcedureInfos(procedureType)) {
                procedureInfos = _serializedCacheManager.getProcedureInfos(procedureType);
            } else {
                procedureInfos = _dbConnectorResult.getSQLConnection().getProcedureInfos(procedureType.getCatalog(), procedureType.getSchema(), procedureName);

                if (procedureType.shouldCache(_scd.getSchemaCacheConfig())) {
                    _serializedCacheManager.putProcedureInfos(procedureType, procedureInfos);
                }
            }

            _scd.getProcedureInfos().put(procedureType, procedureInfos);

            List<ProcedureInfo> buf = _scd.getProcedureInfos().get(procedureType);
            if (null == buf) {
                buf = new ArrayList<>();
                _scd.getProcedureInfos().put(procedureType, buf);
            }
            buf.addAll(procedureInfos);


            for (ProcedureInfo procedureInfo : procedureInfos) {
                _scd.getCaseInsensitiveCache().addProc(procedureInfo.getName());
            }
        }
    }

    public void reloadMatchingTables(String tableName) {
        List<String> caseSensitiveTableNames = _scd.getCaseInsensitiveCache().getMatchingCaseSensitiveTableNames(tableName);

        for (String caseSensitiveTableName : caseSensitiveTableNames) {
            if (false == _reloadMatchingTables(caseSensitiveTableName)) {
                // There several ways database systems store names. One of these three should always match.
                if (false == _reloadMatchingTables(caseSensitiveTableName.toLowerCase())) {
                    _reloadMatchingTables(caseSensitiveTableName.toUpperCase());
                }
            }
        }
    }

    private boolean _reloadMatchingTables(String tableName) {
        ArrayList<TableInfo> tableInfos = new ArrayList<>();

        tableInfos.addAll(Utils.convertNullToArray(_dbConnectorResult.getSQLConnection().getTableInfos(null, null, null, tableName)));
        tableInfos.addAll(Utils.convertNullToArray(_scd.getCaseInsensitiveCache().getTables(tableName)));

        boolean reloaded = false;

        for (TableInfo tableInfo : tableInfos) {
            StructItemTableType tableType = new StructItemTableType(tableInfo.getTableType(), tableInfo.getCatalog(), tableInfo.getSchema());
            FullyQualifiedTableName fullyQualifiedTableName = new FullyQualifiedTableName(tableType.getCatalog(), tableType.getSchema(), tableInfo.getName());
            SchemaQualifiedTableName schemaQualifiedTableName = new SchemaQualifiedTableName(tableType.getSchema(), tableInfo.getName());


            List<TableInfo> buf = _scd.getTableInfos().get(tableType);
            if (null != buf) {
                buf.remove(tableInfo);
            }


            _scd.getTableInfosByFullyQualifiedName().remove(fullyQualifiedTableName);
            _scd.getTableInfosBySchemaQualifiedName().remove(schemaQualifiedTableName);
            _scd.getTableInfosBySimpleName().remove(new CaseInsensitiveString(tableInfo.getName()));
            _scd.getCaseInsensitiveCache().removeTable(tableInfo);

            loadMatchingTables(tableType, tableName, true);

            reloaded = true;
        }

        return reloaded;
    }

    private void loadMatchingTables(StructItemTableType tableType, String tableName, boolean forceReloadFromDB) {
        if (tableType.shouldLoad(_scd.getSchemaCacheConfig())) {
            List<TableInfo> tableInfos;

            if (false == forceReloadFromDB && tableType.shouldCache(_scd.getSchemaCacheConfig()) && null != _serializedCacheManager.getTableInfos(tableType)) {
                tableInfos = _serializedCacheManager.getTableInfos(tableType);
            } else {
                tableInfos = _dbConnectorResult.getSQLConnection().getTableInfos(tableType.getCatalog(), tableType.getSchema(), tableType.getType(), tableName);

                if (tableType.shouldCache(_scd.getSchemaCacheConfig())) {
                    _serializedCacheManager.putTableInfos(tableType, tableInfos);
                }
            }


            List<TableInfo> buf = _scd.getTableInfos().get(tableType);
            if (null == buf) {
                buf = new ArrayList<>();
                _scd.getTableInfos().put(tableType, buf);
            }
            buf.addAll(tableInfos);


            for (TableInfo tableInfo : tableInfos) {
                List<TableInfo> arr;


                FullyQualifiedTableName fullyQualifiedTableName = new FullyQualifiedTableName(tableType.getCatalog(), tableType.getSchema(), tableInfo.getName());
                arr = _scd.getTableInfosByFullyQualifiedName().get(fullyQualifiedTableName);

                if (null == arr) {
                    arr = new ArrayList<>();
                    _scd.getTableInfosByFullyQualifiedName().put(fullyQualifiedTableName, arr);
                }
                arr.add(tableInfo);

                SchemaQualifiedTableName schemaQualifiedTableName = new SchemaQualifiedTableName(tableType.getSchema(), tableInfo.getName());
                arr = _scd.getTableInfosBySchemaQualifiedName().get(schemaQualifiedTableName);

                if (null == arr) {
                    arr = new ArrayList<>();
                    _scd.getTableInfosBySchemaQualifiedName().put(schemaQualifiedTableName, arr);
                }
                arr.add(tableInfo);

                arr = _scd.getTableInfosBySimpleName().get(new CaseInsensitiveString(tableInfo.getName()));

                if (null == arr) {
                    arr = new ArrayList<>();
                    _scd.getTableInfosBySimpleName().put(new CaseInsensitiveString(tableInfo.getName()), arr);
                }
                arr.add(tableInfo);

                _scd.getCaseInsensitiveCache().addTable(tableInfo);

            }

        }
    }

    /**
     * Read only is just by contract.
     * So please don't change the object returned here.
     * Please use the method by SchemaCacheLoader.
     */
    public SchemaCacheData getSchemaCacheDataReadOnly() {
        return _scd;
    }

    public void writeCache() {
        _serializedCacheManager.writeCache();
    }

}
