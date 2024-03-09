Feature: Payment Records

  Scenario: Get each customer_id's count
    Given the database is accessible
    When user requests for get each customer_id's count
    Then user verify that number of customer_id equals count
      | 1 | 30 |
      | 2 | 26 |
      | 3 | 24 |
      | 4 | 22 |
      | 5 | 35 |