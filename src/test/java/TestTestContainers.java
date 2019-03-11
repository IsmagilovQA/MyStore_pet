import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;
import widgets.Menu;

import java.io.File;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;
import static org.testcontainers.containers.BrowserWebDriverContainer.VncRecordingMode.RECORD_FAILING;

public class TestTestContainers {

    public static BrowserWebDriverContainer chrome = new BrowserWebDriverContainer()
            .withCapabilities(new ChromeOptions())
            .withRecordingMode(RECORD_FAILING, new File("./target/"));


    @BeforeAll
    public static void setUp() {
        chrome.start();
        RemoteWebDriver driver = chrome.getWebDriver();
        WebDriverRunner.setWebDriver(driver);
    }

    @Test
    public void test() throws InterruptedException {
        open("/");
        Menu goTo = page(Menu.class);
        goTo.openCasualDresses();
        $(".cat-name").shouldHave(exactText("Casual Dresses"));
    }


    @AfterAll
    public static void tearDown() throws Exception {
        chrome.stop();
    }

}
