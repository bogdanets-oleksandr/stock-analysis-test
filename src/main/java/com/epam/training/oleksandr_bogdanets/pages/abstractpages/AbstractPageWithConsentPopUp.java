package com.epam.training.oleksandr_bogdanets.pages.abstractpages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractPageWithConsentPopUp extends AbstractPage {

    private final By consentButtonBy = By.className("fc-primary-button");

    protected AbstractPageWithConsentPopUp(WebDriver driver) {
        super(driver);
    }

    protected void consentToPersonalDataUse() {
        try {
            WebElement consentButton = driver.findElement(consentButtonBy);
            consentButton.click();
        } catch (NoSuchElementException _) {

        }
    }
}
