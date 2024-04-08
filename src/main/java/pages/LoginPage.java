package pages;

import helper.Utility;
import org.openqa.selenium.By;

import static browserFactory.BrowserFactory.getDriver;

public class LoginPage {


    By username = By.id("user-name");
    By password = By.name("password");
    By loginBtn = By.cssSelector("input[id*='login-button']");



    public HomePage loginToApplication(String user, String pass) {
        getDriver().findElement(username).sendKeys(user);
        getDriver().findElement(password).sendKeys(pass);
        Utility.click(getDriver().findElement(loginBtn));
        return new HomePage();
    }
}
