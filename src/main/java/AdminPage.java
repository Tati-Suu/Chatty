import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AdminPage {
    private SelenideElement adminPageCheck = $("#root > div.admin-panel__users > div > div > h1");
    private SelenideElement userListTitle = $("#root > div.admin-panel__users > div > div > h2");
    private ElementsCollection columnNames = $$("#root > div.admin-panel__users > div > div > table > thead > tr > th");
    private SelenideElement trashDeleteUserButton = $("#root > div.admin-panel__users > div > div > table > tbody > tr:nth-child(1) > td.admin-panel__btn-box > span:nth-child(2) > svg");;
    //по ТЗ не должно удалять пользователя, должно блокировать, это баг
    //нет возможности посмотреть блокированных пользователей
    private SelenideElement editUserBox = $("#root > div.admin-panel__users > div > div > table > tbody > tr:nth-child(1) > td.admin-panel__btn-box > span:nth-child(2) > svg");
    private SelenideElement editUserBox9 =$("#root > div.admin-panel__users > div > div > table > tbody > tr:nth-child(9) > td.admin-panel__btn-box > span:nth-child(1) > svg");

    private SelenideElement emailUserBox1 =$("#root > div.admin-panel__users > div > div > table > tbody > tr:nth-child(1) > td:nth-child(3)");
    private SelenideElement searchBox =$("#root > div.admin-panel__users > div > div > div > input[type=text]");
    private SelenideElement searchButton =$("#root > div.admin-panel__users > div > div > div > button");
    private SelenideElement searchResults = $("#root > div.admin-panel__users > div > div > table > tbody > tr:nth-child(1) > td:nth-child(3)");
    private SelenideElement searchResultsAfter = $("#root > div.admin-panel__users > div > div > table > tbody");
    public void isAdminPagePresent(String expectedText) {
        adminPageCheck.shouldHave(Condition.text(expectedText));
    }
    public void userListTitleCheck(String expectedText) {
        userListTitle.shouldHave(Condition.text(expectedText));
    }
    public void columnNamesCheck(List<String> expectedColumnNames) {
        for (int i = 0; i < expectedColumnNames.size(); i++) {
            columnNames.get(i).shouldHave(Condition.text(expectedColumnNames.get(i)));
        }
    }
    public void trashUserBlockCheck() {
        // Сохранить email пользователя перед удалением
        String userEmail = emailUserBox1.getText();
        trashDeleteUserButton.click();
        // Проверить, что пользователь первый в списке имеет другой email
        assertFalse(searchResults.getText().contains(userEmail));
        //Поиск по email после удаления:
        searchBox.setValue(userEmail);
        searchButton.click();
        // Проверить, что пользователь больше не отображается в результатах поиска
        assertFalse(searchResultsAfter.getText().contains(userEmail));

    }
    public void editUserBoxClick() {
        editUserBox.click();
        editUserBox9.click();//пользователь с номером 9 в таблице
    }
    public void createUserFromAdminCheck(String expectedText) {
        userListTitle.shouldHave(Condition.text(expectedText));//нет кнопки создать юзера  there is no button to create an account from admin
        //According to the documentation there should be a button to create an account from the admin
    }
}

