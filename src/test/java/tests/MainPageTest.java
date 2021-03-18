package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Tag("web")
public class MainPageTest extends TestBase {

    @Test
    @DisplayName("Main page should be loaded")
    void PageLoadedTest() {
        open("https://www.ubrr.ru/");
        $(".horizont__title").shouldBe(visible);
    }

    @Test
    @DisplayName("Check my country")
    void setGeoLocationTest() {
        open("https://www.ubrr.ru/");
        $("div.city-head").click();
        sleep(5000);
        $(".city__info").shouldBe(visible);
    }


    @Test
    @DisplayName("Sign up for the office")
    void visitOfficeButtonTest() {
        open("https://www.ubrr.ru/");
        //$$x("//a[@class='btn btn-index']").first().click();
        $x("//a[contains(.,'Записаться в офис')]").shouldBe(visible).click();
        switchTo().window(1);
        $x("//div[@class='header__title']").shouldBe(visible);
        $(".select-city__city").click();
        $(".choice-city-modal__search-input").setValue("Уфа");
        $(byText("Уфа")).click();
        $(".choice-office__enabled").shouldBe(visible).click();
        $("div.choice-office-modal__select-container").find(byText("Уфа г., Менделеева ул, д. 137")).click();
        $(byText("OK")).click();
        $(".form__select-wrappers").click();
        $(byText("Другое")).shouldBe(visible).click();
        $(".form__select-day").setValue("12.04.2021").pressEnter();
        $(".time-piker-wrapper__input").click();
        sleep(5000);
        $(byText("10:00")).shouldBe(visible).click();
        //int x = $$x("//div[@class='time-piker-popup']/div").first().shouldBe(visible).getLocation().getX();
        //int y = $$x("//div[@class='time-piker-popup']/div").first().shouldBe(visible).getLocation().getY();
        //actions().moveByOffset(x,y).click().build().perform();
        //$$x("//div[@class='time-piker-popup']/div").first().click();
        //$(".time-piker-popup").findElement(byText("10:00")).click();
        $(".form__contacts-fullName").setValue("Кучаев Булат Салаватович").pressEnter();
        $("div.react-dadata__suggestions").shouldBe(visible).click();
        $(".form__contacts-phone").setValue("9175553535").shouldBe(visible);
        $(".form__contacts-email").shouldBe(visible).setValue("test@mail.ru").pressEnter();
        $(byText("Записаться")).click();
        $("div.time-wrapper").shouldHave(text("Не удалось записать на это время"));


    }

    @Test
    @DisplayName("Test support chat")
    void phoneButtonTest() {
        open("https://www.ubrr.ru/");
        $("div.g-main").shouldBe(visible);
        $("div.js-open-btn").click();
        $("div.js-close-btn").shouldBe(visible).click();

    }

}
