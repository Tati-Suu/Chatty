import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ContactUsPage {
    private SelenideElement textPageContactUs = $(By.xpath("//*[@id=\"root\"]/div[2]/div/div/h1"));

    public void textContactPage(String namePageValue) {
        textPageContactUs.shouldBe(Condition.visible).shouldHave(Condition.text(namePageValue));
    }

}
