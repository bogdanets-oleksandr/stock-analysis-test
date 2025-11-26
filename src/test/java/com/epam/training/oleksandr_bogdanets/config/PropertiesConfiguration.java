package com.epam.training.oleksandr_bogdanets.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesConfiguration {
    private static final Logger logger = LogManager.getRootLogger();
    private static final String PATH_TEMPLATE = "src/test/resources/%s.properties";
    public static String ENV;

    private static final Properties properties = new Properties();

    public static void loadPropertiesForEnv(String env) {
        ENV = env;
        try {
            properties.load(new FileInputStream(PATH_TEMPLATE.formatted(env)));
        } catch (IOException e) {
            logger.error("Cant find properties file for {}", env);
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String property) {
        return properties.getProperty(property);
    }
}
