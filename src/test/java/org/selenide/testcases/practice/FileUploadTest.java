package org.selenide.testcases.practice;

import com.codeborne.selenide.SelenideElement;
import com.google.common.util.concurrent.Uninterruptibles;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class FileUploadTest {
    @Test
    public void file_upload_1() {
        open("https://the-internet.herokuapp.com/upload");

        SelenideElement heading = $(byTagAndText("h3", "File Uploader"));
        SelenideElement sub_heading = $(byTagAndText("p", "Choose a file on your system and then click upload. " +
                "Or, drag and drop a file into the area below."));

        SelenideElement choose_file = $("#file-upload");
        SelenideElement upload_file = $("#file-submit");

        heading.shouldBe(visible);
        sub_heading.shouldBe(visible);
        choose_file.shouldBe(visible).shouldBe(enabled);
        upload_file.shouldBe(visible).shouldBe(enabled);

        choose_file.uploadFile(new File("C:\\vinoth\\projects\\AutoBot\\resources\\snap.png"));
        upload_file.click();

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));

        SelenideElement message = $(byTagName("h3"));
        message.shouldHave(text("File Uploaded!"));
    }

    @Test
    public void file_upload_2() {
        open("https://practice.automationbro.com/cart/");

        executeJavaScript("document.getElementById(\"upfile_1\").classList.remove(\"file_input_hidden\")");
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));

        $("#upfile_1").uploadFile(new File("C:\\vinoth\\projects\\AutoBot\\resources\\snap.png"));
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));

        $("#upload_1").click();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));

        $("#wfu_messageblock_header_1_label_1").shouldHave(text("uploaded successfully"));
    }
}