package pages.pagefactorypages;

import constants.Urls;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.SignUpFactoryTest;

public class ZipcodeFactoryPage extends BaseFactoryPage{

    private static  final Logger LOGGER = LogManager.getLogger(ZipcodeFactoryPage.class.getName());

    @FindBy(name="zip_code")
    private WebElement zipCodeInput;

    @FindBy(css="[value=Continue]")
    private WebElement continueButton;

    public ZipcodeFactoryPage(WebDriver driver) {
        super(driver);
    }

    public void openZipcodePage() {
        LOGGER.debug(String.format("Attempt to open URL: %s", Urls.REGISTER_FORM_URL));
        driver.get(Urls.REGISTER_FORM_URL);
    }

    public void inputZipCode(String zipCode) {
        LOGGER.debug(String.format("Attempt to send zipcode: %s", zipCode));
        zipCodeInput.sendKeys(zipCode);
    }

    public void clickContinue() {
        LOGGER.debug(String.format("Attempt to click Continue button: %s", continueButton));
        continueButton.click();
    }
}
