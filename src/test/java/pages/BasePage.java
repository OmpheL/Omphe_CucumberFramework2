package pages;

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
}