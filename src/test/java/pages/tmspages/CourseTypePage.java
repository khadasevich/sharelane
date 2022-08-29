package pages.tmspages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CourseTypePage {

    private final String TYPE_XPATH = "//div[text()='%s']";
    private final String GO_BUTTON_XPATH = "(//div[text()='Перейти'])[1]";

    public void selectCourseType(String type) {
        String courseTypeXpath = String.format(TYPE_XPATH, type);
        $(By.xpath(courseTypeXpath)).shouldBe(Condition.visible).hover();
        $(By.xpath(GO_BUTTON_XPATH)).click();
    }
}
