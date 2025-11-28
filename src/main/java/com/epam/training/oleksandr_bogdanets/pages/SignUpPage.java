package com.epam.training.oleksandr_bogdanets.pages;

import com.epam.training.oleksandr_bogdanets.model.User;
import com.epam.training.oleksandr_bogdanets.pages.abstractpages.AbstractPageWithConsentPopUp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage extends AbstractPageWithConsentPopUp {
    private static final Logger logger = LogManager.getRootLogger();

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
        logger.info("Opening SignUp page");
        driver.navigate().to(PAGE_URL);
        consentToPersonalDataUse();
        return this;
    }

    public SignUpPage signUpWithEmail(User user) {
        logger.info("Sign up Page: Signing up with email {} and password {}", user.email(), user.password());
        continueWithEmailButton.click();
        wait.until(d -> emailInput.isDisplayed());
        emailInput.sendKeys(user.email());
        wait.until(d -> passwordInput.isDisplayed());
        passwordInput.sendKeys(user.password());
        createAccountButton.click();
        return this;
    }

    public boolean isSignUpSuccessful() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        return successMessage.isDisplayed();
    }
}
