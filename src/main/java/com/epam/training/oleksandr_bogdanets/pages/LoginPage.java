package com.epam.training.oleksandr_bogdanets.pages;

import com.epam.training.oleksandr_bogdanets.model.Credentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage extends AbstractPage {

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
        driver.navigate().to(PAGE_URL);
        consentToPersonalDataUse();
        return this;
    }

    public MainPage login(Credentials credentials) {
        emailInput.sendKeys(credentials.email());
        passwordInput.sendKeys(credentials.password());
        logInButton.click();
        return new MainPage(driver);
    }

    public boolean isLoginSuccessful() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        return mainPageTitle.isDisplayed();
    }
}
