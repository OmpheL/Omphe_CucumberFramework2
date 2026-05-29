package pages;

import models.Group;

import org.openqa.selenium.By;

public class CreateNewGroupPage extends BasePage {

    // Modal / Popup
    By CreateGroupPopup_El =
            By.xpath("//div[contains(@style,'position: fixed')]");

    By GroupName_El =
            By.xpath("//input[@name='name']");

    By GroupDescription_El =
            By.xpath("//textarea[@name='description']");

    By GroupYear_El =
            By.xpath("//input[@name='year' and @inputmode='numeric']");

    By MaxCapacity_El =
            By.xpath("//input[@name='maxCapacity']");

    By StartDate_El =
            By.xpath("//input[@name='startDate' and @type='date']");

    By EndDate_El =
            By.xpath("//input[@name='endDate' and @type='date']");

    By CreateGroup_El =
            By.xpath("//button[@type='submit' and contains(.,'Create Group')]");

    public CreateNewGroupPage() {

        super();
    }

    // Wait for popup
    public void waitForCreateGroupPopup() {

        waitHelper.waitForVisibility(
                CreateGroupPopup_El
        );
    }

    public void enterGroupName(String groupName) {

        type(GroupName_El, groupName);
    }

    public void enterGroupDescription(String groupDescription) {

        type(GroupDescription_El, groupDescription);
    }

    public void enterGroupYear(String groupYear) {

        type(GroupYear_El, groupYear);
    }

    public void enterMaxCapacity(String maxCapacity) {

        type(MaxCapacity_El, maxCapacity);
    }

    public void enterStartDate(String startDate) {

        selectDate(StartDate_El, startDate);
    }

    public void enterEndDate(String endDate) {

        selectDate(EndDate_El, endDate);
    }

    public void clickCreateButton() {

        click(CreateGroup_El);
    }

    // Fill Entire Form
    public void fillGroupForm(Group group) {

        // Wait for popup first
        waitForCreateGroupPopup();

        enterGroupName(group.getName());

        enterGroupDescription(group.getDescription());

        enterGroupYear(group.getYear());

        enterMaxCapacity(group.getCapacity());

        enterStartDate(group.getStartDate());

        enterEndDate(group.getEndDate());
    }
}