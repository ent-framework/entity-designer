/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.common.utils;

import java.util.UUID;

public final class IdGenerator {
    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}
