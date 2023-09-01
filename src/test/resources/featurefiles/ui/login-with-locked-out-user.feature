@ui @smoke
  Feature: The user should not be logged in, in case his account is locked out
    As a locked out user

    Scenario: Opens the login page, enters the correct username and password and then presses the login button
      Given the user opens the "https://www.saucedemo.com"
      And the user types in the "locked_out_user" as "username" on the login page
      And the user types in the "secret_sauce" as "password" on the login page
      When the user presses the "login" button on the login page
      Then the user is on the login page

    Scenario: Opens the login page, enters the correct username and an incorrect password
    and then presses the login button
      Given the user opens the "https://www.saucedemo.com"
      And the user types in the "locked_out_user" as "username" on the login page
      And the user types in the "wrong_password" as "password" on the login page
      When the user presses the "login" button on the login page
      Then the user is on the login page

    Scenario: Opens the login page, enters an incorrect username and a correct password
    and then presses the login button
      Given the user opens the "https://www.saucedemo.com"
      And the user types in the "locked_out_user" as "username" on the login page
      And the user types in the "secret_sauce" as "password" on the login page
      When the user presses the "login" button on the login page
      Then the user is on the login page