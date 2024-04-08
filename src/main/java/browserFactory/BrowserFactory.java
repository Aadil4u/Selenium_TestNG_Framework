package browserFactory;

import enums.Browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class BrowserFactory {
    private static final ThreadLocal<WebDriver> Driver = new ThreadLocal<> ();
    public static WebDriver getDriver()
    {
        return Driver.get();
    }

    public static void createDriver(final Browsers browser, boolean headless) {
        switch (browser) {
            case CHROME:
                setupChromeDriver(headless);
                break;
            case FIREFOX:
                setupFirefoxDriver(headless);
                break;
            case EDGE:
                setupEdgeDriver(headless);
                break;
        }
        setupBrowserTimeouts();
    }

    public static void setupChromeDriver(boolean headless) {
        ChromeOptions options = new ChromeOptions();
        if (headless) {
            options.addArguments("--headless");
        }
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        Driver.set(driver);
    }

    public static void setupFirefoxDriver(boolean headless) {
        FirefoxOptions options = new FirefoxOptions();
        if (headless) {
            options.addArguments("--headless");
        }
        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        Driver.set(driver);
    }

    public static void setupEdgeDriver(boolean headless) {
        EdgeOptions options = new EdgeOptions();
        if (headless) {
            options.addArguments("--headless");
        }
        WebDriver driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        Driver.set(driver);
    }

    public static void quitDriver () {
        if (null != Driver.get ()) {
            System.out.println("Closing the driver...");
            getDriver ().quit ();
            Driver.remove ();
        }
    }

    private static void setupBrowserTimeouts() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
    }
}
