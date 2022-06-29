@rest @regression
Feature: Authorization

  Scenario: Verify that authorization token can be generated with valid credentials
    When Token request with username "admin" and password "password123" is sent
    Then Response status code is 200
    And Response contains token

  Scenario: test code
    When I test some method