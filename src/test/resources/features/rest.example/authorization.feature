@rest @regression
Feature: Authorization

  Scenario: Verify that authorization token can be generated with valid credentials
    When Token request with username "admin" and password "password123" is sent
    Then Response contains token