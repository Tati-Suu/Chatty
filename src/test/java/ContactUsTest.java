import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class ContactUsTest extends BaseTest {
    @Test
    public void nameOfThePage() { // названия страницы отличаются
//        loginPage.enterEmail("ghjk2@gmail.com");
//        loginPage.enterPassword("cat2016!");
//        loginPage.clickButton();
        loginPage.login("ghjk2@gmail.com","cat2016!");
        headerPage.clickOnContactHeader();
        contactUsPage.textContactPage("Contact us!");
    }


    // ввод невалидного имени 31 символ
    @Test
    public void invalidNameBig() {

        loginPage.login("ghjk2@gmail.com","cat2016!");
        headerPage.clickOnContactHeader();
        contactUsPage.enterName("ghfjdkrutjynvmsslekjfnvhqkdnvklg");
        contactUsPage.enterEmail("ghjk2@gmail.com");
        contactUsPage.enterContent("zfgjgj;");
        contactUsPage.clickOnButtonSendMessage();
    }

    // сообщение об успешной отправке "Feedback submitted successfully!" /Ждали: Your message has been sent successfully
    @Test
    public void SuccessfulMessageSending() {

        loginPage.login("ghjk2@gmail.com", "cat2016!");
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

        loginPage.login("ghjk2@gmail.com", "cat2016!");
        headerPage.clickOnContactHeader();
        contactUsPage.checkTextContent("Contact");
    }

    //В поле контент не возможно ввести менее 3 символов, иначе, сообщение не отправится. По факту - возможно
    @Test
    public void smallContent() {

        loginPage.login("ghjk2@gmail.com", "cat2016!");
        headerPage.clickOnContactHeader();
        contactUsPage.enterName("nata");
        contactUsPage.enterEmail("ghjk2@gmail.com");
        contactUsPage.enterContent("My");
        contactUsPage.clickOnButtonSendMessage();
        contactUsPage.unSuccessfuiiSending("From 3 to 1000 symbols");
    }

    // проверка появления текста ошибки при отправке с пустыми полями ("Заполните это поле")Ожидаем: This value should't be blank
    @Test
    public void CheckTextErrorMessageAllFieldEmpty() {

        loginPage.login("ghjk2@gmail.com", "cat2016!");
        headerPage.clickOnContactHeader();
        contactUsPage.enterName("");
        contactUsPage.enterEmail("");
        contactUsPage.enterContent("");
        contactUsPage.clickOnButtonSendMessage();
        contactUsPage.emptyFieldErrorMessage();

    }


}
