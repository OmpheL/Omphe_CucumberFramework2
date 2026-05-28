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
}