import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.remote.DesiredCapabilities;
import widgets.Menu;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

@Execution(ExecutionMode.CONCURRENT)
public class SelenoidTest {

    @BeforeAll
    public static void setup() {

        // Selenoid conficurations
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVideo", false);
        capabilities.setCapability("enableVNC", true);
        Configuration.browserCapabilities = capabilities;
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "72.0";
        Configuration.browserSize = "1280x1024";
    }

    @Test
    public void testSelenoid_1() {
        open("/");
        Menu goTo = page(Menu.class);
        goTo.openCasualDresses();
        $(".cat-name").shouldHave(exactText("Casual Dresses"));
    }

    @Test
    public void testSelenoid_2() {
        open("/");
        Menu goTo = page(Menu.class);
        goTo.openCasualDresses();
        $(".cat-name").shouldHave(exactText("Casual Dresses"));
    }

    @Test
    public void testSelenoid_3() {
        open("https://google.com");
    }
}
