package com.epam.training.oleksandr_bogdanets.pages.stockpage.impl;

import com.epam.training.oleksandr_bogdanets.pages.abstractpages.AbstractPage;
import com.epam.training.oleksandr_bogdanets.pages.WatchListPage;
import com.epam.training.oleksandr_bogdanets.pages.stockpage.StockPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StockPageImpl extends AbstractPage implements StockPage {
    private static final Logger logger = LogManager.getRootLogger();

    @FindBy(tagName = "h1")
    private WebElement stockNameHeader;

    @FindBy(xpath = "//button[contains(normalize-space(.), 'Watchlist')]")
    private WebElement watchListButton;

    public StockPageImpl(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> watchListButton.isDisplayed());
    }

    @Override
    protected StockPageImpl openPage() {
        return this;
    }

    @Override
    public String getStockName() {
        return stockNameHeader.getText();
    }

    @Override
    public WatchListPage clickWatchlistButton() {
        logger.info("Stock Page: Clicking watchlist button for {}", getStockName());
        watchListButton.click();
        return new WatchListPage(driver);
    }
}
