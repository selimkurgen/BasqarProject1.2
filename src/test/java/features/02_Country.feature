@Smoke @Regression
Feature: Country functionality

  Scenario: Country create
    Given user navigate to basqar
    And   user loggin to basqar

    When  user navigate to Country page
    And Click to add button
    And   user add a country "Country49" and code as "Code49"
    Then  the new input should be created

  Scenario: Country delete
    Given user click to Dashboard
    And   user navigate to Country page
    Then  user delete the data name as "Country49"
    Then  the input should be deleted
    And logout