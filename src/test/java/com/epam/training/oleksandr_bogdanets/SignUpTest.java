package com.epam.training.oleksandr_bogdanets;

import com.epam.training.oleksandr_bogdanets.model.User;
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
        User randomUser = Utils.getRandomCredentials();
        signUpPage.signUpWithEmail(randomUser);
        assertTrue(signUpPage.isSignUpSuccessful());
    }
}
