package pages;

import org.openqa.selenium.By;

import static browserFactory.BrowserFactory.getDriver;

public class CheckoutPage {
    By firstNameInput = By.cssSelector("#first-name");
    By lastNameInput = By.cssSelector("#last-name");
    By postalCodeInput = By.cssSelector("#postal-code");
    By continueBtn = By.cssSelector("#continue");


    public void fillCustomerInfo(String firstName, String lastName, String postalCode) {
        getDriver().findElement(firstNameInput).sendKeys(firstName);
        getDriver().findElement(lastNameInput).sendKeys(lastName);
        getDriver().findElement(postalCodeInput).sendKeys(postalCode);
    }

    public OverviewPage clickOnContinueBtn() {
        getDriver().findElement(continueBtn).click();
        return new OverviewPage();
    }

}
