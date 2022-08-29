package pages.tmspages;

import com.codeborne.selenide.Condition;
import constants.Urls;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private final String TAB_XPATH = "//div[contains(@class, 'centerside')]//a[text()='%s']";

    public void openMainPage() {
        open(Urls.TMS_MAIN_URL);
    }

    public void clickNavigationMenu(String tabName) {
        String tabXpath = String.format(TAB_XPATH, tabName);
        $(By.xpath(tabXpath)).shouldBe(Condition.visible).click();
    }
}
