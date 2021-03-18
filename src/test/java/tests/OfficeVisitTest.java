package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

@Tag("web")
public class OfficeVisitTest extends TestBase {

    @Test
    @DisplayName("Sign up for the office")
    void visitOfficeButtonTest() {
        Faker faker = new Faker();
        open("https://www.ubrr.ru/");
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
        sleep(3000);
        $x("//div[contains(text(),'11:00')]").click();
        $(".form__contacts-fullName").setValue("Кучаев Булат Салаватович").sendKeys(Keys.TAB);
        $(".form__contacts-phone").setValue(faker.phoneNumber().subscriberNumber(10)).shouldBe(visible);
        sleep(2000);
        $(".form__contacts-email").shouldBe(visible).setValue("test@mail.ru").pressEnter();
        $(byText("Записаться")).click();
        $("div.thanks-wrapper__container").shouldHave(text("Ждем вас в отделении банка"));
    }
}
