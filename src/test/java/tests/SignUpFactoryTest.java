package tests;

import models.RegistrationModel;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pagefactorypages.AccountCreatedFactoryPage;
import pages.pagefactorypages.SignUpFormFactoryPage;
import pages.pagefactorypages.ZipcodeFactoryPage;
import testdata.PrepareRegistrationData;
import utils.FakeMessageGenerator;

public class SignUpFactoryTest extends BaseWithThreadLocalTest {


    @Test(priority = 2, invocationCount = 2, threadPoolSize = 2)
    public void fiveDigitZipCodeTest() {
        ZipcodeFactoryPage zipcodeFactoryPage = new ZipcodeFactoryPage(getDriver());
        zipcodeFactoryPage.openZipcodePage();
        zipcodeFactoryPage.inputZipCode(FakeMessageGenerator.generateFiveDigitsZipCode());
        zipcodeFactoryPage.clickContinue();
        SignUpFormFactoryPage signUpFormFactoryPage = new SignUpFormFactoryPage(getDriver());
        Assert.assertTrue(signUpFormFactoryPage.isRegisterDisplayed(), "'Register' button isn't displayed");
    }

    @Test(priority = 1, description = "User performs sign up to the system")
    public void signUpTest() {
        ZipcodeFactoryPage zipcodeFactoryPage = new ZipcodeFactoryPage(getDriver());
        zipcodeFactoryPage.openZipcodePage();
        zipcodeFactoryPage.inputZipCode(FakeMessageGenerator.generateFiveDigitsZipCode());
        zipcodeFactoryPage.clickContinue();
        SignUpFormFactoryPage signUpFormFactoryPage = new SignUpFormFactoryPage(getDriver());
        RegistrationModel registrationModel = PrepareRegistrationData.getValidRegistration();
        signUpFormFactoryPage.sendRegistrationForm(registrationModel);
        AccountCreatedFactoryPage accountCreatedFactoryPage = new AccountCreatedFactoryPage(getDriver());
        Assert.assertTrue(accountCreatedFactoryPage.isMessageDisplayed(), "'Account is created!' message isn't displayed");
    }
}
