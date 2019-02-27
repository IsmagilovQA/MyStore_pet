import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.close;

public class TestBase {


    @BeforeAll
    public static void setup() {
        Configuration.baseUrl = "http://automationpractice.com/index.php";
        Configuration.browser = "chrome";
        Configuration.fastSetValue = true;
        Configuration.headless = true;
        Configuration.screenshots = false;

        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(true));

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "%1$tT %4$s %5$s%6$s%n"); // for pretty logging in console

        //open("/");
        //new Login().login(rb_cred.getString("email"), rb_cred.getString("password"));
    }

    @AfterAll
    public static void tearDown() {
        //Configuration.holdBrowserOpen = false;
        SelenideLogger.removeListener("AllureSelenide");
        //WebDriverRunner.clearBrowserCache();
        //clearBrowserCookies();
        close();

    }

}
