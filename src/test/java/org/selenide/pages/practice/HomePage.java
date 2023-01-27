package org.selenide.pages.practice;

import com.codeborne.selenide.Selenide;
import lombok.Data;
import org.selenide.pages.BasePage;
import org.selenide.pages.practice.elements.HomePageElements;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;

@Data
public class HomePage extends BasePage implements HomePageElements {
    private MyAccountPage myAccountPage;

    public HomePage() {
        setMyAccountPage(Selenide.page(MyAccountPage.class));
    }

    public HomePage isThePageReady() {
        logo.shouldBe(visible).shouldBe(enabled);
        return this;
    }

    public HomePage verify_primary_menus(List<String> menus) {
        primary_menus.shouldHave(texts(menus));
        return this;
    }

    public void goTo_myAccount() {
        find(menu, "My account").click();
    }
}