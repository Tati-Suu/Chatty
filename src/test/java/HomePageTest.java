import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageTest extends BaseTest{
    private HomePage homePage;

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        open("http://chatty.telran-edu.de:8089/login");

        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail("hirsch.mariia@icloud.com")
                .enterPassword("Blabla2024!")
                .clickButton();
        homePage = new HomePage();
    }

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
        assertEquals(0, numberOfInputs, "The post title search field should not be present.");
        //The test passed because the parameters specified searching by attributes and the input element, and there were no matches for the post title search.
        //Тест прошел потому чт в параметраз указала по поиску по атрибутам и инпут элементу что совпадаений для поиска постов по названию нет.

        //int numberOfInputs = $$("input").filterBy(attribute("name", "postTitleSearch")).size();
       // assertTrue(numberOfInputs > 0, "The post title search field should be present, but it is missing.");
    }
    @Test
    public void verifySimilarPostsButtonIsAbsent() {
        homePage.clickPostsToggle();
        homePage.clickFirstPost();
        sleep(5000);
        int numberOfButtons = $$("button").filterBy(attribute("data-test", "similar-posts")).size();
        assertEquals(0, numberOfButtons, "The 'Similar Posts' button should not be present.");
    }
}
