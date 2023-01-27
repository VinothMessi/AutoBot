package org.selenide.pages.practice.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public interface MyAccountPageElements {
    SelenideElement heading = $("h1");
    SelenideElement login_form = $(byXpath("//div[@class='u-column1 col-1']"));
    SelenideElement register_form = $(byXpath("//div[@class='u-column2 col-2']"));
}