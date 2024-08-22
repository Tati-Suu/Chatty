import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.attributeMatching;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ContactUsPage {
    private SelenideElement textPageContactUs = $(By.xpath("//*[@id=\"root\"]/div[2]/div/div/h1"));

    public void textContactPage(String namePageValue) {
        textPageContactUs.shouldBe(Condition.visible).shouldHave(text(namePageValue));
    }

    private SelenideElement name = $(By.id("name"));

    public void enterName(String nameValue) {
        name.shouldBe(Condition.visible).setValue(nameValue);
    }

    private SelenideElement email = $(By.id("email"));

    public void enterEmail(String emailValue) {
        email.shouldBe(Condition.visible).setValue(emailValue);
    }

    private SelenideElement content = $(By.id("content"));

    public void enterContent(String messageValue) {
        content.shouldBe(Condition.visible).setValue(messageValue);
    }

    private SelenideElement buttonSendMessage = $("[type=\"submit\"]");

    public void clickOnButtonSendMessage() {
        buttonSendMessage.shouldBe(Condition.visible).click();
    }

    private SelenideElement textSussesfulMessageSending = $("[class=\"success-message\"]");

    public void textOfTheSuccesfullSendingMessage(String textSussesfullValue) {
        textSussesfulMessageSending.shouldBe(Condition.visible).shouldHave(text(textSussesfullValue));
    }

    // несоответствие ожидаемого названия Content с актуальным  Message
    private SelenideElement textFieldContent = $("[placeholder=\"Message\"]");

    public void checkTextContent(String textValue) {
        textFieldContent.shouldHave(Condition.attribute("placeholder", textValue));
    }

    public void unSuccessfuiiSending(String messageValue){
        textSussesfulMessageSending.shouldNotHave(text(messageValue));

    }
    // Заполните это поле ( "This value should't be blank")

    public void emptyFieldErrorMessage() {
        name.shouldHave(Condition.attributeMatching("validationMessage","This value should't be blank"));
    }


}
