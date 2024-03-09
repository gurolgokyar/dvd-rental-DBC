Feature: Film Records


  Scenario: Get All film records
    Given the database is accessible
    When user requests all film records
    Then user verify that there are 1000 film records


    Scenario: Get replacement_cost in desc from film
      Given the database is accessible
      When user requests replacement_cost in desc from film
      Then user verify that all records displayed in order


      Scenario: Get length of film that are between 70 and 130
        Given the database is accessible
        When user request length between 70 and 130
        Then user verify that all of records as expected

