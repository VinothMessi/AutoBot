package org.selenide.pages.practice;

import org.selenide.pages.practice.elements.UserPageElements;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;

public class UserPage implements UserPageElements {
    public UserPage isThePageReady(List<String> links) {
        navigation_links.shouldHave(texts(links));
        return this;
    }

    public void log_out() {
        log_out.click();
    }
}