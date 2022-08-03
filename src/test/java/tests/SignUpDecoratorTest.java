package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.decoratorpage.ZipCodeDecoratorPage;
import pages.pagefactorypages.SignUpFormFactoryPage;
import utils.FakeMessageGenerator;

public class SignUpDecoratorTest extends BaseWithoutArchitectureTest {


    @Test
    public void fiveDigitZipCodeTest() {
        ZipCodeDecoratorPage zipCodeDecoratorPage = new ZipCodeDecoratorPage(driver);
        zipCodeDecoratorPage.openZipCodePage();
        zipCodeDecoratorPage.inputZipCode(FakeMessageGenerator.generateFiveDigitsZipCode());
        zipCodeDecoratorPage.clickContinue();
        zipCodeDecoratorPage.goBackInHistory();
        zipCodeDecoratorPage.clearAndInputZip(FakeMessageGenerator.generateFiveDigitsZipCode());
        zipCodeDecoratorPage.clickContinue();
        SignUpFormFactoryPage signUpFormFactoryPage = new SignUpFormFactoryPage(driver);
        Assert.assertTrue(signUpFormFactoryPage.isRegisterDisplayed(), "'Register' button isn't displayed");
    }
}
