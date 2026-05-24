package stepdefinitions;

import pages.LandingPage;
import io.cucumber.java.en.Given;

public class GroupSteps {

    LandingPage landingPage = new LandingPage();

    @Given("user opens the website")
    public void user_opens_the_website() {

        System.out.println(
                landingPage.getPageTitle()
        );
    }
}