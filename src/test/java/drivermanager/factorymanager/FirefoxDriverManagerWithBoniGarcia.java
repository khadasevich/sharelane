package drivermanager.factorymanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.PropertyManager;

public class FirefoxDriverManagerWithBoniGarcia extends DriverManager{

    @Override
    public void createDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }
}
