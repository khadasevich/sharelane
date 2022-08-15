package tests;

import drivermanager.factorymanager.DriverType;
import drivermanager.threadlocalmanager.DriverThreadLocalManager;
import drivermanager.threadlocalmanager.DriverThreadLocalManagerFactory;
import org.testng.annotations.*;

public class BaseWithThreadLocalTest {

    DriverThreadLocalManager driverManager;

    @BeforeClass
    public void createManager() {
        DriverThreadLocalManagerFactory factory = new DriverThreadLocalManagerFactory();
        driverManager = factory.getManager(DriverType.CHROME);
    }

    @BeforeMethod
    public void setUp() {
        driverManager.createDriver();
        driverManager.startMaximize();
        driverManager.setTimeout();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driverManager.getDriver().quit();
    }
}
