@ui @smoke
Feature: TODO

  Background: Opens the login page, enters the correct username and password and then presses the login button
    Given the user opens the "https://www.saucedemo.com"
    And I want to see the thread id in the log
    And the user types in the "standard_user" as "username" on the login page
    And the user types in the "secret_sauce" as "password" on the login page
    And the user presses the "login" button on the login page

  Scenario: TODO
    When the user presses the "open the menu" button on the inventory page
    Then the user see the "login button" on the inventory page

    Scenario: TODO
      Given the user presses the "open the menu" button on the inventory page
      When the user presses the "logout" button on the inventory page
      Then the user is on the login page

