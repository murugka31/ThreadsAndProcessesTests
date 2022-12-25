package com.emurugova;

import com.codeborne.selenide.Configuration;
import com.emurugova.page.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.*;
import static com.emurugova.page.MainPage.*;

@ExtendWith(SimpleCallBack.class)
public class ParallelTest {

    private MainPage page = new MainPage();

    @ValueSource(strings = {
            "simbirSoft",
            "selenide",
            "qa",
            "allure"
    })
    @ParameterizedTest (name = "{0} test")
    void yandexSearchTest (String searchQuery, TestInfo testInfo) {
        Configuration.startMaximized = true;
        open(URL);
        page.doSearch(searchQuery).checkResults(searchQuery);
        System.out.println("Config for test: " + testInfo.getDisplayName() + " " + Configuration.startMaximized);
    }

    @DisplayName("JDI test")
    @Test
    void minimizedWindowTest(TestInfo testInfo){
        Configuration.startMaximized = false;
        open(URL);
        page.doSearch("JDI").checkResults("JDI");
        System.out.println("Config for test: " + testInfo.getDisplayName() + " " + Configuration.startMaximized);
    }
}
