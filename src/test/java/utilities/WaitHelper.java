package utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

    private WebDriver driver;
    private WebDriverWait wait;

    public WaitHelper(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10));
    }

    // ==============================
    // VISIBILITY WAIT
    // ==============================
    public WebElement waitForVisibility(By locator) {

        return wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(locator));
    }

    // ==============================
    // CLICKABLE WAIT
    // ==============================
    public WebElement waitForClickability(By locator) {

        return wait.until(
                ExpectedConditions
                        .elementToBeClickable(locator));
    }

    // ==============================
    // PRESENCE WAIT
    // ==============================
    public WebElement waitForPresence(By locator) {

        return wait.until(
                ExpectedConditions
                        .presenceOfElementLocated(locator));
    }

    // ==============================
    // ALL VISIBLE ELEMENTS
    // ==============================
    public List<WebElement> waitForAllVisible(By locator) {

        return wait.until(
                ExpectedConditions
                        .visibilityOfAllElementsLocatedBy(locator));
    }

    // ==============================
    // URL CONTAINS
    // ==============================
    public void waitForUrlContains(String text) {

        wait.until(
                ExpectedConditions.urlContains(text));
    }

    // ==============================
    // TITLE CONTAINS
    // ==============================
    public void waitForTitleContains(String text) {

        wait.until(
                ExpectedConditions.titleContains(text));
    }

    // ==============================
    // ALERT PRESENT
    // ==============================
    public void waitForAlert() {

        wait.until(
                ExpectedConditions.alertIsPresent());
    }

    // ==============================
    // FRAME SWITCH
    // ==============================
    public void waitForFrame(By locator) {

        wait.until(
                ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }
}