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
        createPostPage.enterTitle(randomTitle);
        createPostPage.enterDescription(randomDescription);
        createPostPage.enterContent(randomContent);
        draftPage.setDate("05.09.2024");
        draftPage.toggleSaveAsDraft();
        draftPage.checkDraftToggleIsOn();
        createPostPage.clickSubmitButton();
        createPostPage.createPostPageIsDisplayed("Save as a draft");
        draftPage.clickOnDraftsLink();
        draftPage.draftPageIsVisible("My drafts");
        draftPage.checkDraftVisible(randomTitle); //чекнула что есть в черновиках пост

        headerPage.clickOnHome();
        sleep(2000); //проходит тоже через раз
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