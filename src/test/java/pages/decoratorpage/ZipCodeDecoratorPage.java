package pages.decoratorpage;

import constants.Urls;
import elements.decoratorelements.ExtendedFieldDecorator;
import elements.decoratorelements.TextField;
import elements.decoratorelements.TextFieldImpl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZipCodeDecoratorPage {

    @FindBy(name = "zip_code")
    private TextField zipcodeInput;

    @FindBy(css="[value=Continue]")
    private WebElement continueButton;

    public WebDriver driver;

    public ZipCodeDecoratorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new ExtendedFieldDecorator(driver), this);
    }

    public void openZipCodePage() {
        driver.get(Urls.REGISTER_FORM_URL);
    }

    public void inputZipCode(String zipCode) {
        zipcodeInput.type(zipCode);
    }

    public void goBackInHistory() {
        driver.navigate().back();
    }

    public void clearAndInputZip(String text) {
        zipcodeInput.clearAndType(text);
    }

    public void clickContinue() {
        continueButton.click();
    }
}
