import com.codeborne.selenide.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class HeaderPage {

    // Проверка наличия в хэдэре Home About Contact
    private SelenideElement navigationPanel = $("[class=\"header__nav-list\"]");
    public void navPanelIsDisplayed(String navPanelText){
        navigationPanel.shouldBe(visible).shouldHave(text(navPanelText)).click();
    }

    private SelenideElement linkHome = $(byXpath("//*[text()='Home']"));
    public void clickOnHome() {
        linkHome.shouldBe(visible).click();
    }
    private SelenideElement linkAbout = $(byXpath("//*[text()='About']"));
    public void clickOnAbout() {
        linkAbout.shouldBe(visible).click();
    }
    private SelenideElement linkContact = $("[href=\"/contact\"]");
    public void clickOnContactHeader(){
        linkContact.shouldBe(Condition.visible).click();
    }
    //подтверждение,что мы находимся на странице About
    private SelenideElement aboutUsPage = $(byXpath("//*[@id=\"root\"]/div[2]/div/div/h1"));
    public void namePageAboutUs(String namePageAboutValue){
        aboutUsPage.shouldBe(visible).shouldHave(text(namePageAboutValue));
    }

    private SelenideElement linkLogout = $(byXpath("//*[@href='/login']"));
    public void clickOnLogoutDropdown(){
        linkLogout.shouldBe(visible).click();
    }

    private SelenideElement linkDraft = $(byXpath("//*[@href='/draft']"));
    public void clickOnLinkDraft(){
        linkDraft.shouldBe(visible).click();
    }

    private SelenideElement yourLinkProfile = $(byXpath("//*[@href='/userprofile']"));
    public void clickOnLinkProfile(){
        yourLinkProfile.shouldBe(visible).click();
    }

    // наведение мышью на элемент
    private SelenideElement headerUser = $("[class=\"header__user header__menu\"]");
    public HeaderPage hoverDropdownMenu() {
        headerUser.hover(); // Наведение на элемент
        return this;
    }
}
