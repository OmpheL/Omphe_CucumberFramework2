package pages;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage {

    By firstname_El = By.id("register-firstName");
    By lastname_El = By.id("register-lastName");
    By email_El = By.id("register-email");
    By password_El = By.id("register-password");
    By confirmPassword_El = By.id("register-confirmPassword");



    // Search input inside dropdown
    By selectGroup_El = By.id("register-group");
    By groupOption(String groupName) {
        return By.xpath("//option[contains(text(),'" + groupName + "')]");
    }




    By submitButton_El = By.id("register-submit");

    By successMessage_El =
            By.xpath("//*[contains(text(),'Registration submitted successfully')]");

    public RegistrationPage() {
        super();
    }

    public void enterFirstName(String firstname) {

        type(firstname_El, firstname);
    }

    public void enterLastName(String lastname) {

        type(lastname_El, lastname);
    }

    public void enterEmail(String email) {

        type(email_El, email);
    }

    public void enterPassword(String password) {

        type(password_El, password);
    }

    public void enterConfirmPassword(String confirmPassword) {

        type(confirmPassword_El, confirmPassword);
    }


    // Search + select group
    // click, type, click
    public void selectGroup(String groupName) {

        // 1. Click to activate dropdown/input
        click(selectGroup_El);

        // 2. Type value (if searchable dropdown/input)
        //type(selectGroup_El, groupName);

        // 3. Click matching option
        click(groupOption(groupName));
    }

    public void clickSubmitButton() {

        click(submitButton_El);
    }
    public String getTextIfVisible(By locator) {

        try {
            return waitHelper.waitForVisibility(locator).getText();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean isUserRegistered() {

        String alertText = getAlertTextAndAccept();

        return alertText.toLowerCase().contains("success");
    }



    public void fillRegistrationForm(User user) {

        enterFirstName(user.getFirstName());

        enterLastName(user.getLastName());

        enterEmail(user.getEmail());

        enterPassword(user.getPassword());

        enterConfirmPassword(user.getConfirmPassword());

        selectGroup(user.getGroupName());
    }
}