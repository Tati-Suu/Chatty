import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class ContactUsTest extends BaseTest {
    @Test
    public void nameOfThePage() { // названия страницы отличаются
        loginPage.enterEmail("ghjk2@gmail.com");
        loginPage.enterPassword("cat2016!");
        loginPage.clickButton();
        headerPage.clickOnContactHeader();
        contactUsPage.textContactPage("Contact us!");
    }


    // ввод невалидного имени 31 символ
    @Test
    public void invalidNameBig() {
        loginPage.enterEmail("ghjk2@gmail.com");
        loginPage.enterPassword("cat2016!");
        loginPage.clickButton();
        headerPage.clickOnContactHeader();
        contactUsPage.enterName("ghfjdkrutjynvmsslekjfnvhqkdnvkl");
        contactUsPage.enterEmail("ghjk2@gmail.com");
        contactUsPage.enterContent("zfgjgj;");
        contactUsPage.clickOnButtonSendMessage();
    }

    // сообщение об успешной отправке "Feedback submitted successfully!" /Ждали: Your message has been sent successfully
    @Test
    public void SuccessfulMessageSending() {
        loginPage.enterEmail("ghjk2@gmail.com");
        loginPage.enterPassword("cat2016!");
        loginPage.clickButton();
        headerPage.clickOnContactHeader();
        contactUsPage.enterName("nata");
        contactUsPage.enterEmail("ghjk2@gmail.com");
        contactUsPage.enterContent("My beste day");
        contactUsPage.clickOnButtonSendMessage();
        contactUsPage.textOfTheSuccesfullSendingMessage("Your message has been sent successfully");
    }

    // несоответствие названия поля для контента. Актуальное - Меssage
    @Test
    public void checkNameFieldMessage() {
        loginPage.enterEmail("ghjk2@gmail.com");
        sleep(5000);
        loginPage.enterPassword("cat2016!");
        loginPage.clickButton();
        headerPage.clickOnContactHeader();
        contactUsPage.checkTextContent("Contact");
    }

    //В поле контент не возможно ввести менее 3 символов, иначе, сообщение не отправится
    @Test
    public void smallContent() {
        loginPage.enterEmail("ghjk2@gmail.com");
        loginPage.enterPassword("cat2016!");
        loginPage.clickButton();
        headerPage.clickOnContactHeader();
        contactUsPage.enterName("nata");
        contactUsPage.enterEmail("ghjk2@gmail.com");
        contactUsPage.enterContent("My");
        contactUsPage.clickOnButtonSendMessage();
        contactUsPage.unSuccessfuiiSending("Feedback submitted successfully!");
    }

    // проверка появления текста ошибки при отправке с пустыми полями ("Заполните это поле")Ожидаем: This value should't be blank
    @Test
    public void CheckTextErrorMessageAllFieldEmpty() {
        loginPage.enterEmail("ghjk2@gmail.com");
        loginPage.enterPassword("cat2016!");
        loginPage.clickButton();
        headerPage.clickOnContactHeader();
        contactUsPage.enterName("");
        contactUsPage.enterEmail("");
        contactUsPage.enterContent("");
        contactUsPage.clickOnButtonSendMessage();
        contactUsPage.emptyFieldErrorMessage();

    }


}
