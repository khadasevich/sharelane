package tests;

import models.NewAccountModel;
import org.testng.annotations.Test;
import pages.salesforcepages.AccountsPage;
import pages.salesforcepages.LoginPage;
import testdata.PrepareNewAccountData;

public class CreateSalesForceAccountTest extends BaseWithFactoryTest{

    @Test
    public void createAccountTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToSalesforce();
        AccountsPage accountsPage = new AccountsPage(driver);
        NewAccountModel accountModel = PrepareNewAccountData.getValidData();
        accountsPage
                .openAccountsPage()
                .openNewAccountModal()
                .fillInAccountForm(accountModel);
        System.out.println("");
    }
}
