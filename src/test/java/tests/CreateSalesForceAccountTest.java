package tests;

import lombok.extern.log4j.Log4j;
import models.NewAccountModel;
import org.testng.annotations.Test;
import pages.salesforcepages.AccountsPage;
import pages.salesforcepages.LoginPage;
import testdata.PrepareNewAccountData;

@Log4j
public class CreateSalesForceAccountTest extends BaseWithFactoryTest{

    @Test
    public void createAccountTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToSalesforce();
        AccountsPage accountsPage = new AccountsPage(driver);
        NewAccountModel accountModel = PrepareNewAccountData.getValidData();
        log.info("Create account with following details: " + accountModel.toString());
        accountsPage
                .openAccountsPage()
                .openNewAccountModal()
                .fillInAccountForm(accountModel);
        System.out.println("");
    }
}
