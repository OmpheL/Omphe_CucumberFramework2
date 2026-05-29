package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    By email =
            By.id("login-email");

    By password =
            By.id("login-password");

    By submitButton =
            By.id("login-submit");

    By signUpButton = By.id("signup-toggle");



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

    public void clickSignup() {
        click(signUpButton);
    }
}