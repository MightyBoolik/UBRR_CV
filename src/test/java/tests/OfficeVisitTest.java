package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("web")
public class OfficeVisitTest extends TestBase {

    @Test
    @DisplayName("Sign up for the office")
    void visitOfficeButtonTest() {
        Faker faker = new Faker();
        step("Open main page", () -> {
            open("");
        });
        step("Click sign for office button", () -> {
            //$(".credit-table__wrap").shouldBe(visible).shouldHave(text("Записаться в офис")).click();
            $x("//a[contains(.,'Записаться в офис')]").shouldBe(visible).click();
        });

        switchTo().window(1);
        step("Header should be visible", () -> {
            $x("//div[@class='header__title']").shouldBe(visible);
        });
        step("Choose your city", () -> {
            $(".select-city__city").click();
            $(".choice-city-modal__search-input").setValue("Уфа");
            $(byText("Уфа")).click();
        });
        step("Choose nearest office", () -> {
            $(".choice-office__enabled").shouldBe(visible).click();
            $("div.choice-office-modal__select-container").find(byText("Уфа г., Менделеева ул, д. 137")).click();
            $(byText("OK")).click();
        });
        step("Set visit date", () -> {
            $(".form__select-wrappers").click();
            $(byText("Другое")).shouldBe(visible).click();
            $(".form__select-day").setValue("13.06.2021").pressEnter();

        });
        sleep(3000);
        step("Set visit time", () -> {
            $(".time-piker-wrapper__input").click();
            $x("//div[contains(text(),'16:00')]").click();
        });
        step("Full name input", () -> {
            $(".form__contacts-fullName").setValue("Кучаев Булат Салаватович").sendKeys(Keys.TAB);
        });

        step("Birthday info input", () -> {
            $(".form__birthday").setValue("12.04.1994").sendKeys(Keys.TAB);
        });

        step("Phone number input", () -> {
            $(".form__contacts-phone").setValue("8800555353").
        });

        sleep(2000);
        step("Email input", () -> {
            $(".form__contacts-email").shouldBe(visible).setValue("test@mail.ru").pressEnter();
        });
        step("Check visit`s registration", () -> {
            $(byText("Записаться")).click();
            $("div.thanks-wrapper__container").shouldHave(text("Ждем вас в отделении банка"));
        });

    }
}
