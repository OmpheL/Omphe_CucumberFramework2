package pages;

import org.openqa.selenium.By;

public class ManageGroupsPage extends BasePage {

    By CreateNewGroup_El = By.xpath("//button[contains(.,'Create New Group')]");
    By SuccessMessage_El =
            By.xpath("//div[contains(text(),'Group created successfully!')]");

    public ManageGroupsPage() {
        super();
    }

    public void ClickCreateNewGroup() {
        click(CreateNewGroup_El);
    }

    public boolean isGroupCreatedSuccessfully() {
        return isDisplayed(SuccessMessage_El);    }

}
