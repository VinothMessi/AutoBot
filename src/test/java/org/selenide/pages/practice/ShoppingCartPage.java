package org.selenide.pages.practice;

import org.selenide.pages.BasePage;
import org.selenide.pages.practice.elements.ShoppingCartPageElements;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingCartPage extends BasePage implements ShoppingCartPageElements {
    public ShoppingCartPage isThePageReady() {
        select_file.shouldBe(visible).shouldBe(enabled);
        upload_file.shouldBe(visible);
        apply_coupon.shouldBe(visible).shouldBe(enabled);
        checkout.shouldBe(visible).shouldBe(enabled);
        return this;
    }

    public ShoppingCartPage verify(String product, String price) {
        assertThat(product_name.getText()).isEqualTo(product);
        assertThat(product_price.getText()).isEqualTo(price);
        return this;
    }

    public ShoppingCartPage remove_product() {
        remove.shouldBe(visible).shouldBe(enabled);
        remove.click();
        cart_empty.shouldBe(visible);
        return this;
    }

    public void return_to_shop() {
        return_to_shop.shouldBe(visible).shouldBe(enabled);
        return_to_shop.click();
    }
}