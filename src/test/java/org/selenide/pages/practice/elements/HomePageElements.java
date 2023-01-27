package org.selenide.pages.practice.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public interface HomePageElements {
    ElementsCollection primary_menus = $$("#primary-menu li");
    SelenideElement logo = $(".custom-logo-link");
    String menu = "//ul[@id='primary-menu']/descendant::a[text()='%s']";
}