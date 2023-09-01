@api @smoke
Feature: TODO

  Background: TODO
    Given I set the base uri to "https://the-internet.herokuapp.com" and the base path to "/status_codes"

  Scenario: TODO
    When I send a GET request to the "/404" endpoint
    And I want to see the thread id in the log
    Then I see 404 as response code