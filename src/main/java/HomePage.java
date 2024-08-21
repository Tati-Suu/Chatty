import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

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
    private SelenideElement postPhoto = $x("//[@src='https://chatty-images-s3.s3.eu-central-1.amazonaws.com/a2475ea7-7d39-446c-90b1-c7a1514ae04d/d169afc8-9c41-4516-87df-bb882d9057b3.jpeg']");
    private SelenideElement postDescription = $x("//[@class='postdescription']");
    private SelenideElement postCreateButton = $x("//span[@data-test='post-header__plus']");
    private SelenideElement firstPost = $x("//div[@data-test='post']");


    public boolean isPostSectionDisplayed() {
        return postSection.shouldBe(Condition.visible).isDisplayed();
    }

    public HomePage clickPostCreationButton() {
        postCreationButton.shouldBe(Condition.enabled).click();
        return this;
    }

    public HomePage fillInTitleEditBox(String title) {
        titleEditBox.setValue(title);
        return this;
    }

    public HomePage fillInDescriptionEditBox(String description) {
        descriptionEditBox.setValue(description);
        return this;
    }

    public HomePage fillInContentEditBox(String content) {
        contentEditBox.setValue(content);
        return this;
    }

    public HomePage clickOnSaveAsDraftToggle() {
        saveAsDraftToggle.click();
        return this;
    }

    public HomePage clickOnSubmitPostButton() {
        submitPostButton.shouldBe(Condition.enabled).click();
        return this;
    }

    public HomePage clickPostsToggle() {
        myPostsToggle.shouldBe(Condition.enabled).click();
        return this;
    }

    public String getMyPostsToggleText() {
        return myPostsToggle.shouldBe(Condition.visible).getText();
    }

    public HomePage clickCreatePostPlusButton() {
        postCreateButton.click();
        return this;
    }
    public HomePage clickFirstPost() {
        firstPost.shouldBe(Condition.visible).click();
        return this;
    }
}
