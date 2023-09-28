module org.entframework.designer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;
    requires java.desktop;
    requires java.prefs;
    requires transitive javafx.graphics;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires io.github.eckig.grapheditor.api;
    requires org.eclipse.emf.edit;
    requires org.eclipse.emf.common;
    requires io.github.eckig.grapheditor.core;
    requires org.eclipse.emf.ecore.xmi;
    requires spring.beans;
    requires spring.context;
    requires spring.core;
    requires org.slf4j;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires java.sql;
    requires org.apache.commons.lang3;
    requires org.kordamp.ikonli.antdesignicons;
    requires org.kordamp.ikonli.fontawesome5;
    requires org.kordamp.ikonli.materialdesign2;
    requires org.entframework.designer.entitydesigner.model;
    requires atlantafx.base;
    requires rsyntaxtextarea;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires org.fxmisc.richtext;
    requires org.fxmisc.flowless;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;

    opens org.entframework.javafx to javafx.fxml, spring.core;
    opens org.entframework.javafx.common to javafx.fxml, spring.core;
    opens org.entframework.javafx.databrowser.services.progress to javafx.fxml;
    opens org.entframework.javafx.databrowser.aliases.dbconnector to javafx.fxml;
    opens org.entframework.javafx.databrowser.session.objecttree to javafx.fxml;
    opens org.entframework.javafx.databrowser.session.sql.tablesearch to javafx.fxml;
    opens org.entframework.javafx.databrowser.drivers to javafx.fxml, spring.core;
    opens org.entframework.javafx.databrowser.session.sql to javafx.fxml;
    opens org.entframework.javafx.databrowser.session.sql.bookmark to javafx.fxml;
    opens org.entframework.javafx.databrowser.aliases to javafx.fxml, spring.beans, spring.core;
    opens org.entframework.javafx.databrowser.settings to javafx.fxml;
    opens org.entframework.javafx.databrowser.table.tableexport to javafx.fxml;
    opens org.entframework.javafx.databrowser to javafx.fxml, spring.core;
    opens org.entframework.javafx.databrowser.view to spring.beans, javafx.fxml;
    opens org.entframework.javafx.designer to javafx.fxml, spring.context, spring.core;
    opens org.entframework.javafx.frame to javafx.fxml, spring.core;



    exports org.entframework.javafx.common.spring to spring.beans;
    exports org.entframework.javafx.common to javafx.graphics, spring.beans, spring.context;

    exports org.entframework.javafx to javafx.graphics, spring.beans, spring.context;

    exports org.entframework.javafx.databrowser to javafx.graphics, javafx.fxml, spring.beans;
    exports org.entframework.javafx.databrowser.drivers to com.fasterxml.jackson.databind, javafx.fxml, spring.beans;
    exports org.entframework.javafx.databrowser.aliases to com.fasterxml.jackson.databind, javafx.fxml;
    exports org.entframework.javafx.databrowser.session.sql to com.fasterxml.jackson.databind, javafx.fxml;
    exports org.entframework.javafx.databrowser.session.sql.bookmark to com.fasterxml.jackson.databind, javafx.fxml;
    exports org.entframework.javafx.databrowser.services.progress to javafx.fxml;
    exports org.entframework.javafx.databrowser.aliases.dbconnector to javafx.fxml;
    exports org.entframework.javafx.databrowser.session.objecttree to javafx.fxml;
    exports org.entframework.javafx.databrowser.session.sql.tablesearch to javafx.fxml;
    exports org.entframework.javafx.databrowser.settings to com.fasterxml.jackson.databind, javafx.fxml;
    exports org.entframework.javafx.databrowser.services to com.fasterxml.jackson.databind;
    exports org.entframework.javafx.databrowser.table.tableexport to javafx.fxml;
    exports org.entframework.javafx.frame to javafx.fxml, javafx.graphics, spring.beans;
    exports org.entframework.javafx.designer to javafx.graphics, spring.beans, spring.context;
    exports org.entframework.javafx.designer.form to spring.beans;
}