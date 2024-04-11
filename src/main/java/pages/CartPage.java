package pages;

import org.openqa.selenium.By;

import static browserFactory.BrowserFactory.getDriver;

public class CartPage {

    By checkoutBtn = By.cssSelector("#checkout");

    public String getItemPriceInCart(String item) {
        return getDriver().findElement(By.xpath("//div[contains(text(),'"+ item +"')]/ancestor::div[@class='cart_item_label'] //div[@class='inventory_item_price']")).getText();
    }

    public CheckoutPage clickOnCheckoutBtn() {
        getDriver().findElement(checkoutBtn).click();
        return new CheckoutPage();
    }
}