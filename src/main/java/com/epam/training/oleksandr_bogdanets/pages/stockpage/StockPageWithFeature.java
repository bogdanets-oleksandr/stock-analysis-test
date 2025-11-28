package com.epam.training.oleksandr_bogdanets.pages.stockpage;

import com.epam.training.oleksandr_bogdanets.pages.abstractpages.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class StockPageWithFeature extends AbstractPage implements Feature, StockPage {

    protected StockPageWithFeature(WebDriver driver) {
        super(driver);
    }
}
