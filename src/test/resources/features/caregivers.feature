Feature: Caregiver functionality

  Background:
    Given Authorized caregiver exists

  Scenario: Updating caregiver
    When  User sends request to add a child
    Then Caregiver is updated