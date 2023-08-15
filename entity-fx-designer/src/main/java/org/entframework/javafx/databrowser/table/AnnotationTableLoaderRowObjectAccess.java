/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.table;

import org.entframework.javafx.databrowser.services.I18n;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnnotationTableLoaderRowObjectAccess<T> implements TableLoaderRowObjectAccess<T> {
    private static <T> PropertyDescriptor findPropertyDescriptor(T rowObject, int colIx) {
        List<ColInfo> colInfos = findAllColInfosOrderedByColIx(rowObject.getClass());

        if (colIx < colInfos.size()) {
            return colInfos.get(colIx).getPropertyDescriptor();
        }

        throw new IllegalArgumentException("Could not find property annotated by RowObjectTableLoaderColumn for column index: " + colIx);
    }

    private static <T> List<ColInfo> findAllColInfosOrderedByColIx(Class<T> rowObjectClass) {
        try {
            ArrayList<ColInfo> ret = new ArrayList<>();

            PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(rowObjectClass).getPropertyDescriptors();

            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {

                if (null == propertyDescriptor.getReadMethod() || false == propertyDescriptor.getReadMethod().isAnnotationPresent(RowObjectTableLoaderColumn.class)) {
                    continue;
                }

                RowObjectTableLoaderColumn annotation = propertyDescriptor.getReadMethod().getAnnotation(RowObjectTableLoaderColumn.class);


                ret.add(new ColInfo(annotation, propertyDescriptor));

            }

            Collections.sort(ret, (ci1, ci2) -> Integer.compare(ci1.getAnnotation().columnIndex(), ci2.getAnnotation().columnIndex()));

            return ret;

        } catch (IntrospectionException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> ArrayList<ColumnHandle> initColsByAnnotations(RowObjectTableLoader<T> rowObjectTableLoader, Class<T> rowObjectClass) {
        List<ColInfo> colInfos = findAllColInfosOrderedByColIx(rowObjectClass);

        I18n i18n = new I18n(rowObjectClass);

        ArrayList<ColumnHandle> ret = new ArrayList<>();
        for (ColInfo colInfo : colInfos) {
            ColumnHandle columnHandle = rowObjectTableLoader.addColumn(i18n.t(colInfo.getAnnotation().columnHeaderI18nKey()));
            ret.add(columnHandle);
        }

        return ret;
    }

    @Override
    public Object getColumn(T rowObject, int colIx) {
        try {
            PropertyDescriptor p = findPropertyDescriptor(rowObject, colIx);
            return p.getReadMethod().invoke(rowObject);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setColumn(T rowObject, int colIx, Object cellValue) {
        try {
            PropertyDescriptor p = findPropertyDescriptor(rowObject, colIx);
            p.getWriteMethod().invoke(rowObject, cellValue);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static class ColInfo {
        RowObjectTableLoaderColumn _annotation;
        PropertyDescriptor _propertyDescriptor;

        private ColInfo(RowObjectTableLoaderColumn annotation, PropertyDescriptor propertyDescriptor) {
            _annotation = annotation;
            _propertyDescriptor = propertyDescriptor;
        }

        public RowObjectTableLoaderColumn getAnnotation() {
            return _annotation;
        }

        public PropertyDescriptor getPropertyDescriptor() {
            return _propertyDescriptor;
        }
    }
}
