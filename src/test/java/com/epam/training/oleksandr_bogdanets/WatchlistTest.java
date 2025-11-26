package com.epam.training.oleksandr_bogdanets;

import com.epam.training.oleksandr_bogdanets.model.User;
import com.epam.training.oleksandr_bogdanets.pages.LoginPage;
import com.epam.training.oleksandr_bogdanets.pages.MainPage;
import com.epam.training.oleksandr_bogdanets.pages.WatchListPage;
import com.epam.training.oleksandr_bogdanets.util.Utils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class WatchlistTest extends CommonConditions {

    private static final String APPLE_STOCK_SYMBOL = "AAPL";
    private MainPage mainPage;
    private WatchListPage watchListPage;

    @BeforeClass
    public void setUpPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        User user = Utils.getRealCredentials();
        mainPage = loginPage.login(user);
    }

    @Test
    public void shouldAddToWatchlist() {
       watchListPage = mainPage.searchBySymbol(APPLE_STOCK_SYMBOL)
            .clickWatchlistButton();
       assertTrue(watchListPage.containsStockBySymbol(APPLE_STOCK_SYMBOL));
    }

    @Test
    public void shouldRemoveFromWatchlist() throws InterruptedException {
        mainPage = new MainPage(driver).openPage();
        watchListPage = mainPage.searchBySymbol(APPLE_STOCK_SYMBOL)
            .clickWatchlistButton();

        watchListPage.removeFirstStock();
        assertFalse(watchListPage.containsStockBySymbol(APPLE_STOCK_SYMBOL));
    }
}
