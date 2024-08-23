import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.codeborne.selenide.Selenide.sleep;

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

}

