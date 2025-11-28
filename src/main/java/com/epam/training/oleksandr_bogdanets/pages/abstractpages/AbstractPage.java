package com.epam.training.oleksandr_bogdanets.pages.abstractpages;

import org.openqa.selenium.*;

public abstract class AbstractPage {

    protected WebDriver driver;

    protected abstract AbstractPage openPage();

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;

    }
}