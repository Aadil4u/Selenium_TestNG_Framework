package base;

import browserFactory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import helper.ConfigReader;

public class BaseClass {

    public WebDriver driver;

    @BeforeMethod
    public void setupApplication() {
        driver = BrowserFactory.startBrowser(ConfigReader.getProperty("browser"), ConfigReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
