package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import constants.Credentials;
import constants.Urls;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ShareLaneLoginSelenideTest {

    @Test
    public void loginTest() {
        open(Urls.SHARELANE_LOGIN_URL);
        $(By.name("email")).sendKeys(Credentials.SHARELANE_USERNAME);
        $(By.name("password")).sendKeys(Credentials.SHARELANE_PASSWORD);
        $(By.cssSelector("[value='Login']")).click();
        SelenideElement userGreeting = $(By.className("user"));
        userGreeting.shouldBe(Condition.visible, Duration.ofSeconds(5));
        boolean isGreetingDisplayed = userGreeting.isDisplayed();
        Assert.assertTrue(isGreetingDisplayed, "Greeting isn't shown");
    }
}
