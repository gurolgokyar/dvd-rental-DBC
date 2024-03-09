Feature: Staff Records

  Scenario: Verify all email contains @
    Given the database is accessible
    When the user request for get all email address
    Then the user verify that all email address contains @ mark