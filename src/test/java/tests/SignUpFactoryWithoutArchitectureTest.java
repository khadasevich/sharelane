package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pagefactorypages.AccountCreatedFactoryPage;
import pages.pagefactorypages.SignUpFormFactoryPage;
import pages.pagefactorypages.ZipcodeFactoryPage;
import utils.FakeMessageGenerator;

public class SignUpFactoryWithoutArchitectureTest extends BaseWithoutArchitectureTest {


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
        String password = FakeMessageGenerator.generatePassword();
        signUpFormFactoryPage.sendRegistrationForm(FakeMessageGenerator.generateFirstName(),
                FakeMessageGenerator.generateLastName(),
                FakeMessageGenerator.generateEmail(),
                password,
                password);
        AccountCreatedFactoryPage accountCreatedFactoryPage = new AccountCreatedFactoryPage(driver);
        Assert.assertTrue(accountCreatedFactoryPage.isMessageDisplayed(), "'Account is created!' message isn't displayed");
    }
}
