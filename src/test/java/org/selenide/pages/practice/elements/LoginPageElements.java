package org.selenide.pages.practice.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;

public interface LoginPageElements {
    SelenideElement heading = $(byTagAndText("h2", "Login"));
    SelenideElement username = $("#username");
    SelenideElement password = $("#password");
    SelenideElement login = $(byTagAndText("button", "Log in"));
    SelenideElement lost_password = $(byLinkText("Lost your password?"));
}