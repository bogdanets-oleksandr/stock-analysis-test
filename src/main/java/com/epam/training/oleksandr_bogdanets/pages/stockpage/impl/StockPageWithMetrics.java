package com.epam.training.oleksandr_bogdanets.pages.stockpage.impl;

import com.epam.training.oleksandr_bogdanets.pages.WatchListPage;
import com.epam.training.oleksandr_bogdanets.pages.stockpage.Feature;
import com.epam.training.oleksandr_bogdanets.pages.stockpage.StockPageWithFeature;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StockPageWithMetrics extends StockPageWithFeature implements Feature {

    @FindBy(xpath = "//a[@data-title='Metrics']")
    private WebElement metricsButton;

    private StockPageImpl stockPageImpl;

    public StockPageWithMetrics(WebDriver driver, StockPageImpl stockPageImpl) {
        super(driver);
        this.stockPageImpl = stockPageImpl;
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
        return stockPageImpl.getStockName();
    }

    @Override
    public WatchListPage clickWatchlistButton() {
        return stockPageImpl.clickWatchlistButton();
    }
}
