package pages;

import org.openqa.selenium.By;

public class LandingPage extends BasePage {

    By loginButton =
            By.xpath("//button[.//span[text()='Login']]");

    public LandingPage() {

        super();
    }

    public void clickLogin() {

        click(loginButton);
    }

    public void acceptAlert() {

        waitHelper.waitForAlert();

        try {
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            throw new RuntimeException("Alert was present but could not be accepted", e);
        }
    }
}