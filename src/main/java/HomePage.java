import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage {



    private SelenideElement myPostsToggle = $x("//label[@for='myPostsId']");
    private SelenideElement firstPost = $x("//div[@data-test='post']");


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
}
