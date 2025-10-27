package com.epam.training.oleksandr_bogdanets.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {

    private final static String PAGE_URL = "https://stockanalysis.com/";

    @FindBy(id = "search-header")
    private WebElement searchBar;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public MainPage openPage() {
        driver.navigate().to(PAGE_URL);
        consentToPersonalDataUse();
        return this;
    }

    public StockPage searchBySymbol(String symbol) {
        searchBar.sendKeys(symbol, Keys.RETURN);
        return new StockPage(driver);
    }
}
