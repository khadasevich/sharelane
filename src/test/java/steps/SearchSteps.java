package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.awt.*;

import static com.codeborne.selenide.Selenide.*;

public class SearchSteps {

    @Before
    public void setUp() {
        Configuration.timeout = 6000;
        Dimension size
                = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) size.getWidth();
        int height = (int) size.getHeight() - 50;
        Configuration.browserSize = String.format("%dx%d", width, height);
    }

    @Given("Main TMS page opened")
    public void mainTMSPageOpened() {
        open("https://teachmeskills.by/");
    }

    @When("User goes to {string}")
    public void userGoesTo(String tabName) {
        String tabXpath = String.format("//div[contains(@class, 'centerside')]//a[text()='%s']", tabName);
        $(By.xpath(tabXpath)).shouldBe(Condition.visible).click();
    }

    @And("Selects {string}")
    public void selects(String courseType) {
        String courseTypeXpath = String.format("//div[text()='%s']", courseType);
        $(By.xpath(courseTypeXpath)).shouldBe(Condition.visible).hover();
        $(By.xpath("(//div[text()='Перейти'])[1]")).click();
    }

    @Then("{string} course presents on page")
    public void coursePresentsOnPage(String courseName) {
        String courseNameXpath = String.format("//div[@aaa]//strong[contains(text(), '%s')]", courseName);
        int quantityOfCourses = $$(By.xpath(courseNameXpath)).size();
        Assert.assertEquals(quantityOfCourses, 2, "Quantity of courses != 2");
    }
}
