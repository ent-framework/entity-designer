/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.services.progress;

import javafx.concurrent.Task;

public class Progressable extends Task {
    private ProgressTask _progressTask;
    private Runnable _runnable;

    private StringBuffer _msg = new StringBuffer();
    private Runnable _cancelCallback;
    private FXThreadUncheckedCallback _fxThreadUncheckedCallback;

    Progressable(FXThreadUncheckedCallback fxThreadUncheckedCallback) {
        _fxThreadUncheckedCallback = fxThreadUncheckedCallback;
    }

    public void update(String msg, long workDone, long max) {
        update(workDone, max);
        update(msg);
    }


    public void update(long workDone, long max) {
        updateProgress(workDone, max);
    }

    public void update(String msg) {
        if (0 == _msg.length()) {
            _msg.append(msg);
        } else {
            _msg.append("\n").append(msg);
        }

        updateMessage(_msg.toString());
    }

    public void setCancelCallback(Runnable cancelCallback) {
        _cancelCallback = cancelCallback;

        if (isCancelled()) {
            _cancelCallback.run();
        }
    }


    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        if (null != _cancelCallback) {
            _cancelCallback.run();
        }
        return super.cancel(mayInterruptIfRunning);
    }

    @Override
    protected Object call() throws Exception {
        if (null != _progressTask) {
            return _progressTask.call();
        } else {
            _runnable.run();
            return null;
        }
    }

    @Override
    protected void succeeded() {
        try {
            if (null != _progressTask) {
                _progressTask.goOn(get());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ProgressTask getProgressTask() {
        return _progressTask;
    }

    void setProgressTask(ProgressTask progressTask) {
        _progressTask = progressTask;
    }

    void setRunnable(Runnable runnable) {
        _runnable = runnable;
    }

    public void postShouldReadMessage(String msg) {
        _fxThreadUncheckedCallback.shouldReadMessagePosted();

        update(msg);
    }
}
