Feature: FilmDetails Records

  Background:
    Given the database is accessible

  Scenario: Retrieve film details records
    When the user request film details
    Then the user verify that titles are not dublicated
    And  the user verify that all release years are equal to 2006
    And the user verify that all categories are in the array below:
      | Comedy      |
      | Sci-Fi      |
      | Action      |
      | Drama       |
      | Horror      |
      | Foreign     |
      | Travel      |
      | Music       |
      | Children    |
      | New         |
      | Sports      |
      | Classics    |
      | Documentary |
      | Animation   |
      | Games       |
      | Family      |