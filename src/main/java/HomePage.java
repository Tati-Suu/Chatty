import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {


    private SelenideElement postSection = $x("//[@class='posts__section']");
    private SelenideElement postCreationButton = $x("//[@data-test='post-headerplus']");
    private SelenideElement titleEditBox = $x("//[@name='title']");
    private SelenideElement descriptionEditBox = $x("//[@placeholder='Description']");
    private SelenideElement contentEditBox = $x("//[@name='content']");
    private SelenideElement saveAsDraftToggle = $x("//label[@for='draftCheckbox']");
    private SelenideElement submitPostButton = $x("//[@data-test='submit']");
    private SelenideElement myPostsToggle = $x("//label[@for='myPostsId']");
    private SelenideElement firstPost = $x("//div[@data-test='post']");

    private SelenideElement createPostPlusButton = $x("//span[@data-test='post-header__plus']");


    public HomePage clickPostsToggle() {
        myPostsToggle.shouldBe(Condition.enabled).click();
        return this;
    }

    public String getMyPostsToggleText() {
        return myPostsToggle.shouldBe(Condition.visible).getText();
    }

    public HomePage clickFirstPost() {
        firstPost.shouldBe(Condition.visible).click();
        return this;
    }
    public void clickCreatePostPlusButton(){
        createPostPlusButton.shouldBe(Condition.visible).click();
    }

    // Check number of post in Home page
    private ElementsCollection elementsPost = $$("[class=\"post\"]");
    public void checkPostsNumber(int expectedMaxSize) {  // сколько мы ожидаем увидеть постов(не более 4)
        elementsPost.first().shouldBe(Condition.visible); // ждем, пока первый элемент станет видимым
        elementsPost.shouldHave(CollectionCondition.size(expectedMaxSize)); //LessThanOrEqual
    }


}
