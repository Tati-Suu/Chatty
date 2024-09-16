import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class UserProfileEditTest extends BaseTest {

    @Test
    public void EditingUserProfileData() {
        userProfileEditPage.getUserMenu().shouldBe(visible).click();
        userProfileEditPage.getProfileLink().shouldBe(visible, visible).click();
        userProfileEditPage.getEditButtonPlus().shouldBe(visible).click();
        userProfileEditPage.getNameField().shouldBe(visible).setValue("Mariia");
        userProfileEditPage.getSurnameField().shouldBe(visible).setValue("Gerasimova");
        userProfileEditPage.getGenderField().selectOptionByValue("FEMALE");
        userProfileEditPage.getBirthDateField().setValue("21.03.1992");
        userProfileEditPage.getPhoneField().setValue("+12536425857");
        userProfileEditPage.getSaveButton().click();

        userProfileEditPage.getNameField().shouldHave(Condition.value("Mariia"));
        userProfileEditPage.getSurnameField().shouldHave(Condition.value("Gerasimova"));
        userProfileEditPage.getGenderField().getSelectedOption().shouldHave(text("Female"));
        userProfileEditPage.getBirthDateField().shouldHave(Condition.value("1992-03-21"));
        userProfileEditPage.getPhoneField().shouldHave(Condition.value("+12536425857"));
    }
    @Test
    public void fillingInChangePasswordField() {
        UserProfileEditPage userProfileEditPage = new UserProfileEditPage();
        userProfileEditPage.getUserMenu().shouldBe(visible).click();
        userProfileEditPage.getProfileLink().shouldBe(visible).click();
        userProfileEditPage.getEditButtonPlus().shouldBe(visible).click();
        userProfileEditPage.clickChangePasswordButton();
        userProfileEditPage.isPasswordBoxDisplayed();
        userProfileEditPage.inputOldPassword("Blabla2024!");
        userProfileEditPage.inputNewPassword("Blabla2024!!");
        userProfileEditPage.confirmNewPassword("Blabla2024!!");

        userProfileEditPage.clickSavePassButton();
    }
}


