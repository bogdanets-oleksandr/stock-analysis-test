package com.epam.training.oleksandr_bogdanets;

import com.epam.training.oleksandr_bogdanets.config.PropertiesConfiguration;
import com.epam.training.oleksandr_bogdanets.driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class CommonConditions {

    protected WebDriver driver;

    @BeforeClass
    @Parameters({"env"})
    public void setUp(String env) {
        driver = WebDriverFactory.getDriver();
        driver.manage().window().maximize();
        PropertiesConfiguration.loadPropertiesForEnv(env);
    }

    @AfterClass
    public void stopBrowser() { WebDriverFactory.quitDriver(); }
}
