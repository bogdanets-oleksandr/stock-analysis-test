Feature: Stock search
  Background:
    Given user is on the main page
  Scenario Outline: Search stocks with their symbols
    When the user enters symbol "<symbol>" in the search bar and presses enter
    Then The user should see the stock page with header "<stockName>"

    Examples:
    | AAPL | Apple Inc. (AAPL)
    | GOOGL | Alphabet Inc. (GOOGL)
    | BMV:EPAM | EPAM Systems, Inc. (BMV:EPAM)