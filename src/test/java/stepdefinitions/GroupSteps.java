package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import pages.LandingPage;
import pages.LoginPage;

import utilities.ConfigReader;
import utilities.DriverFactory;
import utilities.JsonReader;

public class GroupSteps {

    LandingPage landingPage;
    LoginPage loginPage;

    JsonReader reader = new JsonReader();

    @Given("user opens the website")
    public void user_opens_the_website() {

        landingPage = new LandingPage();
        loginPage = new LoginPage();

        System.out.println(
                landingPage.getPageTitle()
        );
    }

    @When("user logs in with admin credentials")
    public void userLogsInWithAdminCredentials() {

        landingPage.clickLogin();

        loginPage.login(
                reader.getValue(
                        "adminCredentials",
                        "email"),

                reader.getValue(
                        "adminCredentials",
                        "password")
        );
    }
}