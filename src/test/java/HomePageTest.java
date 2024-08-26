import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        homePage.checkPostsNumber(4);
        sleep(7000);
    }
}
