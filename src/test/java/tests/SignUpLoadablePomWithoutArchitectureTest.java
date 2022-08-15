package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.loadablepage.SignUpFormLoadablePomPage;
import pages.loadablepage.ZipcodeLoadablePomPage;
import utils.FakeMessageGenerator;

public class SignUpLoadablePomWithoutArchitectureTest extends BaseWithThreadLocalTest {

    @Test
    public void fiveDigitZipCodeTest() {
        ZipcodeLoadablePomPage zipPage = new ZipcodeLoadablePomPage(driverManager.getDriver());
        zipPage.openZipCodePage();
        Assert.assertTrue(zipPage.isPageOpened(), "Continue button isn't displayed");
        zipPage.inputZipcode(FakeMessageGenerator.generateFiveDigitsZipCode());
        zipPage.clickContinue();
        SignUpFormLoadablePomPage signUpFormLoadablePomPage = new SignUpFormLoadablePomPage(driverManager.getDriver());
        Assert.assertTrue(signUpFormLoadablePomPage.isRegisterDisplayed(), "Register button isn't displayed");
    }

}
