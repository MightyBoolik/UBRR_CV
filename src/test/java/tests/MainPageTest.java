package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

@Tag("web")
public class MainPageTest extends TestBase {

    @Test
    @DisplayName("Main page should be loaded")
    void PageLoadedTest() {
        open("");
        $(".horizont__title").shouldBe(visible);
    }

    @Test
    @DisplayName("Internet-bank")
    void InternetBankButtonTest() {
        open("");
        sleep(5000);
        $$("div.g-header_i .btn-internet-bank").find(text("Интернет-банк")).click();
        $("div.popup-2__inner").shouldBe(visible);
        $(byText("Google Play")).click();

    }

    @Test
    @DisplayName("Test support chat")
    void phoneButtonTest() {
        open("");
        $("div.g-main").shouldBe(visible);
        $("div.js-open-btn").click();
        $("div.js-close-btn").shouldBe(visible).click();

    }

}

