package com.epam.training.oleksandr_bogdanets.pages.stockpage;

import com.epam.training.oleksandr_bogdanets.pages.WatchListPage;

public interface StockPage {

    String getStockName();

    WatchListPage clickWatchlistButton();
}
