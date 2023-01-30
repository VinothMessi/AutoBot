package org.selenide.pages.practice;

import com.codeborne.selenide.*;
import lombok.Data;
import org.selenide.pages.practice.elements.UserPageElements;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;

@Data
public class UserPage implements UserPageElements {
    private ShopPage shopPage;

    public UserPage() {
        setShopPage(Selenide.page(ShopPage.class));
    }

    public UserPage isThePageReady(List<String> links) {
        navigation_links.shouldHave(texts(links));
        return this;
    }

    public void browse_products() {
        orders.shouldBe(visible).shouldBe(enabled).click();
        browse.shouldBe(visible).shouldBe(enabled).click();
    }

    public void log_out() {
        log_out.click();
    }
}