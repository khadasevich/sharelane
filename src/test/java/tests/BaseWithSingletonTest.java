package tests;

import drivermanager.singletonmanager.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.PropertyManager;

import java.util.concurrent.TimeUnit;

public class BaseWithSingletonTest {

    public WebDriver driver;
    public ChromeDriverManager chromeDriverManager;

    @BeforeMethod
    public void setUp() {
        chromeDriverManager = ChromeDriverManager.getInstanceOfChromeDriver();
        ChromeDriverManager.setWait();
        ChromeDriverManager.startBrowserMaximize();
        driver = ChromeDriverManager.getDriver();
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        ChromeDriverManager.quitDriver();
    }
}
