package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static browserFactory.BrowserFactory.getDriver;

public class OverviewPage {

    By itemsPrice = By.cssSelector(".inventory_item_price");
    By totalPrice = By.cssSelector(".summary_subtotal_label");
    By finishBtn = By.cssSelector("#finish");

    public String getItemPriceOnOverviewPage(String item) {
        return getDriver().findElement(By.xpath("//div[contains(text(),'"+ item +"')]/ancestor::div[@class='cart_item_label'] //div[@class='inventory_item_price']")).getText();
    }

    public double calculateItemsTotal() {
        List<WebElement> rawPrices= getDriver().findElements(itemsPrice);
        double sum = 0;
        for (WebElement rawPrice: rawPrices) {
            double price = Double.parseDouble(rawPrice.getText().substring(1));
            sum +=price;
        }

        return sum;
    }

    public double getTotal() {
    return Double.parseDouble(getDriver().findElement(totalPrice).getText().split(" ")[2].substring(1));
    }

    public OrderCompletePage clickOnFinishBtn() {
        getDriver().findElement(finishBtn).click();
        return new OrderCompletePage();
    }




}
