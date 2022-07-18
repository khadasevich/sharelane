package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private final String PASSWORD = "1111";
    private final String EMAIL = "brian_rao@578.16.sharelane.com";

    @Test
    public void loginTest() {
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys(EMAIL);
        driver.findElement(By.name("password")).sendKeys(PASSWORD);
        driver.findElement(By.cssSelector("[value='Login']")).click();
        boolean isGreetingShown = driver.findElement(By.className("user")).isDisplayed();
        Assert.assertTrue(isGreetingShown, "Greeting message isn't shown");
    }
}
