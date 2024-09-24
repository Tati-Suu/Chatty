import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreatePostPage {
    //title
    private SelenideElement title = $("input[data-test='title-input']");
    public void enterTitle(String titleValue) {
        title.shouldBe(visible).setValue(titleValue);
    }
    //Description
    private SelenideElement description = $("input[data-test='description-input']");
    public void enterDescription(String enterDescriptionText) {
        description.shouldBe(visible).setValue(enterDescriptionText);
    }
    //Content
    private SelenideElement content = $("[name=\"content\"]");
    public void enterContent(String contentValue) {
        content.shouldBe(Condition.visible).setValue(contentValue);
    }
    //submitButton
    private SelenideElement submitButton = $(By.xpath("//button[@data-test='submit']"));
    public void clickSubmitButton() {
        submitButton.shouldBe(Condition.visible).click();
    }
    private SelenideElement divImage = $("[role=\"presentation\"]");
    public void checkTextFieldImage(String textValue) {
        divImage.shouldHave(Condition.text(textValue));
    }
    //Элементы коллекции названий моих постов
    private ElementsCollection myPosts = $$("h3");
    public void checkCreatedPost(String titleValue) {
        myPosts.filter(visible).findBy(Condition.text(titleValue)).shouldBe(Condition.visible);
    }
    //Проверяум по тексту , что перешли на страницу создания постов
    private SelenideElement textSaveAsADraft = $("[for=\"draftCheckbox\"]");
    public void createPostPageIsDisplayed(String tumblerText) {
        textSaveAsADraft.shouldBe(visible).shouldHave(text(tumblerText));
    }
    // Ожидаем, что сообщение об ошибке  появится: 100 symbols max
    public void checkErrorMessageNotDisplayed(String expectedErrorText) {
        $(byText(expectedErrorText)).shouldHave(Condition.exist);
    }
    //Cut text to 100 character

    public void checkCutDescription(String longDescriptionText) {
        enterDescription(longDescriptionText);
        String actualText = description.getValue();
        String expectedText = longDescriptionText.length() > 100 ? longDescriptionText.substring(0, 100) : longDescriptionText; //descriptionText.substring(0,Math.min(100,descriptionText.length()));// trimo 100 simbols
        assertEquals(expectedText, actualText);
    }
    //Cut text to 100 character
    public void checkCutContent(String longContentText) {
        enterContent(longContentText);
        String actualText = content.getValue();
        String expectedText = longContentText.length() > 1000 ? longContentText.substring(0, 1000) : longContentText; //descriptionText.substring(0,Math.min(100,descriptionText.length()));// trimo 100 simbols
        assertEquals(expectedText, actualText);
    }
    public void checkCutTitle(String longTitleText) {
        enterTitle(longTitleText);
        String actualText = title.getValue();
        String expectedText = longTitleText.length() > 40 ? longTitleText.substring(0, 40) : longTitleText; //descriptionText.substring(0,Math.min(100,descriptionText.length()));// trimo 100 simbols
        assertEquals(expectedText, actualText);
    }
    // Проверяем, что форма для созднания поста содержит элементы Title, Description,Content,Delay, Ppost is draft, New image
    public void checkTextTitle(String textValue) {
        title.shouldHave(Condition.attribute("placeholder", textValue));
    }

    public void checkTextDescription(String textValue) {
        description.shouldHave(Condition.attribute("placeholder", textValue));
    }
    public void checkTextContent(String textValue) {
        content.shouldHave(Condition.attribute("placeholder", textValue));
    }
    public void checkTextDraft(String textValue) {
        textSaveAsADraft.shouldHave(Condition.text(textValue));
    }
    //Проверка дат для черновика: нельзя сегодня или прошедшую дату
    private SelenideElement dateDraft = $(By.id("publishDate"));
    public void setDate(String dateValue) {      //устанавливаем дату
        dateDraft.setValue(dateValue);
    }
    public void checkInvalidDate() {
        String currentDate = dateDraft.getValue();
        LocalDate parseDate = LocalDate.parse(currentDate);

        if (!parseDate.isAfter(LocalDate.now())) {
            dateDraft.shouldHave(text("The date should not be current or earlier date."));
        }
    }
    // Поле Image
    //Загрузка картинки более 2 Мв
    private SelenideElement uploadImage = $("input[type='file']");
    public void uploadImageInField(File file){
        uploadImage.uploadFile(file);
    }
    // Проверка текта ошибки при загрузке большого файла
    private SelenideElement errorMessage = $("[class=\"post_error_message__FQTrb\"]");
    public void checkTextErrorMessage(String errorText){
        errorMessage.shouldBe(visible).shouldHave(text(errorText));
    }


}
