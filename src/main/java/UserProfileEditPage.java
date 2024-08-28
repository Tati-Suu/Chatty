import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class UserProfileEditPage {
    private SelenideElement editButtonPlus = $("[data-test='post-header__plus']");
    private SelenideElement nameField = $x("//input[@name='name']");
    private SelenideElement surnameField = $x("//input[@name='surname']");
    private SelenideElement genderField = $("select[data-test='profileGender']");
    private SelenideElement birthDateField = $("#birthDate");
    private SelenideElement phoneField = $x("//input[@name='phone']");
    private SelenideElement saveButton = $x("//button[@type='submit']");
    private SelenideElement userMenu = $x("//p[contains(text(), 'Hello,')]");
    private SelenideElement profileLink = $x("//a[@href='/userprofile' and text()='Your Profile']");
    private SelenideElement changePasswordButton = $x("//button[@data-test='profileChangePasswordButton']");
    private SelenideElement oldPasswordField = $x("//input[@placeholder='Old password']");
    private SelenideElement newPasswordField = $x("//input[@placeholder='New password']");
    private SelenideElement confirmPasswordField = $x("//input[@placeholder='Confirm new password']");
    private SelenideElement savePassButton = $x("//button[contains(@class, 'PasswordModal_pass_btn__eGL9h')]");
    private SelenideElement personalInformation = $("[class=\"post-header__feed\"]");

    public SelenideElement getEditButtonPlus() {return editButtonPlus;
    }
    public SelenideElement getNameField() {
        return nameField;
    }
    public SelenideElement getSurnameField() {
        return surnameField;
    }
    public SelenideElement getGenderField() {
        return genderField;
    }
    public SelenideElement getBirthDateField() {
        return birthDateField;
    }
    public SelenideElement getPhoneField() {return phoneField;
    }
    public SelenideElement getSaveButton() {
        return saveButton;
    }
    public SelenideElement getUserMenu() {
        return userMenu;
    }
    public SelenideElement getProfileLink() {
        return profileLink;
    }
    public void clickChangePasswordButton() {
        changePasswordButton.shouldBe(visible).click();
    }
    public void isPasswordBoxDisplayed() {
        oldPasswordField.shouldBe(visible);
        newPasswordField.shouldBe(visible);
        confirmPasswordField.shouldBe(visible);
    }
    public void inputOldPassword(String oldPassword) {
        oldPasswordField.setValue(oldPassword);

    }

    public void elemPersonalInformationIsDisplayed(String textFormValue){
        personalInformation.shouldBe(visible).shouldHave(text(textFormValue));
    }
    public void inputNewPassword(String newPassword) {
        newPasswordField.setValue(newPassword);
    }
    public void confirmNewPassword(String confirmPassword) {
        confirmPasswordField.setValue(confirmPassword);
    }
    public void clickSavePassButton() {
        savePassButton.shouldBe(visible).click();
    }
}
