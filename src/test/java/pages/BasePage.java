package pages;

import utilities.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

    public BasePage() {

        driver = DriverFactory.getDriver();

        PageFactory.initElements(driver, this);
    }
}