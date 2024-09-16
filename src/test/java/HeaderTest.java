import org.junit.jupiter.api.Test;

public class HeaderTest extends BaseTest {
    // Кликаем на About и не попадаем на страницу "о нас", а на страницу Abbout Chatty
    @Test
    public void checkLinkAbout() {
        loginPage.enterEmail("ghjk2@gmail.com");
        loginPage.enterPassword("cat2016!");
        loginPage.clickButton();
        headerPage.clickOnAbout();
        headerPage.namePageAboutUs("О нас");
    }

    // При клике на Contact попадаем на страницу "Contact Us", ожидаем  "Contact us!"
    @Test
    public void checkLinkContact() {
        loginPage.enterEmail("ghjk2@gmail.com");
        loginPage.enterPassword("cat2016!");
        loginPage.clickButton();
        headerPage.clickOnContactHeader();
        contactUsPage.textContactPage("Contact us!");
    }


    //Clicking on “Home” in the header opens a personal blog page Подтверрждение, что на странице Home
    @Test
    public void checkLinkHome() {
        loginPage.enterEmail("ghjk2@gmail.com");
        loginPage.enterPassword("cat2016!");
        loginPage.clickButton();
        headerPage.clickOnContactHeader();
        headerPage.clickOnHome();
        homePage.clickPostsToggle();
    }


    // 3 слова Home About Contact
    @Test
    public void checkNavList() {
        loginPage.enterEmail("ghjk2@gmail.com");
        loginPage.enterPassword("cat2016!");
        loginPage.clickButton();
        headerPage.navPanelIsDisplayed("Home About Contact");
    }

    // Проверка наличия ссылки Draftв в дроп-даун меню и переход на страницу  именно Draft
    @Test
    public void checkDropdownDraft() {
        loginPage.login("ghjk2@gmail.com","cat2016!");
        headerPage.hoverDropdownMenu();
        headerPage.clickOnLinkDraft();
        draftPage.draftPageIsVisible("My drafts");

    }
    // Проверка наличия ссылки Logout в дроп-даун меню и переход на страницу  именно Login
    @Test
    public void checkDropdownLogout() {
        loginPage.login("ghjk2@gmail.com","cat2016!");
        headerPage.hoverDropdownMenu();
        headerPage.clickOnLogoutDropdown();
        loginPage.loginFormIsDisplayed("Login Form");

    }
    // Проверка наличия ссылки Your Profile в дроп-даун меню и переход на страницу  именно Personal information
    @Test
    public void checkDropdownYourProfile() {
        loginPage.login("ghjk2@gmail.com","cat2016!");
        headerPage.hoverDropdownMenu();
        headerPage.clickOnLinkProfile();
        userProfileEditPage.elemPersonalInformationIsDisplayed("Personal information");

    }

}
