import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class CreateAccountTest extends BaseTest {
     @Test
    public void successLoginUser(){

         createAccountPage.clickRegistrationPageRedirect();
         createAccountPage.inputEmail("User456@gmail.com");
         createAccountPage.inputPassword("User12356789");
         createAccountPage.inputConfirmPassword("User12356789");
         createAccountPage.clickRegistrationButton();
    }
    @Test
    public void successLoginAdmin(){

        createAccountPage.clickRegistrationPageRedirect();
        createAccountPage.inputEmail("User456@gmail.com");
        createAccountPage.inputPassword("User12356789");
        createAccountPage.inputConfirmPassword("User12356789");
        createAccountPage.selectAdminRoleByClick();
        createAccountPage.clickRegistrationButton();
    }
    @Test
    public void invalidPassword(){
        open("http://chatty.telran-edu.de:8089/registration");
        createAccountPage.inputEmail("User456@gmail.com");
        createAccountPage.inputPassword("Привет12356789");
        createAccountPage.inputConfirmPassword("Привет12356789");
        createAccountPage.isPasswordErrorMessagePresent("Password must be 8-100 characters and include at least one letter and one digit");
    }

    //invalid username
    @Test
    public void invalidUsername(){
        open("http://chatty.telran-edu.de:8089/registration");
        createAccountPage.inputEmail("User456Ошибка@gmail.com");
        createAccountPage.inputPassword("User12356789");
        createAccountPage.inputConfirmPassword("User12356789");
        createAccountPage.isUserNameErrorMessagePresent("Incorrect email format");
    }

    @Test
    public void emptyPass(){
        open("http://chatty.telran-edu.de:8089/registration");
        createAccountPage.inputEmail("User456@gmail.com");
        createAccountPage.inputPassword("");
        createAccountPage.inputConfirmPassword("");
        createAccountPage.passwordEmptyErrorMessageCheck("Password cannot be empty");
    }

    //Empty username
    @Test
    public void emptyUsername(){
        open("http://chatty.telran-edu.de:8089/registration");
        createAccountPage.inputEmail("");
        createAccountPage.inputPassword("User12356789");
        createAccountPage.inputConfirmPassword("User12356789");
        createAccountPage.userNameEmptyErrorMessageCheck("Email cannot be empty");
    }
    //Empty username & password
    @Test
    public void emptyUsernamePassword(){
        open("http://chatty.telran-edu.de:8089/registration");
        createAccountPage.inputEmail("");
        createAccountPage.inputPassword("");
        createAccountPage.inputConfirmPassword("");
        createAccountPage.userNameEmptyErrorMessageCheck("Email cannot be empty");
        createAccountPage.passwordEmptyErrorMessageCheck("Password cannot be empty");
        createAccountPage.confirmPasswordEmptyErrorMessageCheck("Confirm password cannot be empty");

     }

}
