import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;

public class UserProfileEditTest extends BaseTest {

    @Test
    public void EditingUserProfileData() {
        loginPage.login("hirsch.mariia@icloud.com","NewOne!!01");
        userProfileEditPage.getUserMenu().shouldBe(visible).click();
        userProfileEditPage.getProfileLink().shouldBe(visible).click();
        userProfileEditPage.getEditButtonPlus().shouldBe(visible).click();
        userProfileEditPage.getNameField().shouldBe(visible).setValue("Mariia");
        userProfileEditPage.getSurnameField().shouldBe(visible).setValue("Tomovna");
        userProfileEditPage.getGenderField().selectOptionByValue("FEMALE");
        userProfileEditPage.getPhoneField().setValue("+1234567890");
        userProfileEditPage.getSaveButton().click();

        userProfileEditPage.getNameField().shouldHave(Condition.value("Mariia"));
        userProfileEditPage.getSurnameField().shouldHave(Condition.value("Tomovna"));
        userProfileEditPage.getGenderField().getSelectedOption().shouldHave(text("FEMALE"));
        userProfileEditPage.getPhoneField().shouldHave(Condition.value("+1234567890"));
    }
    @Test
    public void fillingInChangePasswordField() {
        loginPage.login("hirsch.mariia@icloud.com","Blabla2024!!");
        userProfileEditPage.getUserMenu().shouldBe(visible).click();
        userProfileEditPage.getProfileLink().shouldBe(visible).click();
        userProfileEditPage.getEditButtonPlus().shouldBe(visible).click();
        userProfileEditPage.clickChangePasswordButton();
        userProfileEditPage.isPasswordBoxDisplayed();
        userProfileEditPage.inputOldPassword("Blabla2024!!");
        userProfileEditPage.inputNewPassword("NewOne!!01");
        userProfileEditPage.confirmNewPassword("NewOne!!01");
        userProfileEditPage.clickSavePassButton();
    }
}


