import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AdminPageTest extends BaseTest {
    @Test
    public void adminPageCheck() {

        createAccountPage.inputEmail("Admin.kater3@gmail.com");
        createAccountPage.inputPassword("123456FGHJKLLO");
        sleep(5000);
        createAccountPage.clickRegistrationButton();
        adminPage.isAdminPagePresent("Admin panel");
    }

    @Test
    public void userListTitleCheck() {

        createAccountPage.inputEmail("Admin.kater3@gmail.com");
        createAccountPage.inputPassword("123456FGHJKLLO");
        sleep(5000);
        createAccountPage.clickRegistrationButton();
        adminPage.userListTitleCheck("List of accounts");//List of accounts - this title is specified in the requirements
    }

    @Test
    public void columnNamesCheck() {

        createAccountPage.inputEmail("Admin.kater3@gmail.com");
        createAccountPage.inputPassword("123456FGHJKLLO");
        sleep(5000);
        createAccountPage.clickRegistrationButton();
        adminPage.columnNamesCheck(Arrays.asList("№","Role", "Email", "Name", "Actions"));//the names of the columns that are actually reflected on the page
        adminPage.columnNamesCheck(Arrays.asList("№","Role", "Username", "Name", "Date Created","Actions"));
        //Date Created!!!!//the name of the column that should be reflected on the page according to the technical specifications
        //According to the technical specifications, the name of the Email column should be Username
    }


    @Test
    public void userBlockCheck() {

        createAccountPage.inputEmail("Admin.kater3@gmail.com");
        createAccountPage.inputPassword("123456FGHJKLLO");
        sleep(5000);
        createAccountPage.clickRegistrationButton();
        sleep(5000);
        adminPage.trashUserBlockCheck();
        sleep(10000);
        //according to the technical specifications it should not delete the user, it should block it, this is a bug
        //there is no way to view blocked users
    }

    @Test
    public void deleteUserAndVerifyRemoval() {
        createAccountPage.inputEmail("Admin.kater3@gmail.com");
        createAccountPage.inputPassword("123456FGHJKLLO");
        sleep(5000);
        createAccountPage.clickRegistrationButton();
        sleep(5000);
        adminPage.trashUserBlockCheck();
        sleep(5000);

    }

    @Test
    public void editUserBoxClick() {

        createAccountPage.inputEmail("Admin.kater3@gmail.com");
        createAccountPage.inputPassword("123456FGHJKLLO");
        createAccountPage.clickRegistrationButton();
        sleep(10000);
        adminPage.editUserBoxClick();
    }

    @Test
    public void createUserFromAdmin() {

        createAccountPage.inputEmail("Admin.kater3@gmail.com");
        createAccountPage.inputPassword("123456FGHJKLLO");
        createAccountPage.clickRegistrationButton();
        sleep(10000);
        adminPage.createUserFromAdminCheck("Create account");//According to the documentation there should be a button to create an account from the admin
        //нет кнопки создать юзера
        //there is no button to create an account from admin
    }

    @Test
    public void editingUserProfileData() {
        createAccountPage.inputEmail("Admin.kater3@gmail.com");
        createAccountPage.inputPassword("123456FGHJKLLO");
        createAccountPage.clickRegistrationButton();
        sleep(10000);
        adminPage.editUserBoxClick();
        //userProfileEditPage.getProfileLink().shouldBe(visible, visible).click();
        userProfileEditPage.getEditButtonPlus().shouldBe(visible).click();
        userProfileEditPage.getNameField().shouldBe(visible).setValue("Lila");
        userProfileEditPage.getSurnameField().shouldBe(visible).setValue("Boss");
        userProfileEditPage.getGenderField().selectOptionByValue("FEMALE");
        userProfileEditPage.getBirthDateField().setValue("21.03.1999");
        userProfileEditPage.getPhoneField().setValue("+12536425857");
        userProfileEditPage.getSaveButton().click();

        userProfileEditPage.getNameField().shouldHave(Condition.value("Lila"));
        userProfileEditPage.getSurnameField().shouldHave(Condition.value("Boss"));
        userProfileEditPage.getGenderField().getSelectedOption().shouldHave(text("Female"));
        //userProfileEditPage.getBirthDateField().shouldHave(Condition.value("21.03.1999"));
        userProfileEditPage.getPhoneField().shouldHave(Condition.value("+12536425857"));
    }


}

