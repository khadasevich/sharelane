import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest {

    @Test
    public void fiveDigitZipCodeTest() {
        //Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open url of zipcode page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //Input 5 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Click 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Add check
        WebElement registerButton = driver.findElement(By.cssSelector("[value=Register]"));
        boolean isRegisterDisplayed = registerButton.isDisplayed();
        driver.findElement(By.cssSelector("[value=Register]")).getAttribute("value");
        driver.quit();
        Assert.assertTrue(isRegisterDisplayed, "'Register' button isn't displayed");

    }

    @Test
    public void fourDigitZipCodeTest() {
        //Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open url of zipcode page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //Input 4 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("1234");
        //Click 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Add check
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isErrorDisplayed = errorMessage.isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorDisplayed, "Error message isn't displayed");
    }

    @Test
    public void sixDigitZipCodeTest() {
        //Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open url of zipcode page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //Input 6 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("123456");
        //Click 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Add check
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isErrorDisplayed = errorMessage.isDisplayed();

        driver.quit();
        Assert.assertTrue(isErrorDisplayed, "Error message isn't displayed");
    }

    @Test
    public void signUpTest() {
        //Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Open url of zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        //input 5 digits into input field
        Faker faker = new Faker();
        driver.findElement(By.name("zip_code")).sendKeys(faker.numerify("#####"));

        //click "Continue"
        driver.findElement(By.cssSelector("[value=Continue]")).click();


        //input first name into input field First Name
        driver.findElement(By.name("first_name")).sendKeys(faker.name().firstName());

        //input last name into input field Last Name
        driver.findElement(By.name("last_name")).sendKeys(faker.name().lastName());

        //input email into input field Email
        driver.findElement(By.name("email")).sendKeys("p1@gmail.com");

        //input password into input field Password
        driver.findElement(By.name("password1")).sendKeys("qwerty");

        //input password into input field Password
        driver.findElement(By.name("password2")).sendKeys("qwerty");

        //click "Register"
        driver.findElement(By.cssSelector("[value=Register]")).click();

        //add check
        WebElement messageAccountIsCreated = driver.findElement(By.className("confirmation_message"));
        boolean isMessageAccountIsCreated = messageAccountIsCreated.isDisplayed();
        driver.quit();
        Assert.assertTrue(isMessageAccountIsCreated, "'Account is created!' message isn't displayed");
        String actualText = driver.findElement(By.name("desc")).getAttribute("value");
    }
}
