package testcases;

import base.BaseClass;
import dataProvider.CustomDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTestCase extends BaseClass {

    @Test(dataProvider = "loginData", dataProviderClass = CustomDataProvider.class)
    public void validLogin(String userName, String password) {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.loginToApplication(userName, password);
        Assert.assertTrue(homePage.verifyLogoDisplayed());
    }
}
