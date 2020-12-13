@Regression @Smoke
Feature:Excel Template functionality


  Scenario: Excel Template create
    Given user navigate to basqar
    And   user loggin to basqar
    When   user navigate to Excel Template page
    And Click to add button
    Then Create a Excel Template name as "kurgen509" period count as "1" and save
    And  create versions row size as"2" and column size as "3" and save and close
    Then  the new input should be created

  Scenario: Excel Template
    Given user click to Dashboard
    When   user navigate to Excel Template page
    Then user edit data name as "kurgen509"
    Then create a new Excel Template name as "kurgen709" and period count as "34" and save
    Then  the input should be updated

  Scenario: Excel Template
    Given user click to Dashboard
    When   user navigate to Excel Template page
    Then  user delete the data name as "kurgen709"
    Then  the input should be deleted
    And logout