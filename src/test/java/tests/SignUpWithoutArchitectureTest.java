package tests;

import constants.Urls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.FakeMessageGenerator;

public class SignUpWithoutArchitectureTest extends BaseTest {

    private void sendZipCode(String zipCode) {
        //Open url of zipcode page
        driver.get(Urls.REGISTER_FORM_URL);
        //Input 5 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys(zipCode);
        //Click 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
    }

    @Test
    public void fiveDigitZipCodeTest() {
        sendZipCode("12345");
        //Add check
        WebElement registerButton = driver.findElement(By.cssSelector("[value=Register]"));
        boolean isRegisterDisplayed = registerButton.isDisplayed();
        driver.findElement(By.cssSelector("[value=Register]")).getAttribute("value");
        Assert.assertTrue(isRegisterDisplayed, "'Register' button isn't displayed");

    }

    @Test
    public void fourDigitZipCodeTest() {
        sendZipCode(FakeMessageGenerator.generateFourDigitsZipCode());

        //Add check
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isErrorDisplayed = errorMessage.isDisplayed();
        Assert.assertTrue(isErrorDisplayed, "Error message isn't displayed");
    }

    @Test
    public void sixDigitZipCodeTest() {
        sendZipCode("123456");

        //Add check
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isErrorDisplayed = errorMessage.isDisplayed();

        Assert.assertTrue(isErrorDisplayed, "Error message isn't displayed");
    }

    @Test
    public void signUpTest() {
        sendZipCode("12345");
        //input first name into input field First Name
        driver.findElement(By.name("first_name")).sendKeys(FakeMessageGenerator.generateFirstName());
        //input last name into input field Last Name
        driver.findElement(By.name("last_name")).sendKeys(FakeMessageGenerator.generateLastName());
        //input email into input field Email
        driver.findElement(By.name("email")).sendKeys(FakeMessageGenerator.generateEmail());
        //input password into input field Password
        String password = FakeMessageGenerator.generatePassword();
        driver.findElement(By.name("password1")).sendKeys(password);
        //input password into input field Password
        driver.findElement(By.name("password2")).sendKeys(password);
        //click "Register"
        driver.findElement(By.cssSelector("[value=Register]")).click();

        //add check
        WebElement messageAccountIsCreated = driver.findElement(By.className("confirmation_message"));
        boolean isMessageAccountIsCreated = messageAccountIsCreated.isDisplayed();
        Assert.assertTrue(isMessageAccountIsCreated, "'Account is created!' message isn't displayed");
    }
}
