package com.epam.training.oleksandr_bogdanets.listeners;

import com.epam.reportportal.listeners.LogLevel;
import com.epam.reportportal.service.ReportPortal;
import com.epam.training.oleksandr_bogdanets.config.PropertiesConfiguration;
import com.epam.training.oleksandr_bogdanets.driver.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotTaker implements ITestListener {
    private static final Logger logger = LogManager.getRootLogger();
    private static final String PATH_TEMPLATE = "screenshots/%s/%s_%s.png";

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = WebDriverManager.getDriver();
        try {
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String path = PATH_TEMPLATE.formatted(PropertiesConfiguration.ENV, result.getName(), timestamp);
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(src.toPath(), Paths.get(path));
            logger.info("Test: {} failed. Screenshot was saved at: {}", result.getName(), path);
            ReportPortal.emitLog("Failted test screenshot", LogLevel.INFO.name(), new Date(), src);
        } catch (Exception e) {
            logger.warn("Test: {} failed. Screenshot couldn't be saved.", result.getName());
            logger.error(e);
        }
    }
}
