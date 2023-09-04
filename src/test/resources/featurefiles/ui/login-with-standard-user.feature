@ui @smoke
  Feature: The user want to login successfully with correct username and password
    The user should not be logged in, in case the username or the password is not correct
    As a standard user

    Scenario: Opens the login page, enters the correct username and password and then presses the login button
      Given the user opens the "https://www.saucedemo.com"
      And the user types in the "standard_user" as "username" on the login page
      And the user types in the "secret_sauce" as "password" on the login page
      When the user presses the "login" button on the login page
      Then the user is on the inventory page

    Scenario: Opens the login page, enters the correct username and an incorrect password
    and then presses the login button
      Given the user opens the "https://www.saucedemo.com"
      And the user types in the "standard_user" as "username" on the login page
      And the user types in the "wrong_password" as "password" on the login page
      When the user presses the "login" button on the login page
      Then the user is on the login page

    Scenario: Opens the login page, enters an incorrect username and a correct password
    and then presses the login button
      Given the user opens the "https://www.saucedemo.com"
      And the user types in the "not_existing_user" as "username" on the login page
      And the user types in the "secret_sauce" as "password" on the login page
      When the user presses the "login" button on the login page
      Then the user is on the login page