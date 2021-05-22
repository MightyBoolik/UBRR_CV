package tests;

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
    @DisplayName("Check income from contribution")
    void percentContTest() {
        open("");
        $(creditForm).shouldHave(Condition.text("Рассчитайте свой кредит")).scrollTo();
        $(sliderLine).shouldBe(visible);
        $(sliderPoint).hover();
        slider.slider();
        $(creditTime).shouldBe(visible);
        $(byText("5 лет")).click();
        $(creditButton).click();
        switchTo().window(1);
        $(mobileFrame).shouldHave(text("Для получения кредита введите номер телефона"));
        $(inputNumber).val(faker.phoneNumber().subscriberNumber(10));
        $(byName(submitButton)).click();

    }
}
