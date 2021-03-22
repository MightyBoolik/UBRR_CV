package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


@Tag("web")
public class ContributionCalculateTest extends TestBase {
    SliderTest slider = new SliderTest();
    @Test
    @DisplayName("Check income from contribution")
    void percentContTest() {
        open("");
        $("#tab-32910").shouldHave(Condition.text("Рассчитайте свой кредит")).scrollTo();
        $(".Slider__SliderBox-credit-calculator__dxxjdy-2").shouldBe(visible);
        $(".Slider__Runner-credit-calculator__dxxjdy-5").hover();
        slider.slider();

    }
}
