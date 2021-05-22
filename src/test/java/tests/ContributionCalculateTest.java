package tests;

import allureAnnotations.JiraIssue;
import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


@Tag("web")
public class ContributionCalculateTest extends TestBase {
    SliderTest slider = new SliderTest();
    Faker faker = new Faker();

    private String sliderLine = ".Slider__SliderBox-credit-calculator__dxxjdy-2",
            sliderPoint = ".Slider__Runner-credit-calculator__dxxjdy-5",
            creditTime = ".ListTerms__Box-credit-calculator__sc-18rkehz-1",
            creditButton = ".main-pic__btn-wrap .scroll-to-service",
            mobileFrame = ".top-block #step_1",
            inputNumber = "#OpenBkithreestepsForm_mobile",
            submitButton = "btn_submit_step_1",
            creditForm = "#tab-32910";


    @Test
    @JiraIssue("QC3-36")
    @DisplayName("Check income from contribution")
    void percentContTest() {
        step("Open main page", () -> {
            open("");
        });
        step("Scroll to credit calculator", () -> {
            $(creditForm).shouldHave(Condition.text("Рассчитайте свой кредит")).scrollTo();
        });
        step("Choose amount", () -> {
            $(sliderLine).shouldBe(visible);
            $(sliderPoint).hover();
            slider.slider();
        });
        step("Choose credit term", () -> {
            $(creditTime).shouldBe(visible);
            $(byText("5 лет")).click();
        });
        step("Credit order button click", () -> {
            $(creditButton).click();
        });
        step("Input phone number", () -> {
            switchTo().window(1);
            $(mobileFrame).shouldHave(text("Для получения кредита введите номер телефона"));
            $(inputNumber).val(faker.phoneNumber().subscriberNumber(10));
        });
        step("Click submit button", () -> {
            $(byName(submitButton)).click();
        });

    }
}
