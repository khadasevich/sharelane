package pages.salesforcepages;

import constants.Credentials;
import constants.Urls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        driver.findElement(loginButton).click();
    }
}
