package org.selenide.pages.practice.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;

public interface ShopPageElements {
    SelenideElement search_products = $("input[placeholder='Search products…']");
    SelenideElement search = $("button[value='Search']");
    SelenideElement add_to_cart = $(byTagAndText("button", "Add to cart"));
    SelenideElement message = $(".woocommerce-message");

    SelenideElement view_cart = $(byLinkText("View cart"));
}