package com.epam.training.oleksandr_bogdanets.hooks;

import com.epam.training.oleksandr_bogdanets.driver.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class StockSearchHooks {

    public static WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverManager.getDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        WebDriverManager.quitDriver();
    }
}
