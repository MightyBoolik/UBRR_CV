package tests;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class SliderTest {
    public void slider() {
        SelenideElement slider = $(".Slider__SliderBox-credit-calculator__dxxjdy-2");
        int width = slider.getSize().getWidth();
        actions().dragAndDropBy(slider, ((width * 250) / 2000), 0).build().perform();
        System.out.println("Slider moved");
    }
}
