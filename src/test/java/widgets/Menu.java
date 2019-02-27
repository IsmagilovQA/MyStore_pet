package widgets;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Menu {

    private SelenideElement woman = $(".sf-menu>li:nth-child(1)"),
                            dresses = $(".sf-menu>li:nth-child(2)"),
                            casualDresses = $(By.linkText("CASUAL DRESSES")),
                            logo = $("#header_logo");


    @Step("Open Women section")
    public void openWomen() {
        woman.click();
    }

    @Step ("Open Dresses section")
    public void openDresses() {
        dresses.click();
    }

    @Step ("Open Casual Dresses subsection")
    public void openCasualDresses() {
        dresses.hover();
        casualDresses.click();
    }

    @Step ("Click Logo")
    public void clickLogo() {
        logo.click();
    }
}
