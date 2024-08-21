import org.junit.jupiter.api.Test;

public class ContactUsTest extends BaseTest {
    @Test
    public void nameOfThePage() { // названия страницы отличаются
        loginPage.enterEmail("ghjk2@gmail.com");
        loginPage.enterPassword("cat2016!");
        loginPage.clickButton();
        headerPage.clickOnContactHeader();
        contactUsPage.textContactPage("Contact us!");
    }


}
