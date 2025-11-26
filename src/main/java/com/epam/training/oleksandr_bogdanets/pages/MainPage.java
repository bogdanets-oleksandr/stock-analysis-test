package com.epam.training.oleksandr_bogdanets.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {
    private static final Logger logger = LogManager.getRootLogger();
    private final static String PAGE_URL = "https://stockanalysis.com/";

    @FindBy(id = "search-header")
    private WebElement searchBar;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public MainPage openPage() {
        logger.info("Opening Main page");
        driver.navigate().to(PAGE_URL);
        consentToPersonalDataUse();
        return this;
    }

    public StockPage searchBySymbol(String symbol) {
        logger.info("Main Page: Searching by symbol {}", symbol);
        searchBar.sendKeys(symbol, Keys.RETURN);
        return new StockPage(driver);
    }
}
