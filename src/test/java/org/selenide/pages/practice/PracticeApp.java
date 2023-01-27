package org.selenide.pages.practice;

import com.codeborne.selenide.Selenide;
import lombok.Data;

import static com.codeborne.selenide.Selenide.*;

@Data
public class PracticeApp {
    private HomePage homePage;

    public PracticeApp() {
        setHomePage(Selenide.page(HomePage.class));
    }

    public PracticeApp navigate() {
        open("/");
        return this;
    }

    public String page_title() {
        return title();
    }
}