import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class NewTestClass {

    @BeforeAll
    static void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";

    }
}
