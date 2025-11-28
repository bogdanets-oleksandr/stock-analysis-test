package com.epam.training.oleksandr_bogdanets.pages;

import com.epam.training.oleksandr_bogdanets.model.User;
import com.epam.training.oleksandr_bogdanets.pages.abstractpages.AbstractPageWithConsentPopUp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage extends AbstractPageWithConsentPopUp {
    private static final Logger logger = LogManager.getRootLogger();

    private final static String PAGE_URL = "https://stockanalysis.com/login/";

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[normalize-space(text())='Log In']")
    private WebElement logInButton;

    @FindBy(xpath = "//*[text()='Search for a stock to start your analysis']")
    private WebElement mainPageTitle;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public LoginPage openPage() {
        logger.info("Opening Login page");
        driver.navigate().to(PAGE_URL);
        consentToPersonalDataUse();
        return this;
    }

    public MainPage login(User user) {
        logger.info("Login Page: Logging in with email {} and password {}", user.email(), user.password());
        emailInput.sendKeys(user.email());
        passwordInput.sendKeys(user.password());
        logInButton.click();
        return new MainPage(driver);
    }

    public boolean isLoginSuccessful() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        return mainPageTitle.isDisplayed();
    }
}
