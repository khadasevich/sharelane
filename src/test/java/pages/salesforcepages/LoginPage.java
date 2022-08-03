package pages.salesforcepages;

import constants.Credentials;
import constants.Urls;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoginPage extends BasePage {

    private By usernameInput = By.id("username");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("Login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginToSalesforce() {
        driver.get(Urls.SALES_FORCE_LOGIN);
        driver.findElement(usernameInput).sendKeys(Credentials.USERNAME);
        driver.findElement(passwordInput).sendKeys(Credentials.PASSWORD);
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        byte[] sourceFile = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        try {
            String path = String.format("src/test/resources/%s_screenshot.png", "today");
            Files.write(Paths.get(path), sourceFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.findElement(loginButton).click();
    }
}
