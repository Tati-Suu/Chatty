import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class UserProfileEditTest extends BaseTest {
    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";

        open("http://chatty.telran-edu.de:8089/login");
        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail("hirsch.mariia@icloud.com")
                .enterPassword("Blabla2024!")
                .clickButton();
    }
//    @Test
//    public void EditingUserProfileData() {
//        UserProfileEditPage userProfileEditPage = new UserProfileEditPage();
//
//        sleep(5000);
//
//    }

}
