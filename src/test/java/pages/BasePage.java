package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.DriverFactory;
import utilities.WaitHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;
    protected WaitHelper waitHelper;

    public BasePage() {

        driver = DriverFactory.getDriver();

        waitHelper = new WaitHelper(driver);

        PageFactory.initElements(driver, this);
    }

    // Click Element
    public void click(By locator) {

        waitHelper.waitForClickability(locator).click();
    }

    // Type Text
    public void type(By locator, String text) {

        WebElement element =
                waitHelper.waitForVisibility(locator);

        element.clear();
        element.sendKeys(text);
    }

    // Get Text
    public String getText(By locator) {

        return waitHelper.waitForVisibility(locator).getText();
    }

    // Check Displayed
    public boolean isDisplayed(By locator) {

        return waitHelper.waitForVisibility(locator).isDisplayed();
    }

    // Clear Field
    public void clear(By locator) {

        waitHelper.waitForVisibility(locator).clear();
    }

    // Get Current URL
    public String getCurrentUrl() {

        return driver.getCurrentUrl();
    }

    // Get Page Title
    public String getPageTitle() {

        return driver.getTitle();
    }

    // Select Date
    public void selectDate(By locator, String dateValue) {

        WebElement dateField =
                waitHelper.waitForVisibility(locator);

        // Clear existing value
        dateField.sendKeys(Keys.CONTROL + "a");
        dateField.sendKeys(Keys.DELETE);

        // Enter date (yyyy-MM-dd)
        dateField.sendKeys(dateValue);
    }

    // Wait for alert and accept it
    public void acceptAlert() {

        waitHelper.waitForAlert(); // add this helper method below
        driver.switchTo().alert().accept();
    }

    // Generic select by visible text
    protected void selectByVisibleText(By locator, String visibleText) {
        WebElement element = driver.findElement(locator);
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    // Select by value (UUID cases)
    protected void selectByValue(By locator, String value) {
        WebElement element = driver.findElement(locator);
        Select select = new Select(element);
        select.selectByValue(value);
    }

    // Select by index
    protected void selectByIndex(By locator, int index) {
        WebElement element = driver.findElement(locator);
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public String getAlertTextAndAccept() {

        waitHelper.waitForAlert();

        String text = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        return text;
    }

}
