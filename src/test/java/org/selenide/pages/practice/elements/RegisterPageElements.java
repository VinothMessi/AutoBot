package org.selenide.pages.practice.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;

public interface RegisterPageElements {
    SelenideElement heading = $(byTagAndText("h2", "Register"));
    SelenideElement username = $("#reg_username");
    SelenideElement email = $("#reg_email");
    SelenideElement password = $("#reg_password");
    SelenideElement register = $(byTagAndText("button", "Register"));
}