@ui @smoke
  Feature: As a user I want to add items to my cart
    As a user I want to be able to remove an item from my backpack

    Background: The user logs in
      Given the user opens the "https://www.saucedemo.com"
      And the user types in the "standard_user" as "username" on the login page
      And the user types in the "secret_sauce" as "password" on the login page
      And the user presses the "login" button on the login page

      Scenario: The user presses the remove item button, and does not see the add item button
        Given the user see the "add backpack to cart" button on the inventory page
        And the user do not see the "remove backpack from cart" button on the inventory page
        When the user presses the "add backpack to cart" button on the inventory page
        Then the user see the "remove backpack from cart" button on the inventory page
        And the user do not see the "add backpack to cart" button on the inventory page