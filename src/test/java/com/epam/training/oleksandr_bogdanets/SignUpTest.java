package com.epam.training.oleksandr_bogdanets;

import com.epam.training.oleksandr_bogdanets.model.Credentials;
import com.epam.training.oleksandr_bogdanets.pages.SignUpPage;
import com.epam.training.oleksandr_bogdanets.util.Utils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SignUpTest extends CommonConditions {

    private SignUpPage signUpPage;

    @BeforeMethod
    public void setUpPage() {
        signUpPage = new SignUpPage(driver);
        signUpPage.openPage();
    }

    @Test
    public void shouldSignUp() {
        Credentials randomCredentials = Utils.getRandomCredentials();
        signUpPage.signUpWithEmail(randomCredentials);
        assertTrue(signUpPage.isSignUpSuccessful());
    }
}
