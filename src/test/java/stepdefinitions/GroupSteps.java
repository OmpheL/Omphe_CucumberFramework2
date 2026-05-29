package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import models.Group;
import models.User;

import org.testng.Assert;
import pages.*;
import testdata.GroupDataFactory;
import testdata.UserDataFactory;
import utilities.JsonReader;

import context.TestContext;

public class GroupSteps {

    LandingPage landingPage;
    LoginPage loginPage;
    HomePage homePage;
    AdminPanelPage adminPanelPage;
    CreateNewGroupPage createNewGroupPage;
    ManageGroupsPage manageGroupsPage;
    RegistrationPage registrationPage;

    JsonReader reader = new JsonReader();

    @Given("user opens the website")
    public void user_opens_the_website() {

        landingPage = new LandingPage();
        loginPage = new LoginPage();
        homePage = new HomePage();
        adminPanelPage = new AdminPanelPage();
        createNewGroupPage = new CreateNewGroupPage();
        manageGroupsPage = new ManageGroupsPage();
        registrationPage = new RegistrationPage();

        System.out.println(
                landingPage.getPageTitle()
        );
    }

    @When("user logs in with admin credentials")
    public void userLogsInWithAdminCredentials() {

        landingPage.clickLogin();

        loginPage.login(
                reader.getValue("adminCredentials", "email"),
                reader.getValue("adminCredentials", "password")
        );

        homePage.isWelcomeMessageDisplayed();
    }

    @And("user navigates to admin panel")
    public void userNavigatesToAdminPanel() {

        homePage.clickMenu();
        homePage.clickAdminPanel();
        adminPanelPage.isUserOnAdminPanel();
    }

    @And("user clicks on Group section")
    public void userClicksOnGroupSection() {
        adminPanelPage.clickGroups();
    }

    @And("user clicks on Create New Group")
    public void userClicksOnCreateNewGroup() {
        manageGroupsPage.ClickCreateNewGroup();
    }

    @And("user fills all group details")
    public void userFillsAllGroupDetails() {

        Group group = GroupDataFactory.createGroup();

        createNewGroupPage.fillGroupForm(group);

        // STORE GROUP NAME FOR LATER USE
        TestContext.setGroupName(group.getName());
    }

    @And("user saves the group")
    public void userSavesTheGroup() {

        createNewGroupPage.clickCreateButton();
    }

    @Then("user should be able to create the group")
    public void userShouldBeAbleToCreateTheGroup() {

        manageGroupsPage.isGroupCreatedSuccessfully();
    }

    @When("user logs out")
    public void userLogsOut() {

        adminPanelPage.clickBackToWebsite();
        homePage.clickMenu();
        homePage.clickLogout();
        landingPage.acceptAlert();
    }

    @And("user clicks login")
    public void userClicksLogin() {
        landingPage.clickLogin();
    }

    @And("user clicks signup")
    public void userClicksSignup() {
        loginPage.clickSignup();
    }

    @And("user fills all registration details")
    public void userFillsAllRegistrationDetails() {

        String groupName = TestContext.getGroupName();
        if (groupName == null || groupName.isEmpty()) {
            throw new RuntimeException(
                    "Group name is not set. Make sure group is created before registration step."
            );
        }

        User user = UserDataFactory.createUser(groupName);

        registrationPage.fillRegistrationForm(user);
    }

    @And("user submits the registration form")
    public void userSubmitsTheRegistrationForm() {
        registrationPage.clickSubmitButton();

    }

    @Then("user account should be created successfully")
    public void userAccountShouldBeCreatedSuccessfully() {
        Assert.assertTrue(registrationPage.isUserRegistered());;
    }
}