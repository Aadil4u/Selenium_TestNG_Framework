package helper;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static browserFactory.BrowserFactory.getDriver;

public class Utility {
    public static void click(WebElement element) {
        try {
            element.click();
        } catch (ElementNotInteractableException e) {
            System.out.println("Normal Click Failed Trying Again with Actions Click");
            Actions act = new Actions(getDriver());
            act.moveToElement(element).click().build().perform();
        } catch (Exception e) {
            System.out.println("Actions Click Failed Trying Again with JS Click");
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].click()", element);
        }
    }

    public static Alert waitForAlert(int waitTime, int pollingSeconds) {
        Alert alt = null;
        for (int i = 0; i < waitTime; i++) {
            try {
                alt = getDriver().switchTo().alert();
                break;
            } catch (NoAlertPresentException e) {
                System.out.println("Alert is not present waiting for few more seconds");
                waitForSeconds(pollingSeconds);
            }
        }
        return alt;
    }

    public static void waitForSeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }

    public static void captureScreenshot() {
        TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File dest = new File("./screenshots/Screenshot_" + getCurrentDateTime() + ".png");
        try {
            FileHandler.copy(src, dest);
        } catch (IOException e) {
            System.out.println("Something went wrong");
            e.getMessage();
        }
    }

    public static String captureScreenshotAsBase64() {
        TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
        String src = takesScreenshot.getScreenshotAs(OutputType.BASE64);
        return src;
    }

    public static String getCurrentDateTime() {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date());
    }

    public static void captureElementScreenshot(WebElement element) {
        File src = element.getScreenshotAs(OutputType.FILE);
        File dest = new File("./screenshots/Screenshot_" + getCurrentDateTime() + ".png");
        try {
            FileHandler.copy(src, dest);
        } catch (IOException e) {
            System.out.println("Something went wrong");
            e.getMessage();
        }
    }

    public static void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;')", element);
        waitForSeconds(1);
        js.executeScript("arguments[0].removeAttribute('style')", element);
    }


}
