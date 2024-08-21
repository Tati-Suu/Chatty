import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class LoginTest extends BaseTest {


    @Test
    public void successLoginUser(){

        loginPage.enterEmail("User456@gmail.com");
        loginPage.enterPassword("User12356789");
        sleep(3000);
        loginPage.clickButton();

          }


    @Test
    public void successLoginAdmin(){

        loginPage.enterEmail("Admin456@gmail.com");
        loginPage.enterPassword("Admin12356789");
        sleep(3000);
        loginPage.clickButton();

    }

}
