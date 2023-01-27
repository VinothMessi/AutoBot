package org.selenide.testcases.practice;

import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.data.JsonReader;
import one.util.streamex.StreamEx;
import org.selenide.enums.NavigationLinks;
import org.selenide.enums.PrimaryMenus;
import org.selenide.testcases.BaseTest;
import org.selenide.testdata.LoginDetails;
import org.testng.annotations.Test;

import java.util.List;

import static io.github.sskorol.data.TestDataReader.use;

public class UserLoginTest extends BaseTest {
    @Test(dataProvider = "login_data")
    public void user_login(LoginDetails loginDetails) {
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
                .user_login_as(loginDetails.getUsername(), loginDetails.getPassword());

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
    public StreamEx<LoginDetails> login_data() {
        return use(JsonReader.class)
                .withTarget(LoginDetails.class)
                .withSource("testdata/login.json")
                .read();
    }
}