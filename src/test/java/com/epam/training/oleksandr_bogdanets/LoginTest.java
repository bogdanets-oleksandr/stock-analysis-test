package com.epam.training.oleksandr_bogdanets;

import com.epam.training.oleksandr_bogdanets.model.Credentials;
import com.epam.training.oleksandr_bogdanets.pages.LoginPage;
import com.epam.training.oleksandr_bogdanets.util.Utils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends CommonConditions {

    private LoginPage loginPage;

    @BeforeMethod
    public void setUpPage() {
        loginPage = new LoginPage(driver);
        loginPage.openPage();
    }

    @Test
    public void shouldLogin() {
        Credentials realCredentials = Utils.getRealCredentials();
        loginPage.login(realCredentials);
        assertTrue(loginPage.isLoginSuccessful());
    }
}
