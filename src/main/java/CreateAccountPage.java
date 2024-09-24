import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CreateAccountPage {
    private SelenideElement dateInput = $x("//input[@id='publishDate']");
    public void setPostDateToFuture (int daysInFuture) {
    // Установка будущей даты в формате YYYY-MM-DD
        LocalDate futureDate = LocalDate.now().plusDays(daysInFuture);
        String formattedDate = futureDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        dateInput.setValue(formattedDate);
    }

    private SelenideElement registrationPageRedirect = $("[href='/registration']");

    private SelenideElement emailEditBox = $("[placeholder='Email']");
    private SelenideElement passwordEditBox = $("[placeholder='Password']");
    private SelenideElement confirmPasswordEditBox = $("[placeholder='Confirm password']");
    private SelenideElement registrationButton = $(".registration-btn");
    private SelenideElement passwordErrorMessage = $(".text-error");
    private SelenideElement userNameErrorMessage = $(".text-error");
    //Empty
    private SelenideElement userNameEmptyErrorMessage = $("#root > div > div > form > div:nth-child(4)");
    private SelenideElement passwordEmptyErrorMessage = $("#root > div > div > form > div:nth-child(6)");
    private SelenideElement confirmPasswordEmptyErrorMessage = $("#root > div > div > form > div:nth-child(8)");
    private SelenideElement selectButton = $("select");
    private SelenideElement adminButton = $("[value=\"admin\"]");
    //registrationPageRedirect
    public CreateAccountPage clickRegistrationPageRedirect() {
        registrationPageRedirect.click();
    return new CreateAccountPage();
    }
    public CreateAccountPage inputEmail(String email) {
        emailEditBox.setValue(email);
        return this;
    }

    public CreateAccountPage inputPassword(String password) {
        passwordEditBox.setValue(password);
        return this;
    }

    public CreateAccountPage inputConfirmPassword(String confirmPassword) {
        confirmPasswordEditBox.setValue(confirmPassword);
        return this;
    }

    public CreateAccountPage clickRegistrationButton() {
        registrationButton.click();
        return new CreateAccountPage();
    }

    public String getPasswordErrorMessage() {
        return passwordErrorMessage.shouldBe(visible).getText();
    }

    public void isPasswordErrorMessagePresent(String expectedText) {
        passwordErrorMessage.shouldBe(Condition.visible).shouldHave(text(expectedText));
    }

    public String getUserNameErrorMessage() {
        return userNameErrorMessage.shouldBe(visible).getText();
    }

    public boolean isUserNameErrorMessagePresent(String text) {
        return userNameErrorMessage.shouldBe(visible).getText().contains(text);
    }
        //Empty
       //userNameEmptyErrorMessage
        public void  userNameEmptyErrorMessageCheck(String expectedText) {
          userNameEmptyErrorMessage.shouldBe(Condition.visible).shouldHave(text(expectedText));
        }

    public void  passwordEmptyErrorMessageCheck(String expectedText) {
         passwordEmptyErrorMessage.shouldBe(Condition.visible).shouldHave(text(expectedText));
    }
    public void  confirmPasswordEmptyErrorMessageCheck(String expectedText) {
        confirmPasswordEmptyErrorMessage.shouldBe(Condition.visible).shouldHave(text(expectedText));
    }
    public void selectAdminRoleByClick() {
        selectButton.shouldBe(visible).click();
        adminButton.shouldBe(visible).click();
    }


}
