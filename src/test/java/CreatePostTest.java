import org.junit.jupiter.api.Test;

public class CreatePostTest extends BaseTest{

    //Создание поста с валидными значениями
    @Test
    public void CreatePost(){
        loginPage.enterEmail("ghjk2@gmail.com");
        loginPage.enterPassword("cat2016!");
        loginPage.clickButton();
        homePage.clickCreatePostPlusButton();
        createPostPage.enterTitle("Moon");
        createPostPage.enterDescription("Night");
        createPostPage.enterContent("The moon is beautiful!");
        createPostPage.clickSubmitButton();
        homePage.clickPostsToggle();
        createPostPage.checkCreatedPost("Moon");
    }

}
