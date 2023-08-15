/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser;

import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.text.Font;
import org.entframework.javafx.common.utils.I18N;
import org.entframework.javafx.databrowser.workaround.StringWidthWA;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Locale;


public class VerticalToggleButton extends ToggleButton {

    private static final String STYLE_VERTICAL_TOGGLE = "vertical-toggle-button";
    private static final int WIDTH_MARGIN = 25;
    private static final int HEIGHT_MARGIN = 0;

    public VerticalToggleButton(String caption) {
        Font f = getFont();
        int captionHeight = toInt(StringWidthWA.computeFontHeight(f, caption));
        int captionWidth = toInt(StringWidthWA.computeTextWidth(f, caption));
        setPadding(new Insets(10, 5, 10, 5));
        if (I18N.getLocale().equals(Locale.ENGLISH)) {
            BufferedImage bi = new BufferedImage(captionHeight + 2 * HEIGHT_MARGIN, captionWidth + 2 * WIDTH_MARGIN, BufferedImage.TYPE_INT_ARGB);

            Graphics2D g = getGraphics2D(bi, f);
            g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            g.rotate(-Math.PI / 2);
            g.translate(-bi.getHeight(), bi.getWidth());
            g.drawString(caption, WIDTH_MARGIN, 0);

            WritableImage writableImage = SwingFXUtils.toFXImage(bi, new WritableImage(captionWidth, captionHeight));

            setGraphic(new ImageView(writableImage));
        } else {

            Label label = new Label(caption);
            label.setWrapText(true);
            label.setPrefHeight(captionWidth + 2 * WIDTH_MARGIN);
            label.setPrefWidth(captionHeight + 2 * HEIGHT_MARGIN);
            setGraphic(label);
        }


        this.getStyleClass().add(STYLE_VERTICAL_TOGGLE);
    }

    private Graphics2D getGraphics2D(BufferedImage bi, Font f) {
        Graphics2D g = (Graphics2D) bi.getGraphics();

        g.setColor(new Color(0, 0, 0, 0)); // transparent
        g.fillRect(0, 0, bi.getWidth(), bi.getHeight());

        javafx.scene.paint.Paint paint = this.getTextFill();

        if (paint instanceof javafx.scene.paint.Color fxc) {
            g.setColor(new Color(toInt(fxc.getRed()), toInt(fxc.getGreen()), toInt(fxc.getBlue())));
        }

        g.setFont(new java.awt.Font(f.getName(), java.awt.Font.BOLD, toInt(f.getSize())));
        return g;
    }

    private int toInt(double d) {
        return (int) (d + .5);
    }
}