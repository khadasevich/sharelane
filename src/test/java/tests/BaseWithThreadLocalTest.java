package tests;

import drivermanager.factorymanager.DriverFactory;
import drivermanager.factorymanager.DriverManager;
import drivermanager.factorymanager.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseWithThreadLocalTest {

    protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    @BeforeMethod
    public void setUp() {
        DriverFactory factory = new DriverFactory();
        DriverManager driverManager = factory.getManager(DriverType.CHROME);
        driverManager.createDriver();
        driverManager.startMaximize();
        driverManager.setTimeout();
        threadLocalDriver.set(driverManager.getDriver());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        threadLocalDriver.get().quit();
    }

    @AfterSuite(alwaysRun = true)
    public void clearThreadLocal() {
        threadLocalDriver.remove();
    }
}
