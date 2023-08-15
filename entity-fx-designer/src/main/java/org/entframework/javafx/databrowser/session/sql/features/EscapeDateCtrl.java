/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.session.sql.features;

import javafx.stage.Stage;
import org.entframework.javafx.databrowser.AppState;
import org.entframework.javafx.databrowser.services.FxmlHelper;
import org.entframework.javafx.databrowser.services.GuiUtils;
import org.entframework.javafx.databrowser.services.Pref;

import java.util.Calendar;

public class EscapeDateCtrl {
    private final EscapeDateListener _escapeDateListener;
    private final Stage _dialog;
    private final EscapeDateView _view;

    public EscapeDateCtrl(EscapeDateListener escapeDateListener) {
        this(escapeDateListener, AppState.get().getPrimaryStage());
    }

    public EscapeDateCtrl(EscapeDateListener escapeDateListener, Stage owner) {

        FxmlHelper<EscapeDateView> fxmlHelper = new FxmlHelper<>(EscapeDateView.class);

        _dialog = GuiUtils.createModalDialog(fxmlHelper.getRegion(), new Pref(getClass()), 190, 350, "EscapeDateView", owner);

        _view = fxmlHelper.getView();


        _escapeDateListener = escapeDateListener;

        _view.btnTimestamp.setOnAction(e -> onTimeStamp());

        _view.btnDate.setOnAction(e -> onDate());

        _view.btnTime.setOnAction(e -> onTime());


        Calendar cal = Calendar.getInstance();

        _view.txtYear.setText("" + cal.get(Calendar.YEAR));
        _view.txtMonth.setText("" + (cal.get(Calendar.MONTH) + 1));
        _view.txtDay.setText("" + cal.get(Calendar.DAY_OF_MONTH));
        _view.txtHour.setText("" + cal.get(Calendar.HOUR_OF_DAY));
        _view.txtMinute.setText("" + cal.get(Calendar.MINUTE));
        _view.txtSecond.setText("" + cal.get(Calendar.SECOND));

        _view.txtYear.requestFocus();


        _dialog.showAndWait();


    }

    private String prefixNulls(String toPrefix, int digitCount) {
        String ret = "" + toPrefix;

        while (ret.length() < digitCount) {
            ret = 0 + ret;
        }

        return ret;
    }

    private void onTime() {
        String esc = "{t '" + prefixNulls(_view.txtHour.getText(), 2) + ":" +
                prefixNulls(_view.txtMinute.getText(), 2) + ":" +
                prefixNulls(_view.txtSecond.getText(), 2) + "'}";

        _escapeDateListener.setDateString(esc);
        _dialog.close();
    }

    private void onDate() {
        String esc = "{d '" + prefixNulls(_view.txtYear.getText(), 4) + "-" +
                prefixNulls(_view.txtMonth.getText(), 2) + "-" +
                prefixNulls(_view.txtDay.getText(), 2) + "'}";

        _escapeDateListener.setDateString(esc);
        _dialog.close();
    }

    private void onTimeStamp() {
        String esc = "{ts '" + prefixNulls(_view.txtYear.getText(), 4) + "-" +
                prefixNulls(_view.txtMonth.getText(), 2) + "-" +
                prefixNulls(_view.txtDay.getText(), 2) + " " +
                prefixNulls(_view.txtHour.getText(), 2) + ":" +
                prefixNulls(_view.txtMinute.getText(), 2) + ":" +
                prefixNulls(_view.txtSecond.getText(), 2) + "'}";

        _escapeDateListener.setDateString(esc);
        _dialog.close();
    }
}
