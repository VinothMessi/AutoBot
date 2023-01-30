package org.selenide.pages.practice;

import com.codeborne.selenide.Selenide;
import lombok.Data;
import org.selenide.pages.BasePage;
import org.selenide.pages.practice.elements.ShopPageElements;

import static com.codeborne.selenide.Condition.*;

@Data
public class ShopPage extends BasePage implements ShopPageElements {
    private ShoppingCartPage shoppingCartPage;

    public ShopPage() {
        setShoppingCartPage(Selenide.page(ShoppingCartPage.class));
    }

    public ShopPage isThePageReady() {
        search_products.shouldBe(visible).shouldBe(enabled);
        search.shouldBe(visible).shouldBe(enabled);
        return this;
    }

    public ShopPage add_to_cart(String product) {
        search_products.setValue(product);
        search.click();
        add_to_cart.shouldBe(visible).shouldBe(enabled);
        add_to_cart.click();
        return this;
    }

    public void view_cart() {
        message.shouldBe(visible);
        view_cart.shouldBe(visible).shouldBe(enabled);
        view_cart.click();
    }
}