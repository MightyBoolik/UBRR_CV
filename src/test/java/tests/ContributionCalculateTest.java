package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;
public class ContributionCalculateTest {
    @Test
    @DisplayName("Check income from contribution")
    void percentContTest(){
        open("https://www.ubrr.ru/");

    }
}
