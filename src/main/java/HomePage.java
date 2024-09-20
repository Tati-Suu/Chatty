import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    private SelenideElement myPostsToggle = $x("//label[@for='myPostsId']");
    private SelenideElement firstPost = $x("//div[@data-test='post']");

    private SelenideElement createPostPlusButton = $x("//span[@data-test='post-header__plus']");


    public HomePage clickPostsToggle() {
        myPostsToggle.shouldBe(Condition.enabled).click();
        return this;
    }

    public String getMyPostsToggleText() {
        return myPostsToggle.shouldBe(visible).getText();
    }

    public HomePage clickFirstPost() {
        firstPost.shouldBe(visible).click();
        return this;
    }

    public void clickCreatePostPlusButton(){
        createPostPlusButton.shouldBe(visible).click();
    }

    // Check the number of posts in a Homepage
    private ElementsCollection elementsPost = $$("[class=\"post\"]");
    public void checkPostsNumber(int expectedMaxSize) {  // сколько мы ожидаем увидеть постов(не более 4)
        elementsPost.first().shouldBe(visible); // ждем, пока первый элемент станет видимым
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
        listOfDates.get(0).shouldBe(visible);
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