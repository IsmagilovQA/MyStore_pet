import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import services.Highlighter;
import widgets.Menu;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.addListener;

import com.automation.remarks.junit5.Video;

public class Tests {

    @BeforeAll
    public static void setUp() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(true));

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "%1$tT %4$s %5$s%6$s%n"); // for pretty logging in console

        addListener(new Highlighter()); // UI highlighting while running tests
    }

    @AfterAll
    public static void tearDown() {
        SelenideLogger.removeListener("AllureSelenide");
        //WebDriverRunner.clearBrowserCache();
        //clearBrowserCookies();
        //close();
    }


    @Test
    //@Video
    @Tag("fast")
    @Severity(SeverityLevel.NORMAL)
    @Description("Allure description")
    public void first_test() {
        open("/");
        Menu goTo = page(Menu.class);
        goTo.openCasualDresses();
        $(".cat-name").shouldHave(exactText("Casual Dresses"));
    }
}

// webhook test
