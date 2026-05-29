package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    By WelcomeElement =
            By.xpath("//span[@class='welcome-word' and normalize-space()='Welcome']");

    By MenuButton = By.xpath("//button[.//span[normalize-space()='Menu']]");

    By AdminPanel_Element = By.xpath("//button[.//span[normalize-space()='Admin Panel']]");

    By LogoutEl = By.xpath("//button[.//span[normalize-space()='Logout']]");

    public HomePage() {

        super();
    }

    public boolean isWelcomeMessageDisplayed() {

        return isDisplayed(WelcomeElement);
    }

    public void clickMenu() {

        click(MenuButton);
    }

    public void clickAdminPanel() {

        click(AdminPanel_Element);
    }

    public void clickLogout() {
        click(LogoutEl);
    }
}
