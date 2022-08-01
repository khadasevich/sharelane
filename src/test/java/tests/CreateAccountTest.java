package tests;

import org.testng.annotations.Test;
import pages.salesforcepages.LoginPage;

public class CreateAccountTest extends BaseWithFactoryTest{

    @Test
    public void createAccountTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToSalesforce();
        System.out.println("");
    }
}
