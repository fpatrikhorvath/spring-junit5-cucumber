@ui @smoke
  Feature: As a user I should not be allowed to reach sites without proper authentication

    Scenario: As a user I should be navigated to the login page, in case I am not authorized to the inventory page
      Given the user opens the "https://www.saucedemo.com/inventory.html"
      Then the user is on the login page

    Scenario: As a user I should be navigated to the login page, in case I am not authorized to the cart page
      Given the user opens the "https://www.saucedemo.com/cart.html"
      Then the user is on the login page