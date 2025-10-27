package com.epam.training.oleksandr_bogdanets.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StockPage extends AbstractPage{

    @FindBy(tagName = "h1")
    private WebElement stockNameHeader;

    @FindBy(xpath = "//button[contains(normalize-space(.), 'Watchlist')]")
    private WebElement watchListButton;

    public StockPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> watchListButton.isDisplayed());
    }

    @Override
    protected StockPage openPage() {
        return this;
    }

    public String getStockName() {
        return stockNameHeader.getText();
    }

    public WatchListPage clickWatchlistButton() {
        watchListButton.click();
        return new WatchListPage(driver);
    }
}
