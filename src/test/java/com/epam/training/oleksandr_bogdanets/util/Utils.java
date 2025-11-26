package com.epam.training.oleksandr_bogdanets.util;

import com.epam.training.oleksandr_bogdanets.config.PropertiesConfiguration;
import com.epam.training.oleksandr_bogdanets.model.User;

import java.util.UUID;

public class Utils {

    private static final String EMAIL_ENDING = "@gmail.com";
    private static final String EMAIL_PROPERTY = "email";
    private static final String PASSWORD_PROPERTY = "password";

    public static User getRandomCredentials() {
        String uuid = UUID.randomUUID().toString();
        return new User(uuid + EMAIL_ENDING, uuid);
    }

    public static User getRealCredentials() {
        String email = PropertiesConfiguration.getProperty(EMAIL_PROPERTY);
        String password = PropertiesConfiguration.getProperty(PASSWORD_PROPERTY);
        return new User(email, password);
    }
}
