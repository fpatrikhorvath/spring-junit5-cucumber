@ui @smoke
Feature: As a user I should be able to
  Open the menu and interact with the menu buttons
  To log out by pressing the logout button on the menu

  Background: Opens the login page, enters the correct username and password and then presses the login button
    Given the user opens the "https://www.saucedemo.com"
    And the user types in the "standard_user" as "username" on the login page
    And the user types in the "secret_sauce" as "password" on the login page
    And the user presses the "login" button on the login page

  Scenario: Checking that the user is can open the menu
    When the user presses the "open the menu" button on the inventory page
    Then the user see the "login button" on the inventory page

  Scenario: Checking that the user is able to log out
      Given the user presses the "open the menu" button on the inventory page
      When the user presses the "logout" button on the inventory page
      Then the user is on the login page