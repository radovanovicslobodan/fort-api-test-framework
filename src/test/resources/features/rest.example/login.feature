@rest @regression
Feature: Login

  Scenario: Verify that user can log in with valid credentials
    When Login request with username "admin" and password "password123" is sent
    Then Response status code is 200