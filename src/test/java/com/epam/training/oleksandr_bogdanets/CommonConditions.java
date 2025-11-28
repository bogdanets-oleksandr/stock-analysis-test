package com.epam.training.oleksandr_bogdanets;

import com.epam.training.oleksandr_bogdanets.config.PropertiesConfiguration;
import com.epam.training.oleksandr_bogdanets.driver.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class CommonConditions {

    protected WebDriver driver;

    @BeforeClass
    @Parameters({"browser", "env"})
    public void setUp(String browser, String env) {
        driver = WebDriverManager.getDriver(browser);
        driver.manage().window().maximize();
        PropertiesConfiguration.loadPropertiesForEnv(env);
    }

    @AfterClass
    public void stopBrowser() { WebDriverManager.quitDriver(); }
}
