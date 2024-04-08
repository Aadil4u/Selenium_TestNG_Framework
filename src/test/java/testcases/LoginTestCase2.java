package testcases;

import base.BaseClass;
import dataProvider.CustomDataProvider;
import helper.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static browserFactory.BrowserFactory.getDriver;

public class LoginTestCase2 extends BaseClass {

    @BeforeMethod
    public void setupTest() {
        getDriver().get(ConfigReader.getProperty("url"));
    }

    @Test(dataProvider = "loginData", dataProviderClass = CustomDataProvider.class)
    public void validLogin(String userName, String password) {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.loginToApplication(userName, password);
        Assert.assertTrue(homePage.verifyLogoDisplayed());
    }

    @Test(dataProvider = "loginData", dataProviderClass = CustomDataProvider.class)
    public void validLogin1(String userName, String password) {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.loginToApplication(userName, password);
        Assert.assertTrue(homePage.verifyLogoDisplayed());
    }

    @Test(dataProvider = "loginData", dataProviderClass = CustomDataProvider.class)
    public void validLogin2(String userName, String password) {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.loginToApplication(userName, password);
        Assert.assertTrue(homePage.verifyLogoDisplayed());
    }

}
