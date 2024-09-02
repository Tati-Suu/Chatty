import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class DraftPage {


    private SelenideElement draft = $("[class=\"post-header__feed\"]");
    public void draftPageIsVisible(String draftValue) {
        draft.shouldBe(visible).shouldHave(text(draftValue));
    }


    private ElementsCollection postTitles = $$("div.posts__section div.post[data-test='post']"); // коллекция для опубликованных постов, вроде сработало верно ,перебирает все посты со скроллом
    private ElementsCollection draftTitles = $$("div[data-test='draft-posts'] div[data-test='post']"); // так же коллекция для черновиков
    // private SelenideElement dateInput = $("input[type='date'][name='publishDate']");



    public void loadAllPosts() {
        while (true) {
            Long initialHeight = executeJavaScript("return document.body.scrollHeight");
            executeJavaScript("window.scrollTo(0, arguments[0])", initialHeight);
            sleep(2000); //тупило все, поэтому эдднула слип
            Long newHeight = executeJavaScript("return document.body.scrollHeight");

            if (Objects.equals(newHeight, initialHeight)) {
                break; // для того что бы когда закончились посты скроллить не надо больше
            }
        }
    }

    public void checkPostNotPresent(String postTitle) {
        loadAllPosts();
        postTitles.filterBy(text(postTitle)).shouldBe(size(0)); // пост не отображается в опубликованных, вот тут вопросы, на этом методе должно валиться, вроде и сайз поставила ноль, а он все равно проходит!
    }

    public void checkDraftVisible(String draftTitle) {
        loadAllPosts();
        draftTitles.filterBy(text(draftTitle)).shouldBe(sizeGreaterThan(0)); //черновики видно по названию делаю поиск
    }

    // Сам тумблер
    private SelenideElement draftCheckboxLabel = $("label[for='draftCheckbox']");

    // Переключила тумблер "Save as a draft"
    public void toggleSaveAsDraft() {
        draftCheckboxLabel.click(); // Кликаем на метку, чтобы переключить чекбокс
    }

    // проверяем что тумблер включен на позицию черновика
    public void checkDraftToggleIsOn() {
        $("#draftCheckbox").shouldBe(Condition.selected);
    }

    private SelenideElement dateDraft = $(By.id("publishDate"));
    public void setDate(String dateValue) {
        //устанавливаем дата
        dateDraft.setValue(dateValue);
    }

    private SelenideElement draftsLink = $("a.menu-item[href='/draft']");
    public void clickOnDraftsLink() {
        draftsLink.shouldBe(Condition.visible, Duration.ofSeconds(10)); // эдднула дьюрейшн для указания таймаута
        draftsLink.click(); // Добавила клик потому что с другими селекторами и методами у меня не сработало почему-то
    }

}