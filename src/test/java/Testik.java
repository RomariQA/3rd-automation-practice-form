import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.href;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Testik {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void name() {
        open("https://github.com/selenide/selenide/wiki/SoftAssertions");
        $(".markdown-heading").$("h4").shouldHave(text("1. Using TestNG just register listener bypass annotation for test class:"));
    }
}
