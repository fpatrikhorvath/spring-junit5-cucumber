@api @smoke
Feature: Checking that I am be able to send requests to the /404 endpoint

  Background: I set the base URI and path to the given values
    Given I set the base uri to "https://the-internet.herokuapp.com" and the base path to "/status_codes"

  Scenario: Sending a GET request to the /404
    When I send a GET request to the "/404" endpoint
    Then I see 404 as response code