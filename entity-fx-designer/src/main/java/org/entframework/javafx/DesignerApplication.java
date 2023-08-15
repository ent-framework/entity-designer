/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx;

import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.entframework.javafx.common.Resources;
import org.entframework.javafx.common.spring.AbstractJavaFxApplicationSupport;
import org.entframework.javafx.common.spring.SplashScreen;
import org.entframework.javafx.databrowser.AppState;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "org.entframework.javafx")
public class DesignerApplication extends AbstractJavaFxApplicationSupport {

    public static final boolean IS_DEV_MODE = "DEV".equalsIgnoreCase(
            Resources.getPropertyOrEnv("app.profiles.active", "app.profiles.active")
    );
    private static final String FONT_AWESOME = "fontawesome.ttf"; //$NON-NLS-1$

    public static void main(String[] args) {
        launchApp(DesignerApplication.class, MainView.class, new SplashScreen(), args);
    }

    @Override
    public void beforeInitialView(Stage stage, ConfigurableApplicationContext ctx) {
        Font.loadFont(getClass().getResource(FONT_AWESOME).toExternalForm(), 12);
    }

}