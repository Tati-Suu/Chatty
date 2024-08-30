import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {


    private SelenideElement emailEditBox = $x("//*[@name='email']");
    private SelenideElement passwordEditBox = $x("//*[@name='password']");
    private SelenideElement loginButton = $x("//button[@type='submit']");
    private SelenideElement emailErrorMessage = $x("(//*[@class='text-error'])[1]");
    private SelenideElement unregisteredUsernameError = $x("//*[@class='text-error']");
    private SelenideElement passwordRequirementsMessage = $(".text-error");
    private SelenideElement loginForm = $("h1");

    public LoginPage enterEmail(String email) {
        //emailEditBox.setValue(email);
        emailEditBox.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        //passwordEditBox.setValue(password);
        passwordEditBox.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(password);
        return this;
    }

    public HomePage clickButton() {
        loginButton.click();
        return new HomePage();
    }

    public String getUnregisteredUsernameErrorMessage() {
        String errorMessage = unregisteredUsernameError.shouldBe(visible).getText();
        System.out.println("Error message received: " + errorMessage);
        return errorMessage;
    }

    public SelenideElement getPasswordRequirementsMessage() {
        return passwordRequirementsMessage;
    }

    public String getEmptyFieldsErrorMessage() {
        return emailErrorMessage.shouldBe(visible).getText();
    }

    public String getWithSpecialCharactersInUsernameErrorMessage() {
        return emailErrorMessage.shouldBe(visible).getText();
    }

    public String getWithWithChineseCharactersInPasswaordErrorMessage() {
        return emailErrorMessage.shouldBe(visible).getText();
    }

    public void loginFormIsDisplayed(String textValue) {
        loginForm.shouldBe(visible).shouldHave(text(textValue));
    }

    public String getWithShortPassErrorMessage() {
        return emailErrorMessage.shouldBe(visible).getText();
    }

    public String getWithLongPassErrorMessage() {
        return emailErrorMessage.shouldBe(visible).getText();
    }

    public void login(String email, String password) {
        emailEditBox.shouldBe(visible).setValue(email);
        passwordEditBox.setValue(password);
        loginButton.click();
    }
}