package pages.pagefactorypages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploadPage extends BaseFactoryPage {

    @FindBy(xpath = "//input[@id='file-upload']")
    private WebElement chooseFileButton;

    @FindBy(xpath = "//input[@id='file-submit']")
    private WebElement uploadButton;

    @FindBy(id = "uploaded-files")
    private WebElement uploadConfirmationText;

    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    public void openFileUploadPage() {
        driver.get("http://the-internet.herokuapp.com/upload");
    }

    public void sendFilePath() {
        String path = System.getProperty("user.dir").concat("/src/test/resources/img.png");
        chooseFileButton.sendKeys(path);
    }

    public void uploadFile() {
        uploadButton.click();
    }

    public String getUploadConfirmationMessage() {
        return uploadConfirmationText.getText().trim();
    }
}
