package com.epam.training.oleksandr_bogdanets.steps;

import com.epam.training.oleksandr_bogdanets.hooks.StockSearchHooks;
import com.epam.training.oleksandr_bogdanets.pages.MainPage;
import com.epam.training.oleksandr_bogdanets.pages.stockpage.StockPage;
import io.cucumber.java.en.*;

import static org.testng.Assert.assertEquals;

public class StockSearchSteps {

    private MainPage mainPage;
    private StockPage stockPage;

    @Given("user is on the main page")
    public void userIsOnTheMainPage() {
        mainPage = new MainPage(StockSearchHooks.driver);
    }

    @When("the user enters symbol {string} in the search bar and presses enter")
    public void theUserEntersSymbolInTheSearchBar(String symbol) {
        stockPage = mainPage.searchBySymbol(symbol);
    }

    @Then("The user should see the stock page with header {string}")
    public void theUserShouldSeeTheStockPageWithHeader(String stockName) {
        String actualTitle = stockPage.getStockName();
        assertEquals(actualTitle, stockName);
    }
}
