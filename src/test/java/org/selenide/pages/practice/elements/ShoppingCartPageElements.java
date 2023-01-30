package org.selenide.pages.practice.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public interface ShoppingCartPageElements {
    SelenideElement select_file = $("#uploadform_1");
    SelenideElement upload_file = $("#upload_1");
    SelenideElement apply_coupon = $(byTagAndText("button", "Apply coupon"));
    SelenideElement checkout = $(".checkout-button");
    SelenideElement product_name = $("td[data-title='Product'] a");
    SelenideElement product_price = $("td[data-title='Price'] span bdi");
    SelenideElement remove = $(".product-remove a.remove");
    SelenideElement cart_empty = $(byTagAndText("p", "Your cart is currently empty."));
    SelenideElement return_to_shop = $(".return-to-shop a");
}