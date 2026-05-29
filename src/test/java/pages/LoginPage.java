package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By email =
            By.id("login-email");

    private final By password =
            By.id("login-password");

    private final By submitButton =
            By.id("login-submit");

    public void enterEmail(String userEmail) {

        type(email, userEmail);
    }

    public void enterPassword(String userPassword) {

        type(password, userPassword);
    }

    public void clickSubmit() {

        click(submitButton);
    }


    public void login(String userEmail,
                      String userPassword) {

        enterEmail(userEmail);

        enterPassword(userPassword);

        clickSubmit();
    }

}