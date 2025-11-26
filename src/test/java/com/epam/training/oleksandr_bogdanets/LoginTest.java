package com.epam.training.oleksandr_bogdanets;

import com.epam.training.oleksandr_bogdanets.model.User;
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
        User realUser = Utils.getRealCredentials();
        loginPage.login(realUser);
        assertTrue(loginPage.isLoginSuccessful());
    }
}
