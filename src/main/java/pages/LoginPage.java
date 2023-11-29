package pages;

import helper.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    By username = By.id("user-name");
    By password = By.name("password");
    By loginBtn = By.cssSelector("input[id*='login-button']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage loginToApplication(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        Utility.click(driver,driver.findElement(loginBtn));
        return new HomePage(driver);
    }
}
