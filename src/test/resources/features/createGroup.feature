Feature: Create Group and User Registration Functionality

  Scenario: Admin creates a group and user signs up successfully

    Given user opens the website

    When user logs in with admin credentials
    And user navigates to admin panel
    And user clicks on Group section
    And user clicks on Create New Group
    And user fills all group details
    And user saves the group
    Then user should be able to create the group

    When user logs out
    And user clicks login
    And user clicks signup
    And user fills all registration details
    And user submits the registration form
    Then user account should be created successfully