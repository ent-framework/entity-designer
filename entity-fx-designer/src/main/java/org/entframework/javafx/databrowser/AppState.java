/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser;

import javafx.application.Application;
import javafx.stage.Stage;
import org.entframework.javafx.common.spring.GUIState;
import org.entframework.javafx.databrowser.services.PropertiesHandler;
import org.entframework.javafx.databrowser.services.RunningServicesManager;
import org.entframework.javafx.databrowser.services.SettingsManager;
import org.entframework.javafx.databrowser.services.SquirrelProperty;
import org.entframework.javafx.databrowser.session.SessionManager;
import org.entframework.javafx.databrowser.session.action.ActionManager;
import org.entframework.javafx.frame.MessagePanelCtrl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AppState {
    private static AppState _appState;
    private final PropertiesHandler _propertiesHandler;

    private List<CloseListenerWithFireTime> _applicationCloseListeners = new ArrayList<>();
    private List<SaveSettingsListener> _saveSettingsListeners = new ArrayList<>();
    private SessionManager _sessionManager = new SessionManager();
    private ActionManager _actionManager = new ActionManager();
    private SqlHistoryManager _sqlHistoryManager;

    private RunningServicesManager _runningServicesManager = new RunningServicesManager();

    private PrefImpl _prefImpl = new PrefImpl();
    private SettingsManager _settingsManager = new SettingsManager();

    private AppState(Application.Parameters parameters) {
        _propertiesHandler = new PropertiesHandler(parameters);
    }

    public static AppState get() {
        return _appState;
    }

    public static void init(Application.Parameters parameters) {
        _appState = new AppState(parameters);
    }

    public PrefImpl getPrefImpl() {
        return _prefImpl;
    }

    public Stage getPrimaryStage() {
        return GUIState.getStage();
    }

    public PropertiesHandler getPropertiesHandler() {
        return _propertiesHandler;
    }

    public File getUserDir() {
        String userDir = _propertiesHandler.getProperty(SquirrelProperty.USER_DIR).trim();
        File file = new File(userDir);
        file.mkdirs();
        return file;
    }

    public File getLogDir() {
        File file = new File(getUserDir(), "logs");
        file.mkdirs();
        return file;
    }

    public void addApplicationCloseListener(ApplicationCloseListener l, ApplicationCloseListener.FireTime fireTime) {
        _applicationCloseListeners.add(new CloseListenerWithFireTime(l, fireTime));
    }

    public void fireApplicationClosing() {
        _fireApplicationClosing(ApplicationCloseListener.FireTime.WITHIN_SESSION_FIRE_TIME);
        _fireApplicationClosing(ApplicationCloseListener.FireTime.AFTER_SESSION_FIRE_TIME);
    }

    public void fireSaveSettings() {
        SaveSettingsListener[] clone = _saveSettingsListeners.toArray(new SaveSettingsListener[_saveSettingsListeners.size()]);

        for (SaveSettingsListener saveSettingsListener : clone) {
            saveSettingsListener.saveSettings();
        }
    }


    private void _fireApplicationClosing(ApplicationCloseListener.FireTime fireTime) {
        CloseListenerWithFireTime[] clone = _applicationCloseListeners.toArray(new CloseListenerWithFireTime[_applicationCloseListeners.size()]);

        for (CloseListenerWithFireTime applicationCloseListener : clone) {
            if (applicationCloseListener.getFireTime() == fireTime) {
                applicationCloseListener.getListener().applicationClosing();
            }
        }
    }

    public SessionManager getSessionManager() {
        return _sessionManager;
    }

    public ActionManager getActionManager() {
        return _actionManager;
    }

    public void removeApplicationCloseListener(ApplicationCloseListener l) {
        for (CloseListenerWithFireTime applicationCloseListener : _applicationCloseListeners) {
            if (applicationCloseListener.getListener().equals(l)) {
                _applicationCloseListeners.remove(applicationCloseListener);
                break;
            }
        }
    }

    public SqlHistoryManager getSqlHistoryManager() {
        if (null == _sqlHistoryManager) {
            // Lazy because it breaks when done during bootstrap
            _sqlHistoryManager = new SqlHistoryManager();
        }
        return _sqlHistoryManager;
    }

    public RunningServicesManager getRunningServicesManager() {
        return _runningServicesManager;
    }


    public SettingsManager getSettingsManager() {
        return _settingsManager;
    }

    public void addSaveSettingsListener(SaveSettingsListener saveSettingsListener) {
        _saveSettingsListeners.remove(saveSettingsListener);
        _saveSettingsListeners.add(saveSettingsListener);
    }
}
