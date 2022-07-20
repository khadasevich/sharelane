package pages.pagefactorypages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpFormFactoryPage extends BaseFactoryPage {

    @FindBy(css = "[value=Register]")
    private WebElement registerButton;

    @FindBy(name = "first_name")
    private WebElement firstNameInput;

    @FindBy(name = "last_name")
    private WebElement lastNameInput;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password1")
    private WebElement passwordInput;

    @FindBy(name = "password2")
    private WebElement confirmPasswordInput;

    public SignUpFormFactoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isRegisterDisplayed() {
        return registerButton.isDisplayed();
    }

    public void sendRegistrationForm(String firstName,
                                     String lastName,
                                     String email,
                                     String password,
                                     String confirmPassword) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(confirmPassword);
        registerButton.click();
    }
}
