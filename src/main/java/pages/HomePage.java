package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;
    By appLogo = By.cssSelector(".app_logo");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyLogoDisplayed() {
        return driver.findElement(appLogo).isDisplayed();
    }
}
