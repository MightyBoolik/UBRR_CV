package tests;

import allureAnnotations.JiraIssue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("web")
public class OfficeVisitTest extends TestBase {
    private String city = "Уфа",
            signButton = "Записаться в офис",
            officeAddress = "Уфа г., Менделеева ул, д. 137",
            visitDate = "09.06.2021",
            visitTime = "15:00",
            fullName = "Кучаев Булат Салаватович",
            birthday = "12.04.1994",
            phonenumber = "9177191209",
            email = "test@mail.ru";

    private String cookiePopUp = ".cookies__wrap .cookies__btn",
            header = ".header__title",
            selectCityButton = ".select-city__city",
            searchCity = ".choice-city-modal__search-input",
            selectOfficeButton = ".choice-office__enabled",
            cityList = ".choice-office-modal__select-container",
            formService = ".form__select-wrappers",
            inputVisitDay = ".form__select-day",
            inputVisitTime = ".time-piker-wrapper__input",
            fullNameInput = ".form__contacts-fullName",
            birthdayInput = ".form__birthday",
            emailInput = ".form__contacts-email",
            phonenumberInput = ".form__contacts-phone",
            finishRegistration = ".thanks-wrapper__container";

    @Test
    @JiraIssue("QC3-36")
    @DisplayName("Sign up for the office")
    void visitOfficeButtonTest() {
        step("Open main page", () -> {
            open("");
        });
        step("Click sign for office button", () -> {
            $(cookiePopUp).shouldBe(visible).click();
            $(byText(signButton)).click();
        });
        switchTo().window(1);
        step("Header should be visible", () -> {
            $(header).shouldBe(visible);
        });
        step("Choose your city", () -> {
            $(selectCityButton).click();
            $(searchCity).setValue(city);
            $(byText(city)).click();
        });
        step("Choose nearest office", () -> {
            $(selectOfficeButton).shouldBe(visible).click();
            $(cityList).find(byText(officeAddress)).click();
            $(byText("OK")).click();
        });
        step("Set visit date", () -> {
            $(formService).click();
            $(byText("Другое")).shouldBe(visible).click();
            $(inputVisitDay).setValue(visitDate).pressEnter();
        });
        step("Set visit time", () -> {
            $(inputVisitTime).shouldBe(enabled, Duration.ofSeconds(3)).click();
            $(withText(visitTime)).click();
        });
        step("Full name input", () -> {
            $(fullNameInput).setValue(fullName).pressTab();
        });
        step("Birthday info input", () -> {
            $(birthdayInput).setValue(birthday).pressTab();
        });
        step("Phone number input", () -> {
            $(phonenumberInput).setValue(phonenumber);
        });
        step("Email input", () -> {
            $(emailInput).shouldBe(visible).setValue(email).pressEnter();
        });
        step("Check visit`s registration", () -> {
            $(byText("Записаться")).click();
            $(finishRegistration).shouldHave(text("Ждем вас в отделении банка"));
        });
    }
}
