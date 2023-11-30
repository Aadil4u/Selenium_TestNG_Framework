package browserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.time.Duration;

public class BrowserFactory {
    static WebDriver driver;
    public static WebDriver getDriver()
    {
        return driver;
    }

    public static WebDriver startBrowser(String browserName, String appUrl, String headless) {

        if (browserName.equalsIgnoreCase("Chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (headless.equalsIgnoreCase("true")) {
                options.addArguments("--headless");
            }
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            if (headless.equalsIgnoreCase("true")) {
                options.addArguments("--headless");
            }
            driver = new FirefoxDriver(options);
        } else if (browserName.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        } else if (browserName.equalsIgnoreCase("Edge")) {
            EdgeOptions options = new EdgeOptions();
            if (headless.equalsIgnoreCase("true")) {
                options.addArguments("--headless");
            }
            driver = new EdgeDriver();
        } else {
            System.out.println("Sorry " + browserName + " Not Present Setting the Browser To Chrome");
            ChromeOptions options = new ChromeOptions();
            if (headless.equalsIgnoreCase("true")) {
                options.addArguments("--headless");
            }
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
        driver.get(appUrl);
        return driver;
    }
}
