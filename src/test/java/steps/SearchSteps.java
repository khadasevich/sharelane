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
import pages.tmspages.CourseTypePage;
import pages.tmspages.CoursesListPage;
import pages.tmspages.MainPage;

import java.awt.*;

public class SearchSteps {

    MainPage mainPage;
    CourseTypePage courseTypePage;
    CoursesListPage coursesListPage;

    @Before
    public void setUp() {
        Configuration.timeout = 6000;
        Dimension size
                = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) size.getWidth();
        int height = (int) size.getHeight() - 50;
        Configuration.browserSize = String.format("%dx%d", width, height);
        mainPage = new MainPage();
        courseTypePage = new CourseTypePage();
        coursesListPage = new CoursesListPage();
    }

    @Given("Main TMS page opened")
    public void mainTMSPageOpened() {
        mainPage.openMainPage();
    }

    @When("User goes to {string}")
    public void userGoesTo(String tabName) {
        mainPage.clickNavigationMenu(tabName);
    }

    @And("Selects {string}")
    public void selects(String courseType) {
        courseTypePage.selectCourseType(courseType);
    }

    @Then("{string} course presents on page")
    public void coursePresentsOnPage(String courseName) {
        int quantityOfCourses = coursesListPage.getQuantityOfCourses(courseName);
        Assert.assertEquals(quantityOfCourses, 2, "Quantity of courses != 2");
    }
}
