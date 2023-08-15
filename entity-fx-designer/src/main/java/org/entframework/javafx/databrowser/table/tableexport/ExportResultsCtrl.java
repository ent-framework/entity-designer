/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.table.tableexport;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Region;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.entframework.javafx.databrowser.AppState;
import org.entframework.javafx.databrowser.Props;
import org.entframework.javafx.databrowser.globalicons.GlobalIconNames;
import org.entframework.javafx.databrowser.services.*;
import org.entframework.javafx.databrowser.table.TableLoader;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ExportResultsCtrl {

    public static final String PREF_LAST_EXPORT_DIR = "lastExportDir";
    private static final String PREF_LAST_EXPORT_FILE_NAME = "lastExportFileName";
    private static final String PREF_LAST_EXPORT_TYPE = "lastExportFileType";
    private static final String PREF_EXECUTE_COMMAND_STRING = "executeCommandString";
    private static final String PREF_SHOULD_EXECUTE_COMMAND = "shouldExecuteCommand";
    private final Stage _dialog;
    private ExportResultsView _exportResultsView;
    private I18n _i18n = new I18n(this.getClass());
    private Pref _pref = new Pref(getClass());
    private ExcelService _currentExcelService;

    public ExportResultsCtrl(TableLoader tableLoader) {
        FxmlHelper<ExportResultsView> fxmlHelper = new FxmlHelper<>(ExportResultsView.class);
        _exportResultsView = fxmlHelper.getView();
        _dialog = new Stage();
        _dialog.setTitle(_i18n.t("export.title.exportresults"));
        _dialog.initModality(Modality.WINDOW_MODAL);
        _dialog.initOwner(AppState.get().getPrimaryStage());
        Region region = fxmlHelper.getRegion();
        _dialog.setScene(new Scene(region));
        GuiUtils.makeEscapeClosable(region);

        _exportResultsView.browseExportDir.setGraphic(new Props(this.getClass()).getImageView(GlobalIconNames.FOLDER));
        _exportResultsView.browseExportDir.setTooltip(new Tooltip(_i18n.t("navigateToExportDir")));
        _exportResultsView.browseExportDir.setOnAction(e -> onBrowseFile());

        _exportResultsView.browseCommand.setGraphic(new Props(this.getClass()).getImageView(GlobalIconNames.FOLDER));
        _exportResultsView.browseCommand.setTooltip(new Tooltip(_i18n.t("navigateToExecutable")));
        _exportResultsView.browseCommand.setOnAction(e -> onFindExecuteCommand());

        _exportResultsView.export.setOnAction(e -> onExportResults(tableLoader));
        _exportResultsView.exportCancel.setOnAction((e) -> onCancelOrClose());

        _exportResultsView.commandToExecute.setText(_pref.getString(PREF_EXECUTE_COMMAND_STRING, ""));

        _exportResultsView.checkExecuteCommand.setSelected(_pref.getBoolean(PREF_SHOULD_EXECUTE_COMMAND, false));

        _exportResultsView.checkExecuteCommand.setOnAction((e) -> onExecuteCommandChanged());
        onExecuteCommandChanged();

        _exportResultsView.exportTo.setText(System.getProperty("user.home"));

        String lastExportDir = _pref.getString(PREF_LAST_EXPORT_DIR, System.getProperty("user.home"));
        File lastDir = new File(lastExportDir);
        if (lastDir.exists() && lastDir.isDirectory()) {
            _exportResultsView.exportTo.setText(lastDir.getAbsolutePath());
        }

        String lastExportType = _pref.getString(PREF_LAST_EXPORT_TYPE, FileTypeEnum.EXPORT_FORMAT_XLSX.name());

        if (FileTypeEnum.EXPORT_FORMAT_XLSX.name().equals(lastExportType)) {
            _exportResultsView.excelXLSX.setSelected(true);
        } else if (FileTypeEnum.EXPORT_FORMAT_XLS.name().equals(lastExportType)) {
            _exportResultsView.excelXLS.setSelected(true);
        }


        String lastExportFileName = _pref.getString(PREF_LAST_EXPORT_FILE_NAME, null);
        _exportResultsView.fileName.setText(lastExportFileName);

        new StageDimensionSaver("resultExport", _dialog, _pref, 500, 350, AppState.get().getPrimaryStage());

        _dialog.showAndWait();
    }

    private void onCancelOrClose() {
        if (null != _currentExcelService) {
            _currentExcelService.cancel();
        }

        _dialog.close();
    }

    private void onExecuteCommandChanged() {
        boolean shouldExecuteCommand = _exportResultsView.checkExecuteCommand.isSelected();
        if (shouldExecuteCommand) {
            _exportResultsView.commandToExecute.setDisable(false);
            _exportResultsView.browseCommand.setDisable(false);
        } else {
            _exportResultsView.commandToExecute.setDisable(true);
            _exportResultsView.browseCommand.setDisable(true);
        }

        _pref.set(PREF_SHOULD_EXECUTE_COMMAND, shouldExecuteCommand);

    }

    private void onFindExecuteCommand() {
        final FileChooser dc = new FileChooser();
        dc.setInitialDirectory(new File(System.getProperty("user.home")));

        File file = dc.showOpenDialog(_dialog);

        if (null != file) {
            String execCommandString = file.getAbsolutePath() + " %file";
            _exportResultsView.commandToExecute.setText(execCommandString);

            _pref.set(PREF_EXECUTE_COMMAND_STRING, execCommandString);
        }
    }

    public void showWindow() {
        _dialog.showAndWait();
    }

    private void onBrowseFile() {
        final DirectoryChooser dc = new DirectoryChooser();

        if (false == Utils.isEmptyString(_exportResultsView.exportTo.getText())) {
            File initialDirectory = new File(_exportResultsView.exportTo.getText());
            if (initialDirectory.exists() && initialDirectory.isDirectory()) {
                dc.setInitialDirectory(initialDirectory);
            }
        }


        dc.setTitle(_i18n.t("export.title.directorychooser"));
        final File selectedDirectory = dc.showDialog(_dialog);
        if (null != selectedDirectory) {
            _exportResultsView.exportTo.setText(selectedDirectory.getAbsolutePath());
            saveLastExport(selectedDirectory, true);
        }
    }

    private void saveLastExport(File file, boolean isDirectoryOnly) {
        if (isDirectoryOnly) {
            _pref.set(PREF_LAST_EXPORT_DIR, file.getAbsolutePath());
        } else {
            _pref.set(PREF_LAST_EXPORT_DIR, file.getParent());
            _pref.set(PREF_LAST_EXPORT_FILE_NAME, file.getName());
        }
    }

    //TODO figure out how to use ProgressTask/ProgressUtil, they need to support updateProgress for a task
    private void onExportResults(TableLoader tableLoader) {

        File file = getAndCheckFile();
        if (file == null) {
            return;
        }

        saveLastExport(file, false);


        _pref.set(PREF_LAST_EXPORT_TYPE, FileTypeEnum.EXPORT_FORMAT_XLSX.name());
        if (_exportResultsView.excelXLS.isSelected()) {
            _pref.set(PREF_LAST_EXPORT_TYPE, FileTypeEnum.EXPORT_FORMAT_XLS.name());
        }

        //if (false == Utils.isEmptyString(_exportResultsView.commandToExecute.getText()))
        //{
        _pref.set(PREF_EXECUTE_COMMAND_STRING, _exportResultsView.commandToExecute.getText());
        //}

        _exportResultsView.export.setDisable(true);

        FileTypeEnum fileTypeEnum = FileTypeEnum.EXPORT_FORMAT_XLSX;

        if (_exportResultsView.excelXLS.isSelected()) {
            fileTypeEnum = FileTypeEnum.EXPORT_FORMAT_XLS;
        }

        _currentExcelService = new ExcelService(file, fileTypeEnum, tableLoader);
        _currentExcelService.stateProperty().addListener(new ChangeListener<Worker.State>() {
            @Override
            public void changed(ObservableValue<? extends Worker.State> observableValue, Worker.State oldState, Worker.State newState) {
                onServiceStateChanged(newState, _currentExcelService);
            }
        });

        _exportResultsView.exportCancel.setText(_i18n.t("export.button.cancel"));

        _currentExcelService.start();

//		Task<Void> task = es.excelWriteTask(tableLoader, _fileTypeEnum, _exportResultsView.exportTo.getText(), _exportResultsView.fileName.getText());
//		_exportResultsView.exportProgressIndicator.progressProperty().bind(task.progressProperty());
//		new Thread(task).start();
//		_exportResultsView.exportProgressIndicator.progressProperty().unbind();
//		_exportResultsView.exportProgressIndicator.setProgress(1.0);
    }

    private void onServiceStateChanged(Worker.State newState, ExcelService es) {
        switch (newState) {
            case SUCCEEDED:
                onSucceeded(es);
                break;
            case RUNNING:
                _exportResultsView.exportProgressIndicator.progressProperty().bind(es.progressProperty());
                break;
            case SCHEDULED:
                _exportResultsView.exportProgressIndicator.setProgress(ProgressIndicator.INDETERMINATE_PROGRESS);
            case FAILED:
                Platform.runLater(() -> onExportFailed(es));
            default:
                break;
        }
    }

    private void onSucceeded(ExcelService es) {
        _exportResultsView.exportProgressIndicator.progressProperty().unbind();
        _exportResultsView.exportProgressIndicator.setProgress(1.0);
        _exportResultsView.exportCancel.setText(_i18n.t("close"));
        _exportResultsView.export.setDisable(false);

        File exportFile = es.getExportFile();

        String command = getCommand(exportFile);

        if (null != command) {
            try {
                Runtime.getRuntime().exec(command);
                //FXMessageBox.showInfoOk(_dialog, _i18n.t("commandExecutedSuccesfully", command));
                _dialog.close();
            } catch (IOException e) {
                FXMessageBox.showInfoError(_dialog, _i18n.t("failedToExecCommand", command, e.getMessage()));
                new MessageHandler(getClass(), MessageHandlerDestination.MESSAGE_LOG).error("Failed to execute command: " + command, e);
            }
        } else {
            String s = FXMessageBox.showYesNo(_dialog, _i18n.t("successCreatingExport", exportFile.getAbsolutePath()));

            if (FXMessageBox.YES.equals(s)) {
                Utils.runOnSwingEDT(() -> onOpenExportDir(exportFile));
            }
            _dialog.close();
        }
    }

    private void onOpenExportDir(File exportFile) {
        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(exportFile.getParent()));
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }


    String getCommand(File exportFile) {
        if (_exportResultsView.checkExecuteCommand.isSelected()) {
            String commandPattern = _exportResultsView.commandToExecute.getText();

            if (Utils.isEmptyString(commandPattern)) {
                FXMessageBox.showInfoError(_dialog, "noCommand");
                return null;
            }

            // Copied from Java Doc Matcher.replaceAll:
            //
            // Note that backslashes (\) and dollar signs ($) in the replacement string
            // may cause the results to be different than if it
            // were being treated as a literal replacement string.
            // Dollar signs may be treated as references to
            // captured subsequences as described above, and
            // backslashes are used to escape literal characters in the replacement string.
            return commandPattern.replaceAll("%file", exportFile.getAbsolutePath().replaceAll("\\\\", "\\\\\\\\"));
        } else {
            return null;
        }
    }


    private void onExportFailed(ExcelService es) {
        if (null == es.getException()) {
            return;
        }

        _exportResultsView.exportProgressIndicator.progressProperty().unbind();
        _exportResultsView.exportProgressIndicator.setProgress(0);
        _exportResultsView.exportCancel.setText(_i18n.t("close"));
        _exportResultsView.export.setDisable(false);


        new MessageHandler(getClass(), MessageHandlerDestination.MESSAGE_LOG).error(es.getException());
        FXMessageBox.showInfoOk(_dialog, _i18n.t("exportFailed", ExceptionUtils.getRootCauseMessage(es.getException())));
    }

    private File getAndCheckFile() {
        File path = new File(_exportResultsView.exportTo.getText());
        if (false == path.exists() || false == path.isDirectory()) {
            FXMessageBox.showInfoOk(_dialog, new I18n(getClass()).t("exportDirDoesNotExist", path.getAbsolutePath()));
            return null;
        }


        if (Utils.isEmptyString(_exportResultsView.fileName.getText())) {
            FXMessageBox.showInfoOk(_dialog, new I18n(getClass()).t("noExportFile"));
            return null;
        }

        File file = new File(path, _exportResultsView.fileName.getText());


        if (_exportResultsView.excelXLS.isSelected()) {
            if (file.getName().toLowerCase().endsWith(FileTypeEnum.EXPORT_FORMAT_XLSX.getFileExtension().toLowerCase())) {
                // Change extension from .xlsx to .xls
                String fileNameWithoutFileExt = file.getName().substring(0, file.getName().length() - FileTypeEnum.EXPORT_FORMAT_XLSX.getFileExtension().length());
                file = new File(file.getParent(), fileNameWithoutFileExt + FileTypeEnum.EXPORT_FORMAT_XLS.getFileExtension());
            } else if (false == file.getName().toLowerCase().endsWith(FileTypeEnum.EXPORT_FORMAT_XLS.getFileExtension().toLowerCase())) {
                // Append .xls extension
                file = new File(file.getParent(), file.getName() + FileTypeEnum.EXPORT_FORMAT_XLS.getFileExtension());
            }
        } else if (_exportResultsView.excelXLSX.isSelected()) {
            if (file.getName().toLowerCase().endsWith(FileTypeEnum.EXPORT_FORMAT_XLS.getFileExtension().toLowerCase())) {
                // Change extension from .xls to .xlsx
                String fileNameWithoutFileExt = file.getName().substring(0, file.getName().length() - FileTypeEnum.EXPORT_FORMAT_XLS.getFileExtension().length());
                file = new File(file.getParent(), fileNameWithoutFileExt + FileTypeEnum.EXPORT_FORMAT_XLSX.getFileExtension());
            } else if (false == file.getName().toLowerCase().endsWith(FileTypeEnum.EXPORT_FORMAT_XLSX.getFileExtension().toLowerCase())) {
                // Append .xls extension
                file = new File(file.getParent(), file.getName() + FileTypeEnum.EXPORT_FORMAT_XLSX.getFileExtension());
            }
        } else {
            throw new IllegalStateException("How did we get here: Unknown export type");
        }

        if (file.exists()) {
            if (false == FXMessageBox.YES.equals(FXMessageBox.showYesNo(_dialog, new I18n(getClass()).t("exportFileOverwrite", file.getAbsolutePath())))) {
                return null;
            }
        }

        _exportResultsView.fileName.setText(file.getName());

        return file;
    }
}