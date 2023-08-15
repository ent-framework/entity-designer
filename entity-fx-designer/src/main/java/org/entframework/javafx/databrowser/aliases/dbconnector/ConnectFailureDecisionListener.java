/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.databrowser.aliases.dbconnector;

public interface ConnectFailureDecisionListener {
    void decided(Decision decision);

    enum Decision {
        EDIT_ALIAS_REQUESTED,
        RELOGIN_REQUESTED
    }

}
