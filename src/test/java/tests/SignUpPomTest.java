package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pompages.AccountCreatedPomPage;
import pages.pompages.SignUpFormPomPage;
import pages.pompages.ZipcodePomPage;
import pages.services.SendZipService;
import utils.FakeMessageGenerator;

public class SignUpPomTest extends BaseTest {


    @Test
    public void fiveDigitZipCodeTest() {
        SendZipService sendZipService = new SendZipService(driver);
        sendZipService.inputZipCode(FakeMessageGenerator.generateFiveDigitsZipCode());
        SignUpFormPomPage signUpFormPomPage = new SignUpFormPomPage(driver);
        Assert.assertTrue(signUpFormPomPage.isRegisterDisplayed(), "'Register' button isn't displayed");
    }


    @Test
    public void signUpTest() {
        SendZipService sendZipService = new SendZipService(driver);
        sendZipService.inputZipCode(FakeMessageGenerator.generateFiveDigitsZipCode());
        SignUpFormPomPage signUpFormPomPage = new SignUpFormPomPage(driver);
        signUpFormPomPage.inputFirstName(FakeMessageGenerator.generateFirstName());
        signUpFormPomPage.inputLastName(FakeMessageGenerator.generateLastName());
        signUpFormPomPage.inputEmail(FakeMessageGenerator.generateEmail());
        String password = FakeMessageGenerator.generatePassword();
        signUpFormPomPage.inputPassword(password);
        signUpFormPomPage.inputConfirmPassword(password);
        signUpFormPomPage.clickRegister();
        AccountCreatedPomPage accountCreatedPomPage = new AccountCreatedPomPage(driver);
        Assert.assertTrue(accountCreatedPomPage.isSuccessMessageDisplayed(), "'Account is created!' message isn't displayed");
    }
}
