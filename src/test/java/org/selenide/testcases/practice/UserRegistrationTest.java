package org.selenide.testcases.practice;

import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.data.JsonReader;
import one.util.streamex.StreamEx;
import org.selenide.enums.NavigationLinks;
import org.selenide.enums.PrimaryMenus;
import org.selenide.testcases.BaseTest;
import org.selenide.testdata.RegistrationDetails;
import org.testng.annotations.Test;

import java.util.List;

import static io.github.sskorol.data.TestDataReader.use;

public class UserRegistrationTest extends BaseTest {
    @Test(dataProvider = "registration_data")
    public void user_registration(RegistrationDetails registrationDetails) {
        practiceApp
                .getHomePage().isThePageReady()
                .verify_primary_menus(List.of(PrimaryMenus.HOME.getValue(), PrimaryMenus.ABOUT.getValue(),
                        PrimaryMenus.SHOP.getValue(), PrimaryMenus.BLOG.getValue(), PrimaryMenus.CONTACT.getValue(),
                        PrimaryMenus.MYACCOUNT.getValue(), ""))
                .goTo_myAccount();

        practiceApp.getHomePage()
                .getMyAccountPage().isThePageReady();

        practiceApp.getHomePage().getMyAccountPage()
                .getRegisterPage().isThePageReady()
                .register_user(registrationDetails.getUsername(), registrationDetails.getEmail(), registrationDetails.getPassword());

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
    public StreamEx<RegistrationDetails> registration_data() {
        return use(JsonReader.class)
                .withTarget(RegistrationDetails.class)
                .withSource("testdata/register.json")
                .read();
    }
}