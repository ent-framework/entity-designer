/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.common.spring;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.application.Platform;
import javafx.css.PseudoClass;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.entframework.javafx.common.Resources;
import org.entframework.javafx.common.event.BrowseEvent;
import org.entframework.javafx.common.event.DefaultEventBus;
import org.entframework.javafx.common.event.Listener;
import org.entframework.javafx.common.theme.ThemeManager;
import org.entframework.javafx.common.utils.I18N;
import org.entframework.javafx.databrowser.AppState;
import org.entframework.javafx.databrowser.services.Pref;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.awt.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * The Class AbstractJavaFxApplicationSupport.
 *
 * @author Felix Roske
 */
@SuppressWarnings("WeakerAccess")
public abstract class AbstractJavaFxApplicationSupport extends Application {
    static Class<? extends AbstractFxmlView> savedInitialView;
    static SplashScreen splashScreen;
    private static Logger LOGGER = LoggerFactory.getLogger(AbstractJavaFxApplicationSupport.class);
    private static String[] savedArgs = new String[0];
    private static ConfigurableApplicationContext applicationContext;

    private static List<Image> icons = new ArrayList<>();

    private static Consumer<Throwable> errorAction = defaultErrorAction();

    private final List<Image> defaultIcons = new ArrayList<>();

    private final CompletableFuture<Runnable> splashIsShowing;

    protected AbstractJavaFxApplicationSupport() {
        splashIsShowing = new CompletableFuture<>();
    }

    public static Stage getStage() {
        return GUIState.getStage();
    }

    public static Scene getScene() {
        return GUIState.getScene();
    }

    public static HostServices getAppHostServices() {
        return GUIState.getHostServices();
    }

    public static SystemTray getSystemTray() {
        return GUIState.getSystemTray();
    }

    protected static void setErrorAction(Consumer<Throwable> callback) {
        errorAction = callback;
    }

    /**
     * Default error action that shows a message and closes the app.
     */
    private static Consumer<Throwable> defaultErrorAction() {
        return e -> {
            Alert alert = new Alert(AlertType.ERROR, "Oops! An unrecoverable error occurred.\n" +
                    "Please contact your software vendor.\n\n" +
                    "The application will stop now.");
            alert.showAndWait().ifPresent(response -> Platform.exit());
        };
    }

    /**
     * Apply env props to view.
     */
    private static void applyEnvPropsToView() {
        PropertyReaderHelper.setIfPresent(applicationContext.getEnvironment(), Constant.KEY_TITLE, String.class,
                GUIState.getStage()::setTitle);

        PropertyReaderHelper.setIfPresent(applicationContext.getEnvironment(), Constant.KEY_STAGE_WIDTH, Double.class,
                GUIState.getStage()::setWidth);

        PropertyReaderHelper.setIfPresent(applicationContext.getEnvironment(), Constant.KEY_STAGE_HEIGHT, Double.class,
                GUIState.getStage()::setHeight);

        PropertyReaderHelper.setIfPresent(applicationContext.getEnvironment(), Constant.KEY_STAGE_RESIZABLE, Boolean.class,
                GUIState.getStage()::setResizable);
    }

    /**
     * Sets the title. Allows to overwrite values applied during construction at
     * a later time.
     *
     * @param title the new title
     */
    protected static void setTitle(final String title) {
        GUIState.getStage().setTitle(title);
    }

    /**
     * Launch app.
     *
     * @param appClass the app class
     * @param view     the view
     * @param args     the args
     * @deprecated To be more in line with javafx.application please use launch
     */
    public static void launchApp(final Class<? extends Application> appClass,
                                 final Class<? extends AbstractFxmlView> view, final String[] args) {

        launchApp(appClass, view, new SplashScreen(), args);
    }

    /**
     * Launch app.
     *
     * @param appClass     the app class
     * @param view         the view
     * @param splashScreen the splash screen
     * @param args         the args
     */
    public static void launchApp(final Class<? extends Application> appClass,
                                 final Class<? extends AbstractFxmlView> view, final SplashScreen splashScreen, final String[] args) {
        savedInitialView = view;
        savedArgs = args;

        AbstractJavaFxApplicationSupport.splashScreen = Objects.requireNonNullElseGet(splashScreen, SplashScreen::new);

        if (SystemTray.isSupported()) {
            GUIState.setSystemTray(SystemTray.getSystemTray());
        }

        Application.launch(appClass, args);
    }

