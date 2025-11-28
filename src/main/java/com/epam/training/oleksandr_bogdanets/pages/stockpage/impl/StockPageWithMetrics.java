package com.epam.training.oleksandr_bogdanets.pages.stockpage.impl;

import com.epam.training.oleksandr_bogdanets.pages.WatchListPage;
import com.epam.training.oleksandr_bogdanets.pages.stockpage.Feature;
import com.epam.training.oleksandr_bogdanets.pages.stockpage.StockPage;
import com.epam.training.oleksandr_bogdanets.pages.stockpage.StockPageWithFeature;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StockPageWithMetrics extends StockPageWithFeature implements Feature {

    @FindBy(xpath = "//a[@data-title='Metrics']")
    private WebElement metricsButton;

    private StockPage stockPage;

    public StockPageWithMetrics(WebDriver driver, StockPageImpl stockPage) {
        super(driver);
        this.stockPage = stockPage;
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public StockPageWithFeature openFeature() {
        metricsButton.click();
        return this;
    }

    @Override
    protected StockPageWithMetrics openPage() {
        return this;
    }

    @Override
    public String getStockName() {
        return stockPage.getStockName();
    }

    @Override
    public WatchListPage clickWatchlistButton() {
        return stockPage.clickWatchlistButton();
    }
}
