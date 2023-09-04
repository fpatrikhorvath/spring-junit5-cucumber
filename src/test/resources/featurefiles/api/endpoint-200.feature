@api @smoke
Feature: Checking that I am be able to send requests to the /200 endpoint

  Background: I set the base URI and path to the given values
    Given I set the base uri to "https://the-internet.herokuapp.com" and the base path to "/status_codes"

  Scenario: I send a GET request to the /200 endpoint and checking that the response is proper
    When I send a GET request to the "/200" endpoint
    Then I see 200 as response code
