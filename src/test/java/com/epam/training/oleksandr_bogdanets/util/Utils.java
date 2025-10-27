package com.epam.training.oleksandr_bogdanets.util;

import com.epam.training.oleksandr_bogdanets.model.Credentials;

import java.util.UUID;

public class Utils {

    private static final String EMAIL_ENDING = "@gmail.com";

    private static final String EMAIL = "test12345@gmail.com";
    private static final String PASSWORD = "-xyVWgwj8CkN339";

    public static Credentials getRandomCredentials() {
        String uuid = UUID.randomUUID().toString();
        return new Credentials(uuid + EMAIL_ENDING, uuid);
    }

    public static Credentials getRealCredentials() {
        return new Credentials(EMAIL, PASSWORD);
    }
}
