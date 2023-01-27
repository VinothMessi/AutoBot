package org.selenide.pages.practice.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public interface UserPageElements {
    ElementsCollection navigation_links = $$(".woocommerce-MyAccount-navigation ul li");
    SelenideElement log_out = $(byLinkText("Logout"));
}