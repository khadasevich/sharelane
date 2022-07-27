package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class UploadFileWithoutArchitectureTest extends BaseWithFactoryTest {

    @Test
    public void uploadFileTest() {
        String path = System.getProperty("user.dir").concat("/src/test/resources/img.png");
        driver.get("http://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("file-upload")).sendKeys(path);
        driver.findElement(By.id("file-submit")).click();
        System.out.println("");
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
            if(option.isEnabled()) {
                enabledOptionsList.add(option);
            }
        }
        int actualSize = optionsList.size();
        int enabledSize = enabledOptionsList.size();
        Assert.assertEquals(actualSize, 3, "Check quantity");
        Assert.assertEquals(enabledSize, 2, "Check quantity of enabled");
    }
}
