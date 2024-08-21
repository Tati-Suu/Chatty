import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CreateAccountPage {
    //$("a[href='/registration']")
    private SelenideElement registrationPageRedirect = $("[href='/registration']");
    //[href="/registration"]

    private SelenideElement emailEditBox = $("[placeholder='Email']");
            //$x("//[@name='email']");
    private SelenideElement passwordEditBox = $("[placeholder='Password']");
                    //$x("//[@name='password']");
    private SelenideElement confirmPasswordEditBox = $("[placeholder='Confirm password']");
                            //$("#root > div > div > form > label:nth-child(9) > input");
                            //$(".input-password");
                            //$("[placeholder='Confirm password']");
                            //$x("//[@name='confirmPassword']"); placeholder="Confirm password"


    private SelenideElement registrationButton = $(".registration-btn");
                                    // $x("//[@class='registration-btn']");
                                    //$("#root > div > div > form > button");
                                    //$(".registration-btn");
                                    //$x("//[@class='registration-btn']");
    //#root > div > div > form > button
    private SelenideElement passwordErrorMessage = $(".text-error");
            //$x("(//*[@class='text-error'])[1]");
    private SelenideElement userNameErrorMessage = $(".text-error");


    //Empty
    ////*[@id="root"]/div/div/form/div[1]     #root > div > div > form > div:nth-child(4)
    private SelenideElement userNameEmptyErrorMessage = $("#root > div > div > form > div:nth-child(4)");
    private SelenideElement passwordEmptyErrorMessage = $(".text-error");
            //$("br:nth-child(2)");
   // #root > div > div > form > div.text-error
    private SelenideElement confirmPasswordEmptyErrorMessage = $("br:nth-child(3)");

    //от Альбины
    private SelenideElement selectButton = $("select");
    private SelenideElement adminButton = $("[value=\"admin\"]");

        //registrationPageRedirect
    public HomePage clickRegistrationPageRedirect() {
        registrationPageRedirect.click();
    return new HomePage();
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
         //passwordErrorMessage.shouldBe(visible).getText().contains(text); Машин код
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
    //от Альбины

    public void selectAdminRoleByClick() {
        selectButton.shouldBe(visible).click();
        adminButton.shouldBe(visible).click();
    }


}
