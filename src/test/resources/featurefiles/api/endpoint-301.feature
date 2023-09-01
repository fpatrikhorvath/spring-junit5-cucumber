@api @smoke
Feature: TODO

  Background:
    Given I set the base uri to "https://the-internet.herokuapp.com" and the base path to "/status_codes"

  Scenario: TODO
    Given I set the automatic redirect to "false"
    When I send a GET request to the "/301" endpoint
    And I want to see the thread id in the log
    Then I see 301 as response code
