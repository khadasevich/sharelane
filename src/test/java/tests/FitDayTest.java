package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FitDayTest extends BaseWithFactoryTest{

    @Test
    public void sendMessageToForum() {
        driver.get("https://www.fitday.com/fitness/forums");
        driver.get("https://www.fitday.com/fitness/forums/motivation-support/28735-i-cant-stop-snacking.html");
        WebElement replyButton = driver.findElement(By.xpath("(//div[@class='flexitem']//a[contains(., 'Reply')])[1]"));
        replyButton.click();
        WebElement iframe = driver.findElement(By.xpath("//div[@id='cke_1_contents']//iframe"));
        driver.switchTo().frame(iframe);
        WebElement inputFieldInFrame = driver.findElement(By.cssSelector(".cke_editable"));
        inputFieldInFrame.sendKeys("yoyoyo");
        driver.switchTo().parentFrame();

    }
}
