Feature: Retrieval of Actor Records

  Scenario: Retrieve all actor records
    Given the database is accessible
    When I request all actor records
    Then I should receive a list of all actors