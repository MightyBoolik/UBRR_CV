package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.Keys.ARROW_RIGHT;

@Tag("web")
public class ContributionCalculateTest extends TestBase {

    @Test
    @DisplayName("Check income from contribution")
    void percentContTest() {
        open("");
        $("#tab-32910").shouldHave(Condition.text("Рассчитайте свой кредит")).scrollTo();
        $(".Slider__SliderBox-credit-calculator__dxxjdy-2").shouldBe(visible);
        $(".Slider__Runner-credit-calculator__dxxjdy-5").hover().val("2000000");

        //$x("//*[@class='Slider__Runner-credit-calculator__dxxjdy-5']").
        //$x("//button[contains(.,'1')]").scrollTo().click()"| //button[contains(.,'Отправить')]").scrollTo().click();
    }
}
