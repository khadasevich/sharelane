package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.fluentpage.ZipcodeFluentPomPage;
import utils.FakeMessageGenerator;

public class SignUpFluentPomWithoutArchitectureTest extends BaseWithThreadLocalTest {

    @Test
    public void fiveDigitZipCodeTest() {
        ZipcodeFluentPomPage zipPage = new ZipcodeFluentPomPage(threadLocalDriver.get());
        boolean isRegisterDisplayed = zipPage
                .openZipCodePage()
                .inputZipcode(FakeMessageGenerator.generateFiveDigitsZipCode())
                .clickContinue()
                .isRegisterDisplayed();
        Assert.assertTrue(isRegisterDisplayed, "Register button isn't displayed");
    }

}
