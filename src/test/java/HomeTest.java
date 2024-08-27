import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeTest extends BaseTest{


//    @BeforeEach
//    public void setUp() {
//        Configuration.browser = "chrome";
//        Configuration.browserSize = "1920x1080";
//        open("http://chatty.telran-edu.de:8089/login");
//
//        loginPage.enterEmail("hirsch.mariia@icloud.com")
//                .enterPassword("Blabla2024!")
//                .clickButton();
//        homePage = new HomePage();
//    }

    @Test
    public void verifyToggleMyPostsLabelTest() {
        homePage.clickPostsToggle();
        String actualErrorMessage = homePage.getMyPostsToggleText();
        String expectedErrorMessage = "See my Posts";
        sleep(5000);
        assertEquals(expectedErrorMessage, actualErrorMessage, "Wrong Toggle Name");
    }

    @Test
    public void verifyPostTitleSearchFieldIsAbsent() {
        sleep(5000);
        int numberOfInputs = $$("input").filterBy(attribute("name", "postTitleSearch")).size();
        assertEquals(numberOfInputs > 0, "The post title search field should be present, but it is missing.");
    }
    @Test
    public void verifySimilarPostsButtonIsAbsent() {
        homePage.clickPostsToggle();
        homePage.clickFirstPost();
        sleep(5000);
        int numberOfButtons = $$("button").filterBy(attribute("data-test", "similar-posts")).size();
        assertEquals(numberOfButtons > 0, "The 'Similar Posts' button should be present, but it is missing.");
    }


    //check number of posts on page// количество постов на странице не 4
    @Test
    public void checkNumberPosts(){
        loginPage.login("ghjk2@gmail.com","cat2016!");
      homePage.checkPostsNumber(4);
    }

    // сортировка на странице Home всех постов по дате от новой к старой - верно!

    @Test
    public void checkPostsSortedByDate() {
        loginPage.login("ghjk2@gmail.com", "cat2016!");
        assertTrue(homePage.checkDateSortFromHighToLow());

    }

    // Сортировка на странице My Posts  по дате от новой к старой - не верно!
    @Test
    public void checkMyPostsSortedByDate() {
        loginPage.login("ghjk2@gmail.com", "cat2016!");
        homePage.clickPostsToggle();
        assertTrue(homePage.checkDateSortFromHighToLow());

    }

}
