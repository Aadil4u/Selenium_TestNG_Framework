package pages;

import org.openqa.selenium.By;
import static browserFactory.BrowserFactory.getDriver;

public class HomePage {

    By appLogo = By.cssSelector(".app_logo");
    By cartBtn = By.cssSelector(".shopping_cart_link");
    By cartCountBadge = By.cssSelector(".shopping_cart_badge");

    public boolean verifyLogoDisplayed() {
        return getDriver().findElement(appLogo).isDisplayed();
    }

    public void addItemToCart(String item) {
        getDriver().findElement(By.xpath("//div[@class='inventory_item_name '][contains(text(),'" + item + "')]/ancestor::div[@class='inventory_item_description'] //button[text()='Add to cart']")).click();
    }

    public String getItemsPrice(String item) {
       return getDriver().findElement(By.xpath("//div[@class='inventory_item_name '][contains(text(),'" + item + "')]/ancestor::div[@class='inventory_item_description'] //div[@class='inventory_item_price']")).getText();
    }

    public int getItemsCountInCart() {
        String actualCount = getDriver().findElement(cartCountBadge).getText();
        return Integer.parseInt(actualCount);
    }


    public CartPage clickOnCartBtn() {
        getDriver().findElement(cartBtn).click();
        return new CartPage();
    }



}
