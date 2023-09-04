@api @smoke
Feature: Checking that I am be able to send requests to the /301 endpoint

  Background: I set the base URI and path to the given values
    Given I set the base uri to "https://the-internet.herokuapp.com" and the base path to "/status_codes"

  Scenario: I turn off the automatic redirect and send a GET request to the /301
    Given I set the automatic redirect to "false"
    When I send a GET request to the "/301" endpoint
    Then I see 301 as response code
