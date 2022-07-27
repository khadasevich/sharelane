package tests;

import models.RegistrationModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pompages.AccountCreatedPomPage;
import pages.pompages.SignUpFormPomPage;
import pages.services.SendZipService;
import testdata.PrepareRegistrationData;
import utils.FakeMessageGenerator;

public class SignUpPomWithoutArchitectureTest extends BaseWithoutArchitectureTest {


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
        RegistrationModel registrationModel = PrepareRegistrationData.getValidRegistration();
        signUpFormPomPage.inputFirstName(registrationModel.getFirstName());
        signUpFormPomPage.inputLastName(registrationModel.getLastName());
        signUpFormPomPage.inputEmail(registrationModel.getEmail());
        signUpFormPomPage.inputPassword(registrationModel.getPassword());
        signUpFormPomPage.inputConfirmPassword(registrationModel.getConfirmPassword());
        signUpFormPomPage.clickRegister();
        AccountCreatedPomPage accountCreatedPomPage = new AccountCreatedPomPage(driver);
        Assert.assertTrue(accountCreatedPomPage.isSuccessMessageDisplayed(), "'Account is created!' message isn't displayed");
    }
}
