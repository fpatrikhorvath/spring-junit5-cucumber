@ui @smoke
Feature: TODO

  Background: TODO
    Given the user opens the "https://www.saucedemo.com"
    And I want to see the thread id in the log
    And the user types in the "standard_user" as "username" on the login page
    And the user types in the "secret_sauce" as "password" on the login page
    And the user presses the "login" button on the login page

  Scenario: TODO
    When the user presses the "cart" button on the inventory page
    Then the user is on the cart page

  Scenario: TODO
    When the user presses the "add backpack to cart" button on the inventory page
    When the user presses the "cart" button on the inventory page
    Then the user is on the cart page