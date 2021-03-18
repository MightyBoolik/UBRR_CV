package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

@Tag("web")
public class CreditRequestTest extends TestBase {
    @Test
    void requestForCredit() {
        open("https://www.ubrr.ru/");
        $$("div.menu-drop-7 .menu_level_1").find(text("Кредиты")).shouldBe(visible).click();
        $$("ul li .menu_level_1 .item_1 has-submenu").findBy(text("Подобрать кредит")).click();

    }
}
