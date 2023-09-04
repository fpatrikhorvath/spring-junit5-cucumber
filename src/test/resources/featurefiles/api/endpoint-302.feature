@api @smoke
Feature: Checking that I am be able to send requests to the /302 endpoint

  Background: I set the base URI and path to the given values
    Given I set the base uri to "https://the-internet.herokuapp.com" and the base path to "/status_codes"

  Scenario: Sending the GET to the /302 endpoint
    When I send a GET request to the "/302" endpoint
    Then I see 302 as response code
