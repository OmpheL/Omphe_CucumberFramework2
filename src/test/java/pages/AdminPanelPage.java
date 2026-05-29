package pages;

import org.openqa.selenium.By;

public class AdminPanelPage extends BasePage {

    By IsUserOnAdmiPanel_Element = By.xpath("//h2[contains(normalize-space(),'Admin Panel')]");

    By Groups_Element = By.xpath("//button[contains(.,'Groups')]");

    By back_to_website = By.xpath(
            "//div[contains(@class,'admin-sidebar-footer')]//button[contains(.,'Back to Website')]");

    public AdminPanelPage() {
    super();
    }

    public boolean isUserOnAdminPanel() {
    return isDisplayed(IsUserOnAdmiPanel_Element);
    }

    public void clickGroups() {
    click(Groups_Element);
    }

    public void clickBackToWebsite() {
        click(back_to_website);
    }

}
