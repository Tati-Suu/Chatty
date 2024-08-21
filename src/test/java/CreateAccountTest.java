import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class CreateAccountTest extends BaseTest {
     @Test
    public void successLoginUser(){
         //createAccountPage.clickRegistrationPageRedirect();
        //open("http://chatty.telran-edu.de:8089/registration");
        createAccountPage.inputEmail("User456@gmail.com");
        createAccountPage.inputPassword("User12356789");
         createAccountPage.inputConfirmPassword("User12356789");
         sleep(5000);
         createAccountPage.clickRegistrationButton();
    }
    @Test
    public void invalidPassword(){

        createAccountPage.inputEmail("User456@gmail.com");
        createAccountPage.inputPassword("Привет12356789");
        createAccountPage.inputConfirmPassword("Привет12356789");
        sleep(3000);
        createAccountPage.isPasswordErrorMessagePresent("Password must be 8-100 characters and include at least one letter and one digit");
    }



    //invalid username
    @Test
    public void invalidUsername(){

        createAccountPage.inputEmail("User456Ошибка@gmail.com");
        createAccountPage.inputPassword("User12356789");
        createAccountPage.inputConfirmPassword("User12356789");
        sleep(5000);
        createAccountPage.isUserNameErrorMessagePresent("Incorrect email format");
    }



    //
    //Empty password
    @Test
    public void emptyPass(){
        createAccountPage.inputEmail("User456@gmail.com");
        createAccountPage.inputPassword("");
        createAccountPage.inputConfirmPassword("");
        sleep(3000);
        createAccountPage.passwordEmptyErrorMessageCheck("Password cannot be empty");
    }
//1. Email cannot be empty .text-error:first-child
    //2. Password cannot be empty $(".text-error:nth-child(2)");
///====3.Confirm password cannot be empty





    //Empty username
    @Test
    public void emptyUsername(){
        createAccountPage.inputEmail("");
        createAccountPage.inputPassword("User12356789");
        createAccountPage.inputConfirmPassword("User12356789");
        sleep(3000);
        createAccountPage.userNameEmptyErrorMessageCheck("Email cannot be empty");
    }

    //Empty username & password
    @Test
    public void emptyUsernamePassword(){
        createAccountPage.inputEmail("");
        createAccountPage.inputPassword("");
        createAccountPage.inputConfirmPassword("");

        sleep(3000);
        createAccountPage.userNameEmptyErrorMessageCheck("Email cannot be empty");
        createAccountPage.passwordEmptyErrorMessageCheck("Password cannot be empty");
        createAccountPage.confirmPasswordEmptyErrorMessageCheck("Confirm password cannot be empty");

     }

}
