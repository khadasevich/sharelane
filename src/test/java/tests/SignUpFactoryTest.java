package tests;

import io.qameta.allure.*;
import models.RegistrationModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pagefactorypages.AccountCreatedFactoryPage;
import pages.pagefactorypages.SignUpFormFactoryPage;
import pages.pagefactorypages.ZipcodeFactoryPage;
import testdata.PrepareRegistrationData;
import utils.FakeMessageGenerator;

@Epic("User Management")
@Feature("Registration")
@Story("User Registration")
public class SignUpFactoryTest extends BaseWithThreadLocalTest {

    private static  final Logger LOGGER = LogManager.getLogger(SignUpFactoryTest.class.getName());

    @Test(priority = 2)
    @Description("User tries to input 5 digits zip code")
    @Issue("QA-125")
    @TmsLink("SHARELANE-1")
    @Severity(SeverityLevel.BLOCKER)
    public void fiveDigitZipCodeTest() {
        ZipcodeFactoryPage zipcodeFactoryPage = new ZipcodeFactoryPage(driverManager.getDriver());
        LOGGER.info(String.format("Page %s initialized", ZipcodeFactoryPage.class.getName()));
        LOGGER.info(String.format("Open %s page", ZipcodeFactoryPage.class.getName()));
        zipcodeFactoryPage.openZipcodePage();
        LOGGER.info("Input zipcode");
        zipcodeFactoryPage.inputZipCode(FakeMessageGenerator.generateFiveDigitsZipCode());
        LOGGER.info("Proceed with zipcode");
        zipcodeFactoryPage.clickContinue();
        SignUpFormFactoryPage signUpFormFactoryPage = new SignUpFormFactoryPage(driverManager.getDriver());
        LOGGER.info(String.format("Page %s initialized", SignUpFormFactoryPage.class.getName()));
        LOGGER.info("Check if button is displayed");
        Assert.assertTrue(signUpFormFactoryPage.isRegisterDisplayed(), "'Register' button isn't displayed");
    }

    @Test(priority = 1, description = "User performs sign up to the system")
    @Description("User performs sign up to the system")
    @Severity(SeverityLevel.BLOCKER)
    public void signUpTest() {
        ZipcodeFactoryPage zipcodeFactoryPage = new ZipcodeFactoryPage(driverManager.getDriver());
        zipcodeFactoryPage.openZipcodePage();
        zipcodeFactoryPage.inputZipCode(FakeMessageGenerator.generateFiveDigitsZipCode());
        zipcodeFactoryPage.clickContinue();
        SignUpFormFactoryPage signUpFormFactoryPage = new SignUpFormFactoryPage(driverManager.getDriver());
        RegistrationModel registrationModel = PrepareRegistrationData.getValidRegistration();
        signUpFormFactoryPage.sendRegistrationForm(registrationModel);
        AccountCreatedFactoryPage accountCreatedFactoryPage = new AccountCreatedFactoryPage(driverManager.getDriver());
        Assert.assertTrue(accountCreatedFactoryPage.isMessageDisplayed(), "'Account is created!' message isn't displayed");
    }
}
