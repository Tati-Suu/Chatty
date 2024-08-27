import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Double.parseDouble;
import static java.util.Collections.reverseOrder;
import static java.util.Collections.sort;

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

    // Check the number of posts in a Homepage
    private ElementsCollection elementsPost = $$("[class=\"post\"]");
    public void checkPostsNumber(int expectedMaxSize) {  // сколько мы ожидаем увидеть постов(не более 4)
        elementsPost.first().shouldBe(Condition.visible); // ждем, пока первый элемент станет видимым
        elementsPost.shouldHave(CollectionCondition.sizeLessThanOrEqual(expectedMaxSize)); //LessThanOrEqual
    }


    //Проверяем,что наши даты отсортированы от новой даты к старой
//    public boolean allDateIsDisplayed() {      // проверяем, что все date отображаются
//        boolean displayed = true;
//        for (WebElement elementDate : listOfDates) {// если везде заполнены заголовки, то тру
//            if (!elementDate.isDisplayed()) {    // если хотя бы в одном отсутствует - фолс
//                displayed = false;
//            }
//        }
//        return displayed;
//    }


    private ElementsCollection listOfDates = $$(".post-content__top p");  //коллекция
    public boolean checkDateSortFromHighToLow() {
       listOfDates.get(0).shouldBe(Condition.visible);
        for (SelenideElement dateElem:listOfDates) {
            System.out.println(dateElem.getText());
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMANY);
        List<Date> actualDates = new ArrayList<>();
        for (SelenideElement dateElement : listOfDates) {
            String dateText = dateElement.getText();
            try {
                Date parsedDate = formatter.parse(dateText);
                actualDates.add(parsedDate);
            }catch(ParseException e) {
                e.printStackTrace();  // Обрабатываем исключение, если дата не может быть распознана
            }

        }
        List<Date> expectedDates = new ArrayList<>(actualDates);
        expectedDates.sort(Collections.reverseOrder());//  меняем на обратную сортировку,параметр при сортировке - reverseOrder для обратного прядка
        return actualDates.equals(expectedDates);

    }

}
