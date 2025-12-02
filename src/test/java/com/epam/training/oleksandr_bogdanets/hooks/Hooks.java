package com.epam.training.oleksandr_bogdanets.hooks;

import com.epam.training.oleksandr_bogdanets.driver.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        driver = WebDriverManager.getDriver(browser);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        WebDriverManager.quitDriver();
    }
}
