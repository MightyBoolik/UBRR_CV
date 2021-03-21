package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

@Tag("web")
public class CreditRequestTest extends TestBase {
    @Test
    void requestForCredit() {
        open("");
        $("div.head_bottom div.menu-drop-7").shouldBe(visible);
        $$(".head_bottom .break-word").find(text("Вклады")).click();



    }
}
