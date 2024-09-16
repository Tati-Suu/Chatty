import org.junit.jupiter.api.Test;

import java.io.File;

public class CreatePostTest extends BaseTest {

    //Создание поста с валидными значениями
    @Test
    public void createPost() {
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

    @Test
    public void createPostPageIsDisplayed() {
        loginPage.enterEmail("ghjk2@gmail.com");
        loginPage.enterPassword("cat2016!");
        loginPage.clickButton();
        homePage.clickCreatePostPlusButton();
        createPostPage.createPostPageIsDisplayed("Save as a draft");
    }

    //Проверка названий элементов формы создания поста.Check if the field names in the post creation form match
    @Test
    public void checkNameFieldTitle() {
        loginPage.login("ghjk2@gmail.com", "cat2016!");
        homePage.clickCreatePostPlusButton();
        createPostPage.checkTextTitle("Title");
    }

    @Test
    public void checkNameFieldDescription() {
        loginPage.login("ghjk2@gmail.com", "cat2016!");
        homePage.clickCreatePostPlusButton();
        createPostPage.checkTextDescription("Description");
    }

    // Ожидали название поля Content,а стоит: My thoughts. No more than 1000 characters
    @Test
    public void checkNameFieldContent() {
        loginPage.login("ghjk2@gmail.com", "cat2016!");
        homePage.clickCreatePostPlusButton();
        createPostPage.checkTextContent("Content");
    }

    @Test
    public void checkNameFieldImage() {
        loginPage.login("ghjk2@gmail.com", "cat2016!");
        homePage.clickCreatePostPlusButton();
        createPostPage.checkTextFieldImage("New image");
    }

    @Test
    public void checkNameFieldDrafts() {
        loginPage.login("ghjk2@gmail.com", "cat2016!");
        homePage.clickCreatePostPlusButton();
        createPostPage.checkTextDraft("Post is draft");
    }

    // Field Description have more than 100 chracters. no error text 100 symbols max"
    @Test
    public void bigDescription() {
        loginPage.enterEmail("ghjk2@gmail.com");
        loginPage.enterPassword("cat2016!");
        loginPage.clickButton();
        homePage.clickCreatePostPlusButton();
        createPostPage.enterTitle("Soon");
        createPostPage.enterDescription("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean ma");
        createPostPage.enterContent("The moon is beautiful!");
        createPostPage.clickSubmitButton();
        createPostPage.checkErrorMessageNotDisplayed("100 symbols max");

    }

    //Проверка обрезки текста до 100 ссимволов/Текст не обрезается
    @Test
    public void checkCutTitleText() {
        loginPage.login("hirsch.mariia@icloud.com", "Blabla2024!!");
        homePage.clickCreatePostPlusButton();
        createPostPage.enterDescription("Soon");
        createPostPage.enterContent("The moon is beautiful!");
        createPostPage.checkCutTitle("Lorem ipsum dolor sit amet,consectetuer adipiscing elit.");
        createPostPage.clickSubmitButton();
    }

    @Test
    public void checkCutDescriptionText() {
        loginPage.login("ghjk2@gmail.com", "cat2016!");
        homePage.clickCreatePostPlusButton();
        createPostPage.enterTitle("Soon");
        createPostPage.enterContent("The moon is beautiful!");
        createPostPage.checkCutDescription("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean ma");
        createPostPage.clickSubmitButton();
    }
    //Проверка обрезки текста до 1000 ссимволов Contecst/Текст не обрезается, когда ввели 1001

    @Test
    public void checkCutContentText() {
        loginPage.login("ghjk2@gmail.com", "cat2016!");
        homePage.clickCreatePostPlusButton();
        createPostPage.enterTitle("Soon");
        createPostPage.enterDescription("Lorem ipsum dolor sit amet, consectetuer ad");
        createPostPage.checkCutContent(
                "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor." +
                        " Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus." +
                        " Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim." +
                        " Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a," +
                        " venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus." +
                        " Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, " +
                        "consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. " +
                        "Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies" +
                        " nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus." +
                        " Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. N1");
        createPostPage.clickSubmitButton();
    }
    // set current or past date to draft// current Date

    @Test
    public void testCalenderOfDraftCurrentDate() {
        loginPage.login("ghjk2@gmail.com", "cat2016!");
        homePage.clickCreatePostPlusButton();
        createPostPage.enterTitle("Moon");
        createPostPage.enterDescription("Night");
        createPostPage.enterContent("The moon is beautiful!");
        createPostPage.setDate("24.09.2024");
        draftPage.toggleSaveAsDraft();
        createPostPage.checkInvalidDate();
    }

    @Test
    public void testCalenderOfDraftAfterDate() {
        loginPage.login("ghjk2@gmail.com", "cat2016!");
        homePage.clickCreatePostPlusButton();
        createPostPage.enterTitle("Moon");
        createPostPage.enterDescription("Night");
        createPostPage.enterContent("The moon is beautiful!");
        createPostPage.setDate("22.08.2024");
        draftPage.toggleSaveAsDraft();
        createPostPage.checkInvalidDate();
    }

      //Создание поста с валидной датой черновика
    @Test
    public void testCalenderOfDraftValidDate() {
        loginPage.login("ghjk2@gmail.com", "cat2016!");
        homePage.clickCreatePostPlusButton();
        createPostPage.enterTitle("Moon");
        createPostPage.enterDescription("Night");
        createPostPage.enterContent("The moon is beautiful!");
        createPostPage.setDate("25.09.2024");
        draftPage.toggleSaveAsDraft();
        createPostPage.checkInvalidDate();
    }
    // Проверка текста ошибки при загрузке большого размера файла(более 2Мв)
    @Test
    public void inputInValidImage() {
        //File imageFile = new File("C:\\Users\\Natalia Smolnikova\\Desktop\\2024-08-02 131845.png");
        loginPage.login("ghjk2@gmail.com", "cat2016!");
        homePage.clickCreatePostPlusButton();
        createPostPage.enterTitle("Moon");
        createPostPage.enterDescription("Night");
        createPostPage.enterContent("The moon is beautiful!");
        File largeImageFile = new File("C:\\Users\\Natalia Smolnikova\\Desktop\\Снимок экрана 2024-08-02 131845.png");
        createPostPage.uploadImageInField(largeImageFile);
        createPostPage.checkTextErrorMessage("Max size 2Mb"); //"File size exceeds the 2MB limit"
    }

}
