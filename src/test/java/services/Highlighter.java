package services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static java.lang.Thread.sleep;

public class Highlighter extends AbstractWebDriverEventListener {

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        try {
            highlight(element, "red");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        try {
            highlight(element, "red");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static <T extends WebElement> T highlight(T element, final String color) throws InterruptedException {
        if (element != null && element.getAttribute("__selenideHighlighting") == null) {
            for (int i = 1; i < 4; i++) {
                transform(element, color, i);
                sleep(100);
            }
            for (int i = 4; i > 0; i--) {
                transform(element, color, i);
                sleep(100);
            }
            sleep(2000);
        }
        return element;
    }

    private static void transform(WebElement element, String color, int i) {
        executeJavaScript(
                "arguments[0].setAttribute('__selenideHighlighting', 'done'); " +
                        "arguments[0].setAttribute(arguments[1], arguments[2])",
                element,
                "style",
                "border: 4px solid " + color + "; background-color:rgba(255, 99, 71, 0.4);" +
                        "transform: scale(1, 1." + i + ");");
    }

}
