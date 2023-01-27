package org.selenide.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class BasePage {
    public SelenideElement find(String locator, String wild_card) {
        return $(byXpath(String.format(locator, wild_card)));
    }
}