/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.schemainfo.schemacacheloading;

import org.entframework.javafx.databrowser.aliases.Alias;
import org.entframework.javafx.databrowser.services.Dao;
import org.entframework.javafx.databrowser.services.I18n;
import org.entframework.javafx.databrowser.services.MessageHandler;
import org.entframework.javafx.databrowser.services.MessageHandlerDestination;
import org.entframework.javafx.databrowser.session.ProcedureInfo;
import org.entframework.javafx.databrowser.session.TableInfo;
import org.entframework.javafx.databrowser.session.UDTInfo;
import org.entframework.javafx.databrowser.session.schemainfo.StructItemProcedureType;
import org.entframework.javafx.databrowser.session.schemainfo.StructItemTableType;
import org.entframework.javafx.databrowser.session.schemainfo.StructItemUDTType;

import java.util.List;

public class SerializedCacheManager {
    SerializedCache _serializedCache;
    private I18n _i18n = new I18n(getClass());
    private Alias _alias;

    public SerializedCacheManager(Alias alias) {
        _alias = alias;
    }

    public List<TableInfo> getTableInfos(StructItemTableType structItem) {
        return getSerializedCache().getTableInfos(structItem);
    }

    public void putTableInfos(StructItemTableType tableType, List<TableInfo> tableInfos) {
        getSerializedCache().putTableInfos(tableType, tableInfos);
    }

    public List<ProcedureInfo> getProcedureInfos(StructItemProcedureType procedureType) {
        return getSerializedCache().getProcedureInfos(procedureType);
    }

    public void putProcedureInfos(StructItemProcedureType procedureType, List<ProcedureInfo> procedureInfos) {
        getSerializedCache().putProcedureInfos(procedureType, procedureInfos);
    }

    public List<UDTInfo> getUDTInfos(StructItemUDTType udtType) {
        return getSerializedCache().getUDTInfos(udtType);
    }

    public void putUDTInfos(StructItemUDTType udtType, List<UDTInfo> udtInfos) {
        getSerializedCache().putUDTInfos(udtType, udtInfos);
    }


    private SerializedCache getSerializedCache() {
        if (null == _serializedCache) {
            _serializedCache = new SerializedCache();

            try {
                SerializedCache buf = Dao.readSerializedSchemaCache(_alias);

                if (buf != null) {
                    _serializedCache = buf;
                }
            } catch (Exception e) {
                new MessageHandler(getClass(), MessageHandlerDestination.MESSAGE_PANEL).warning(_i18n.t("failed.load.serialized.cache.panel", e));
                new MessageHandler(getClass(), MessageHandlerDestination.MESSAGE_LOG).warning(_i18n.t("failed.load.serialized.cache"), e);
            }
        }

        return _serializedCache;
    }

    public void writeCache() {
        // We check null != _serializedCache here because it might be that no cache
        // was accessed at all and we don't want to try to read it now.
        if (null != _serializedCache && false == _serializedCache.empty()) {
            Dao.writeSerializedSchemaCache(_alias, _serializedCache);
        }
    }
}
