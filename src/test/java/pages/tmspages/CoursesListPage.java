package pages.tmspages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class CoursesListPage {

    private final String COURSE_NAME_XPATH = "//div[@aaa]//strong[contains(text(), '%s')]";

    public int getQuantityOfCourses(String courseName) {
        String courseNameXpath = String.format(COURSE_NAME_XPATH, courseName);
        return $$(By.xpath(courseNameXpath)).size();
    }
}
