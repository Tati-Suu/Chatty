import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    private SelenideElement myPostsToggle = $x("//label[@for='myPostsId']"); //PAGE HOME
    public void buttonMyPostIsVisible(String myPostValue){
       myPostsToggle.shouldBe(Condition.visible).shouldHave(Condition.text(myPostValue));

    }

}
