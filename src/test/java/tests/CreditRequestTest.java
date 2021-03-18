package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CreditRequestTest {
    @Test
    void requestForCredit(){
        open("https://www.ubrr.ru/");
        $(".menu_level_1 break-word list-reset").shouldHave(text("Кредиты")).click();
        //$(byText("Кредиты")).click();
        $(".submenu-col").shouldHave(text("Все кредиты"));
        $(byText("Подобрать кредит")).click();

    }
}
