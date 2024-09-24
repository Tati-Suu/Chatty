import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.*;
import java.time.Duration;
import java.util.Objects;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class DraftPage {
    private SelenideElement draft = $("[class=\"post-header__feed\"]");
    public void draftPageIsVisible(String draftValue) {
        draft.shouldBe(visible).shouldHave(text(draftValue));
    }
    private ElementsCollection postTitles = $$("div.posts__section div.post[data-test='post']");
    private ElementsCollection draftPosts = $$("div.draft__posts > div.post > div.post-content > div.post-content__top > h3");
    public void loadAllPosts() {
        while (true) {
            Long initialHeight = executeJavaScript("return document.body.scrollHeight");
            executeJavaScript("window.scrollTo(0, arguments[0])", initialHeight);
            Long newHeight = executeJavaScript("return document.body.scrollHeight");
            if (Objects.equals(newHeight, initialHeight)) {
                break;
            }
        }
    }
    public void checkPostNotPresent(String postTitle) {
        loadAllPosts();
        postTitles.filterBy(text(postTitle)).shouldBe(size(0));
    }
    public void checkDraftVisible(String draftTitle) {
        loadAllPosts();
        System.out.println("===================== Check Draft!!!" + draftPosts.size());

        final int count = draftPosts.size(); // extract to evaluate once only
        for (int i=0; i<count; i++) {
            System.out.println("Post: --> " + draftPosts.get(i).getText());
        }

        draftPosts.filterBy(text(draftTitle)).shouldBe(sizeGreaterThan(0)); //черновики видно по названию делаю поиск
    }
    // Сам тумблер
    private SelenideElement draftCheckboxLabel = $("label[for='draftCheckbox']");
    // Переключила тумблер "Save as a draft"
    public void toggleSaveAsDraft() {
        draftCheckboxLabel.click(); // Кликаем на метку, чтобы переключить чекбокс
    }
    // проверяем что тумблер включен на позицию черновика
    public void checkDraftToggleIsOn() {
        boolean test = $("#draftCheckbox").isSelected();
        System.out.println("TEST: " + test);
    }
    private SelenideElement dateDraft = $(By.id("publishDate"));
    public void setDate(String dateValue) {
        //устанавливаем дату
        dateDraft.setValue(dateValue);
    }
    private SelenideElement draftsLink = $("a.menu-item[href='/draft']");
    public void clickOnDraftsLink() {
        draftsLink.shouldBe(Condition.visible, Duration.ofSeconds(10));
        draftsLink.click();
    }

}