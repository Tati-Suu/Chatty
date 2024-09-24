import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class DraftTest extends BaseTest {
    @Test
    public void draftVisibleInDrafts() {
        Faker faker = new Faker();
        String randomTitle = faker.book().title();
        String randomDescription = faker.lorem().sentence();
        String randomContent = faker.lorem().paragraph();
        loginPage.login("hirsch.mariia@icloud.com","NewOne!!01");
        homePage.clickCreatePostPlusButton();
        createPostPage.enterTitle(randomTitle);
        createPostPage.enterDescription(randomDescription);
        createPostPage.enterContent(randomContent);
        draftPage.setDate("05.09.2024");
        draftPage.toggleSaveAsDraft();
        draftPage.checkDraftToggleIsOn();
        createPostPage.clickSubmitButton();
        draftPage.clickOnDraftsLink();

        draftPage.draftPageIsVisible("My drafts");
        draftPage.checkDraftVisible(randomTitle);
    }
    @Test
    public void draftNotVisibleInPublishedFeeds() {
        Faker faker = new Faker();
        String randomTitle = faker.book().title();
        String randomDescription = faker.lorem().sentence();
        String randomContent = faker.lorem().paragraph();
        loginPage.login("hirsch.mariia@icloud.com","NewOne!!01");
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
        draftPage.checkPostNotPresent(randomTitle);

    }
}