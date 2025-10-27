package com.epam.training.oleksandr_bogdanets.pages;

import org.openqa.selenium.*;

public abstract class AbstractPage {

    private final By consentButtonBy = By.className("fc-primary-button");
    protected WebDriver driver;

    protected abstract AbstractPage openPage();

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;

    }

    protected void consentToPersonalDataUse() {
        try {
            WebElement consentButton = driver.findElement(consentButtonBy);
            consentButton.click();
        } catch (NoSuchElementException _) {

        }
    }
}