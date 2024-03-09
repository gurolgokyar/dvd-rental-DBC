Feature: Rental Records

  Scenario: Get rental_ids
    Given the database is accessible
    When the user requests for get all rental_id
    Then the user verify that rental_ids are unique