package com.epam.training.oleksandr_bogdanets.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class WebDriverManager {
    public static WebDriver driver;
    private static final Logger logger = LogManager.getRootLogger();

    public static WebDriver getDriver(String browser) {
        if (driver != null) return driver;
        driver = WebDriverFactory.setUpDriver(browser);
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        logger.info("Quitting driver");
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
