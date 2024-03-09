Feature: Actor Records

  Scenario: Retrieve all actor records
    Given the database is accessible
    When I request all actor records
    Then I should receive a list of all actors

  Scenario Outline: Retrieve actor record by ID
    Given the database is accessible
    When I request the actor record with ID <actor_id>
    Then I should receive the actor record with first name "<first_name>" and last name "<last_name>"

    Examples:
      | actor_id | first_name | last_name |
      | 1        | Penelope   | Guiness   |
      | 2        | Nick       | Wahlberg  |
      | 3        | Ed         | Chase     |


  Scenario: Actor records are up-to-date
    Given the database is accessible
    When I check the last update timestamp for any actor record
    Then the last update timestamp should be more recent than "2010-01-01 00:00:00"
