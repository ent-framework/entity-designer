/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.table.tableexport;

public enum FileTypeEnum {
    EXPORT_FORMAT_XLSX(".xlsx"),
    EXPORT_FORMAT_XLS(".xls");

    public String _fileExtension;

    FileTypeEnum(String fileExtension) {
        this._fileExtension = fileExtension;
    }

    public String getFileExtension() {
        return _fileExtension;
    }
}
