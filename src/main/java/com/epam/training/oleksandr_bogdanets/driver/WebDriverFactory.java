package com.epam.training.oleksandr_bogdanets.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {
    private static final Logger logger = LogManager.getRootLogger();

    public static final String DEFAULT_BROWSER = "chrome";
    public static WebDriver driver;

    public static WebDriver getDriver(String browser) {
        if (driver != null) return driver;
        logger.info("Setting up a new driver for {}", browser);
        return switch (browser.toLowerCase()) {
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                yield new EdgeDriver();
            }
            case "safari" -> {
                WebDriverManager.safaridriver().setup();
                yield new SafariDriver();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                yield new FirefoxDriver();
            }
            default -> {
                WebDriverManager.chromedriver().setup();
                yield new ChromeDriver();
            }
        };
    }

    public static WebDriver getDriver() {
        return getDriver(DEFAULT_BROWSER);
    }

    public static void quitDriver() {
        logger.info("Quitting driver");
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

