package elements.wrapperelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextInput {

    private static final String INPUT_XPATH = "//div[contains(@class, 'modal-body')]//span[text()='%s']//parent::label//following-sibling::input";
    private String labelText;
    private WebDriver driver;

    public TextInput(WebDriver driver, String labelText) {
        this.labelText = labelText;
        this.driver = driver;
    }

    public void inputText(String text) {
        String finalXpath = String.format(INPUT_XPATH, labelText);
        driver.findElement(By.xpath(finalXpath)).sendKeys(text);
    }
}
