package org.selenide.pages.practice;

import com.codeborne.selenide.Selenide;
import lombok.Data;
import org.selenide.pages.practice.elements.RegisterPageElements;

import static com.codeborne.selenide.Condition.*;

@Data
public class RegisterPage implements RegisterPageElements {
    private UserPage userPage;

    public RegisterPage() {
        setUserPage(Selenide.page(UserPage.class));
    }

    public RegisterPage isThePageReady() {
        heading.shouldBe(visible);
        username.shouldBe(visible).shouldBe(enabled);
        email.shouldBe(visible).shouldBe(enabled);
        password.shouldBe(visible).shouldBe(enabled);
        register.shouldBe(visible).shouldBe(enabled);
        return this;
    }

    public void register_user(String userName, String mailID, String passWord) {
        username.setValue(userName);
        email.setValue(mailID);
        password.setValue(passWord);
        register.click();
    }
}