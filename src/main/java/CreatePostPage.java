import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreatePostPage {
    //title
    private SelenideElement title = $("[data-test=\"title-input\"]");

    public void enterTitle(String titleValue) {
        title.shouldBe(visible).setValue(titleValue);
    }

    //Description
    private SelenideElement description = $("input[data-test='description-input']");
    public void enterDescription(String enterDescriptionText){
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

    //Элементы коллекции названий моих постов
    private ElementsCollection myPosts = $$("h3");

    public void checkCreatedPost(String titleValue) {
        myPosts.filter(visible).findBy(Condition.text(titleValue)).shouldBe(Condition.visible);
    }

    //Проверяум по тексту , что перешли на страницу создания постов
    private SelenideElement textSaveAsADraft = $("[for=\"draftCheckbox\"]");

    public void creanePostPageIsDisplayed(String tumblerText) {
        textSaveAsADraft.shouldBe(visible).shouldHave(text(tumblerText));
    }

    // Проверяем, что форма для созднания поста содержит элементы Title, Description,Content,Delay, Ppost is draft, New image
    //1
    private SelenideElement nameElementCreatePostForm = $("[class=\"post-form\"]");
    List<String> expectedElements = Arrays.asList("Title", "Description", "Content", "Delay ppost to", "New image");

    public void checkNameElemForm() {
        nameElementCreatePostForm.shouldBe(visible);
        for (String elemText : expectedElements) {
            nameElementCreatePostForm.$(byText(elemText)).shouldBe(visible);
        }
    }
    //2
    public void checkElementsInPostForm() {
        nameElementCreatePostForm.shouldBe(visible);
        nameElementCreatePostForm.$(byText("Title")).shouldBe(visible);
//        nameElementCreatePostForm.$(byText("Description")).shouldBe(visible);
//        nameElementCreatePostForm.$(byText("Content")).shouldBe(visible);
//        nameElementCreatePostForm.$(byText("Delay ppost to")).shouldBe(visible);
//        nameElementCreatePostForm.$(byText("New image")).shouldBe(visible);
    }

    // Ожидаем, что сообщение об ошибке  появится: 100 symbols max
    public void checkErrorMessageNotDisplayed(String expectedErrorText) {

        $(byText(expectedErrorText)).shouldHave(Condition.exist);
    }


//    public void invalidBigDescription(String messageText) {
//        nameElementCreatePostForm.shouldHave(Condition.attributeMatching("validationMessage", "This value should't be blank"));
//    }

    //Cut text to 100 character

    public void checkCutDescription(String longDescriptionText) {
        enterDescription(longDescriptionText);
        String actualText = description.getValue();
        String expectedText = longDescriptionText.length() >100 ? longDescriptionText.substring(0,100): longDescriptionText; //descriptionText.substring(0,Math.min(100,descriptionText.length()));// trimo 100 simbols
        assertEquals(expectedText, actualText);
    }

    //Cut text to 100 character

    public void checkCutContent(String longContentText) {
        enterContent(longContentText);
        String actualText = content.getValue();
        String expectedText = longContentText.length() >1000 ? longContentText.substring(0,1000): longContentText; //descriptionText.substring(0,Math.min(100,descriptionText.length()));// trimo 100 simbols
        assertEquals(expectedText, actualText);
    }






//    //прозрачный текст в поле Content
//    private SelenideElement paleTextContent = $("placeholder=\"My thoughts. No more than 1000 characters\"");
//
//    placeholder:"My thoughts. No more than 1000 characters"
//    private SelenideElement textFieldContent = $("[placeholder=\"Message\"]");
//
//    public void checkTextContent(String textValue) {
//        textFieldContent.shouldHave(Condition.attribute("placeholder", textValue));
//    }


    // Photo
//    private SelenideElement imageField = $(By.className(".post_uploaded_image__7qSWV"));
//    public void loadImege(String filePath){   //путь к файлу
//        imageField.shouldBe(Condition.visible).uploadFile(new File(filePath));
//    }


}
