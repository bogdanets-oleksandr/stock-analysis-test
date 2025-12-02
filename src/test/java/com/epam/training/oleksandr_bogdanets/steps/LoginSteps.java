package com.epam.training.oleksandr_bogdanets.steps;

import com.epam.training.oleksandr_bogdanets.hooks.Hooks;
import com.epam.training.oleksandr_bogdanets.model.User;
import com.epam.training.oleksandr_bogdanets.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertTrue;

public class LoginSteps {
    
    private LoginPage loginPage;

    @Given("user opens login page")
    public void userOpensLoginsPage() {
        loginPage = new LoginPage(Hooks.driver);
        loginPage.openPage();
    }

    @When("^user enters email ([A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}) and password (.+)$")
    public void userEntersEmailAndPassword(String email, String password) {
        User user = new User(email, password);
        loginPage.login(user);
    }

    @Then("user is successfully logged in")
    public void userIsSuccessfullyLoggedIn() {
        assertTrue(loginPage.isLoginSuccessful());
    }
}
