package pages.pagefactorypages;

import constants.Urls;
import io.qameta.allure.Step;
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

    @Step("Open Zip code page")
    public void openZipcodePage() {
        LOGGER.debug(String.format("Attempt to open URL: %s", Urls.REGISTER_FORM_URL));
        driver.get(Urls.REGISTER_FORM_URL);
    }

    @Step("Input zipcode '{zipCode}'")
    public void inputZipCode(String zipCode) {
        LOGGER.debug(String.format("Attempt to send zipcode: %s", zipCode));
        zipCodeInput.sendKeys(zipCode);
    }

    @Step("Click continue button")
    public void clickContinue() {
        LOGGER.debug(String.format("Attempt to click Continue button: %s", continueButton));
        continueButton.click();
    }
}
