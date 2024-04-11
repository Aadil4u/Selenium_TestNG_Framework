package testcases;

import base.BaseClass;
import helper.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import static browserFactory.BrowserFactory.getDriver;

public class E2ETestCase extends BaseClass {

    @BeforeMethod
    public void setupTest() {
        getDriver().get(ConfigReader.getProperty("url"));
    }

    @Test
    public void e2eTest() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.loginToApplication("standard_user", "secret_sauce");
        Assert.assertTrue(homePage.verifyLogoDisplayed());

        homePage.addItemToCart("Sauce Labs Backpack");
        String backpackPrice = homePage.getItemsPrice("Sauce Labs Backpack");
        homePage.addItemToCart("Sauce Labs Fleece Jacket");
        String jacketPrice = homePage.getItemsPrice("Sauce Labs Fleece Jacket");
        int actualCount = homePage.getItemsCountInCart();
        Assert.assertEquals(actualCount, 2);
        CartPage cartPage = homePage.clickOnCartBtn();

        String backpackPriceInCart = cartPage.getItemPriceInCart("Sauce Labs Backpack");
        String jacketPriceInCart = cartPage.getItemPriceInCart("Sauce Labs Fleece Jacket");
        Assert.assertEquals(backpackPrice, backpackPriceInCart);
        Assert.assertEquals(jacketPrice, jacketPriceInCart);
        CheckoutPage checkoutPage = cartPage.clickOnCheckoutBtn();

        checkoutPage.fillCustomerInfo("demo", "test", "400001");
        OverviewPage overviewPage = checkoutPage.clickOnContinueBtn();

        String backpackPriceInOverview = overviewPage.getItemPriceOnOverviewPage("Sauce Labs Backpack");
        String jacketPriceInOverview = overviewPage.getItemPriceOnOverviewPage("Sauce Labs Fleece Jacket");
        Assert.assertEquals(backpackPrice, backpackPriceInOverview);
        Assert.assertEquals(jacketPrice, jacketPriceInOverview);
        double itemsTotal = overviewPage.calculateItemsTotal();
        double actualTotal = overviewPage.getTotal();
        Assert.assertEquals(actualTotal, itemsTotal);
        OrderCompletePage orderCompletePage = overviewPage.clickOnFinishBtn();

       String completeHeader = orderCompletePage.getOrderCompleteHeader();
       Assert.assertEquals(completeHeader, "Thank you for your order!");
        String completeText = orderCompletePage.getOrderCompleteText();
        Assert.assertEquals(completeText, "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
    }

}
