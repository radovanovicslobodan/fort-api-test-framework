Feature: Get clinicians

  Background:
    Given Authorized user exists

  Scenario: Get list of clinicians
    When User sends request for clinicians list
    Then Status code is 200

  Scenario: Get single clinician
    When User sends request for clinician
    Then Status code is 200