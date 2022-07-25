package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private final String PASSWORD = "1111";
    private final String EMAIL = "vladimir_baker@2137.7.sharelane.com";

    @Test
    public void loginTest() {
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys(EMAIL);
        driver.findElement(By.name("password")).sendKeys(PASSWORD);
        WebElement loginButton = driver.findElement(By.cssSelector("[value='Login']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginButton);

        removeImplicitlyWait();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("user")));
        boolean isGreetingShown = driver.findElement(By.className("user")).isDisplayed();
        setImplicitlyWait();
        Assert.assertTrue(isGreetingShown, "Greeting message isn't shown");
    }
}
