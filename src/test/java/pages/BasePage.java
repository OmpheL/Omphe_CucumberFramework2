package pages;

import utilities.DriverFactory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {

        driver = DriverFactory.getDriver();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        PageFactory.initElements(driver, this);
    }

    // Wait for Visibility
    public WebElement waitForVisibility(By locator) {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait for Clickable
    public WebElement waitForClickability(By locator) {

        return wait.until(
                ExpectedConditions.elementToBeClickable(locator));
    }

    // Click Element
    public void click(By locator) {

        waitForClickability(locator).click();
    }

    // Type Text
    public void type(By locator, String text) {

        WebElement element = waitForVisibility(locator);

        element.clear();
        element.sendKeys(text);
    }

    // Get Text
    public String getText(By locator) {

        return waitForVisibility(locator).getText();
    }

    // Check Displayed
    public boolean isDisplayed(By locator) {

        return waitForVisibility(locator).isDisplayed();
    }

    // Clear Field
    public void clear(By locator) {

        waitForVisibility(locator).clear();
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

