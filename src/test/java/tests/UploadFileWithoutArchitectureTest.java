package tests;

import drivermanager.factorymanager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.pagefactorypages.FileUploadPage;
import utils.RetryAnalyzer;

import java.util.ArrayList;
import java.util.List;

public class UploadFileWithoutArchitectureTest extends BaseWithFactoryTest {

    @Test
    public void uploadFileTest() {
        String path = System.getProperty("user.dir").concat("/src/test/resources/img.png");
        driver.get("http://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("file-upload")).sendKeys(path);
        driver.findElement(By.id("file-submit")).click();
        driverManager.removeTimeout();
        String srt = driver.findElement(By.xpath("//div[@id='uploaded-files']")).getText().trim();
        System.out.println(srt);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void uploadFileTest2() {
        FileUploadPage fileUploadPage = new FileUploadPage(driver);
        fileUploadPage.openFileUploadPage();
        fileUploadPage.sendFilePath();
        fileUploadPage.uploadFile();

        String conf = fileUploadPage.getUploadConfirmationMessage();
        Assert.assertEquals(conf, "assure");
    }

    @Test
    public void selectTest() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement webElement = driver.findElement(By.id("dropdown"));
        Select dropDownList = new Select(webElement);
        List<WebElement> optionsList = dropDownList.getOptions();
        List<WebElement> enabledOptionsList = new ArrayList<>();
        for (WebElement option :
                optionsList) {
            if (option.isEnabled()) {
                enabledOptionsList.add(option);
            }
        }
        int actualSize = optionsList.size();
        int enabledSize = enabledOptionsList.size();
        Assert.assertEquals(actualSize, 3, "Check quantity");
        Assert.assertEquals(enabledSize, 2, "Check quantity of enabled");
    }

    @DataProvider(name = "testData")
    public Object[][] inputForTask() {
        return new Object[][]{
                {3, "Alex"},
                {5, "Khadasevich"},
                {15, "Alex Khadasevich"},
                {6, "Alex"},
                {10, "Khadasevich"},
                {30, "Alex Khadasevich"},
                {1, "Error"},
                {-1, "Error"},
        };
    }

    @Test(dataProvider = "testData")
    public void test123(double number, String expectedString) {
        System.out.println(number + " " + expectedString);
    }

}
