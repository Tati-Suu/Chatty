import com.codeborne.selenide.SelenideElement;

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

    public SelenideElement getEditButtonPlus() {
        return editButtonPlus;
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
    public SelenideElement getPhoneField() {
        return phoneField;
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
}
