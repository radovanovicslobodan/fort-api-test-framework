@ui
Feature: Conduit login

  Background:
    Given User is not logged in

  Scenario: Verify that registered user can login
    When User navigates to Conduit home page
    And User clicks on sign in button
    And User enters "test@test.me" and "123456" in login form fields
    Then Users avatar is displayed in header