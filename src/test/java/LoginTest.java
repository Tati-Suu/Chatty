
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.*;


public class LoginTest extends BaseTest {
    @Test
    public void AuthorizationValidData() {
        open("http://chatty.telran-edu.de:8089");
        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail("hirsch.mariia@icloud.com")
                .enterPassword("Blabla2024!")
                .clickButton();
    }
    @Test
    public void LoginUnregisteredUsername() {
            open("http://chatty.telran-edu.de:8089");

            LoginPage loginPage = new LoginPage();
            loginPage.enterEmail("blabla@example.com")
                    .enterPassword("Blabla2024!")
                    .clickButton();
            String actualErrorMessage = loginPage.getUnregisteredUsernameErrorMessage();
            String expectedErrorMessage = "Check your login and password.";
            sleep(5000);
            assertEquals(expectedErrorMessage, actualErrorMessage, "Wrong Error message");

    }

    @Test
    public void  LoginButtonUnresponsiveWithEmptyFields() {
        LoginPage loginPage = open("http://chatty.telran-edu.de:8089", LoginPage.class);
        loginPage.enterEmail("")
                .enterPassword("");
        loginPage.clickButton();

        String actualErrorMessage = loginPage.getEmptyFieldsErrorMessage();
        String expectedErrorMessage = "The fields cannot be empty.";
        sleep(5000);
        assertEquals(expectedErrorMessage, actualErrorMessage, "Wrong Error message");
    }
    @Test
    public void testLoginButtonUnclickableWithSpecialCharactersInUsername() {
        open("http://chatty.telran-edu.de:8089");
        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail("mariia@hirsch[]@icloud.com")
                .enterPassword("Blabla2024!");
        loginPage.clickButton();

        String actualErrorMessage = loginPage.getWithSpecialCharactersInUsernameErrorMessage();
        String expectedErrorMessage = "Неравильный Username . Должен состоять из латинских букв и цифр, без спецсимволов."; // Incorrect Username. It should consist of Latin letters and numbers, without special characters.
        sleep(5000);
        assertEquals(expectedErrorMessage, actualErrorMessage, "Wrong Error message");
    }

    @Test
    public void testLoginButtonUnclickableWithChineseCharactersInPassword() {
        LoginPage loginPage = open("http://chatty.telran-edu.de:8089", LoginPage.class);
        loginPage.enterEmail("hirsch.mariia@icloud.com")
                .enterPassword("测试测试测试2024!");
        loginPage.clickButton();
        String actualErrorMessage = loginPage.getWithWithChineseCharactersInPasswaordErrorMessage();
        String expectedErrorMessage = "Неправильный  Password . Должен состоять из латинских букв, цифр и спецсимволов."; //Incorrect Password. It should consist of Latin letters, numbers, and special characters.
        sleep(5000);
        assertEquals(expectedErrorMessage, actualErrorMessage, "Wrong Error message");
    }

    @Test
    public void testLoginButtonDisabledWithShortPassword() {
        LoginPage loginPage = open("http://chatty.telran-edu.de:8089", LoginPage.class);
        loginPage.enterEmail("hirsch.mariia@icloud.com")
                .enterPassword("Bbla2!");
        loginPage.clickButton();
        String actualErrorMessage = loginPage.getWithShortPassErrorMessage();
        String expectedErrorMessage = "Неправильный Password . Должен быть не менее 8 и  не более 20 символов.";
        sleep(5000);
        assertEquals(expectedErrorMessage, actualErrorMessage, "Wrong Error message");
    }

    @Test
    public void testNoErrorMessageAndRedirectionWithLongPassword() {
        open("http://chatty.telran-edu.de:8089");
        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail("hirsch.mariia@icloud.com")
                .enterPassword("bla2024!".repeat(15));
        loginPage.clickButton();
        String actualErrorMessage = loginPage.getWithLongPassErrorMessage();
        String expectedErrorMessage = "Неправильный Password . Должен быть не менее 8 и  не более 20 символов.";
        sleep(5000);
        assertEquals(expectedErrorMessage, actualErrorMessage, "Wrong Error message");

    }

    @Test
    public void testIncorrectErrorMessageForUnregisteredUsername() {
            open("http://chatty.telran-edu.de:8089");
            LoginPage loginPage = new LoginPage();
            loginPage.enterEmail("gerasimovam92@gmail.com")
                    .enterPassword("heyhey2024chatty!")
                    .clickButton();
            String actualErrorMessage = loginPage.getUnregisteredUsernameErrorMessage();
            String expectedErrorMessage = "Check your login and password.";
            sleep(5000);
            assertEquals(expectedErrorMessage, actualErrorMessage, "Wrong Error Message");

    }

    @Test
    public void testPasswordRequirementsMessage() {
        open("http://chatty.telran-edu.de:8089");
        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail("hirsch.mariia@icloud.com");
        loginPage.enterPassword("blabla");

        sleep(5000);
        loginPage.getPasswordRequirementsMessage().shouldBe(visible);

        String expectedMessage = "Password must be 8-100 characters and include at least one letter and one digit";
        String actualMessage = loginPage.getPasswordRequirementsMessage().getText();
        assertTrue(actualMessage.contains(expectedMessage),
                "The password requirements message should contain: " + expectedMessage);
    }



}
