package tests;

import allureAnnotations.JiraIssue;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Tag("web")
public class MainPageTest extends TestBase {
    Faker faker = new Faker();

    private String bankButton = "div.g-header_i .btn-internet-bank",
            popup = "div.popup-2__inner",
            googleButtonText = "Google Play",
            mainPage = "div.g-main",
            callButton = "div.js-open-btn",
            callOrder = "Заказать звонок",
            inputNumber = "#call-api-form .js-form-tel";

    @Test
    @JiraIssue("QC3-36")
    @DisplayName("Main page should be loaded")
    void PageLoadedTest() {
        open("");
        $(".horizont__title").shouldBe(visible);
    }

    @Test
    @JiraIssue("QC3-36")
    @DisplayName("Internet-bank")
    void InternetBankButtonTest() {
        open("");
        sleep(5000);
        $$(bankButton).find(text("Интернет-банк")).click();
        $(popup).shouldBe(visible);
        $(byText(googleButtonText)).click();

    }

    @Test
    @JiraIssue("QC3-36")
    @DisplayName("Test support chat")
    void phoneButtonTest() {
        open("");
        $(mainPage).shouldBe(visible);
        $(callButton).click();
        $(byText(callOrder)).click();
        $(inputNumber).val(faker.phoneNumber().subscriberNumber(9)).click();

    }

}

