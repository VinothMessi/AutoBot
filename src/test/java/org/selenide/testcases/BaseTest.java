package org.selenide.testcases;

import org.selenide.pages.practice.PracticeApp;
import org.testng.annotations.BeforeTest;

import static org.assertj.core.api.Assertions.*;

public class BaseTest {
    protected PracticeApp practiceApp;

    @BeforeTest
    public void setUp() {
        practiceApp = new PracticeApp();
        assertThat(practiceApp
                .navigate()
                .page_title())
                .isEqualTo("Practice E-Commerce Site – Automation Bro");
    }
}