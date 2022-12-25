package com.emurugova.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    public static final String URL = "https://ya.ru/";

    private SelenideElement searchInput = $("#text");
    private SelenideElement searchButton = $("button[type='submit']");

    public ResultsPage doSearch (String searchQuery) {
        searchInput.setValue(searchQuery);
        searchButton.click();
        return new ResultsPage();
    }
}
