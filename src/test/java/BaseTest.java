import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    @BeforeEach
    public void setUp(){

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        open("http://chatty.telran-edu.de:8089/login");

    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    LoginPage loginPage = new LoginPage();


    AdminPage adminPage = new AdminPage();

    AdminAuthPage adminAuthPage = new AdminAuthPage();
    HomePage homePage = new HomePage();

    CreateAccountPage createAccountPage = new CreateAccountPage();

}
