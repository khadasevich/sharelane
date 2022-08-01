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

public class SignUpFactoryTest extends BaseWithoutArchitectureTest {


    @Test
    public void fiveDigitZipCodeTest() {
        ZipcodeFactoryPage zipcodeFactoryPage = new ZipcodeFactoryPage(driver);
        zipcodeFactoryPage.openZipcodePage();
        zipcodeFactoryPage.inputZipCode(FakeMessageGenerator.generateFiveDigitsZipCode());
        zipcodeFactoryPage.clickContinue();
        SignUpFormFactoryPage signUpFormFactoryPage = new SignUpFormFactoryPage(driver);
        Assert.assertTrue(signUpFormFactoryPage.isRegisterDisplayed(), "'Register' button isn't displayed");
    }

    @Test
    public void signUpTest() {
        ZipcodeFactoryPage zipcodeFactoryPage = new ZipcodeFactoryPage(driver);
        zipcodeFactoryPage.openZipcodePage();
        zipcodeFactoryPage.inputZipCode(FakeMessageGenerator.generateFiveDigitsZipCode());
        zipcodeFactoryPage.clickContinue();
        SignUpFormFactoryPage signUpFormFactoryPage = new SignUpFormFactoryPage(driver);
        RegistrationModel registrationModel = PrepareRegistrationData.getValidRegistration();
        signUpFormFactoryPage.sendRegistrationForm(registrationModel);
        AccountCreatedFactoryPage accountCreatedFactoryPage = new AccountCreatedFactoryPage(driver);
        Assert.assertTrue(accountCreatedFactoryPage.isMessageDisplayed(), "'Account is created!' message isn't displayed");
    }
}
