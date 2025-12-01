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

    public static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver != null) return driver;
        String browser = System.getProperty("browser", "chrome");
        logger.info("Setting up a new driver for {}", browser);
        driver = switch (browser.toLowerCase()) {
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
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                yield new ChromeDriver();
            }
            default -> {
                logger.error("Trying to set up a driver for unknown browser: {}", browser);
                throw new IllegalArgumentException();
            }
        };
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

