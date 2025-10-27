package com.epam.training.oleksandr_bogdanets.pages;

import com.epam.training.oleksandr_bogdanets.model.Credentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage extends AbstractPage {

    private final static String PAGE_URL = "https://stockanalysis.com/create-account/";

    private final Wait<WebDriver> wait;

    @FindBy(xpath = "//*[text() = 'Continue with email']")
    private WebElement continueWithEmailButton;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[text() = 'Create Free Account']")
    private WebElement createAccountButton;

    @FindBy(xpath = "//*[text()='Your free account was created successfully. Log in now.']")
    private WebElement successMessage;
    
    public SignUpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Override
    public SignUpPage openPage() {
        driver.navigate().to(PAGE_URL);
        consentToPersonalDataUse();
        return this;
    }

    public SignUpPage signUpWithEmail(Credentials credentials) {
        continueWithEmailButton.click();
        wait.until(d -> emailInput.isDisplayed());
        emailInput.sendKeys(credentials.email());
        wait.until(d -> passwordInput.isDisplayed());
        passwordInput.sendKeys(credentials.password());
        createAccountButton.click();
        return this;
    }

    public boolean isSignUpSuccessful() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        return successMessage.isDisplayed();
    }
}
