package pages;

import org.openqa.selenium.By;
import static browserFactory.BrowserFactory.getDriver;

public class HomePage {

    By appLogo = By.cssSelector(".app_logo");

    public boolean verifyLogoDisplayed() {
        return getDriver().findElement(appLogo).isDisplayed();
    }
}
