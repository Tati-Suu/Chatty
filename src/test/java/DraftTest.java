import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class DraftTest extends BaseTest {
    @Test
    public void draftVisibleInDrafts() {
        Faker faker = new Faker();
        String randomTitle = faker.book().title();
        String randomDescription = faker.lorem().sentence();
        String randomContent = faker.lorem().paragraph();


        loginPage.login("hirsch.mariia@icloud.com","Blabla2024!!");
        homePage.clickCreatePostPlusButton();
        sleep(1000);
        createPostPage.enterTitle(randomTitle);
        createPostPage.enterDescription(randomDescription);
        createPostPage.enterContent(randomContent);
        sleep(1000);
        draftPage.setDate("05.09.2024");
        draftPage.toggleSaveAsDraft();
        sleep(1000);
        draftPage.checkDraftToggleIsOn();
        sleep(1000);
        createPostPage.clickSubmitButton();



        sleep(2000);
        draftPage.clickOnDraftsLink();
        sleep(3000);

        draftPage.draftPageIsVisible("My drafts");
        draftPage.checkDraftVisible(randomTitle);
        sleep(5000);
    }
    @Test
    public void draftNotVisibleInPublishedFeeds() {
        Faker faker = new Faker();
        String randomTitle = faker.book().title();
        String randomDescription = faker.lorem().sentence();
        String randomContent = faker.lorem().paragraph();


        loginPage.login("hirsch.mariia@icloud.com","Blabla2024!!");
        homePage.clickCreatePostPlusButton();
        createPostPage.enterTitle(randomTitle);
        createPostPage.enterDescription(randomDescription);
        createPostPage.enterContent(randomContent);
        draftPage.setDate("05.09.2024");
        draftPage.toggleSaveAsDraft();
        draftPage.checkDraftToggleIsOn();
        createPostPage.clickSubmitButton();



        headerPage.clickOnHome();
        homePage.clickPostsToggle();
        sleep(2000);
        draftPage.checkPostNotPresent(randomTitle); //валится через раз

    }
}