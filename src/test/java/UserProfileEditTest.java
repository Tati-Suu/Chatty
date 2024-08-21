import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

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
    @Test
    public void EditingUserProfileData() {
        UserProfileEditPage userProfileEditPage = new UserProfileEditPage();

        // Ожидание и клик по меню пользователя "Hello, ..."
        userProfileEditPage.getUserMenu().shouldBe(visible).click();

        // Ожидание и клик по ссылке на профиль
        userProfileEditPage.getProfileLink().shouldBe(visible, visible).click();

        // Ожидание появления кнопки "+"
        userProfileEditPage.getEditButtonPlus().shouldBe(visible).click();

        // Ожидание видимости поля имени и ввод нового значения
        userProfileEditPage.getNameField().shouldBe(visible).setValue("Mariia");

        // Ожидание видимости поля фамилии и ввод нового значения
        userProfileEditPage.getSurnameField().shouldBe(visible).setValue("Gerasimova");

        // Выбор пола
        userProfileEditPage.getGenderField().selectOptionByValue("FEMALE");

        // Ввод даты рождения
        userProfileEditPage.getBirthDateField().setValue("21.03.1992");

        // Ввод телефона
        userProfileEditPage.getPhoneField().setValue("+12536425857");

        // Сохранение изменений
        userProfileEditPage.getSaveButton().click();

        // Ожидание и проверка внесенных изменений
        userProfileEditPage.getNameField().shouldHave(Condition.value("Mariia"));
        userProfileEditPage.getSurnameField().shouldHave(Condition.value("Gerasimova"));
        userProfileEditPage.getGenderField().getSelectedOption().shouldHave(Condition.text("Female"));
        userProfileEditPage.getBirthDateField().shouldHave(Condition.value("1992-03-21"));
        userProfileEditPage.getPhoneField().shouldHave(Condition.value("+12536425857"));
    }

}
