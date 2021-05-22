package tests;

import allureAnnotations.JiraIssue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("web")
public class OfficeVisitTest extends TestBase {
    private String signButton = "//a[contains(.,'Записаться в офис')]",
            header = "//div[@class='header__title']",
            selectCityButton = ".select-city__city",
            searchCity = ".choice-city-modal__search-input",
            city = "Уфа",
            selectOfficeButton = ".choice-office__enabled",
            cityList = "div.choice-office-modal__select-container",
            officeAddress = "Уфа г., Менделеева ул, д. 137",
            formService = ".form__select-wrappers",
            inputVisitDay = ".form__select-day",
            visitDate = "11.06.2021",
            inputVisitTime = ".time-piker-wrapper__input",
            visitTime = "//div[contains(text(),'16:00')]",
            fullNameInput = ".form__contacts-fullName",
            fullName = "Кучаев Булат Салаватович",
            birthdayInput = ".form__birthday",
            birthday = "12.04.1994",
            phonenumberInput = ".form__contacts-phone",
            phonenumber = "9177191209",
            emailInput = ".form__contacts-email",
            email = "test@mail.ru",
            finishRegistration = "div.thanks-wrapper__container";

    @Test
    @JiraIssue("QC3-36")
    @DisplayName("Sign up for the office")
    void visitOfficeButtonTest() {
        step("Open main page", () -> {
            open("");
        });
        step("Click sign for office button", () -> {
            $x(signButton).shouldBe(visible).click();
        });

        switchTo().window(1);
        step("Header should be visible", () -> {
            $x(header).shouldBe(visible);
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
        sleep(3000);
        step("Set visit time", () -> {
            $(inputVisitTime).click();
            $x(visitTime).click();
        });
        step("Full name input", () -> {
            $(fullNameInput).setValue(fullName).sendKeys(Keys.TAB);
        });

        step("Birthday info input", () -> {
            $(birthdayInput).setValue(birthday).sendKeys(Keys.TAB);
        });

        step("Phone number input", () -> {
            $(phonenumberInput).setValue(phonenumber);
        });

        sleep(2000);
        step("Email input", () -> {
            $(emailInput).shouldBe(visible).setValue(email).pressEnter();
        });
        step("Check visit`s registration", () -> {
            $(byText("Записаться")).click();
            $(finishRegistration).shouldHave(text("Ждем вас в отделении банка"));
        });

    }
}
