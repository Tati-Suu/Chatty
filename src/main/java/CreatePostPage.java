import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CreatePostPage {
    private SelenideElement title = $("[name=\"title\"]");
    public void enterTitle(String titleValue){
        title.shouldBe(visible).setValue(titleValue);
    }
    //Description

    private SelenideElement description = $("input[data-test='description-input']");
    public void enterDescription(String descriptionValue){
        description.shouldBe(visible).setValue(descriptionValue);
    }
    //Content

    private SelenideElement content = $("[name=\"content\"]");
    public void enterContent(String contentValue){
        content.shouldBe(Condition.visible).setValue(contentValue);
    }

    private SelenideElement submitButton = $(By.xpath("//button[@data-test='submit']"));
    public void clickSubmitButton(){
        submitButton.shouldBe(Condition.visible).click();
    }

    private ElementsCollection myPosts = $$("h3");
    public void checkCreatedPost(String titleValue) {
        myPosts.filter(visible).findBy(Condition.text(titleValue)).shouldBe(Condition.visible);
       // myPosts.filter(visible).shouldHave(CollectionCondition.texts(titleValue));
    }
//    public void emptyFieldErrorMessage() {
//        name.shouldHave(Condition.attributeMatching("validationMessage","This value should't be blank"));
//    }




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
