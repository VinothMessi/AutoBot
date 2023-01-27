package org.selenide.pages.practice;

import com.codeborne.selenide.Selenide;
import lombok.Data;
import org.selenide.pages.practice.elements.MyAccountPageElements;

import static com.codeborne.selenide.Condition.*;

@Data
public class MyAccountPage implements MyAccountPageElements {
    private RegisterPage registerPage;
    private LoginPage loginPage;

    public MyAccountPage() {
        setRegisterPage(Selenide.page(RegisterPage.class));
        setLoginPage(Selenide.page(LoginPage.class));
    }

    public void isThePageReady() {
        heading.shouldHave(text("My account"));
        login_form.shouldBe(visible);
        register_form.shouldBe(visible);
    }
}