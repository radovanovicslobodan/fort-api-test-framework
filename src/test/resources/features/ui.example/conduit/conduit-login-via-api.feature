Feature: Login via API

  Background:
    Given User is logged in

    Scenario: Verify that newly registered user nas no articles in her/his feed
      When User navigates to Conduit home page
      Then User has no articles in feed