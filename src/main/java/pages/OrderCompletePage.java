package pages;

import org.openqa.selenium.By;

import static browserFactory.BrowserFactory.getDriver;

public class OrderCompletePage {
    By orderCompleteHeader = By.cssSelector(".complete-header");
    By orderCompleteText = By.cssSelector(".complete-text");

    public String getOrderCompleteHeader() {
        return getDriver().findElement(orderCompleteHeader).getText();
    }

    public String getOrderCompleteText() {
        return getDriver().findElement(orderCompleteText).getText();
    }


}