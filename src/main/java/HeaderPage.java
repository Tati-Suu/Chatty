import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class HeaderPage {
    private SelenideElement linkHome = $(byXpath("//*[text()='Home']"));

    public void clickOnHome() {
        linkHome.shouldBe(visible).click();
    }

    private SelenideElement lincAbout = $(byXpath("//*[text()='About']"));

    public void clickOnAbout() {
        lincAbout.shouldBe(visible).click();
    }
    private SelenideElement buttonContact = $("[href=\"/contact\"]");
    public void clickOnContactHeader(){
        buttonContact.shouldBe(Condition.visible).click();
    }



}
