package pages.salesforcepages;

import elements.wrapperelements.DropdownList;
import elements.wrapperelements.TextInput;
import models.NewAccountModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewAccountModalPage extends BasePage{

    private By ACCOUNT_NAME_INPUT = By.xpath("//div[contains(@class, 'modal-body')]//span[text()='Account Name']//parent::label//following-sibling::div//input");
    private By SAVE_BUTTON = By.xpath("//div[contains(@class, 'modal-body')]//button[@title='Save']");

    public NewAccountModalPage(WebDriver driver) {
        super(driver);
    }

    public void fillInAccountForm(NewAccountModel newAccount) {
        driver.findElement(ACCOUNT_NAME_INPUT).sendKeys(newAccount.getAccountName());
        new TextInput(driver, "Phone").inputText(newAccount.getPhone());
        new DropdownList(driver, "Type").selectOptionInList(newAccount.getType());
        //ToDo: add all details

        driver.findElement(SAVE_BUTTON).click();
    }
}
