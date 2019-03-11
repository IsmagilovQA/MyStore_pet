import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.proxy.SelenideProxyServer;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import net.lightbody.bmp.core.har.HarRequest;
import net.lightbody.bmp.core.har.HarResponse;
import net.lightbody.bmp.proxy.CaptureType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import services.Highlighter;
import widgets.Login;
import widgets.Menu;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.addListener;
import static com.codeborne.selenide.WebDriverRunner.getSelenideProxy;

import com.automation.remarks.junit5.Video;
import widgets.SimpleClass;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Tests {

    @BeforeAll
    public static void setUp() {

        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(false));

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

    @Test
    public void check() {
        SimpleClass test1 = new SimpleClass("Ivan", "Kharkov", 21);
        System.out.println(test1);
    }

    @Test
    public void proxyTest() {

        Configuration.proxyEnabled = true;

        open("https://google.com");
        SelenideProxyServer proxy = WebDriverRunner.getSelenideProxy();
        proxy.getProxy().newHar("google");

        $(By.name("q")).setValue("selenide").pressEnter();
        $(withText("Selenide: лаконичные и стабильные UI тесты на Java")).shouldBe(Condition.visible);

        Har har = proxy.getProxy().getHar();
        for (HarEntry entry : har.getLog().getEntries()) {
            HarRequest request = entry.getRequest();
            HarResponse response = entry.getResponse();

            System.out.println(request.getUrl() + " : " + response.getStatus()
                    + ", " + entry.getTime() + "ms");
        }
        close();
    }

    @Test
    public void testmethod(SimpleClass simple) {
        $("").val(simple.getName());

    }
}