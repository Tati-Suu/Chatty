import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private SelenideElement emailEditBox = $("[placeholder='Email']");
            //$x("//[@name='email']");
    private SelenideElement passwordEditBox = $("[placeholder='Password']");
                    //$x("//[@name='password']");
    private SelenideElement loginButton = $("[data-test=\"submit\"]");

    private SelenideElement formElement = $x("//[@class='form']");
    private SelenideElement signUpLink = $x("//[@href='/registration']");
    private SelenideElement signInButton = $x("//[@id='root']/div/div/p/a");
    private SelenideElement emailErrorMessage = $x("(//[@class='text-error'])[1]");

//    public LoginPage open (String url) {
//        open("http://chatty.telran-edu.de:8089/login");
//        return this;
//    }

    public LoginPage enterEmail(String email) {
        emailEditBox.setValue(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordEditBox.setValue(password);
        return this;
    }

    public HomePage clickButton() {
                loginButton.shouldBe(Condition.enabled, Duration.ofSeconds(10))
                .shouldHave(Condition.text("Login"));
        loginButton.click();
        return new HomePage();
    }

    public boolean isFormElementDisplayed() {
        return formElement.isDisplayed();
    }

    public boolean isEmailErrorMessageDisplayed() {
        return emailErrorMessage.isDisplayed();
    }

}

// $("[data-test=\"submit\"]");
//$(".registration-btn");
//$x("//button[@type='submit']");