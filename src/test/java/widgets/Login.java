package widgets;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class Login {

    private SelenideElement signIn = $(By.linkText("Sign in")),
                            email = $("#email"),
                            password = $("#passwd"),
                            submit = $("#SubmitLogin");


    @Step("Log In with email {0} and password {1}")
    public void login(String email, String password) {
        signIn.click();
        this.email.val(email);
        this.password.val(password);
        submit.click();
    }
}
