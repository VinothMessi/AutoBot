package org.selenide.pages.practice;

import com.codeborne.selenide.Selenide;
import lombok.Data;
import org.selenide.pages.practice.elements.LoginPageElements;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

@Data
public class LoginPage implements LoginPageElements {
    private UserPage userPage;

    public LoginPage() {
        setUserPage(Selenide.page(UserPage.class));
    }

    public LoginPage isThePageReady() {
        heading.shouldBe(visible);
        username.shouldBe(visible).shouldBe(enabled);
        password.shouldBe(visible).shouldBe(enabled);
        login.shouldBe(visible).shouldBe(enabled);
        lost_password.shouldBe(visible).shouldBe(enabled);
        return this;
    }

    public void user_login_as(String userName, String passWord) {
        username.setValue(userName);
        password.setValue(passWord);
        login.click();
    }
}