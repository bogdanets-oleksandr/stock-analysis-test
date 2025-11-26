package com.epam.training.oleksandr_bogdanets.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WatchListPage extends AbstractPage {
    private static final Logger logger = LogManager.getRootLogger();

    private final static String PAGE_URL = "https://stockanalysis.com/watchlist/";

    private final Wait<WebDriver> wait;

    @FindBy(name = "left")
    private WebElement stockSymbolsColumn;

    @FindBy(xpath = "//button[normalize-space(.)='Edit']")
    private WebElement editButton;

    @FindBy(xpath = "//button[contains(@title, 'Delete')]")
    private WebElement deleteButton;

    @FindBy(css = "div.ag-selection-checkbox div[data-ref='eCheckbox']")
    private WebElement firstRowCheckbox;

    public WatchListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> stockSymbolsColumn.isDisplayed());
    }

    @Override
    protected WatchListPage openPage() {
        return this;
    }

    public void removeFirstStock() throws InterruptedException {
        logger.info("Watchlist page: Removing first Stock");
        editButton.click();
        wait.until(d -> firstRowCheckbox.isDisplayed());
        firstRowCheckbox.click();
        wait.until(d -> deleteButton.isDisplayed());
        deleteButton.click();
    }

    public boolean containsStockBySymbol(String symbol) {
        wait.until(d -> stockSymbolsColumn.isDisplayed());
        return stockSymbolsColumn.getText().contains(symbol);
    }
}