    private void loadIcons(ConfigurableApplicationContext ctx) {
        try {
            final List<String> fsImages = PropertyReaderHelper.get(ctx.getEnvironment(), Constant.KEY_APPICONS);
            if (!fsImages.isEmpty()) {
                fsImages.forEach((s) -> {
                    Image img = new Image(getClass().getResource(s).toExternalForm());
                    icons.add(img);
                });
            } else { // add factory images
                icons.addAll(defaultIcons);
            }
        } catch (Exception e) {
            LOGGER.error("Failed to load icons: ", e);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see javafx.application.Application#init()
     */
    @Override
    public void init() throws Exception {
        // Load in JavaFx Thread and reused by Completable Future, but should not be a big deal.
        // Provide an executor instead of using default, otherwise spring application will fail to start via JAR(mvn package)
        AppState.init(getParameters());
        Pref pref = new Pref(org.entframework.javafx.MainCtrl.class);
        String savedLocale = pref.getString("locale", "");
        Locale locale = I18N.getLocalFromSettings(savedLocale);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        I18N.setLocale(locale);
        defaultIcons.addAll(loadDefaultIcons());
        CompletableFuture.supplyAsync(() ->
                SpringApplication.run(this.getClass(), savedArgs), executor
        ).whenComplete((ctx, throwable) -> {
            if (throwable != null) {
                LOGGER.error("Failed to load spring application context: ", throwable);
                executor.shutdown();
                Platform.runLater(() -> errorAction.accept(throwable));
            } else {
                Platform.runLater(() -> {
                    loadIcons(ctx);
                    launchApplicationView(ctx);
                });
            }
        }).thenAcceptBothAsync(splashIsShowing, (ctx, closeSplash) -> {
            executor.shutdown();
            Platform.runLater(closeSplash);
        });
    }

    /*
     * (non-Javadoc)
     *
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    @Override
    public void start(final Stage stage) throws Exception {
        loadApplicationProperties();

        GUIState.setStage(stage);
        GUIState.setHostServices(this.getHostServices());

        final Stage splashStage = new Stage(StageStyle.TRANSPARENT);

        if (AbstractJavaFxApplicationSupport.splashScreen.visible()) {
            final Scene splashScene = new Scene(splashScreen.getParent(), Color.TRANSPARENT);
            splashStage.setScene(splashScene);
            splashStage.getIcons().addAll(defaultIcons);
            splashStage.initStyle(StageStyle.TRANSPARENT);
            beforeShowingSplash(splashStage);
            splashStage.show();
        }

        splashIsShowing.complete(() -> {
            showInitialView();
            if (AbstractJavaFxApplicationSupport.splashScreen.visible()) {
                splashStage.hide();
                splashStage.setScene(null);
            }
        });
    }

    private void loadApplicationProperties() {
        try {
            var properties = new Properties();
            properties.load(new InputStreamReader(Resources.getResourceAsStream("application.properties"), UTF_8));
            properties.forEach((key, value) -> System.setProperty(
                    String.valueOf(key),
                    String.valueOf(value)
            ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Show initial view.
     */
    private void showInitialView() {
        final String stageStyle = applicationContext.getEnvironment().getProperty(Constant.KEY_STAGE_STYLE);
        if (stageStyle != null) {
            GUIState.getStage().initStyle(StageStyle.valueOf(stageStyle.toUpperCase()));
        } else {
            GUIState.getStage().initStyle(StageStyle.DECORATED);
        }

        beforeInitialView(GUIState.getStage(), applicationContext);

        showInitialView(savedInitialView);
    }

    /**
     * Launch application view.
     */
    private void launchApplicationView(final ConfigurableApplicationContext ctx) {
        AbstractJavaFxApplicationSupport.applicationContext = ctx;
    }

    /**
     * Show view.
     *
     * @param newView the new view
     */
    public void showInitialView(final Class<? extends AbstractFxmlView> newView) {
        try {
            final AbstractFxmlView view = applicationContext.getBean(newView);

            view.initFirstView();
            applyEnvPropsToView();

            ThemeManager themeManager = ThemeManager.getInstance();
            themeManager.setScene(GUIState.getScene());
            String theme = Resources.getPreferences().get("theme", themeManager.getDefaultTheme().getName());
            themeManager.setThemeByName(theme);

            PseudoClass CUSTOM_THEME = PseudoClass.getPseudoClass("custom-theme");
            GUIState.getScene().getRoot().pseudoClassStateChanged(CUSTOM_THEME, true);

            DefaultEventBus.getInstance().subscribe(BrowseEvent.class, this::onBrowseEvent);

            GUIState.getStage().getIcons().addAll(icons);
            GUIState.getStage().show();
            //GUIState.getStage().requestFocus();

        } catch (Throwable t) {
            LOGGER.error("Failed to load application: ", t);
            errorAction.accept(t);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see javafx.application.Application#stop()
     */
    @Override
    public void stop() throws Exception {
        super.stop();
        try {
            Resources.getPreferences().flush();
        } catch (Exception ex) {

        }

        if (applicationContext != null) {
            applicationContext.close();
        } // else: someone did it already
    }

    /**
     * Gets called after full initialization of Spring application context
     * and JavaFX platform right before the initial view is shown.
     * Override this method as a hook to add special code for your app. Especially meant to
     * add AWT code to add a system tray icon and behavior by calling
     * GUIState.getSystemTray() and modifying it accordingly.
     * <p>
     * By default noop.
     *
     * @param stage can be used to customize the stage before being displayed
     * @param ctx   represents spring ctx where you can loog for beans.
     */
    public void beforeInitialView(final Stage stage, final ConfigurableApplicationContext ctx) {
    }

    public void beforeShowingSplash(Stage splashStage) {

    }

    public Collection<Image> loadDefaultIcons() {
        return Arrays.asList(new Image(getClass().getResource("/icons/logo_16x16.png").toExternalForm()),
                new Image(getClass().getResource("/icons/logo_24x24.png").toExternalForm()),
                new Image(getClass().getResource("/icons/logo_36x36.png").toExternalForm()),
                new Image(getClass().getResource("/icons/logo_42x42.png").toExternalForm()),
                new Image(getClass().getResource("/icons/logo_64x64.png").toExternalForm()));
    }

    @Listener
    private void onBrowseEvent(BrowseEvent event) {
        getHostServices().showDocument(event.getUri().toString());
    }
}
