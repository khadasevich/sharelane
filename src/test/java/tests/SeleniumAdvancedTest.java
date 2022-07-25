package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SeleniumAdvancedTest extends BaseTest{

    @Test
    public void selectTest() {
        driver.get("http://the-internet.herokuapp.com/dropdown");

        WebElement dropdownList = driver.findElement(By.id("dropdown"));
        Select selectOption = new Select(dropdownList);
        selectOption.getOptions();
    }

    @Test
    public void actionsTest() {
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");
        Actions actions = new Actions(driver);
        WebElement elementSource = driver.findElement(By.id("column-a"));
        WebElement elementTarget = driver.findElement(By.id("column-b"));
        actions
                .clickAndHold(elementSource)
                .moveToElement(elementTarget)
                .release()
                .build()
                .perform();
        System.out.println("Some");
    }
}
