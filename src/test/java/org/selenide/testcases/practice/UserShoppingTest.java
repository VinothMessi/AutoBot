package org.selenide.testcases.practice;

import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.data.JsonReader;
import one.util.streamex.StreamEx;
import org.selenide.enums.NavigationLinks;
import org.selenide.enums.PrimaryMenus;
import org.selenide.testcases.BaseTest;
import org.selenide.testdata.LoginDetails;
import org.selenide.testdata.RegistrationDetails;
import org.selenide.testdata.ShoppingDetails;
import org.testng.annotations.Test;

import java.util.List;

import static io.github.sskorol.data.TestDataReader.use;

public class UserShoppingTest extends BaseTest {
    @Test(dataProvider = "shopping_data")
    public void shop(ShoppingDetails shoppingDetails) {
        practiceApp
                .getHomePage().isThePageReady()
                .verify_primary_menus(List.of(PrimaryMenus.HOME.getValue(), PrimaryMenus.ABOUT.getValue(),
                        PrimaryMenus.SHOP.getValue(), PrimaryMenus.BLOG.getValue(), PrimaryMenus.CONTACT.getValue(),
                        PrimaryMenus.MYACCOUNT.getValue(), ""))
                .goTo_myAccount();

        practiceApp.getHomePage()
                .getMyAccountPage().isThePageReady();

        practiceApp.getHomePage().getMyAccountPage()
                .getLoginPage().isThePageReady()
                .user_login_as(shoppingDetails.getUsername(), shoppingDetails.getPassword());

        practiceApp.getHomePage().getMyAccountPage().getLoginPage().getUserPage()
                .isThePageReady(List.of(NavigationLinks.DASHBOARD.getValue(), NavigationLinks.ORDERS.getValue(),
                        NavigationLinks.DOWNLOADS.getValue(), NavigationLinks.ADDRESSES.getValue(),
                        NavigationLinks.ACCOUNT_DETAILS.getValue(), NavigationLinks.LOGOUT.getValue()))
                .browse_products();

        practiceApp.getHomePage().getMyAccountPage().getLoginPage().getUserPage().getShopPage()
                .isThePageReady()
                .add_to_cart(shoppingDetails.getProduct())
                .view_cart();

        practiceApp.getHomePage().getMyAccountPage().getLoginPage().getUserPage().getShopPage().getShoppingCartPage()
                .isThePageReady()
                .verify(shoppingDetails.getProduct(), shoppingDetails.getPrice())
                .remove_product()
                .return_to_shop();

        practiceApp.getHomePage().getMyAccountPage().getLoginPage().getUserPage().getShopPage()
                .isThePageReady();

        practiceApp.getHomePage().goTo_myAccount();

        practiceApp.getHomePage().getMyAccountPage().getLoginPage().getUserPage()
                .isThePageReady(List.of(NavigationLinks.DASHBOARD.getValue(), NavigationLinks.ORDERS.getValue(),
                        NavigationLinks.DOWNLOADS.getValue(), NavigationLinks.ADDRESSES.getValue(),
                        NavigationLinks.ACCOUNT_DETAILS.getValue(), NavigationLinks.LOGOUT.getValue()))
                .log_out();

        practiceApp.getHomePage().getMyAccountPage()
                .getRegisterPage().isThePageReady();

        practiceApp
                .getHomePage().isThePageReady()
                .verify_primary_menus(List.of(PrimaryMenus.HOME.getValue(), PrimaryMenus.ABOUT.getValue(),
                        PrimaryMenus.SHOP.getValue(), PrimaryMenus.BLOG.getValue(), PrimaryMenus.CONTACT.getValue(),
                        PrimaryMenus.MYACCOUNT.getValue(), ""));
    }

    @DataSupplier
    public StreamEx<ShoppingDetails> shopping_data() {
        return use(JsonReader.class)
                .withTarget(ShoppingDetails.class)
                .withSource("testdata/shopping.json")
                .read();
    }
}