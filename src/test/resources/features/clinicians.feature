Feature: Get clinicians

  Background:
    Given Authorized user exists

  Scenario: Get list of clinicians
    When User sends request for clinicians list
    Then Status code is 200