import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class UserProfileEditPage {

    private SelenideElement editButtonPlus = $("[data-test='post-header__plus']");
    private SelenideElement sideBarLeftSection = $x("//*[@class='sidebar__section']");
    private SelenideElement suggestionsSection = $x("//*[@class='suggestions__section']");
    private SelenideElement nameField = $x("//input[@name='name']");
    private SelenideElement surnameField = $x("//input[@name='surname']");
    private SelenideElement genderField = $("select[data-test='profileGender']");
    private SelenideElement birthDateField = $("#birthDate");
    private SelenideElement phoneField = $x("//input[@name='phone']");
    private SelenideElement changePassButton = $x("//button[@type='button']");
    private SelenideElement saveButton = $x("//button[@type='submit']");
    private SelenideElement headerEditCancelWordNearButtonPlus = $x("//*[@class='post-header__plus-box']");
    private SelenideElement userAvatarUploededPhoto = $x("//img[@data-test='uploaded-image']");
    private SelenideElement profileEmailUnderAvatar = $x("//p[@data-test='profileEmail']");
    private SelenideElement userMenu = $x("//p[contains(text(), 'Hello,')]");
    private SelenideElement profileLink = $x("//a[@href='/userprofile' and text()='Your Profile']");
    private SelenideElement visibleProfilePage = $x("//a[@href='/userprofile' and text()='Your Profile']");
    private SelenideElement toggleMyPostsLabel = $("label[for='myPostsId']");
    private SelenideElement firstPost = $x("(//div[@class='post-card'])[1]");
    private SelenideElement postTitle = $x("//input[@name='postTitle']");
    private SelenideElement postContent = $x("//textarea[@name='postContent']");

    public SelenideElement getEditButtonPlus() {
        return editButtonPlus;
    }
    public SelenideElement getSideBarLeftSection() {
        return sideBarLeftSection;
    }
    public SelenideElement getSuggestionsSection() {
        return suggestionsSection;
    }
    public SelenideElement getNameField() {
        return nameField;
    }
    public SelenideElement getSurnameField() {
        return surnameField;
    }
    public SelenideElement getGenderField() {
        return genderField;
    }
    public SelenideElement getBirthDateField() {
        return birthDateField;
    }
    public SelenideElement getPhoneField() {
        return phoneField;
    }
    public SelenideElement getChangePassButton() {
        return changePassButton;
    }
    public SelenideElement getSaveButton() {
        return saveButton;
    }
    public SelenideElement getUserMenu() {
        return userMenu;
    }
    public SelenideElement getProfileLink() {
        return profileLink;
    }
    public SelenideElement getVisibleProfilePage() {
        return visibleProfilePage;
    }
    public SelenideElement getToggleMyPostsLabel() {
        return toggleMyPostsLabel;
    }
    public SelenideElement getFirstPost() {
        return firstPost;
    }

    public SelenideElement getPostTitle() {
        return postTitle;
    }

    public SelenideElement getPostContent() {
        return postContent;
    }

}
