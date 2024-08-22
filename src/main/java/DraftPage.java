import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DraftPage {
    private SelenideElement draft = $("[class=\"post-header__feed\"]");
    public void draftPageIsVisible(String draftValue){
        draft.shouldBe(Condition.visible).shouldHave(Condition.text(draftValue));
    }

}
