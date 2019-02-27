import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import widgets.Menu;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

public class Tests extends TestBase {

    @Test
    @Tag("fast")
    @Severity(SeverityLevel.NORMAL)
    @Description ("Allure description")
    public void first_test() {
        open("/");
        Menu goTo = page(Menu.class);
        goTo.openCasualDresses();
        $(".cat-name").shouldHave(exactText("Casual Dresses"));
    }
}
